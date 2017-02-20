package beautyocl.atl.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class holds the list of available transformations
 *  
 * @author jesus
 *
 */
public class TransformationRepository {

	private List<ATLTransformation> allTrafos = new ArrayList<ATLTransformation>();

	public void add(String fname) {
		this.allTrafos.add(new ATLTransformation(fname));
	}
	
	public List<ATLTransformation> getTransformations() {
		return Collections.unmodifiableList(this.allTrafos);
	}

}
