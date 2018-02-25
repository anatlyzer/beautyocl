package beautyocl.atl.evaluation.raw;

import org.simpleframework.xml.Attribute;

public class BEInvariant extends AbstractSimplificable {

	@Attribute
	protected String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
