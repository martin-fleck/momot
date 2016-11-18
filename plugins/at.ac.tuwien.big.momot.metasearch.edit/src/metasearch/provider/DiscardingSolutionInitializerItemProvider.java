/**
 */
package metasearch.provider;


import java.util.Collection;
import java.util.List;

import metasearch.DiscardingSolutionInitializer;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link metasearch.DiscardingSolutionInitializer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DiscardingSolutionInitializerItemProvider extends SolutionInitializerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiscardingSolutionInitializerItemProvider(AdapterFactory adapterFactory) {
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

			addSolutionConsiderSizePropertyDescriptor(object);
			addSolutionUseSizePropertyDescriptor(object);
			addSolutionsPerQueuePropertyDescriptor(object);
			addNumQueuesPropertyDescriptor(object);
			addNumInitSolutionsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Solution Consider Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSolutionConsiderSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DiscardingSolutionInitializer_solutionConsiderSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DiscardingSolutionInitializer_solutionConsiderSize_feature", "_UI_DiscardingSolutionInitializer_type"),
				 MetasearchPackage.Literals.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_CONSIDER_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Solution Use Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSolutionUseSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DiscardingSolutionInitializer_solutionUseSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DiscardingSolutionInitializer_solutionUseSize_feature", "_UI_DiscardingSolutionInitializer_type"),
				 MetasearchPackage.Literals.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_USE_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Solutions Per Queue feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSolutionsPerQueuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DiscardingSolutionInitializer_solutionsPerQueue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DiscardingSolutionInitializer_solutionsPerQueue_feature", "_UI_DiscardingSolutionInitializer_type"),
				 MetasearchPackage.Literals.DISCARDING_SOLUTION_INITIALIZER__SOLUTIONS_PER_QUEUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Num Queues feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumQueuesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DiscardingSolutionInitializer_numQueues_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DiscardingSolutionInitializer_numQueues_feature", "_UI_DiscardingSolutionInitializer_type"),
				 MetasearchPackage.Literals.DISCARDING_SOLUTION_INITIALIZER__NUM_QUEUES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Num Init Solutions feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumInitSolutionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DiscardingSolutionInitializer_numInitSolutions_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DiscardingSolutionInitializer_numInitSolutions_feature", "_UI_DiscardingSolutionInitializer_type"),
				 MetasearchPackage.Literals.DISCARDING_SOLUTION_INITIALIZER__NUM_INIT_SOLUTIONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns DiscardingSolutionInitializer.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DiscardingSolutionInitializer"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		DiscardingSolutionInitializer discardingSolutionInitializer = (DiscardingSolutionInitializer)object;
		return getString("_UI_DiscardingSolutionInitializer_type") + " " + discardingSolutionInitializer.getSolutionConsiderSize();
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

		switch (notification.getFeatureID(DiscardingSolutionInitializer.class)) {
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_CONSIDER_SIZE:
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTION_USE_SIZE:
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__SOLUTIONS_PER_QUEUE:
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_QUEUES:
			case MetasearchPackage.DISCARDING_SOLUTION_INITIALIZER__NUM_INIT_SOLUTIONS:
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
