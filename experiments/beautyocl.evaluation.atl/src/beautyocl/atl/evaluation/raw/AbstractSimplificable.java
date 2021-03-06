package beautyocl.atl.evaluation.raw;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

public abstract class AbstractSimplificable {

	@Attribute
	protected int expId;	
	
	@Element(name="baseExpression")
	private String originalExpression;

	@Element(name="finalExpression", required=false)
	private String finalExpression;

	@Element(name="bestEffortVerifiableOriginalExpression", required=false)
	private String bestEffortVerifiableOriginalExpression;

	@Element(name="bestEffortVerifiableFinalExpression", required=false)
	private String bestEffortVerifiableFinalExpression;

	@Element(name="additionalHelpers", required=false)
	private String additionalHelpers;
	
	@ElementList(name="simplifications")
	protected List<BESimplification> simplifications = new ArrayList<BESimplification>();

	@Attribute
	protected int originalNumNodes;

	@Attribute
	protected int simplifiedNumNodes;

	private static int idCounter = 0;
	
	public AbstractSimplificable() {
		expId = ++idCounter;
	}
	
	public static void resetCounter() {
		idCounter = 0;
	}
	
	public int getExpId() {
		return expId;
	}
	
	public void setExpId(int expId) {
		this.expId = expId;
	}
	
	public List<BESimplification> getSimplifications() {
		return simplifications;
	}

	public void addSimplification(BESimplification s) {
		simplifications.add(s);
	}

	public void setOriginalExpression(String exp) {
		this.originalExpression = exp;
	}
	
	public String getOriginalExpression() {
		return originalExpression;
	}
	
	public void setFinalExpression(String finalExpression) {
		this.finalExpression = finalExpression;
	}
	
	public String getFinalExpression() {
		return finalExpression;
	}
	
	public void setOriginalNumNodes(int originalNumNodes) {
		this.originalNumNodes = originalNumNodes;
	}
	
	public void setSimplifiedNumNodes(int simplifiedNumNodes) {
		this.simplifiedNumNodes = simplifiedNumNodes;
	}
	
	public int getOriginalNumNodes() {
		return originalNumNodes;
	}
	
	public int getSimplifiedNumNodes() {
		return simplifiedNumNodes;
	}
	
	public void setBestEffortVerifiableFinalExpression(String bestEffortVerifiableFinalExpression) {
		this.bestEffortVerifiableFinalExpression = bestEffortVerifiableFinalExpression;
	}
	
	public void setBestEffortVerifiableOriginalExpression(String bestEffortVerifiableOriginalExpression) {
		this.bestEffortVerifiableOriginalExpression = bestEffortVerifiableOriginalExpression;
	}
	
	public String getBestEffortVerifiableFinalExpression() {
		return bestEffortVerifiableFinalExpression;
	}
	
	public String getBestEffortVerifiableOriginalExpression() {
		return bestEffortVerifiableOriginalExpression;
	}
	
	public String getAdditionalHelpers() {
		return additionalHelpers;
	}
	
	public void setAdditionalHelpers(String additionalHelpers) {
		this.additionalHelpers = additionalHelpers;
	}
}
