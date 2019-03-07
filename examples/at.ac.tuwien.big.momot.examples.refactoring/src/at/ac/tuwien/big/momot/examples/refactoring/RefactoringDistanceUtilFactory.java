package at.ac.tuwien.big.momot.examples.refactoring;

/**
 * Gives singleton access to {@link RefactoringDistanceUtil}
 * @author Eugene Syriani
 *
 */
public final class RefactoringDistanceUtilFactory {

	private static RefactoringDistanceUtil INSTANCE;
	
	/**
	 * Returns the utility instance
	 * @return utility object
	 */
	public synchronized static RefactoringDistanceUtil getInstance() {
		if(INSTANCE == null) {
	        synchronized (RefactoringDistanceUtil.class) {
	            if(INSTANCE == null) {
	            	INSTANCE = new RefactoringDistanceUtil();
	            }
	        }
	    }
	    return INSTANCE;
	}
}
