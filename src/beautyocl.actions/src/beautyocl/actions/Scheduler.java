package beautyocl.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;

import beautyocl.actions.MatchPhase.Match;

public class Scheduler {

	public List<MatchPhase> matches = new ArrayList<>();
	private IExecutionTracer tracer; 
	
	public Scheduler(IExecutionTracer tracer) {
		this.tracer = tracer;
	}

	// TODO: Organise matches according to overlappings
	public void add(MatchPhase match) {
		matches.add(match);		
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
		
		return info;
	}

}
