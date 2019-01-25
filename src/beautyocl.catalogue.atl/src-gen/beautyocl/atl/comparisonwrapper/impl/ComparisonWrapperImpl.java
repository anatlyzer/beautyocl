/**
 */
package beautyocl.atl.comparisonwrapper.impl;

import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atlext.OCL.OclExpression;

import beautyocl.atl.comparisonwrapper.ComparisonWrapper;
import beautyocl.atl.comparisonwrapper.ComparisonwrapperPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Comparison Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ComparisonWrapperImpl extends MinimalEObjectImpl.Container implements ComparisonWrapper {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComparisonWrapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComparisonwrapperPackage.Literals.COMPARISON_WRAPPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSameExpr(OclExpression e1, OclExpression e2) {
		if ( e1 == null || e2 == null )
			return false;
		String s1 = ATLSerializer.serialize(e1);
		String s2 = ATLSerializer.serialize(e2);
		//System.out.println(s1.equals(s2));
		return s1.equals(s2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ComparisonwrapperPackage.COMPARISON_WRAPPER___IS_SAME_EXPR__OCLEXPRESSION_OCLEXPRESSION:
				return isSameExpr((OclExpression)arguments.get(0), (OclExpression)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ComparisonWrapperImpl
