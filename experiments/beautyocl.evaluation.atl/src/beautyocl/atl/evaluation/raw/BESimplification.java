package beautyocl.atl.evaluation.raw;

import org.simpleframework.xml.Attribute;

public class BESimplification {
	@Attribute
	protected String name;
	
	@Attribute
	protected String originalExp;
	
	@Attribute
	protected String simplifiedExp;

	@Attribute
	protected int originalNumNodes;

	@Attribute
	protected int simplifiedNumNodes;
	
	public String getName() {
		return name;
	}
	
	public String getOriginalExp() {
		return originalExp;
	}
	
	public String getSimplifiedExp() {
		return simplifiedExp;
	}
	
	public int getOriginalNumNodes() {
		return originalNumNodes;
	}
	
	public int getSimplifiedNumNodes() {
		return simplifiedNumNodes;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setOriginalExp(String originalExp) {
		this.originalExp = originalExp;
	}
	
	public void setSimplifiedExp(String simplifiedExp) {
		this.simplifiedExp = simplifiedExp;
	}
	
	public void setOriginalNumNodes(int originalNumNodes) {
		this.originalNumNodes = originalNumNodes;
	}
	
	public void setSimplifiedNumNodes(int simplifiedNumNodes) {
		this.simplifiedNumNodes = simplifiedNumNodes;
	}
}
