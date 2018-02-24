package beautyocl.api.common;

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
		Scheduler scheduler = new Scheduler(tracer);

		return scheduler.apply(s -> {
			for (IATLTransformation t : repo.getTransformations()) {
				MatchPhase match = t.exec(exp);
				s.add(match);
			}
		});
		
	}
	
}
