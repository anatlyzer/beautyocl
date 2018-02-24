package beautyocl.atl.evaluation.raw;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="beautyocl-experiment")
public class BEData {
	@ElementList(name="transformations")
	protected List<BETransformation> transformations;
	
	public BEData() {
		this.transformations = new ArrayList<BETransformation>();		
	}

	public void addTransformation(BETransformation trafo) {
		this.transformations.add(trafo);		
	}
	
	public List<BETransformation> getTransformations() {
		return transformations;
	}
	
}
