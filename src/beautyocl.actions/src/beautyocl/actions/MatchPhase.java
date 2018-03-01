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
	private IExpressionHolder exp;
	private String trafoName;

	public MatchPhase(Resource r, IExpressionHolder exp, List<InPlaceAction> actions) {
		this.actions = actions;
		this.resource = r;
		this.exp = exp;
	}
	
	public List<Match> getMatches() {
		return this.actions.stream().map(a -> new Match(a)).collect(Collectors.toList());	
	}
	
	public void setTransformation(String name) {
		this.trafoName = name;
	}
	
	
	public IExpressionHolder getExpression() {
		return exp;
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
		
		public IExpressionHolder getExpression() {
			return exp;
		}
		
		/**
		 * Checks whether an object to be replaced is within the scope provided by another object
		 * Everythin "outside" cannot be transformed 
		 * @param scope
		 * @param source
		 * @return
		 */
		public boolean isWithinScope(EObject source) {
			return exp.getRoot() == source || EcoreUtil.isAncestor(exp.getRoot(), source);
		}

		public String getTransformationName() {
			return trafoName;
		}
	}
	
}
