/**
 */
package metasearch.provider;


import java.util.Collection;
import java.util.List;

import metasearch.GeneticAlgorithm;
import metasearch.MetasearchPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link metasearch.GeneticAlgorithm} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneticAlgorithmItemProvider extends AlgorithmItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneticAlgorithmItemProvider(AdapterFactory adapterFactory) {
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

			addPopulationSizePropertyDescriptor(object);
			addMutateDeletePropertyDescriptor(object);
			addMutateModifyRulePropertyDescriptor(object);
			addMutateReplaceRulePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Population Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPopulationSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneticAlgorithm_populationSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneticAlgorithm_populationSize_feature", "_UI_GeneticAlgorithm_type"),
				 MetasearchPackage.Literals.GENETIC_ALGORITHM__POPULATION_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mutate Delete feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMutateDeletePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneticAlgorithm_mutateDelete_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneticAlgorithm_mutateDelete_feature", "_UI_GeneticAlgorithm_type"),
				 MetasearchPackage.Literals.GENETIC_ALGORITHM__MUTATE_DELETE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mutate Modify Rule feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMutateModifyRulePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneticAlgorithm_mutateModifyRule_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneticAlgorithm_mutateModifyRule_feature", "_UI_GeneticAlgorithm_type"),
				 MetasearchPackage.Literals.GENETIC_ALGORITHM__MUTATE_MODIFY_RULE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mutate Replace Rule feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMutateReplaceRulePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneticAlgorithm_mutateReplaceRule_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneticAlgorithm_mutateReplaceRule_feature", "_UI_GeneticAlgorithm_type"),
				 MetasearchPackage.Literals.GENETIC_ALGORITHM__MUTATE_REPLACE_RULE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		GeneticAlgorithm geneticAlgorithm = (GeneticAlgorithm)object;
		return getString("_UI_GeneticAlgorithm_type") + " " + geneticAlgorithm.getNrEvaluations();
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

		switch (notification.getFeatureID(GeneticAlgorithm.class)) {
			case MetasearchPackage.GENETIC_ALGORITHM__POPULATION_SIZE:
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_DELETE:
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_MODIFY_RULE:
			case MetasearchPackage.GENETIC_ALGORITHM__MUTATE_REPLACE_RULE:
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
