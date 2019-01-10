package beautyocl.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import beautyocl.actions.MatchPhase.Match;

public class Scheduler {

	public List<MatchPhase> matches = new ArrayList<>();
	private IExecutionTracer tracer;
	private IExpressionHolder exp; 
	
	public Scheduler(IExecutionTracer tracer, IExpressionHolder exp) {
		this.tracer = tracer;
		this.exp = exp;
	}

	// TODO: Organise matches according to overlappings
	public void add(MatchPhase match) {
		matches.add(match);		
	}

	public ExecutionInfo applyIt(Supplier<TrafoIterator> supplier) {
		ActionsEngine engine = new ActionsEngine();
		ExecutionInfo info = new ExecutionInfo();
		
		MAIN_LOOP:
		while ( true ) {
			TrafoIterator it = supplier.get();
			
			boolean applied = false;

			TRY_TRAFO:
			while ( it.hasNext() ) {
				MatchPhase matchPhase = it.next();
				List<Match> matches = matchPhase.getMatches().stream().filter(m -> engine.isWithinScope(m)).collect(Collectors.toList());
				List<EObject> affectedElements = new ArrayList<EObject>();
				
				PROCESS_MATCH:
				for(Match m : matches) {
					EObject result = null;
					try {
						EObject source = m.getAction().getSource();
						System.out.println("Applying source" + source);
						// Check conflicts, this is a naive way. 
						for (EObject obj : affectedElements) {
							if ( EcoreUtil.isAncestor(obj, source) )
								continue PROCESS_MATCH;
						}
						
						tracer.preApply(m, source);
						result = engine.apply(m);
						affectedElements.add(source);
						
						applied = true;
						tracer.postApply(m, result);

						continue MAIN_LOOP;
					} catch ( Throwable e ) {
						if ( tracer.onError(e) ) {
							// Continue with another trafo
							continue TRY_TRAFO;
						}
					}
					
				}				
			}
			
			if ( ! applied ) {
				break;
			}
			
		}
		

		info.setResult(exp.getRoot());
		return info;
	}
	
	public ExecutionInfo apply(Consumer<List<MatchPhase>> consumer) {
		ActionsEngine engine = new ActionsEngine();
		ExecutionInfo info = new ExecutionInfo();
		
		while ( true ) {
			List<MatchPhase> l = new ArrayList<MatchPhase>();
			consumer.accept(l);
			
			if ( l.isEmpty() )
				break;

			// TODO: Replace the scope!
			boolean applied = l.stream().
					flatMap(mp -> mp.getMatches().stream()).
					filter(m -> engine.isWithinScope(m)).
					findFirst().
					map(m -> {
						tracer.preApply(m, m.getAction().getSource());
						EObject result = engine.apply(m);
						// TODO: Apply should return the generated object, which is then passed to postApply
						tracer.postApply(m, result);
						return true;
					}).orElse(false);
		
			if ( ! applied )
				break;
		}

		info.setResult(exp.getRoot());
		return info;
	}

	public static interface TrafoIterator extends Iterator<MatchPhase> {
		
	}
}
