package beautyocl.api.simpleocl;

import beautyocl.api.common.TransformationRepository;

public class BeautySimpleOCLUtils {
	public static final SimpleOCLSimplification SIMP_INTEGERS = new SimpleOCLSimplification("integers", pathTo("beautyocl.simplifications.integers.asm"));
	public static final SimpleOCLSimplification SIMP_BOOLEANS = new SimpleOCLSimplification("booleans", pathTo("beautyocl.simplifications.booleans.asm"));
	public static final SimpleOCLSimplification SIMP_IF_ELSE = new SimpleOCLSimplification("if-else", pathTo("beautyocl.simplifications.ifelse.asm"));
	public static final SimpleOCLSimplification SIMP_ITERATORS = new SimpleOCLSimplification("iterators", pathTo("beautyocl.simplifications.iterator.asm"));
	public static final SimpleOCLSimplification SIMP_IF_SAME_EXPR = new SimpleOCLSimplification("if-same-expr", pathTo("beautyocl.simplifications.ifsameexpr.asm"));
	public static final SimpleOCLSimplification SIMP_IF_FUSION = new SimpleOCLSimplification("if-fusion", pathTo("beautyocl.simplifications.iffusion.asm"));
	public static final SimpleOCLSimplification SIMP_UNSHORT_CIRCUIT = new SimpleOCLSimplification("unshort", pathTo("beautyocl.simplifications.unshortcircuit.asm"));	
	public static final SimpleOCLSimplification SIMP_KIND_OF_TRUE = new SimpleOCLSimplification("kind-of-true", pathTo("beautyocl.simplifications.kindoftrue.asm"));
	public static final SimpleOCLSimplification SIMP_KIND_OF_FULL = new SimpleOCLSimplification("kind-of-full", pathTo("beautyocl.simplifications.fullTypeComparison.asm"));
	public static final SimpleOCLSimplification SIMP_IF_INTRO_CALL= new SimpleOCLSimplification("if-intro-call", pathTo("beautyocl.simplifications.ifintrocall.asm"));
	public static final SimpleOCLSimplification SIMP_IF_TRUE_FALSE = new SimpleOCLSimplification("if-true-false", pathTo("beautyocl.simplifications.iftruefalse.asm"));
	public static final SimpleOCLSimplification SIMP_REMOVE_LET = new SimpleOCLSimplification("remove-let", pathTo("beautyocl.simplifications.removelet.asm"));
	public static final SimpleOCLSimplification SIMP_SAME_OPERAND = new SimpleOCLSimplification("same-operand", pathTo("beautyocl.simplifications.sameoperand.asm"));
	
	public static TransformationRepository getRepository() {
		TransformationRepository rep = new TransformationRepository();
		rep.add(SIMP_INTEGERS);
		rep.add(SIMP_BOOLEANS);
//		rep.add(SIMP_SAME_OPERAND);
//		rep.add(SIMP_ITERATORS);
//		rep.add(SIMP_IF_ELSE);
//		rep.add(SIMP_IF_SAME_EXPR);
//		rep.add(SIMP_IF_FUSION);
//		rep.add(SIMP_UNSHORT_CIRCUIT);
//		rep.add(SIMP_KIND_OF_TRUE);
//		rep.add(SIMP_KIND_OF_FULL);
//		rep.add(SIMP_IF_TRUE_FALSE);
//		//rep.add(SIMP_IF_INTRO_CALL);
//		rep.add(SIMP_REMOVE_LET);
		
		return rep;
	}

	private static String pathTo(String base) {
		return "platform:/plugin/beautyocl.catalogue.simpleocl/adaptations/" + base;
	}
}
