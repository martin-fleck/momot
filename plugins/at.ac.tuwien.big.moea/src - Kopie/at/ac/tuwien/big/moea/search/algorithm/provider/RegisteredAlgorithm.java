package at.ac.tuwien.big.moea.search.algorithm.provider;

import org.moeaframework.core.Algorithm;

public abstract class RegisteredAlgorithm<A extends Algorithm> implements IRegisteredAlgorithm<A> {
	protected boolean isRegistered = false;
	protected String registeredName = null;
	
	public RegisteredAlgorithm() {
		register();
	}
	
	@Override
	public abstract A createAlgorithm();

	@Override
	public boolean isRegistered() {
		return isRegistered;
	}
	
	@Override
	public String getRegisteredName() {
		return registeredName;
	}
	
	@Override
	public String register() {
		if(isRegistered())
			return registeredName;
		
		registeredName = Long.toString(System.nanoTime());
		int i = 0;
		while(!DynamicAlgorithmProvider.registerAlgorithm(registeredName, this))
			registeredName += "_" + i++;
		
		return registeredName;
	}

	

}
