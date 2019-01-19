package beautyocl.atl.evaluation.raw;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="beautyocl-correctness-experiment")
public class BECorrectnessData {
	@ElementList(name="executions")
	protected List<BECorrectnessExecution> executions;
	
	public BECorrectnessData() {
		this.executions = new ArrayList<BECorrectnessExecution>();		
	}

	public void addExecution(BECorrectnessExecution exec) {
		this.executions.add(exec);		
	}
	
	public List<BECorrectnessExecution> getExecutions() {
		return executions;
	}
	
}
