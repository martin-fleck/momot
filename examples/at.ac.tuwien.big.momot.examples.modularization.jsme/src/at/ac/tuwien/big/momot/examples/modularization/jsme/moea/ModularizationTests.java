package at.ac.tuwien.big.momot.examples.modularization.jsme.moea;

import at.ac.tuwien.big.momot.examples.modularization.jsme.metric.ModelMetrics;

import org.junit.Assert;
import org.junit.Test;

public class ModularizationTests {

   protected static double DELTA = 0.001;
   protected static ModularizationCalculator calculator = new ModularizationCalculator();

   @Test
   public void testHarman() {
      final ModelMetrics harmanMetrics = calculator
            .calculate(ModularizationInstances.createHarmanPaperModularization());
      final ModelMetrics expectedHarmanMetrics = ModularizationInstances.createHarmanMetrics();
      Assert.assertEquals(expectedHarmanMetrics.cohesion, harmanMetrics.cohesion, DELTA);
      Assert.assertEquals(expectedHarmanMetrics.coupling, harmanMetrics.coupling, DELTA);
      Assert.assertEquals(expectedHarmanMetrics.modularizationQuality, harmanMetrics.modularizationQuality, DELTA);
      Assert.assertEquals(expectedHarmanMetrics.nrModules, harmanMetrics.nrModules, DELTA);
      Assert.assertEquals(expectedHarmanMetrics.minMaxDiff, harmanMetrics.minMaxDiff, DELTA);
   }

   @Test
   public void testKishore() {
      final ModelMetrics kishoreMetrics = calculator
            .calculate(ModularizationInstances.createKishorePaperModularization());
      final ModelMetrics expectedKishoreMetrics = ModularizationInstances.createKishoreMetrics();
      Assert.assertEquals(expectedKishoreMetrics.cohesion, kishoreMetrics.cohesion, DELTA);
      Assert.assertEquals(expectedKishoreMetrics.coupling, kishoreMetrics.coupling, DELTA);
      Assert.assertEquals(expectedKishoreMetrics.modularizationQuality, kishoreMetrics.modularizationQuality, DELTA);
      Assert.assertEquals(expectedKishoreMetrics.nrModules, kishoreMetrics.nrModules, DELTA);
   }
}
