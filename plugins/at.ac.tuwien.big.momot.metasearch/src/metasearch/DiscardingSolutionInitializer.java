/**
 */
package metasearch;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Discarding Solution Initializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.DiscardingSolutionInitializer#getSolutionConsiderSize <em>Solution Consider Size</em>}</li>
 *   <li>{@link metasearch.DiscardingSolutionInitializer#getSolutionUseSize <em>Solution Use Size</em>}</li>
 *   <li>{@link metasearch.DiscardingSolutionInitializer#getSolutionsPerQueue <em>Solutions Per Queue</em>}</li>
 *   <li>{@link metasearch.DiscardingSolutionInitializer#getNumQueues <em>Num Queues</em>}</li>
 *   <li>{@link metasearch.DiscardingSolutionInitializer#getNumInitSolutions <em>Num Init Solutions</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getDiscardingSolutionInitializer()
 * @model
 * @generated
 */
public interface DiscardingSolutionInitializer extends SolutionInitializer {
	/**
	 * Returns the value of the '<em><b>Solution Consider Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solution Consider Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution Consider Size</em>' attribute.
	 * @see #setSolutionConsiderSize(int)
	 * @see metasearch.MetasearchPackage#getDiscardingSolutionInitializer_SolutionConsiderSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getSolutionConsiderSize();

	/**
	 * Sets the value of the '{@link metasearch.DiscardingSolutionInitializer#getSolutionConsiderSize <em>Solution Consider Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solution Consider Size</em>' attribute.
	 * @see #getSolutionConsiderSize()
	 * @generated
	 */
	void setSolutionConsiderSize(int value);

	/**
	 * Returns the value of the '<em><b>Solution Use Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solution Use Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution Use Size</em>' attribute.
	 * @see #setSolutionUseSize(int)
	 * @see metasearch.MetasearchPackage#getDiscardingSolutionInitializer_SolutionUseSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getSolutionUseSize();

	/**
	 * Sets the value of the '{@link metasearch.DiscardingSolutionInitializer#getSolutionUseSize <em>Solution Use Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solution Use Size</em>' attribute.
	 * @see #getSolutionUseSize()
	 * @generated
	 */
	void setSolutionUseSize(int value);

	/**
	 * Returns the value of the '<em><b>Solutions Per Queue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solutions Per Queue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solutions Per Queue</em>' attribute.
	 * @see #setSolutionsPerQueue(int)
	 * @see metasearch.MetasearchPackage#getDiscardingSolutionInitializer_SolutionsPerQueue()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getSolutionsPerQueue();

	/**
	 * Sets the value of the '{@link metasearch.DiscardingSolutionInitializer#getSolutionsPerQueue <em>Solutions Per Queue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solutions Per Queue</em>' attribute.
	 * @see #getSolutionsPerQueue()
	 * @generated
	 */
	void setSolutionsPerQueue(int value);

	/**
	 * Returns the value of the '<em><b>Num Queues</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Queues</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Queues</em>' attribute.
	 * @see #setNumQueues(int)
	 * @see metasearch.MetasearchPackage#getDiscardingSolutionInitializer_NumQueues()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumQueues();

	/**
	 * Sets the value of the '{@link metasearch.DiscardingSolutionInitializer#getNumQueues <em>Num Queues</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Queues</em>' attribute.
	 * @see #getNumQueues()
	 * @generated
	 */
	void setNumQueues(int value);

	/**
	 * Returns the value of the '<em><b>Num Init Solutions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Init Solutions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Init Solutions</em>' attribute.
	 * @see #setNumInitSolutions(int)
	 * @see metasearch.MetasearchPackage#getDiscardingSolutionInitializer_NumInitSolutions()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getNumInitSolutions();

	/**
	 * Sets the value of the '{@link metasearch.DiscardingSolutionInitializer#getNumInitSolutions <em>Num Init Solutions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Init Solutions</em>' attribute.
	 * @see #getNumInitSolutions()
	 * @generated
	 */
	void setNumInitSolutions(int value);

} // DiscardingSolutionInitializer
