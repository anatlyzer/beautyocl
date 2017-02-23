package beautyocl.actions;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This class applies a set of actions to a resource.
 *  
 * @author jesus
 *
 */
public class ActionsEngine {

	public void apply(Resource r, List<InPlaceAction> actions) {
		
		for (InPlaceAction a : actions) {
			if ( a instanceof Replace ) {
				replace(r, (Replace) a);
			} else {
				throw new IllegalStateException("Action not supported: " + a);
			}
		}
		
	}

	private void replace(Resource r, Replace a) {
		// TODO: Sanity check, elements poined by a should belong to r	
		checkInResource(r, a.getSource(), a.getTarget());
		
		
		EcoreUtil.replace(a.getSource(), a.getTarget());
	}

	private void checkInResource(Resource r, EObject... objs) {
		for (EObject eObject : objs) {
			if ( eObject.eResource() != r ) {
				throw new IllegalStateException("Object " + eObject + " does not belong to resource: " + r);
			}
		}
	}
	
}
