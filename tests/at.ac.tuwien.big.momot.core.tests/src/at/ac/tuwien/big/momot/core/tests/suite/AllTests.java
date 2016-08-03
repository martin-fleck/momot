package at.ac.tuwien.big.momot.core.tests.suite;

import at.ac.tuwien.big.momot.core.tests.ModuleLoadingTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.textui.TestRunner;

@RunWith(Suite.class)
@SuiteClasses({ ModuleLoadingTest.class })
public final class AllTests {

   public static void main(final String[] args) {
      TestRunner.run(suite());
   }

   private static Test suite() {
      return new JUnit4TestAdapter(AllTests.class);
   }

   private AllTests() {}

}
