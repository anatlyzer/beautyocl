package beautyocl.actions;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
		return apply(match, match.getAction(), new CloneScope());	
	}

	
	private EObject apply(Match match, InPlaceAction a, CloneScope cloneScope) {
		if ( a instanceof Replace ) {
			return replace(match, (Replace) a, cloneScope);
		} else if ( a instanceof DeleteMoveChildren ) {
			return deleteMoveChildren(match, (DeleteMoveChildren) a, cloneScope);
		} else if ( a instanceof CompositeAction ) {
			return compositeAction(match, (CompositeAction) a);			
		} else { 
			throw new IllegalStateException("Action not supported: " + a);
		}
	}

	private EObject compositeAction(Match m, CompositeAction a) {
		CloneScope scope = new CloneScope();
		
		for(Clone c : getActions(a.getActions(), Clone.class))  {
			CustomCopier copier = new CustomCopier(c.getSource()).
					withIgnoredReferences(c.getIgnoredProperties());
			
			EObject result = copier.copyFull();
			scope.put(c, result);			
		}
		
		for(Clone c : getActions(a.getActions(), Clone.class))  {
			EObject result = scope.get(c);
			
			for(int i = 0; i < c.getValues().size(); i++) {
				EObject v = c.getValues().get(i);
				String prop = c.getIgnoredProperties().get(i);
				
				// Adapt v if it is a clone
				v = getTarget(v, scope);
				
				EStructuralFeature f = result.eClass().getEStructuralFeature(prop);
				if ( f.isMany() ) {
					((Collection<EObject>) result.eGet(f)).add(v);
				} else {
					result.eSet(f, v);
				}
			}
			
		}
		
		EObject lastResult = null;
		for(InPlaceAction ia : a.getActions()) {
			if ( ia instanceof Clone )
				continue;
			
			lastResult = apply(m, ia, scope);
		}
		
		return lastResult;
	}

	public <T extends InPlaceAction> List<? extends T> getActions(List<? extends InPlaceAction> actions, Class<T> type) {
		return actions.stream().filter(a -> type.isInstance(a)).map(a -> type.cast(a)).collect(Collectors.toList());
	}
	

	private EObject replace(Match m, Replace a, CloneScope scope) {		
		// TODO: Sanity check, elements poined by a should belong to r	
		checkInResource(m.getResource(), null, a.getSource());
		
		//if ( newElementsResource != null )
		//	checkInResource(r, newElementsResource, a.getTarget());
		
		EObject tgt = getTarget(a.getTarget(), scope);			
		EcoreUtil.replace(a.getSource(), tgt);
		
		changeRootIfNeeded(m, a.getSource(), tgt);
		
		return tgt;
	}


	private EObject getTarget(EObject eObject, CloneScope scope) {
		EObject tgt = eObject;
		if ( tgt instanceof Clone ) {
			tgt = scope.get(tgt);
		}
		return tgt;
	}

	private EObject deleteMoveChildren(Match m, DeleteMoveChildren a, CloneScope scope) {		
		checkInResource(m.getResource(), null, a.getSource());
		checkInResource(m.getResource(), null, a.getChildren());
			
		EObject tgt = getTarget(a.getChildren(), scope);			
		EcoreUtil.replace(a.getSource(), tgt);
		
		changeRootIfNeeded(m, a.getSource(), tgt);
		
		return a.getChildren();
	}
	
	private void changeRootIfNeeded(Match m, EObject source, EObject tgt) {
		if ( m.getExpression().getRoot() == source ) {
			m.getExpression().setRoot(tgt);
		}
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


	private class CloneScope extends HashMap<EObject, EObject> {
		@Override
		public EObject get(Object key) {
			EObject r = super.get(key);
			if ( r == null )
				throw new IllegalStateException("Cannot find: " + key);
			return r;
		}
	}
	
}
