package beautyocl.atl.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beautyocl.atl.api.ATLTransformation.VM;

/**
 * This class holds the list of available transformations
 *  
 * @author jesus
 *
 */
public class TransformationRepository {

	private List<ATLTransformation> allTrafos = new ArrayList<ATLTransformation>();

	public void addStd(String fname) {
		this.allTrafos.add(new ATLTransformation(fname, VM.STANDARD));
	}

	public void addEMFTVM(String fname) {
		this.allTrafos.add(new ATLTransformation(fname, VM.EMFTVM));
	}

	
	public List<ATLTransformation> getTransformations() {
		return Collections.unmodifiableList(this.allTrafos);
	}

}
