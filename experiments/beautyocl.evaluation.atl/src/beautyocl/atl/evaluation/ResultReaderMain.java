package beautyocl.atl.evaluation;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import beautyocl.atl.evaluation.raw.AbstractSimplificable;
import beautyocl.atl.evaluation.raw.BEData;
import beautyocl.atl.evaluation.raw.BEInvariant;
import beautyocl.atl.evaluation.raw.BEProblem;
import beautyocl.atl.evaluation.raw.BEQuickfix;
import beautyocl.atl.evaluation.raw.BESimplification;
import beautyocl.atl.evaluation.raw.BETransformation;

public class ResultReaderMain {

	public static void main(String[] args) throws Exception {
		
		if ( args.length < 2 ) {
			System.out.println("ResultReaderMain file expId");
			return;
		}
			
		String fileName = args[0];
		int expId = Integer.parseInt(args[1]);
		
		Serializer serializer = new Persister();
		File source = new File(args[0]);

		BEData data = serializer.read(BEData.class, source);
		
		int originalId = expId;
		for(int i = 0; i < 10; i++) {
			
			for (BETransformation t : data.getTransformations()) {
				for (BEProblem p : t.getProblems()) {
					for (BEQuickfix qfx : p.getQuickfixes()) {
						if ( qfx.getExpId() == expId ) {
							System.out.println("Transformation: " + t.getName());
							show(qfx);
							System.out.println("Found expId = " + expId + "(" + originalId + ")");
							return;
						}
					}
				}
				
				for (BEInvariant inv : t.getInvariants()) {
					if ( inv.getExpId() == expId ) {
						show(inv);
						System.out.println("Found expId = " + expId + "(" + originalId + ")");
						return;
					}
				}
				
			}

			expId++;
		}
		
		
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
		
		System.out.println("Best effort ORIGINAL: \n" + inv.getBestEffortVerifiableOriginalExpression());
		System.out.println("Best effort FINAL: \n" + inv.getBestEffortVerifiableOriginalExpression());
		System.out.println("Helpers: \n" + inv.getAdditionalHelpers());
	}
	
}
