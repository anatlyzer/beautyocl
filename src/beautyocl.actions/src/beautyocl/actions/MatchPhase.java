package beautyocl.actions;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This represents a set of matches obtained by a transformation.
 * 
 * @author jesus
 *
 */
public class MatchPhase {

	private List<InPlaceAction> actions;
	private Resource resource;
	private EObject scope;

	public MatchPhase(Resource r, EObject scope, List<InPlaceAction> actions) {
		this.actions = actions;
		this.resource = r;
		this.scope = scope;
	}
	
	public List<Match> getMatches() {
		return this.actions.stream().map(a -> new Match(a)).collect(Collectors.toList());
	
	}
	
	public class Match {

		private InPlaceAction action;

		public Match(InPlaceAction a) {
			this.action = a;
		}
		
		public InPlaceAction getAction() {
			return action;
		}

		public Resource getResource() {
			return resource;
		}
				
		/**
		 * Checks whether an object to be replaced is within the scope provided by another object
		 * Everythin "outside" cannot be transformed 
		 * @param scope
		 * @param source
		 * @return
		 */
		public boolean isWithinScope(EObject source) {
			return scope == source || EcoreUtil.isAncestor(scope, source);
		}
	}
	
}
