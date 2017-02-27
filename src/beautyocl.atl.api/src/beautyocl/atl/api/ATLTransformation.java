package beautyocl.atl.api;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.m2m.atl.core.ATLCoreException;

import beautyocl.api.common.FileUtils;
import beautyocl.api.common.IATLTransformation;
import beautyocl.api.common.UglyExpression;

public class ATLTransformation implements IATLTransformation {

	private String fname;
	private VM vm;
	private static FileUtils futils = new FileUtils(Activator.class);
	
	public enum VM {
		STANDARD {
			final String ext = ".asm";
			public void execute(String fname, UglyExpression exp) throws IOException, ATLCoreException {
				InputStream asmFile = futils.getFileURL( fname.replace(".atl", ext) ).openStream();
				InPlaceExecutorATL exec = new InPlaceExecutorATL();
				exec.apply(asmFile, exp);				
			}
		},
		EMFTVM {
			final String ext = ".emftvm";
			
			@Override
			public void execute(String fname, UglyExpression exp) throws IOException, ATLCoreException {
				InputStream asmFile = futils.getFileURL( fname.replace(".atl", ext) ).openStream();
				InPlaceExecutor exec = new InPlaceExecutor();
				exec.apply(asmFile, exp);	
			}
		};

		public abstract void execute(String fname, UglyExpression exp) throws IOException, ATLCoreException;
	}
	
	public ATLTransformation(String fname, VM vm) {
		this.fname = fname;
		this.vm = vm;
	}

	public void exec(UglyExpression exp) {
		try {
			vm.execute(fname, exp);
		} catch (IOException | ATLCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
