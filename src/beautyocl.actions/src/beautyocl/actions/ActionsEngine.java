package beautyocl.actions;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import beautyocl.actions.MatchPhase.Match;

/**
 * This class applies a set of actions to a resource.
 *  
 * @author jesus
 *
 */
public class ActionsEngine {

	public void apply(Match match) {
		apply(match.getResource(), null, Collections.singletonList(match.getAction()));	
	}

	
	private void apply(Resource originalResource, Resource newElementsResource, List<InPlaceAction> actions) {
		
		for (InPlaceAction a : actions) {
			if ( a instanceof Replace ) {
				replace(originalResource, newElementsResource, (Replace) a);
			} else if ( a instanceof DeleteMoveChildren ) {
				deleteMoveChildren(originalResource, newElementsResource, (DeleteMoveChildren) a);
			} else {
				throw new IllegalStateException("Action not supported: " + a);
			}
		}
		
	}

	private void replace(Resource r, Resource newElementsResource, Replace a) {		
		// TODO: Sanity check, elements poined by a should belong to r	
		checkInResource(r, null, a.getSource());
		
		if ( newElementsResource != null )
			checkInResource(r, newElementsResource, a.getTarget());
		
		
		EcoreUtil.replace(a.getSource(), a.getTarget());
	}

	private void deleteMoveChildren(Resource r, Resource newElementsResource, DeleteMoveChildren a) {		
		checkInResource(r, null, a.getSource());
		checkInResource(r, null, a.getChildren());
			
		EcoreUtil.replace(a.getSource(), a.getChildren());
	}
	
	private void checkInResource(Resource r, Resource newElementsResource, EObject... objs) {
		for (EObject eObject : objs) {
			if ( eObject.eResource() != r && eObject.eResource() != newElementsResource) {
				throw new IllegalStateException("Object " + eObject + " does not belong to resource: " + r);
			}
		}
	}


	/**
	 * Checks whether the matched object of the match is within the scope configured
	 * This is a filtering facility. 
	 * @param m
	 * @return
	 */
	public boolean isWithinScope(Match m) {
		InPlaceAction a = m.getAction();
		return m.isWithinScope(a.getSource());		
	}

	
}
