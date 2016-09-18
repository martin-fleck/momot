/**
 */
package at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.MMNames;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.RuleTypePackage;
import at.ac.tuwien.big.momot.examples.tse.metric.ruletype.TransformationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MM Names</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.MMNamesImpl#getInputMM <em>Input MM</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.MMNamesImpl#getOutputMM <em>Output MM</em>}</li>
 *   <li>{@link at.ac.tuwien.big.momot.examples.tse.metric.ruletype.impl.MMNamesImpl#getTrafo <em>Trafo</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MMNamesImpl extends MinimalEObjectImpl.Container implements MMNames {
	/**
	 * The default value of the '{@link #getInputMM() <em>Input MM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputMM()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_MM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputMM() <em>Input MM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputMM()
	 * @generated
	 * @ordered
	 */
	protected String inputMM = INPUT_MM_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputMM() <em>Output MM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputMM()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_MM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputMM() <em>Output MM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputMM()
	 * @generated
	 * @ordered
	 */
	protected String outputMM = OUTPUT_MM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MMNamesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RuleTypePackage.Literals.MM_NAMES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputMM() {
		return inputMM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputMM(String newInputMM) {
		String oldInputMM = inputMM;
		inputMM = newInputMM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleTypePackage.MM_NAMES__INPUT_MM, oldInputMM, inputMM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputMM() {
		return outputMM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputMM(String newOutputMM) {
		String oldOutputMM = outputMM;
		outputMM = newOutputMM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleTypePackage.MM_NAMES__OUTPUT_MM, oldOutputMM, outputMM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationType getTrafo() {
		if (eContainerFeatureID() != RuleTypePackage.MM_NAMES__TRAFO) return null;
		return (TransformationType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrafo(TransformationType newTrafo, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTrafo, RuleTypePackage.MM_NAMES__TRAFO, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrafo(TransformationType newTrafo) {
		if (newTrafo != eInternalContainer() || (eContainerFeatureID() != RuleTypePackage.MM_NAMES__TRAFO && newTrafo != null)) {
			if (EcoreUtil.isAncestor(this, newTrafo))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTrafo != null)
				msgs = ((InternalEObject)newTrafo).eInverseAdd(this, RuleTypePackage.TRANSFORMATION_TYPE__MMS, TransformationType.class, msgs);
			msgs = basicSetTrafo(newTrafo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleTypePackage.MM_NAMES__TRAFO, newTrafo, newTrafo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuleTypePackage.MM_NAMES__TRAFO:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTrafo((TransformationType)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RuleTypePackage.MM_NAMES__TRAFO:
				return basicSetTrafo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RuleTypePackage.MM_NAMES__TRAFO:
				return eInternalContainer().eInverseRemove(this, RuleTypePackage.TRANSFORMATION_TYPE__MMS, TransformationType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuleTypePackage.MM_NAMES__INPUT_MM:
				return getInputMM();
			case RuleTypePackage.MM_NAMES__OUTPUT_MM:
				return getOutputMM();
			case RuleTypePackage.MM_NAMES__TRAFO:
				return getTrafo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RuleTypePackage.MM_NAMES__INPUT_MM:
				setInputMM((String)newValue);
				return;
			case RuleTypePackage.MM_NAMES__OUTPUT_MM:
				setOutputMM((String)newValue);
				return;
			case RuleTypePackage.MM_NAMES__TRAFO:
				setTrafo((TransformationType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RuleTypePackage.MM_NAMES__INPUT_MM:
				setInputMM(INPUT_MM_EDEFAULT);
				return;
			case RuleTypePackage.MM_NAMES__OUTPUT_MM:
				setOutputMM(OUTPUT_MM_EDEFAULT);
				return;
			case RuleTypePackage.MM_NAMES__TRAFO:
				setTrafo((TransformationType)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RuleTypePackage.MM_NAMES__INPUT_MM:
				return INPUT_MM_EDEFAULT == null ? inputMM != null : !INPUT_MM_EDEFAULT.equals(inputMM);
			case RuleTypePackage.MM_NAMES__OUTPUT_MM:
				return OUTPUT_MM_EDEFAULT == null ? outputMM != null : !OUTPUT_MM_EDEFAULT.equals(outputMM);
			case RuleTypePackage.MM_NAMES__TRAFO:
				return getTrafo() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (inputMM: ");
		result.append(inputMM);
		result.append(", outputMM: ");
		result.append(outputMM);
		result.append(')');
		return result.toString();
	}

} //MMNamesImpl
