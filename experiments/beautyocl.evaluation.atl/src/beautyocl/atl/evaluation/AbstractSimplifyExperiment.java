package beautyocl.atl.evaluation;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.experiments.typing.AbstractATLExperiment;
import beautyocl.actions.IExecutionTracer;
import beautyocl.actions.MatchPhase.Match;
import beautyocl.atl.evaluation.raw.AbstractSimplificable;
import beautyocl.atl.evaluation.raw.BEQuickfix;
import beautyocl.atl.evaluation.raw.BESimplification;

public abstract class AbstractSimplifyExperiment extends AbstractATLExperiment {

	public class ExperimentTracer implements IExecutionTracer {

		private AbstractSimplificable simp;
		private BESimplification currentSimplification;

		public ExperimentTracer(AbstractSimplificable simp) {
			this.simp = simp;
		}

		@Override
		public void preApply(Match m, EObject original) {
			this.currentSimplification = new BESimplification();
			this.currentSimplification.setName(m.getTransformationName());
			this.currentSimplification.setOriginalExp(ATLSerializer.serialize(original));
			this.currentSimplification.setOriginalNumNodes(countNodes(original));
		}

		@Override
		public void postApply(Match m, EObject transformed) {
			if ( transformed == null ) {				
				throw new IllegalStateException("Cannot be null: " + m.getAction().getTransformation());
			}
			System.out.println(this.currentSimplification.getOriginalExp());
			this.currentSimplification.setSimplifiedExp(ATLSerializer.serialize(transformed));
			this.currentSimplification.setSimplifiedNumNodes(countNodes(transformed));
			this.simp.addSimplification(currentSimplification);
		}

		@Override
		public boolean onError(Throwable t) {
			t.printStackTrace();
			return false;
		}

	}
	
	protected int countNodes(EObject obj) {
		int i = 1;
		TreeIterator<EObject> it = obj.eAllContents();
		while ( it.hasNext() ) {
			it.next();
			i++;
		}
		return i;
	}

}
