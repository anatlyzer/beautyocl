package beautyocl.api.common;

import beautyocl.actions.MatchPhase;

public interface IATLTransformation {
	public MatchPhase exec(UglyExpression exp);
}
