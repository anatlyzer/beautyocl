/**
 */
package emfocl.typwrapper.impl;

import emfocl.typwrapper.TypWrapper;
import emfocl.typwrapper.TypwrapperPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;

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
	public boolean isSameType(OCLExpression e1, OCLExpression e2) {
		EClassifier t1 = getType(e1);
		EClassifier t2 = getType(e2);
		if ( t1 == null || t2 == null )
			return false;
		return t1.equals(t2);
	}
	

	/**
	 * @generated NOT
	 */
	private EClassifier getType(OCLExpression e) {
		if ( e instanceof TypeExp ) {
			return ((TypeExp) e).getReferredType();
		}
		return e.getType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSuperType(OCLExpression e1_subtype, OCLExpression e2_supertype) {
		EClassifier sub = getType(e1_subtype);
		EClassifier sup = getType(e2_supertype);
		if ( ! (sub instanceof EClass && sup instanceof EClass) )
			return false;		
		
		return  sub.equals(sup) || ((EClass) sup).isSuperTypeOf((EClass) sub);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setOperation(OperationCallExp e, String name) {
		try {
			// org.eclipse.ocl.utilities.PredefinedType.
			System.out.println(name);
			// EList<EOperation> ops = OCLStandardLibraryImpl.getExistingOperations(OCLStandardLibraryImpl.INSTANCE.getBoolean());
			EList<EOperation> ops = OCLStandardLibraryImpl.getExistingOperations(OCLStandardLibraryImpl.INSTANCE.getInteger());
			System.out.println(ops);
			//org.eclipse.emf.ecore.EDataType c = (org.eclipse.emf.ecore.EDataType) 
			EOperation op2 = ops.stream().filter(op -> op.getName().equals(name)).findAny().get();
			e.setReferredOperation(op2);
		} catch ( Exception e1 ) {
			e1.printStackTrace();
		}
		
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		
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
				return isSameType((OCLExpression)arguments.get(0), (OCLExpression)arguments.get(1));
			case TypwrapperPackage.TYP_WRAPPER___IS_SUPER_TYPE__OCLEXPRESSION_OCLEXPRESSION:
				return isSuperType((OCLExpression)arguments.get(0), (OCLExpression)arguments.get(1));
			case TypwrapperPackage.TYP_WRAPPER___SET_OPERATION__OPERATIONCALLEXP_STRING:
				setOperation((OperationCallExp)arguments.get(0), (String)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //TypWrapperImpl
