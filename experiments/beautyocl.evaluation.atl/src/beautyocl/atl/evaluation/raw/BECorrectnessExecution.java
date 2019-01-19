package beautyocl.atl.evaluation.raw;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class BECorrectnessExecution {
	@Attribute
	protected String name;
	
	@Element
	protected String originalExp;
	
	@Element
	protected String simplifiedExp;

	@Element
	protected int expId;
	
	@Attribute
	protected String status;
	
	@Attribute
	protected String kind = "not-specified"; // test or model-finding
	
	@Attribute(required = false)
	protected String reason = null;
	
	
	public String getName() {
		return name;
	}
	
	public int getExpId() {
		return expId;
	}
		
	public String getKind() {
		return kind;
	}
		
	public String getOriginalExp() {
		return originalExp;
	}
	
	public String getSimplifiedExp() {
		return simplifiedExp;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setExpId(int expId) {
		this.expId = expId;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public void setOriginalExp(String originalExp) {
		this.originalExp = originalExp;
	}
	
	public void setSimplifiedExp(String simplifiedExp) {
		this.simplifiedExp = simplifiedExp;
	}
	
	
}
