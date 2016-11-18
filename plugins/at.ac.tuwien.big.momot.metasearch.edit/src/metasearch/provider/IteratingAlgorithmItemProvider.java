/**
 */
package metasearch.provider;


import java.util.Collection;
import java.util.List;

import metasearch.IteratingAlgorithm;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link metasearch.IteratingAlgorithm} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class IteratingAlgorithmItemProvider extends AlgorithmItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratingAlgorithmItemProvider(AdapterFactory adapterFactory) {
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

			addSolutioninitializerPropertyDescriptor(object);
			addAlgorithmPropertyDescriptor(object);
			addFitnesscomparatorgeneratorPropertyDescriptor(object);
			addTournamentSizePropertyDescriptor(object);
			addTournamentRemainPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Solutioninitializer feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSolutioninitializerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IteratingAlgorithm_solutioninitializer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IteratingAlgorithm_solutioninitializer_feature", "_UI_IteratingAlgorithm_type"),
				 MetasearchPackage.Literals.ITERATING_ALGORITHM__SOLUTIONINITIALIZER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Algorithm feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAlgorithmPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IteratingAlgorithm_algorithm_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IteratingAlgorithm_algorithm_feature", "_UI_IteratingAlgorithm_type"),
				 MetasearchPackage.Literals.ITERATING_ALGORITHM__ALGORITHM,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fitnesscomparatorgenerator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFitnesscomparatorgeneratorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IteratingAlgorithm_fitnesscomparatorgenerator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IteratingAlgorithm_fitnesscomparatorgenerator_feature", "_UI_IteratingAlgorithm_type"),
				 MetasearchPackage.Literals.ITERATING_ALGORITHM__FITNESSCOMPARATORGENERATOR,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tournament Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTournamentSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IteratingAlgorithm_tournamentSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IteratingAlgorithm_tournamentSize_feature", "_UI_IteratingAlgorithm_type"),
				 MetasearchPackage.Literals.ITERATING_ALGORITHM__TOURNAMENT_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Tournament Remain feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTournamentRemainPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IteratingAlgorithm_tournamentRemain_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IteratingAlgorithm_tournamentRemain_feature", "_UI_IteratingAlgorithm_type"),
				 MetasearchPackage.Literals.ITERATING_ALGORITHM__TOURNAMENT_REMAIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns IteratingAlgorithm.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IteratingAlgorithm"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		IteratingAlgorithm iteratingAlgorithm = (IteratingAlgorithm)object;
		return getString("_UI_IteratingAlgorithm_type") + " " + iteratingAlgorithm.getTournamentSize();
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

		switch (notification.getFeatureID(IteratingAlgorithm.class)) {
			case MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_SIZE:
			case MetasearchPackage.ITERATING_ALGORITHM__TOURNAMENT_REMAIN:
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
