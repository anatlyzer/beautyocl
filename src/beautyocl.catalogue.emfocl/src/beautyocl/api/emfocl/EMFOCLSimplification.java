package beautyocl.api.emfocl;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.m2m.atl.core.ATLCoreException;

import beautyocl.actions.MatchPhase;
import beautyocl.api.common.FileUtils;
import beautyocl.api.common.IATLTransformation;
import beautyocl.api.common.UglyExpression;

public class EMFOCLSimplification implements IATLTransformation {

	private String fname;
	private static FileUtils futils = new FileUtils(Activator.class);
	
	public EMFOCLSimplification(String fname) {
		this.fname = fname;
	}

	@Override
	public MatchPhase exec(UglyExpression exp) {
		try {
			final String ext = ".asm";
			InputStream asmFile = futils.getFileURL( fname.replace(".atl", ext) ).openStream();
			EMFOclInPlaceExecutor exec = new EMFOclInPlaceExecutor(exp);
			
			exec.apply(asmFile, exp);
			throw new UnsupportedOperationException();
		} catch (IOException | ATLCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


}
