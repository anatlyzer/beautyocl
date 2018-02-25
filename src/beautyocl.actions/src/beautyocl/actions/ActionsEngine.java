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

	public EObject apply(Match match) {
		return apply(match.getResource(), null, match.getAction());	
	}

	
	private EObject apply(Resource originalResource, Resource newElementsResource, InPlaceAction a) {
		if ( a instanceof Replace ) {
			return replace(originalResource, newElementsResource, (Replace) a);
		} else if ( a instanceof DeleteMoveChildren ) {
			return deleteMoveChildren(originalResource, newElementsResource, (DeleteMoveChildren) a);
		} else {
			throw new IllegalStateException("Action not supported: " + a);
		}
	}

	private EObject replace(Resource r, Resource newElementsResource, Replace a) {		
		// TODO: Sanity check, elements poined by a should belong to r	
		checkInResource(r, null, a.getSource());
		
		if ( newElementsResource != null )
			checkInResource(r, newElementsResource, a.getTarget());
				
		EcoreUtil.replace(a.getSource(), a.getTarget());
		
		return a.getTarget();
	}

	private EObject deleteMoveChildren(Resource r, Resource newElementsResource, DeleteMoveChildren a) {		
		checkInResource(r, null, a.getSource());
		checkInResource(r, null, a.getChildren());
			
		EcoreUtil.replace(a.getSource(), a.getChildren());
		
		return a.getChildren();
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
