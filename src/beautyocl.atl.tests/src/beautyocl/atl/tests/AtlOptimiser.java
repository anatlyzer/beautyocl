package beautyocl.atl.tests;

import java.io.File;
import java.io.IOException;

import org.eclipse.jdt.annotation.NonNull;

import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.testing.atl.common.AtlTransformation;
import anatlyzer.testing.difftesting.IOptimiser;
import beautyocl.actions.ExecutionInfo;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.UglyAnATLyzerExpression;

public class AtlOptimiser implements IOptimiser<AtlTransformation> {

	private TransformationRepository rep;
	private File resultFolder;

	public AtlOptimiser(@NonNull TransformationRepository rep, File resultFolder) {
		this.rep = rep;
		this.resultFolder = resultFolder;
	}

	@Override
	public AtlTransformation optimise(AtlTransformation transformation) {
		IAnalyserResult analysis = transformation.getAnalysis();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(analysis, analysis.getATLModel().getRoot());
		
		Beautyfier beauty = new Beautyfier(rep, IExecutionTracer.NULL);
		ExecutionInfo result = beauty.applyAll(exp);
		
		if ( ! resultFolder.exists() ) {
			resultFolder.mkdirs();
		}
		
		String resultFile = resultFolder.getAbsolutePath() + File.separator + transformation.getUnitName() + ".atl";
		try {
			ATLSerializer.serialize(exp.getRoot(), resultFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return transformation.copyAs(resultFile);
	}

}
