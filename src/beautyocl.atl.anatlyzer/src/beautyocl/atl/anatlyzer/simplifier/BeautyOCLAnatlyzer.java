package beautyocl.atl.anatlyzer.simplifier;

import org.eclipse.emf.ecore.EObject;

import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.simplifier.IOclSimplifier;
import beautyocl.actions.ExecutionInfo;
import beautyocl.actions.IExecutionTracer;
import beautyocl.api.common.Beautyfier;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.UglyAnATLyzerExpression;
import beautyocl.atl.api.utils.BeautyATLUtils;

public class BeautyOCLAnatlyzer implements IOclSimplifier {

	public BeautyOCLAnatlyzer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public EObject simplify(ATLModel model, EObject obj) {
		return simplify(model, obj, IExecutionTracer.NULL).getResult();
	}

	public ExecutionInfo simplify(ATLModel model, EObject obj, IExecutionTracer tracer) {
		TransformationRepository rep = BeautyATLUtils.getRepository();
		UglyAnATLyzerExpression exp = new UglyAnATLyzerExpression(model, obj);
		
		Beautyfier beauty = new Beautyfier(rep, tracer);
		ExecutionInfo info = beauty.applyAll(exp);
		
		// This should be changed by the object returned by applyAll
		// i.e., applyAll should be able to properly fill info.setResult
		info.setResult(obj);		
		
		return info;
	}

}