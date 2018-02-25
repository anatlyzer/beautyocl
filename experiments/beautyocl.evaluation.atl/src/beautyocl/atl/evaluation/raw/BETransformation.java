package beautyocl.atl.evaluation.raw;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="transformation")
public class BETransformation {
	@Attribute
	protected String name;
	
	@Attribute
	protected String path;
	
	@ElementList(name="problems")
	protected List<BEProblem> problems = new ArrayList<BEProblem>();

	@ElementList(name="invariants")
	protected List<BEInvariant> invariants = new ArrayList<BEInvariant>();

	public List<BEProblem> getProblems() {
		return problems;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void addProblem(BEProblem p) {
		this.problems.add(p);
	}

	public List<BEInvariant> getInvariants() {
		return invariants;
	}
	
	public void addInvariant(BEInvariant inv) {
		this.invariants.add(inv);
	}

}
