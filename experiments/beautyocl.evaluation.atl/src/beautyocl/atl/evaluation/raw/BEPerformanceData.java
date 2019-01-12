package beautyocl.atl.evaluation.raw;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="beautyocl-performance-experiment")
public class BEPerformanceData {
	@ElementList(name="executions")
	protected List<BEPerformanceExecution> executions;
	
	public BEPerformanceData() {
		this.executions = new ArrayList<BEPerformanceExecution>();		
	}

	public void addExecution(BEPerformanceExecution exec) {
		this.executions.add(exec);		
	}
	
	public List<BEPerformanceExecution> getExecutions() {
		return executions;
	}
	
}
