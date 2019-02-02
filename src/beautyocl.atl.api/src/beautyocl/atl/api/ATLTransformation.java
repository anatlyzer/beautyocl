package beautyocl.atl.api;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.m2m.atl.core.ATLCoreException;

import beautyocl.actions.MatchPhase;
import beautyocl.api.common.FileUtils;
import beautyocl.api.common.IATLTransformation;
import beautyocl.api.common.UglyExpression;

public class ATLTransformation implements IATLTransformation {

	private String fname;
	private VM vm;
	private String name;
	private static FileUtils futils = new FileUtils(Activator.class);
	
	@Override
	public String getName() {
		return name;
	}
	
	public VM getVm() {
		return vm;
	}
	
	public String getFileName() {
		return fname;
	}
	
	public enum VM {
		STANDARD {
			final String ext = ".asm";
			public MatchPhase execute(String fname, UglyExpression exp) throws IOException, ATLCoreException {
				InputStream asmFile = futils.getFileURL( fname ).openStream();
				InPlaceExecutorATL exec = new InPlaceExecutorATL();
				return exec.apply(fname, asmFile, exp);				
			}
		},
		EMFTVM {
			final String ext = ".emftvm";
			
			@Override
			public MatchPhase execute(String fname, UglyExpression exp) throws IOException, ATLCoreException {
				InputStream asmFile = futils.getFileURL( fname ).openStream();
				InPlaceExecutor exec = new InPlaceExecutor();
				exec.apply(asmFile, exp);
				throw new UnsupportedOperationException("TODO: Implement match-phase at the EMFTVM level");
			}
		};

		public abstract MatchPhase execute(String fname, UglyExpression exp) throws IOException, ATLCoreException;
	}
	
	public ATLTransformation(String name, String fname, VM vm) {
		this.name = name;
		this.fname = fname;
		this.vm = vm;
	}

	public MatchPhase exec(UglyExpression exp) {
		try {
			MatchPhase phase = vm.execute(fname, exp);
			phase.setTransformation(name);
			return phase;
		} catch (IOException | ATLCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
