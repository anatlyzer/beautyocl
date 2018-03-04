package beautyocl.atl.api.utils;

import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;

public class BeautyATLUtils {
	public static final ATLTransformation SIMP_INTEGERS = new ATLTransformation("integers", pathTo("beautyocl.simplifications.integers.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_BOOLEANS = new ATLTransformation("booleans", pathTo("beautyocl.simplifications.booleans.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_ELSE = new ATLTransformation("if-else", pathTo("beautyocl.simplifications.ifelse.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_ITERATORS = new ATLTransformation("iterators", pathTo("beautyocl.simplifications.iterator.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_SAME_EXPR = new ATLTransformation("if-same-expr", pathTo("beautyocl.simplifications.ifsameexpr.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_UNSHORT_CIRCUIT = new ATLTransformation("unshort", pathTo("beautyocl.simplifications.unshortcircuit.asm"), VM.STANDARD);	
	public static final ATLTransformation SIMP_KIND_OF_TRUE = new ATLTransformation("kind-of-true", pathTo("beautyocl.simplifications.kindoftrue.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_KIND_OF_FULL = new ATLTransformation("kind-of-full", pathTo("beautyocl.simplifications.fullTypeComparison.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_INTRO_CALL= new ATLTransformation("if-intro-call", pathTo("beautyocl.simplifications.ifintrocall.asm"), VM.STANDARD);
	
	public static TransformationRepository getRepository() {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(SIMP_INTEGERS);
		rep.add(SIMP_BOOLEANS);
		rep.add(SIMP_ITERATORS);
		rep.add(SIMP_IF_ELSE);
		rep.add(SIMP_IF_INTRO_CALL);
		rep.add(SIMP_IF_SAME_EXPR);
		rep.add(SIMP_UNSHORT_CIRCUIT);
		rep.add(SIMP_KIND_OF_TRUE);
		rep.add(SIMP_KIND_OF_FULL);
		
		
		return rep;
	}

	private static String pathTo(String base) {
		return "platform:/plugin/beautyocl.atl.api/resources/beautyocl/atl/api/" + base;
	}
}
