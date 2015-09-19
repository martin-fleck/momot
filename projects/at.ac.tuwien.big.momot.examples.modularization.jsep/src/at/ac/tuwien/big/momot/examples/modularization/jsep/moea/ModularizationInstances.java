package at.ac.tuwien.big.momot.examples.modularization.jsep.moea;

import java.util.List;

import com.google.common.collect.Lists;

import at.ac.tuwien.big.momot.examples.modularization.jsep.metric.ModelMetrics;

public class ModularizationInstances {
	public static ModularizationResult createHarmanPaperModularization() {
		return new ModularizationResult(createHarmanPaperInstance(), createHarmanAssignment());
	}
	
	public static ModularizationInstance createHarmanPaperInstance() {
		ModularizationInstance instance = new ModularizationInstance();
		instance.addClasses("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8");
		instance.addDependencies("M1", "M3");
		instance.addDependencies("M2", "M3");
		instance.addDependencies("M3", "M5");
		instance.addDependencies("M4", "M1", "M5");
		instance.addDependencies("M6", "M7", "M8");
		instance.addDependencies("M8", "M5", "M7");
		return instance;
	}
	
	public static List<Integer> createHarmanAssignment() {
		return Lists.newArrayList(2, 1, 1, 2, 2, 3, 3, 3);
	}
	
	public static ModelMetrics createHarmanMetrics() {
		ModelMetrics metrics = new ModelMetrics();
		metrics.coupling = 6;
		metrics.cohesion = 6;
		metrics.nrModules = 3;
		metrics.modularizationQuality = 1.928571;
		metrics.minMaxDiff = 1;
		return metrics;
	}
	
	public static ModularizationResult createKishorePaperModularization() {
		return new ModularizationResult(createKishorePaperInstance(), createKishoreAssignment());
	}
	
	public static ModularizationInstance createKishorePaperInstance() {
		ModularizationInstance instance = new ModularizationInstance();
		instance.addClasses("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10");
		instance.addDependencies("M1", "M6", "M9");
		instance.addDependencies("M3", "M2", "M10");
		instance.addDependencies("M4", "M7");
		instance.addDependencies("M5", "M4", "M8");
		instance.addDependencies("M7", "M2");
		instance.addDependencies("M8", "M4");
		instance.addDependencies("M9", "M4", "M6");
		instance.addDependencies("M10", "M4");
		return instance;
	}
	
	public static List<Integer> createKishoreAssignment() {
		return Lists.newArrayList(0, 2, 2, 1, 1, 0, 2, 1, 0, 2);
	}
	
	public static ModelMetrics createKishoreMetrics() {
		ModelMetrics metrics = new ModelMetrics();
		metrics.coupling = 6;
		metrics.cohesion = 9;
		metrics.nrModules = 3;
		metrics.modularizationQuality = 2.207; // in paper, but probably a mistake
		metrics.modularizationQuality = 2.273;
		return metrics;
	}
	
	public static ModularizationInstance createMtunis() {
		ModularizationInstance instance = new ModularizationInstance();
		instance.addClasses(
				"File", "Panic", "State", "Family", "Directory", 
				"main", "FileTable", "InodeGlobals", "Inode", "Tty", 
				"User", "FileIO", "Device", "Disk", "FreeInode", 
				"System", "Control", "InodeTable", "Computer", "Memory");
		instance.addDependencies("File", "System", "Inode", "Directory", "Panic", "FileTable");
		instance.addDependencies("Panic", "Directory", "File", "Inode", "Disk", "InodeTable", "FileIO", "InodeGlobals", "Control", "User", "Computer");
		instance.addDependencies("State", "System", "File", "Memory", "Computer");
		instance.addDependencies("Family", "State");
		instance.addDependencies("Directory", "Panic", "Inode");
		instance.addDependencies("main", "User", "Control");
		instance.addDependencies("FileTable", "Inode");
		instance.addDependencies("InodeGlobals", "Panic", "Device", "System");
		instance.addDependencies("Inode", "Panic", "Device", "System", "InodeTable", "FreeInode", "FileIO", "InodeGlobals");
		instance.addDependencies("Tty", "System");
		instance.addDependencies("User", "File", "System", "Panic", "Family", "State", "Memory", "Computer");
		instance.addDependencies("FileIO", "Panic", "Device", "InodeGlobals");
		instance.addDependencies("Device", "Tty", "Disk", "System");
		instance.addDependencies("Disk", "System", "Panic");
		instance.addDependencies("FreeInode", "FileIO", "InodeGlobals");
		instance.addDependencies("System"); // no dependencies
		instance.addDependencies("Control", "File", "Panic", "Tty", "Family", "System");
		instance.addDependencies("InodeTable", "FileIO", "FreeInode", "Panic", "InodeGlobals");
		instance.addDependencies("Computer", "Panic", "System");
		instance.addDependencies("Memory", "File", "System", "Computer");
		return instance;
	}
	
	public static List<Integer> createMtunisKishoreAssignment() {
		return Lists.newArrayList(1, 1, 4, 4, 1, 4, 1, 3, 1, 2, 4, 3, 2, 2, 3, 2, 4, 3, 4, 4);
	}
}
