/**
 */
package beautyocl.atl.typwrapper.impl;

import anatlyzer.atl.model.TypingModel;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.Type;
import anatlyzer.atlext.OCL.OclExpression;

import anatlyzer.atlext.OCL.PropertyCallExp;
import beautyocl.atl.typwrapper.TypWrapper;
import beautyocl.atl.typwrapper.TypwrapperPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EClassifier;
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
			case TypwrapperPackage.TYP_WRAPPER___ACCESS_TYPE__PROPERTYCALLEXP:
				return accessType((PropertyCallExp)arguments.get(0));
			case TypwrapperPackage.TYP_WRAPPER___TYPE_OF__OCLEXPRESSION:
				return typeOf((OclExpression)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //TypWrapperImpl
