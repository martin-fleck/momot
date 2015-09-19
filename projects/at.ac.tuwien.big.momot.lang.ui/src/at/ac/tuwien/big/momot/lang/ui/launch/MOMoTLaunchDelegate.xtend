package at.ac.tuwien.big.momot.lang.ui.launch

import org.apache.log4j.Logger
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.debug.core.DebugEvent
import org.eclipse.debug.core.DebugPlugin
import org.eclipse.debug.core.ILaunch
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.model.IProcess
import org.eclipse.debug.ui.RefreshTab
import org.eclipse.jdt.launching.JavaLaunchDelegate

class MOMoTLaunchDelegate extends JavaLaunchDelegate {
	
	override launch(ILaunchConfiguration configuration, 
		            String mode,
		            ILaunch launch, 
		            IProgressMonitor monitor) {
		if (RefreshTab.getRefreshScope(configuration) != null) {
			DebugPlugin.getDefault.addDebugEventListener [
				for (event : it) {
					if (event.source instanceof IProcess && event.kind == DebugEvent.TERMINATE) {
						val process = event.source as IProcess
						if (configuration == process.launch.launchConfiguration) {
							DebugPlugin.getDefault.removeDebugEventListener(self)
							new RefreshJob(configuration).schedule
							return 
						}
					}
				}
			]
		}
		super.launch(configuration, mode, launch, monitor)
	}
}

class RefreshJob extends Job {

	static val Logger logger = Logger.getLogger(MOMoTLaunchDelegate)
	
	ILaunchConfiguration configuration
	
	new(ILaunchConfiguration configuration) {
		super('Refreshing after MOMoT launch')
		this.configuration = configuration
	}
	
	override run(IProgressMonitor monitor) {
		try {
			RefreshTab.refreshResources(configuration, monitor)
		} catch (CoreException e) {
			logger.error(e.message, e)
			return e.status
		}
		Status.OK_STATUS
	}
	
}
