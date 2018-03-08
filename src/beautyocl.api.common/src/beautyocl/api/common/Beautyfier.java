package beautyocl.api.common;

import java.util.Iterator;
import java.util.List;

import beautyocl.actions.ExecutionInfo;
import beautyocl.actions.IExecutionTracer;
import beautyocl.actions.MatchPhase;
import beautyocl.actions.Scheduler;

/**
 * This class applies the beautification rules (i.e., ATL in-place transformations) 
 * of the repository.
 * 
 * @author jesus
 *
 */
public class Beautyfier {
	
	private TransformationRepository repo;
	private IExecutionTracer tracer;

	public Beautyfier(TransformationRepository repo, IExecutionTracer tracer) {
		this.repo = repo;
		this.tracer = tracer;
	}
	
	public ExecutionInfo applyAll(UglyExpression exp) {
		Scheduler scheduler = new Scheduler(tracer, exp);

		return scheduler.applyIt(() -> {
			return new RepoIterator(repo, exp);
		});


//		return scheduler.apply(s -> {
//			for (IATLTransformation t : repo.getTransformations()) {
//				MatchPhase match = t.exec(exp);
//				s.add(match);
//			}
//		});
	
	}
	
	public class RepoIterator implements Scheduler.TrafoIterator {

		private Iterator<IATLTransformation> trafos;
		private UglyExpression exp;

		public RepoIterator(TransformationRepository repo, UglyExpression exp) {
			this.trafos = repo.getTransformations().iterator();
			this.exp = exp;
		}
		
		@Override
		public boolean hasNext() {
			return trafos.hasNext();
		}

		@Override
		public MatchPhase next() {
			IATLTransformation t = trafos.next();
			return t.exec(exp);
		}
		
	}
}
