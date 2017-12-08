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

	public void apply(Resource originalResource, Resource newElementsResource, List<InPlaceAction> actions) {
		
		for (InPlaceAction a : actions) {
			if ( a instanceof Replace ) {
				replace(originalResource, newElementsResource, (Replace) a);
			} else {
				throw new IllegalStateException("Action not supported: " + a);
			}
		}
		
	}

	private void replace(Resource r, Resource newElementsResource, Replace a) {
		// TODO: Sanity check, elements poined by a should belong to r	
		checkInResource(r, null, a.getSource());
		checkInResource(r, newElementsResource, a.getTarget());
		
		
		EcoreUtil.replace(a.getSource(), a.getTarget());
	}

	private void checkInResource(Resource r, Resource newElementsResource, EObject... objs) {
		for (EObject eObject : objs) {
			if ( eObject.eResource() != r && eObject.eResource() != newElementsResource) {
				throw new IllegalStateException("Object " + eObject + " does not belong to resource: " + r);
			}
		}
	}
	
}
