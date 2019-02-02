package beautyocl.atl.evaluation;

import anatlyzer.atlext.OCL.BagExp;
import anatlyzer.atlext.OCL.CollectionExp;
import anatlyzer.atlext.OCL.IfExp;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.LetExp;
import anatlyzer.atlext.OCL.OperatorCallExp;
import anatlyzer.atlext.OCL.OrderedSetExp;
import anatlyzer.atlext.OCL.SequenceExp;
import anatlyzer.atlext.OCL.SetExp;
import anatlyzer.atlext.processing.AbstractVisitor;

public class MetricsCalculator extends AbstractVisitor {

	private int numKeywords = 0;
	
	@Override
	public void inIfExp(IfExp self) {
		numKeywords += 4; // if then else endif
	}
	
	@Override
	public void inLetExp(LetExp self) {
		numKeywords += 2; // let in
	}
	
	@Override
	public void inOperatorCallExp(OperatorCallExp self) {
		numKeywords++;
		if ( self.getArguments().size() > 0 ) {
			numKeywords++;
		}
	}
		
	@Override
	public void inIteratorExp(IteratorExp self) {
		numKeywords++;
	}
	
	@Override
	public void inSequenceExp(SequenceExp self) {
		numKeywords++;
	}
	
	@Override
	public void inSetExp(SetExp self) {
		numKeywords++;
	}
	
	@Override
	public void inOrderedSetExp(OrderedSetExp self) {
		numKeywords++;
	}
	
	@Override
	public void inBagExp(BagExp self) {
		numKeywords++;
	}
	
	
}
