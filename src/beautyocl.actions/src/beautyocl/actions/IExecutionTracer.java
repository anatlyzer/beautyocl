package beautyocl.actions;

import org.eclipse.emf.ecore.EObject;

import beautyocl.actions.MatchPhase.Match;

public interface IExecutionTracer {
	public static final IExecutionTracer NULL = new IExecutionTracer() {

		@Override
		public void preApply(Match m, EObject original) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void postApply(Match m, EObject transformed) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean onError(Throwable t) {
			t.printStackTrace();			
			return false;
		}
		
	};

	void preApply(Match m, EObject original);

	void postApply(Match m, EObject transformed);
	
	boolean onError(Throwable t);
}
