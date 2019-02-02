package beautyocl.atl.evaluation;

import org.eclipse.emf.ecore.EObject;

import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.simplifier.IOclSimplifier;
import beautyocl.actions.ExecutionInfo;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.IATLTransformation;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.anatlyzer.simplifier.BeautyOCLAnatlyzer;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.UglyAnATLyzerExpression;
import beautyocl.atl.api.utils.BeautyATLUtils;

/**
 * Similar to {@link BeautyOCLAnatlyzer} but it adapts the repository to work
 * with transformations with coverage.
 * 
 * @author jesus
 */
public class BeautyOCLAnatlyzerWithCoverage implements IOclSimplifier {


	@Override
	public EObject simplify(IAnalyserResult r, EObject obj) {
		return simplify(r, obj, IExecutionTracer.NULL).getResult();
	}

	public ExecutionInfo simplify(IAnalyserResult r, EObject obj, IExecutionTracer tracer) {
		TransformationRepository rep = adaptedRepository();
		
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(r, obj);
		
		Beautyfier beauty = new Beautyfier(rep, tracer);
		ExecutionInfo info = beauty.applyAll(exp);
		
		return info;
	}

	private TransformationRepository adaptedRepository() {
		TransformationRepository original = BeautyATLUtils.getRepository();
		TransformationRepository rep = new TransformationRepository();
		
		for (IATLTransformation t : original.getTransformations()) {
			// This has to be an ATL transformation
			ATLTransformation atl = (ATLTransformation) t;
			String newFileName = atl.getFileName().replace("asm$", "_coverage.asm");
			ATLTransformation newTrafo = new ATLTransformation(atl.getName(), newFileName, atl.getVm());
		
			rep.add(newTrafo);
		}
		
		return rep;
	}

}
