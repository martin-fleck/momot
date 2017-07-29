package at.ac.tuwien.big.moea.search.algorithm.provider;

import org.moeaframework.core.Algorithm;
import org.moeaframework.core.Problem;

public abstract class AbstractRegisteredAlgorithm<A extends Algorithm> implements IRegisteredAlgorithm<A> {
   protected boolean isRegistered = false;
   protected String registeredName = null;

   public AbstractRegisteredAlgorithm() {
      register();
   }

   @Override
   public abstract A createAlgorithm(Problem problem);

   @Override
   public String getRegisteredName() {
      return registeredName;
   }

   @Override
   public boolean isRegistered() {
      return isRegistered;
   }

   @Override
   public String register() {
      if(isRegistered()) {
         return registeredName;
      }

      registeredName = Long.toString(System.nanoTime());
      int i = 0;
      while(!DynamicAlgorithmProvider.registerAlgorithm(registeredName, this)) {
         registeredName += "_" + i++;
      }

      return registeredName;
   }

}
