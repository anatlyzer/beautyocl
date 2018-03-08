package beautyocl.api.emfocl;

import beautyocl.api.common.TransformationRepository;

public class BeautyOCLUtils {
	public static final EMFOCLSimplification SIMP_INTEGERS = new EMFOCLSimplification("integers", pathTo("beautyocl.simplifications.integers.asm"));
	public static final EMFOCLSimplification SIMP_BOOLEANS = new EMFOCLSimplification("booleans", pathTo("beautyocl.simplifications.booleans.asm"));
	public static final EMFOCLSimplification SIMP_IF_ELSE = new EMFOCLSimplification("if-else", pathTo("beautyocl.simplifications.ifelse.asm"));
	public static final EMFOCLSimplification SIMP_ITERATORS = new EMFOCLSimplification("iterators", pathTo("beautyocl.simplifications.iterator.asm"));
	public static final EMFOCLSimplification SIMP_IF_SAME_EXPR = new EMFOCLSimplification("if-same-expr", pathTo("beautyocl.simplifications.ifsameexpr.asm"));
	public static final EMFOCLSimplification SIMP_IF_FUSION = new EMFOCLSimplification("if-fusion", pathTo("beautyocl.simplifications.iffusion.asm"));
	public static final EMFOCLSimplification SIMP_UNSHORT_CIRCUIT = new EMFOCLSimplification("unshort", pathTo("beautyocl.simplifications.unshortcircuit.asm"));	
	public static final EMFOCLSimplification SIMP_KIND_OF_TRUE = new EMFOCLSimplification("kind-of-true", pathTo("beautyocl.simplifications.kindoftrue.asm"));
	public static final EMFOCLSimplification SIMP_KIND_OF_FULL = new EMFOCLSimplification("kind-of-full", pathTo("beautyocl.simplifications.fullTypeComparison.asm"));
	public static final EMFOCLSimplification SIMP_IF_INTRO_CALL= new EMFOCLSimplification("if-intro-call", pathTo("beautyocl.simplifications.ifintrocall.asm"));
	public static final EMFOCLSimplification SIMP_IF_TRUE_FALSE = new EMFOCLSimplification("if-true-false", pathTo("beautyocl.simplifications.iftruefalse.asm"));
	public static final EMFOCLSimplification SIMP_REMOVE_LET = new EMFOCLSimplification("remove-let", pathTo("beautyocl.simplifications.removelet.asm"));
	public static final EMFOCLSimplification SIMP_SAME_OPERAND = new EMFOCLSimplification("same-operand", pathTo("beautyocl.simplifications.sameoperand.asm"));
	
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
		return "platform:/plugin/beautyocl.catalogue.emfocl/adaptations/" + base;
	}
}
