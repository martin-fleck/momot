package at.ac.tuwien.big.momot.examples.wizards;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;

public class MOMoTExampleWizardPlugin extends EMFPlugin {
	/**
	 * The singleton instance of the plugin.
	 */
	public static final MOMoTExampleWizardPlugin INSTANCE = new MOMoTExampleWizardPlugin();

	/**
	 * The one instance of this class.
	 */
	private static Implementation plugin;

	/**
	 * Creates the singleton instance.
	 */
	private MOMoTExampleWizardPlugin() {
		super(new ResourceLocator[] {});
	}

	/*
	 * Javadoc copied from base class.
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 *
	 * @return the singleton instance.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation extends EclipseUIPlugin {
		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
			plugin = this;
		}

		@Override
		public void stop(BundleContext context) throws Exception {
			super.stop(context);
		}
	}
}
