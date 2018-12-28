package beautyocl.atl.api.utils;

import beautyocl.api.common.IATLTransformation;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;

public class BeautyATLUtils {
	public static final ATLTransformation SIMP_INTEGERS = new ATLTransformation("integers", pathTo("beautyocl.simplifications.integers.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_BOOLEANS = new ATLTransformation("booleans", pathTo("beautyocl.simplifications.booleans.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_ELSE = new ATLTransformation("if-else", pathTo("beautyocl.simplifications.ifelse.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_ITERATORS = new ATLTransformation("iterators", pathTo("beautyocl.simplifications.iterator.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_SAME_EXPR = new ATLTransformation("if-same-expr", pathTo("beautyocl.simplifications.ifsameexpr.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_FUSION = new ATLTransformation("if-fusion", pathTo("beautyocl.simplifications.iffusion.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_UNSHORT_CIRCUIT = new ATLTransformation("unshort", pathTo("beautyocl.simplifications.unshortcircuit.asm"), VM.STANDARD);	
	public static final ATLTransformation SIMP_KIND_OF_TRUE = new ATLTransformation("kind-of-true", pathTo("beautyocl.simplifications.kindoftrue.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_KIND_OF_FULL = new ATLTransformation("kind-of-full", pathTo("beautyocl.simplifications.fullTypeComparison.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_INTRO_CALL= new ATLTransformation("if-intro-call", pathTo("beautyocl.simplifications.ifintrocall.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_TRUE_FALSE = new ATLTransformation("if-true-false", pathTo("beautyocl.simplifications.iftruefalse.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_REMOVE_LET = new ATLTransformation("remove-let", pathTo("beautyocl.simplifications.removelet.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_SAME_OPERAND = new ATLTransformation("same-operand", pathTo("beautyocl.simplifications.sameoperand.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_EQUALITY_SEQUENCE = new ATLTransformation("equality-sequence", pathTo("beautyocl.simplifications.equalitysequence.asm"), VM.STANDARD);
	public static final ATLTransformation PULL_UP_CONDITIONAL = new ATLTransformation("pull-up-conditional", pathTo("beautyocl.simplifications.pullupconditional.asm"), VM.STANDARD);
	
	public static TransformationRepository getRepository() {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(SIMP_INTEGERS);
		rep.add(SIMP_BOOLEANS);
		rep.add(SIMP_SAME_OPERAND);
		rep.add(SIMP_ITERATORS);
		rep.add(SIMP_IF_ELSE);
		rep.add(SIMP_IF_SAME_EXPR);
		rep.add(SIMP_IF_FUSION);
		rep.add(SIMP_UNSHORT_CIRCUIT);
		rep.add(SIMP_KIND_OF_TRUE);
		rep.add(SIMP_KIND_OF_FULL);
		rep.add(SIMP_IF_TRUE_FALSE);
		//rep.add(SIMP_IF_INTRO_CALL);
		rep.add(SIMP_REMOVE_LET);
		
		rep.add(PULL_UP_CONDITIONAL);
		
		rep.add(SIMP_EQUALITY_SEQUENCE);
		return rep;
	}

	private static String pathTo(String base) {
		return "platform:/plugin/beautyocl.atl.api/resources/beautyocl/atl/api/" + base;
	}
}
