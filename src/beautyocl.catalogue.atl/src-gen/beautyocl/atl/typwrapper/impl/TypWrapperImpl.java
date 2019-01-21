/**
 */
package beautyocl.atl.typwrapper.impl;

import anatlyzer.atl.model.TypingModel;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.TupleType;
import anatlyzer.atl.types.Type;
import anatlyzer.atlext.ATL.PatternElement;
import anatlyzer.atlext.ATL.RuleVariableDeclaration;
import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OCLPackage;
import anatlyzer.atlext.OCL.OclExpression;

import anatlyzer.atlext.OCL.PropertyCallExp;
import anatlyzer.atlext.OCL.VariableDeclaration;
import anatlyzer.atlext.OCL.VariableExp;
import beautyocl.atl.typwrapper.TypWrapper;
import beautyocl.atl.typwrapper.TypwrapperPackage;


import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typ Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TypWrapperImpl extends MinimalEObjectImpl.Container implements TypWrapper {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypWrapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypwrapperPackage.Literals.TYP_WRAPPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSameType(OclExpression e1, OclExpression e2) {
		if ( e1.getInferredType() == null || e2.getInferredType() == null )
			return false;
		return TypingModel.equalTypes(e1.getInferredType(), e2.getInferredType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSuperType(OclExpression e1_subtype, OclExpression e2_supertype) {
		return TypingModel.isCompatible(e1_subtype.getInferredType(), e2_supertype.getInferredType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isNonNull(OclExpression e) {
		if ( e instanceof NavigationOrAttributeCallExp ) {
			NavigationOrAttributeCallExp nav = (NavigationOrAttributeCallExp ) e;
			EStructuralFeature f = (EStructuralFeature) nav.getUsedFeature();
			if ( f != null ) {
				return f.isRequired();
			} else {
				if ( nav.getSource().getInferredType() instanceof TupleType ) {
					// As below. We would need some more analysis, but we assume that it is non-null.
					return true;
				}				
			}
		} 
		else if ( e instanceof VariableExp ) {
			VariableExp exp = (VariableExp) e;
			VariableDeclaration varDcl = exp.getReferredVariable();
			if ( varDcl.eContainingFeature() == OCLPackage.Literals.LET_EXP__VARIABLE ) {
				return isNonNull(varDcl.getInitExpression());
			}		
			else if ( varDcl instanceof Iterator ) {
				// Ok, this may introduce an issue in case the collection has OclUndefined
				// elements... 
				// Alternatives:
				// 1. Resort on the correctness procedure at runtime?
				// 2. Analyse this further checking if the source may generate OclUndefined somehow
				//    maybe with a simple procedure like checking if it uses optionals and/or OclUndefined
				return true;
			} else if ( varDcl instanceof PatternElement ) {
				return true;
			} else if ( varDcl instanceof RuleVariableDeclaration ) {
				return isNonNull(varDcl.getInitExpression());
			}			
		}
		
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClass accessType(PropertyCallExp exp) {
		Type t = exp.getNoCastedType();
		if ( t instanceof Metaclass ) {
			return ((Metaclass) t).getKlass();
		}
		return null;
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		//throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String modelName(VariableDeclaration vd) {
		Type t = vd.getInferredType();
		if ( t instanceof Metaclass ) {
			return ((Metaclass) t).getModel().getName();
		}
		
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		//throw new UnsupportedOperationException();
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier typeOf(OclExpression e) {
		if ( e.getInferredType() instanceof Metaclass ) {
			return ((Metaclass) e.getInferredType()).getKlass();
		}
		
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TypwrapperPackage.TYP_WRAPPER___IS_SAME_TYPE__OCLEXPRESSION_OCLEXPRESSION:
				return isSameType((OclExpression)arguments.get(0), (OclExpression)arguments.get(1));
			case TypwrapperPackage.TYP_WRAPPER___IS_SUPER_TYPE__OCLEXPRESSION_OCLEXPRESSION:
				return isSuperType((OclExpression)arguments.get(0), (OclExpression)arguments.get(1));
			case TypwrapperPackage.TYP_WRAPPER___IS_NON_NULL__OCLEXPRESSION:
				return isNonNull((OclExpression)arguments.get(0));
			case TypwrapperPackage.TYP_WRAPPER___ACCESS_TYPE__PROPERTYCALLEXP:
				return accessType((PropertyCallExp)arguments.get(0));
			case TypwrapperPackage.TYP_WRAPPER___MODEL_NAME__VARIABLEDECLARATION:
				return modelName((VariableDeclaration)arguments.get(0));
			case TypwrapperPackage.TYP_WRAPPER___TYPE_OF__OCLEXPRESSION:
				return typeOf((OclExpression)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //TypWrapperImpl
