/**
 */
package icmt.tool.momot.demo.architectureCRA.impl;

import icmt.tool.momot.demo.architectureCRA.ArchitecturePackage;
import icmt.tool.momot.demo.architectureCRA.ClassModel;
import icmt.tool.momot.demo.architectureCRA.Feature;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.ClassModelImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.ClassModelImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.ClassModelImpl#getCounter <em>Counter</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.ClassModelImpl#getClasscounter <em>Classcounter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassModelImpl extends NamedElementImpl implements ClassModel {
	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<icmt.tool.momot.demo.architectureCRA.Class> classes;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * The default value of the '{@link #getCounter() <em>Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCounter()
	 * @generated
	 * @ordered
	 */
	protected static final int COUNTER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCounter() <em>Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCounter()
	 * @generated
	 * @ordered
	 */
	protected int counter = COUNTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getClasscounter() <em>Classcounter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasscounter()
	 * @generated
	 * @ordered
	 */
	protected static final int CLASSCOUNTER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getClasscounter() <em>Classcounter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasscounter()
	 * @generated
	 * @ordered
	 */
	protected int classcounter = CLASSCOUNTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.CLASS_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<icmt.tool.momot.demo.architectureCRA.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<icmt.tool.momot.demo.architectureCRA.Class>(icmt.tool.momot.demo.architectureCRA.Class.class, this, ArchitecturePackage.CLASS_MODEL__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<Feature>(Feature.class, this, ArchitecturePackage.CLASS_MODEL__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCounter() {
		return counter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCounter(int newCounter) {
		int oldCounter = counter;
		counter = newCounter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.CLASS_MODEL__COUNTER, oldCounter, counter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getClasscounter() {
		return classcounter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClasscounter(int newClasscounter) {
		int oldClasscounter = classcounter;
		classcounter = newClasscounter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.CLASS_MODEL__CLASSCOUNTER, oldClasscounter, classcounter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.CLASS_MODEL__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case ArchitecturePackage.CLASS_MODEL__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArchitecturePackage.CLASS_MODEL__CLASSES:
				return getClasses();
			case ArchitecturePackage.CLASS_MODEL__FEATURES:
				return getFeatures();
			case ArchitecturePackage.CLASS_MODEL__COUNTER:
				return getCounter();
			case ArchitecturePackage.CLASS_MODEL__CLASSCOUNTER:
				return getClasscounter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ArchitecturePackage.CLASS_MODEL__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends icmt.tool.momot.demo.architectureCRA.Class>)newValue);
				return;
			case ArchitecturePackage.CLASS_MODEL__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case ArchitecturePackage.CLASS_MODEL__COUNTER:
				setCounter((Integer)newValue);
				return;
			case ArchitecturePackage.CLASS_MODEL__CLASSCOUNTER:
				setClasscounter((Integer)newValue);
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
			case ArchitecturePackage.CLASS_MODEL__CLASSES:
				getClasses().clear();
				return;
			case ArchitecturePackage.CLASS_MODEL__FEATURES:
				getFeatures().clear();
				return;
			case ArchitecturePackage.CLASS_MODEL__COUNTER:
				setCounter(COUNTER_EDEFAULT);
				return;
			case ArchitecturePackage.CLASS_MODEL__CLASSCOUNTER:
				setClasscounter(CLASSCOUNTER_EDEFAULT);
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
			case ArchitecturePackage.CLASS_MODEL__CLASSES:
				return classes != null && !classes.isEmpty();
			case ArchitecturePackage.CLASS_MODEL__FEATURES:
				return features != null && !features.isEmpty();
			case ArchitecturePackage.CLASS_MODEL__COUNTER:
				return counter != COUNTER_EDEFAULT;
			case ArchitecturePackage.CLASS_MODEL__CLASSCOUNTER:
				return classcounter != CLASSCOUNTER_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (counter: ");
		result.append(counter);
		result.append(", classcounter: ");
		result.append(classcounter);
		result.append(')');
		return result.toString();
	}

} //ClassModelImpl
