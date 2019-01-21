package beautyocl.atl.evaluation.raw;

import org.simpleframework.xml.Attribute;

public class BEModuleElement extends AbstractSimplificable {

	@Attribute
	protected String transformationName;

	@Attribute
	protected String name;

	@Attribute
	protected String kind;

	public String getTransformationName() {
		return transformationName;
	}
	
	public void setTransformationName(String transformationName) {
		this.transformationName = transformationName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getKind() {
		return kind;
	}
	
}
