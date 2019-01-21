package beautyocl.atl.api.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;

import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.OCLFactory;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OclModel;
import anatlyzer.atlext.OCL.OclModelElement;
import anatlyzer.atlext.OCL.OperationCallExp;
import anatlyzer.atlext.OCL.VariableDeclaration;
import anatlyzer.atlext.OCL.VariableExp;
import beautyocl.api.common.IATLTransformation;
import beautyocl.api.common.TransformationRepository;
import beautyocl.atl.api.ATLTransformation;
import beautyocl.atl.api.ATLTransformation.VM;

public class BeautyATLUtils {
	public static final ATLTransformation SIMP_INTEGERS = new ATLTransformation("integers", pathTo("beautyocl.simplifications.integers.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_BOOLEANS = new ATLTransformation("booleans", pathTo("beautyocl.simplifications.booleans.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IDENTITY_ELEMENT = new ATLTransformation("identity-element", pathTo("beautyocl.simplifications.identityelement.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_ELSE = new ATLTransformation("if-else", pathTo("beautyocl.simplifications.ifelse.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_ITERATORS = new ATLTransformation("iterators", pathTo("beautyocl.simplifications.iterator.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_UNBOUND_ITERATOR = new ATLTransformation("unbound-iterator", pathTo("beautyocl.simplifications.unbounditerator.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_SAME_EXPR = new ATLTransformation("if-same-expr", pathTo("beautyocl.simplifications.ifsameexpr.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_FUSION = new ATLTransformation("if-fusion", pathTo("beautyocl.simplifications.iffusion.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_UNSHORT_CIRCUIT = new ATLTransformation("unshort", pathTo("beautyocl.simplifications.unshortcircuit.asm"), VM.STANDARD);	
	public static final ATLTransformation SIMP_KIND_OF_TRUE = new ATLTransformation("kind-of-true", pathTo("beautyocl.simplifications.kindoftrue.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_KIND_OF_FULL = new ATLTransformation("kind-of-full", pathTo("beautyocl.simplifications.fullTypeComparison.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_INTRO_CALL= new ATLTransformation("if-intro-call", pathTo("beautyocl.simplifications.ifintrocall.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_IF_TRUE_FALSE = new ATLTransformation("if-true-false", pathTo("beautyocl.simplifications.iftruefalse.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_REMOVE_LET = new ATLTransformation("remove-let", pathTo("beautyocl.simplifications.removelet.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_SAME_OPERAND = new ATLTransformation("same-operand", pathTo("beautyocl.simplifications.sameoperand.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_EQUALITY_SEQUENCE = new ATLTransformation("equality-sequence", pathTo("beautyocl.simplifications.equalitysequence.asm"), VM.STANDARD);
	public static final ATLTransformation PULL_UP_CONDITIONAL = new ATLTransformation("pull-up-conditional", pathTo("beautyocl.simplifications.pullupconditional.asm"), VM.STANDARD);
	public static final ATLTransformation SIMP_BUILT_IN_OPERATIONS = new ATLTransformation("built-in-operations", pathTo("beautyocl.simplifications.builtinoperations.asm"), VM.STANDARD);
	
	
	public static TransformationRepository getRepository() {
		TransformationRepository rep = new TransformationRepository();
		// rep.addEMFTVM("beautyocl.simplifications.integer.atl");
		rep.add(SIMP_INTEGERS);
		rep.add(SIMP_BOOLEANS);
		rep.add(SIMP_IDENTITY_ELEMENT);
		rep.add(SIMP_SAME_OPERAND);
		rep.add(SIMP_KIND_OF_TRUE);
		rep.add(SIMP_ITERATORS);
		//Not working yet and not sure if it is an improvement
		//rep.add(SIMP_UNBOUND_ITERATOR);
		rep.add(SIMP_IF_ELSE);
		rep.add(SIMP_IF_SAME_EXPR);
		rep.add(SIMP_IF_FUSION);
		rep.add(SIMP_UNSHORT_CIRCUIT);
		rep.add(SIMP_KIND_OF_FULL);
		rep.add(SIMP_IF_TRUE_FALSE);
		rep.add(SIMP_IF_INTRO_CALL);
		rep.add(SIMP_REMOVE_LET);
		
		rep.add(SIMP_BUILT_IN_OPERATIONS);
		
		// This is idiomatic, should be in a last round with all the idiomatic stuff
		// rep.add(PULL_UP_CONDITIONAL);
		
		rep.add(SIMP_EQUALITY_SEQUENCE);
		return rep;
	}

	private static String pathTo(String base) {
		return "platform:/plugin/beautyocl.atl.api/resources/beautyocl/atl/api/" + base;
	}
	
	/**
	 * Given an expression it computes an object which gathers the elements (typicallyl VariableDeclaration)
	 * which are "outside" the expression. The ExpressionCompletion object contains the algorithm to
	 * create a proper context for the expression. 
	 * 
	 * @return null if the completion is not possible
	 * 
	 */
	public static ExpressionCompletion getCompletion(OclExpression expression) {
		Set<VariableDeclaration> varDcls = new HashSet<>();  
		List<VariableExp> variables = ATLUtils.findAllVarExp(expression);
		for (VariableExp v : variables) {
			if ( ! EcoreUtil.isAncestor(expression, v.getReferredVariable()) ) {
				varDcls.add(v.getReferredVariable());
			}
		}
		
		for (VariableDeclaration variableDeclaration : varDcls) {
			if ( ! (variableDeclaration.getInferredType() instanceof Metaclass) ) {
				return null;
			}
		}
		
		return new ExpressionCompletion(expression, varDcls);
	}
	
	public static class ExpressionCompletion {
		private OclExpression expression;
		private Set<? extends VariableDeclaration> context;

		public ExpressionCompletion(OclExpression expression, Set<? extends VariableDeclaration> context) {
			this.expression = expression;
			this.context = context;
		}
		
		public OclExpression toExpressionContext() {
			if ( context.size() == 0 )
				return expression;
			
			List<VariableExp> variables = ATLUtils.findAllVarExp(expression);
			IteratorExp outer = null;
			
			for (VariableDeclaration dcl : context) {
				Iterator it = OCLFactory.eINSTANCE.createIterator();
				it.setVarName(dcl.getVarName());

				for (VariableExp vexp : variables) {
					if ( vexp.getReferredVariable() == dcl ) {
						vexp.setReferredVariable(it);
					}
				}
				
				IteratorExp iterator = OCLFactory.eINSTANCE.createIteratorExp();
				iterator.getIterators().add(it);
				iterator.setName("forAll");
				
				SOURCE:
				{
					OclModelElement me = OCLFactory.eINSTANCE.createOclModelElement();
					
					Metaclass metaclass = (Metaclass) dcl.getInferredType();
					
					me.setName(metaclass.getName());
					OclModel m = OCLFactory.eINSTANCE.createOclModel();
					m.setName(metaclass.getModel().getName());								
					me.setModel(m);
					
					OperationCallExp allInstances = OCLFactory.eINSTANCE.createOperationCallExp();
					allInstances.setOperationName("allInstances");
					allInstances.setSource(me);
					
					iterator.setSource(allInstances);
				}
				
				if ( outer == null ) {
					outer = iterator;
					outer.setBody(expression);
				} else {
					iterator.setBody(outer);
					outer = iterator;
				}
			}
			
			return outer;
		}
	}
}
