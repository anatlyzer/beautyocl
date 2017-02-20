package beautyocl.atl.api;

/**
 * This class applies the beautification rules (i.e., ATL in-place transformations) 
 * of the repository.
 * 
 * @author jesus
 *
 */
public class Beautyfier {
	
	private TransformationRepository repo;

	public Beautyfier(TransformationRepository repo) {
		this.repo = repo;
	}
	
	public void applyAll(UglyExpression exp) {
		
		for (ATLTransformation t : repo.getTransformations()) {
			t.exec(exp);
		
			
			break;
		}
		
	}
	
}
