/**
 */
package metasearch.provider;


import java.util.Collection;
import java.util.List;

import metasearch.MetasearchPackage;
import metasearch.SimulatedAnnealing;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link metasearch.SimulatedAnnealing} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulatedAnnealingItemProvider extends TabuSupportingLocalSearchItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulatedAnnealingItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addStartTempPropertyDescriptor(object);
			addTempIncreasePropertyDescriptor(object);
			addRestartNoCurrentImpPropertyDescriptor(object);
			addRestartNoBestImpPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Start Temp feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStartTempPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulatedAnnealing_startTemp_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulatedAnnealing_startTemp_feature", "_UI_SimulatedAnnealing_type"),
				 MetasearchPackage.Literals.SIMULATED_ANNEALING__START_TEMP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Temp Increase feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTempIncreasePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulatedAnnealing_tempIncrease_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulatedAnnealing_tempIncrease_feature", "_UI_SimulatedAnnealing_type"),
				 MetasearchPackage.Literals.SIMULATED_ANNEALING__TEMP_INCREASE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Restart No Current Imp feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRestartNoCurrentImpPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulatedAnnealing_restartNoCurrentImp_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulatedAnnealing_restartNoCurrentImp_feature", "_UI_SimulatedAnnealing_type"),
				 MetasearchPackage.Literals.SIMULATED_ANNEALING__RESTART_NO_CURRENT_IMP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Restart No Best Imp feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRestartNoBestImpPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SimulatedAnnealing_restartNoBestImp_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SimulatedAnnealing_restartNoBestImp_feature", "_UI_SimulatedAnnealing_type"),
				 MetasearchPackage.Literals.SIMULATED_ANNEALING__RESTART_NO_BEST_IMP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns SimulatedAnnealing.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SimulatedAnnealing"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		SimulatedAnnealing simulatedAnnealing = (SimulatedAnnealing)object;
		return getString("_UI_SimulatedAnnealing_type") + " " + simulatedAnnealing.getNrEvaluations();
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SimulatedAnnealing.class)) {
			case MetasearchPackage.SIMULATED_ANNEALING__START_TEMP:
			case MetasearchPackage.SIMULATED_ANNEALING__TEMP_INCREASE:
			case MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_CURRENT_IMP:
			case MetasearchPackage.SIMULATED_ANNEALING__RESTART_NO_BEST_IMP:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
