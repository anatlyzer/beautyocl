package beautyocl.api.common;

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

	private List<IATLTransformation> allTrafos = new ArrayList<IATLTransformation>();

	public void add(IATLTransformation trafo) {
		this.allTrafos.add(trafo);
	}
	
//	public void addStd(String fname) {
//		this.allTrafos.add(new ATLTransformation(fname, VM.STANDARD));
//	}
//
//	public void addEMFTVM(String fname) {
//		this.allTrafos.add(new ATLTransformation(fname, VM.EMFTVM));
//	}

	public List<IATLTransformation> getTransformations() {
		return Collections.unmodifiableList(this.allTrafos);
	}

}
