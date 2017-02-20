package beautyocl.atl.api;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.m2m.atl.core.ATLCoreException;

import beautyocl.atl.api.utils.FileUtils;
import beautyocl.atl.api.utils.InPlaceExecutor;

public class ATLTransformation {

	private String fname;

	public ATLTransformation(String fname) {
		this.fname = fname;
	}

	public void exec(UglyExpression exp) {
		String extension = ".emftvm"; // .asm
		
		try {
			InputStream asmFile = FileUtils.getFileURL( fname.replace(".atl", extension) ).openStream();
			InPlaceExecutor exec = new InPlaceExecutor();
			exec.apply(asmFile, exp);
		} catch (ATLCoreException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
