/**
 */
package icmt.tool.momot.demo.architectureCRA.impl;

import icmt.tool.momot.demo.architectureCRA.ArchitecturePackage;
import icmt.tool.momot.demo.architectureCRA.Feature;

import icmt.tool.momot.demo.architectureCRA.SenselessToken;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.FeatureImpl#getIsEncapsulatedBy <em>Is Encapsulated By</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.FeatureImpl#getNext <em>Next</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.FeatureImpl#getPrev <em>Prev</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.FeatureImpl#getSenselessToken <em>Senseless Token</em>}</li>
 *   <li>{@link icmt.tool.momot.demo.architectureCRA.impl.FeatureImpl#getFind <em>Find</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FeatureImpl extends NamedElementImpl implements Feature {
	/**
	 * The cached value of the '{@link #getIsEncapsulatedBy() <em>Is Encapsulated By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsEncapsulatedBy()
	 * @generated
	 * @ordered
	 */
	protected icmt.tool.momot.demo.architectureCRA.Class isEncapsulatedBy;

	/**
	 * The cached value of the '{@link #getNext() <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNext()
	 * @generated
	 * @ordered
	 */
	protected Feature next;

	/**
	 * The cached value of the '{@link #getPrev() <em>Prev</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrev()
	 * @generated
	 * @ordered
	 */
	protected Feature prev;

	/**
	 * The cached value of the '{@link #getSenselessToken() <em>Senseless Token</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSenselessToken()
	 * @generated
	 * @ordered
	 */
	protected SenselessToken senselessToken;

	/**
	 * The default value of the '{@link #getFind() <em>Find</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFind()
	 * @generated
	 * @ordered
	 */
	protected static final int FIND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFind() <em>Find</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFind()
	 * @generated
	 * @ordered
	 */
	protected int find = FIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ArchitecturePackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public icmt.tool.momot.demo.architectureCRA.Class getIsEncapsulatedBy() {
		if (isEncapsulatedBy != null && isEncapsulatedBy.eIsProxy()) {
			InternalEObject oldIsEncapsulatedBy = (InternalEObject)isEncapsulatedBy;
			isEncapsulatedBy = (icmt.tool.momot.demo.architectureCRA.Class)eResolveProxy(oldIsEncapsulatedBy);
			if (isEncapsulatedBy != oldIsEncapsulatedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY, oldIsEncapsulatedBy, isEncapsulatedBy));
			}
		}
		return isEncapsulatedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public icmt.tool.momot.demo.architectureCRA.Class basicGetIsEncapsulatedBy() {
		return isEncapsulatedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIsEncapsulatedBy(icmt.tool.momot.demo.architectureCRA.Class newIsEncapsulatedBy, NotificationChain msgs) {
		icmt.tool.momot.demo.architectureCRA.Class oldIsEncapsulatedBy = isEncapsulatedBy;
		isEncapsulatedBy = newIsEncapsulatedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY, oldIsEncapsulatedBy, newIsEncapsulatedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsEncapsulatedBy(icmt.tool.momot.demo.architectureCRA.Class newIsEncapsulatedBy) {
		if (newIsEncapsulatedBy != isEncapsulatedBy) {
			NotificationChain msgs = null;
			if (isEncapsulatedBy != null)
				msgs = ((InternalEObject)isEncapsulatedBy).eInverseRemove(this, ArchitecturePackage.CLASS__ENCAPSULATES, icmt.tool.momot.demo.architectureCRA.Class.class, msgs);
			if (newIsEncapsulatedBy != null)
				msgs = ((InternalEObject)newIsEncapsulatedBy).eInverseAdd(this, ArchitecturePackage.CLASS__ENCAPSULATES, icmt.tool.momot.demo.architectureCRA.Class.class, msgs);
			msgs = basicSetIsEncapsulatedBy(newIsEncapsulatedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY, newIsEncapsulatedBy, newIsEncapsulatedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Feature getNext() {
		if (next != null && next.eIsProxy()) {
			InternalEObject oldNext = (InternalEObject)next;
			next = (Feature)eResolveProxy(oldNext);
			if (next != oldNext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.FEATURE__NEXT, oldNext, next));
			}
		}
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetNext() {
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNext(Feature newNext, NotificationChain msgs) {
		Feature oldNext = next;
		next = newNext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__NEXT, oldNext, newNext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNext(Feature newNext) {
		if (newNext != next) {
			NotificationChain msgs = null;
			if (next != null)
				msgs = ((InternalEObject)next).eInverseRemove(this, ArchitecturePackage.FEATURE__PREV, Feature.class, msgs);
			if (newNext != null)
				msgs = ((InternalEObject)newNext).eInverseAdd(this, ArchitecturePackage.FEATURE__PREV, Feature.class, msgs);
			msgs = basicSetNext(newNext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__NEXT, newNext, newNext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Feature getPrev() {
		if (prev != null && prev.eIsProxy()) {
			InternalEObject oldPrev = (InternalEObject)prev;
			prev = (Feature)eResolveProxy(oldPrev);
			if (prev != oldPrev) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.FEATURE__PREV, oldPrev, prev));
			}
		}
		return prev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetPrev() {
		return prev;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrev(Feature newPrev, NotificationChain msgs) {
		Feature oldPrev = prev;
		prev = newPrev;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__PREV, oldPrev, newPrev);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrev(Feature newPrev) {
		if (newPrev != prev) {
			NotificationChain msgs = null;
			if (prev != null)
				msgs = ((InternalEObject)prev).eInverseRemove(this, ArchitecturePackage.FEATURE__NEXT, Feature.class, msgs);
			if (newPrev != null)
				msgs = ((InternalEObject)newPrev).eInverseAdd(this, ArchitecturePackage.FEATURE__NEXT, Feature.class, msgs);
			msgs = basicSetPrev(newPrev, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__PREV, newPrev, newPrev));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SenselessToken getSenselessToken() {
		return senselessToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSenselessToken(SenselessToken newSenselessToken, NotificationChain msgs) {
		SenselessToken oldSenselessToken = senselessToken;
		senselessToken = newSenselessToken;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__SENSELESS_TOKEN, oldSenselessToken, newSenselessToken);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSenselessToken(SenselessToken newSenselessToken) {
		if (newSenselessToken != senselessToken) {
			NotificationChain msgs = null;
			if (senselessToken != null)
				msgs = ((InternalEObject)senselessToken).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ArchitecturePackage.FEATURE__SENSELESS_TOKEN, null, msgs);
			if (newSenselessToken != null)
				msgs = ((InternalEObject)newSenselessToken).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ArchitecturePackage.FEATURE__SENSELESS_TOKEN, null, msgs);
			msgs = basicSetSenselessToken(newSenselessToken, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__SENSELESS_TOKEN, newSenselessToken, newSenselessToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFind() {
		return find;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFind(int newFind) {
		int oldFind = find;
		find = newFind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.FEATURE__FIND, oldFind, find));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				if (isEncapsulatedBy != null)
					msgs = ((InternalEObject)isEncapsulatedBy).eInverseRemove(this, ArchitecturePackage.CLASS__ENCAPSULATES, icmt.tool.momot.demo.architectureCRA.Class.class, msgs);
				return basicSetIsEncapsulatedBy((icmt.tool.momot.demo.architectureCRA.Class)otherEnd, msgs);
			case ArchitecturePackage.FEATURE__NEXT:
				if (next != null)
					msgs = ((InternalEObject)next).eInverseRemove(this, ArchitecturePackage.FEATURE__PREV, Feature.class, msgs);
				return basicSetNext((Feature)otherEnd, msgs);
			case ArchitecturePackage.FEATURE__PREV:
				if (prev != null)
					msgs = ((InternalEObject)prev).eInverseRemove(this, ArchitecturePackage.FEATURE__NEXT, Feature.class, msgs);
				return basicSetPrev((Feature)otherEnd, msgs);
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
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				return basicSetIsEncapsulatedBy(null, msgs);
			case ArchitecturePackage.FEATURE__NEXT:
				return basicSetNext(null, msgs);
			case ArchitecturePackage.FEATURE__PREV:
				return basicSetPrev(null, msgs);
			case ArchitecturePackage.FEATURE__SENSELESS_TOKEN:
				return basicSetSenselessToken(null, msgs);
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
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				if (resolve) return getIsEncapsulatedBy();
				return basicGetIsEncapsulatedBy();
			case ArchitecturePackage.FEATURE__NEXT:
				if (resolve) return getNext();
				return basicGetNext();
			case ArchitecturePackage.FEATURE__PREV:
				if (resolve) return getPrev();
				return basicGetPrev();
			case ArchitecturePackage.FEATURE__SENSELESS_TOKEN:
				return getSenselessToken();
			case ArchitecturePackage.FEATURE__FIND:
				return getFind();
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
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				setIsEncapsulatedBy((icmt.tool.momot.demo.architectureCRA.Class)newValue);
				return;
			case ArchitecturePackage.FEATURE__NEXT:
				setNext((Feature)newValue);
				return;
			case ArchitecturePackage.FEATURE__PREV:
				setPrev((Feature)newValue);
				return;
			case ArchitecturePackage.FEATURE__SENSELESS_TOKEN:
				setSenselessToken((SenselessToken)newValue);
				return;
			case ArchitecturePackage.FEATURE__FIND:
				setFind((Integer)newValue);
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
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				setIsEncapsulatedBy((icmt.tool.momot.demo.architectureCRA.Class)null);
				return;
			case ArchitecturePackage.FEATURE__NEXT:
				setNext((Feature)null);
				return;
			case ArchitecturePackage.FEATURE__PREV:
				setPrev((Feature)null);
				return;
			case ArchitecturePackage.FEATURE__SENSELESS_TOKEN:
				setSenselessToken((SenselessToken)null);
				return;
			case ArchitecturePackage.FEATURE__FIND:
				setFind(FIND_EDEFAULT);
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
			case ArchitecturePackage.FEATURE__IS_ENCAPSULATED_BY:
				return isEncapsulatedBy != null;
			case ArchitecturePackage.FEATURE__NEXT:
				return next != null;
			case ArchitecturePackage.FEATURE__PREV:
				return prev != null;
			case ArchitecturePackage.FEATURE__SENSELESS_TOKEN:
				return senselessToken != null;
			case ArchitecturePackage.FEATURE__FIND:
				return find != FIND_EDEFAULT;
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
		result.append(" (find: ");
		result.append(find);
		result.append(')');
		return result.toString();
	}

} //FeatureImpl
