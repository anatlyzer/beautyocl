package beautyocl.api.common;

import beautyocl.actions.MatchPhase;

public interface IATLTransformation {
	public String getName();
	
	public MatchPhase exec(UglyExpression exp);
}
