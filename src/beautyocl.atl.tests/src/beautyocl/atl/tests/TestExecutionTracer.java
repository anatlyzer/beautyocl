package beautyocl.atl.tests;

import org.eclipse.emf.ecore.EObject;

import anatlyzer.atl.util.ATLSerializer;
import beautyocl.actions.IExecutionTracer;
import beautyocl.actions.MatchPhase.Match;

public class TestExecutionTracer implements IExecutionTracer {
	@Override
	public void preApply(Match m, EObject original) {
		System.out.println("A: " + m.getAction().getSource());
		
		String exp = ATLSerializer.serialize(original);
		System.out.println("Before " + m.getTransformationName() + "\n" + exp);
	}

	@Override
	public void postApply(Match m, EObject transformed) {
		String exp = ATLSerializer.serialize(transformed);
		System.out.println("After " + m.getTransformationName() + "\n" + exp);					
	}

	@Override
	public boolean onError(Match m, Throwable t) {
		t.printStackTrace();
		// TODO Auto-generated method stub
		return false;
	}
}