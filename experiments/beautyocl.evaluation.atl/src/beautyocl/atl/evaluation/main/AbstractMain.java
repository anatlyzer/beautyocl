package beautyocl.atl.evaluation.main;

import beautyocl.atl.evaluation.raw.AbstractSimplificable;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEInvariant;
import beautyocl.atl.evaluation.raw.BEProblem;
import beautyocl.atl.evaluation.raw.BEQuickfix;
import beautyocl.atl.evaluation.raw.BESimplification;
import beautyocl.atl.evaluation.raw.BETransformation;

public abstract class AbstractMain {


	protected AbstractSimplificable findSimplificable(BEData cData, int expId) {
		for (BETransformation t : cData.getTransformations()) {
			for (BEProblem p : t.getProblems()) {
				for (BEQuickfix qfx : p.getQuickfixes()) {
					if ( qfx.getExpId() == expId ) {
						return qfx;
					}
				}
			}
			
			for (BEInvariant inv : t.getInvariants()) {
				if ( inv.getExpId() == expId ) {
					return inv;
				}
			}
		}
		return null;
	}
	
	public static String fixedLengthString(String string, int length) {
	    return String.format("%1$"+length+ "s", string);
	}
	
	public static String fixedLengthInt(int i, int length) {
	    return String.format("%1$"+length+ "d", i);
	}
	
	public static String fixedLengthDouble(double d, int length) {
	    return String.format("%." + length + "f", d);
	}
	
	private static void show(AbstractSimplificable inv) {
		System.out.println("Original: \n" + inv.getOriginalExpression());
		System.out.println("--");
		System.out.println("Final: \n" + inv.getFinalExpression());
		System.out.println("---");
		System.out.println("Original: " + inv.getOriginalNumNodes() + " - Simplified: " + inv.getSimplifiedNumNodes());
		System.out.println("Simplifications:");
		for (BESimplification s : inv.getSimplifications()) {
			System.out.println(" * " + s.getName());
		}
	}

}
