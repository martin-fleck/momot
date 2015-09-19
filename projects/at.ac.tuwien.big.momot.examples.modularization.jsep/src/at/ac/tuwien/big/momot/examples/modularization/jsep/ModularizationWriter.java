package at.ac.tuwien.big.momot.examples.modularization.jsep;

import org.eclipse.emf.henshin.interpreter.EGraph;

import at.ac.tuwien.big.moea.search.fitness.IMultiDimensionalFitnessFunction;
import at.ac.tuwien.big.momot.print.TransformationSolutionWriter;
import at.ac.tuwien.big.momot.util.MomotUtil;

public class ModularizationWriter extends TransformationSolutionWriter {
	
	public ModularizationWriter(IMultiDimensionalFitnessFunction<?> fitnessFunction) {
		super(fitnessFunction);
	}
	
	public ModularizationWriter() { }
	
	@Override
	public String write(EGraph graph) {
		String superWrite = super.write(graph);
		superWrite += MomotUtil.getRoot(graph).toString();
		return superWrite;
	}

}
