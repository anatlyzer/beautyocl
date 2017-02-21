package beautyocl.atl.api;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.m2m.atl.core.ATLCoreException;

import beautyocl.atl.api.utils.FileUtils;
import beautyocl.atl.api.utils.InPlaceExecutor;
import beautyocl.atl.api.utils.InPlaceExecutorATL;

public class ATLTransformation {

	private String fname;
	private VM vm;
	
	public enum VM {
		STANDARD {
			final String ext = ".asm";
			public void execute(String fname, UglyExpression exp) throws IOException, ATLCoreException {
				InputStream asmFile = FileUtils.getFileURL( fname.replace(".atl", ext) ).openStream();
				InPlaceExecutorATL exec = new InPlaceExecutorATL();
				exec.apply(asmFile, exp);				
			}
		},
		EMFTVM {
			final String ext = ".emftvm";
			
			@Override
			public void execute(String fname, UglyExpression exp) throws IOException, ATLCoreException {
				InputStream asmFile = FileUtils.getFileURL( fname.replace(".atl", ext) ).openStream();
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
