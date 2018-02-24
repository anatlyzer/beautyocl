package beautyocl.atl.evaluation.raw;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

public class BEQuickfix {
	@Attribute
	protected String name;

	@Attribute
	protected String description;

	@Attribute
	private String orginalExpression;

	@ElementList(name="simplifications")
	protected List<BESimplification> simplifications = new ArrayList<BESimplification>();

	public String getName() {
		return name;
	}
	
	public List<BESimplification> getSimplifications() {
		return simplifications;
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
	
	public void addSimplification(BESimplification s) {
		simplifications.add(s);
	}

	public void setOriginalExpression(String exp) {
		this.orginalExpression = exp;
	}
	
	public String getOrginalExpression() {
		return orginalExpression;
	}
}

