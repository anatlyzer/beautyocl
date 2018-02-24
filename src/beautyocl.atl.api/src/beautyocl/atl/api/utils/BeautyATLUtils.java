package beautyocl.atl.api.utils;

import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;

public class BeautyATLUtils {
	public static TransformationRepository getRepository() {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(new ATLTransformation(pathTo("beautyocl.simplifications.integers.asm"), VM.STANDARD));
		rep.add(new ATLTransformation(pathTo("beautyocl.simplifications.booleans.asm"), VM.STANDARD));
		rep.add(new ATLTransformation(pathTo("beautyocl.simplifications.iterator.asm"), VM.STANDARD));
		
		return rep;
	}

	private static String pathTo(String base) {
		return "platform:/plugin/beautyocl.atl.api/resources/beautyocl/atl/api/" + base;
	}
}
