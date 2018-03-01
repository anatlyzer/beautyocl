package beautyocl.atl.api.utils;

import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;

public class BeautyATLUtils {
	public static TransformationRepository getRepository() {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(new ATLTransformation("integers", pathTo("beautyocl.simplifications.integers.asm"), VM.STANDARD));
		rep.add(new ATLTransformation("booleans", pathTo("beautyocl.simplifications.booleans.asm"), VM.STANDARD));
		rep.add(new ATLTransformation("iterators", pathTo("beautyocl.simplifications.iterator.asm"), VM.STANDARD));
		rep.add(new ATLTransformation("if-else", pathTo("beautyocl.simplifications.ifelse.asm"), VM.STANDARD));
		rep.add(new ATLTransformation("if-intro-call", pathTo("beautyocl.simplifications.ifintrocall.asm"), VM.STANDARD));
		rep.add(new ATLTransformation("kind-of-true", pathTo("beautyocl.simplifications.kindoftrue.asm"), VM.STANDARD));
		rep.add(new ATLTransformation("kind-of-full", pathTo("beautyocl.simplifications.fullTypeComparison.asm"), VM.STANDARD));
		
		return rep;
	}

	private static String pathTo(String base) {
		return "platform:/plugin/beautyocl.atl.api/resources/beautyocl/atl/api/" + base;
	}
}
