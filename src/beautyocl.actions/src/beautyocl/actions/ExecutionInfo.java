package beautyocl.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class ExecutionInfo {

	private List<String> transformations = new ArrayList<>();
	private EObject result;

	public void addExecutionStep(String transformation) {
		transformations.add(transformation);
	}

	public void setResult(EObject obj) {
		this.result = obj;
	}
	
	public EObject getResult() {
		return result;
	}
}
