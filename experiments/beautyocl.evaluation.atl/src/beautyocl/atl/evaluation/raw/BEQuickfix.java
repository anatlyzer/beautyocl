package beautyocl.atl.evaluation.raw;

import org.simpleframework.xml.Attribute;

public class BEQuickfix extends AbstractSimplificable {
	@Attribute
	protected String name;

	@Attribute
	protected String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


}

