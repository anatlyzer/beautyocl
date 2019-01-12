package beautyocl.atl.evaluation.raw;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class BEPerformanceExecution {
	@Attribute
	protected String name;
	
	@Element
	protected String originalExp;
	
	@Element
	protected String simplifiedExp;

	@Attribute
	protected int originalNumNodes;

	@Attribute
	protected int simplifiedNumNodes;
	
	@Attribute
	protected int expId = -1;
	
	@Attribute
	protected String kind = "not-specified";
	
	
	@Attribute
	protected long originalTimeNano;
	
	@Attribute
	protected long simplifiedTimeNano;
	
	public String getName() {
		return name;
	}
	
	public int getExpId() {
		return expId;
	}
		
	public String getKind() {
		return kind;
	}
		
	public long getOriginalTimeNano() {
		return originalTimeNano;
	}
	
	public long getSimplifiedTimeNano() {
		return simplifiedTimeNano;
	}
	
	public void setOriginalTimeNano(long originalTimeNano) {
		this.originalTimeNano = originalTimeNano;
	}
	
	public void setSimplifiedTimeNano(long simplifiedTimeNano) {
		this.simplifiedTimeNano = simplifiedTimeNano;
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
	
	public void setOriginalNumNodes(int originalNumNodes) {
		this.originalNumNodes = originalNumNodes;
	}
	
	public void setSimplifiedNumNodes(int simplifiedNumNodes) {
		this.simplifiedNumNodes = simplifiedNumNodes;
	}
}
