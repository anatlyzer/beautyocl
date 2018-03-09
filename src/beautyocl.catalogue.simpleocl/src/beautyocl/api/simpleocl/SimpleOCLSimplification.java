package beautyocl.api.simpleocl;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.m2m.atl.core.ATLCoreException;

import beautyocl.actions.MatchPhase;
import beautyocl.api.common.FileUtils;
import beautyocl.api.common.IATLTransformation;
import beautyocl.api.common.UglyExpression;

public class SimpleOCLSimplification implements IATLTransformation {

	private String fname;
	private String name;
	private static FileUtils futils = new FileUtils(Activator.class);
	
	public SimpleOCLSimplification(String name, String fname) {
		this.name = name;
		this.fname = fname;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public MatchPhase exec(UglyExpression exp) {
		try {
			final String ext = ".asm";
			InputStream asmFile = futils.getFileURL( fname.replace(".atl", ext) ).openStream();
			SimpleOCLInPlaceExecutor exec = new SimpleOCLInPlaceExecutor(exp);
			
			return exec.apply(name, asmFile, exp);
		} catch (IOException | ATLCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String getFileName() {
		return fname;
	}


}
