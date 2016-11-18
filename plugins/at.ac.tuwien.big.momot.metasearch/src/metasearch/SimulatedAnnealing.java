/**
 */
package metasearch;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulated Annealing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metasearch.SimulatedAnnealing#getStartTemp <em>Start Temp</em>}</li>
 *   <li>{@link metasearch.SimulatedAnnealing#getTempIncrease <em>Temp Increase</em>}</li>
 *   <li>{@link metasearch.SimulatedAnnealing#getRestartNoCurrentImp <em>Restart No Current Imp</em>}</li>
 *   <li>{@link metasearch.SimulatedAnnealing#getRestartNoBestImp <em>Restart No Best Imp</em>}</li>
 * </ul>
 *
 * @see metasearch.MetasearchPackage#getSimulatedAnnealing()
 * @model
 * @generated
 */
public interface SimulatedAnnealing extends TabuSupportingLocalSearch {
	/**
	 * Returns the value of the '<em><b>Start Temp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Temp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Temp</em>' attribute.
	 * @see #setStartTemp(double)
	 * @see metasearch.MetasearchPackage#getSimulatedAnnealing_StartTemp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getStartTemp();

	/**
	 * Sets the value of the '{@link metasearch.SimulatedAnnealing#getStartTemp <em>Start Temp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Temp</em>' attribute.
	 * @see #getStartTemp()
	 * @generated
	 */
	void setStartTemp(double value);

	/**
	 * Returns the value of the '<em><b>Temp Increase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Temp Increase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Temp Increase</em>' attribute.
	 * @see #setTempIncrease(double)
	 * @see metasearch.MetasearchPackage#getSimulatedAnnealing_TempIncrease()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 * @generated
	 */
	double getTempIncrease();

	/**
	 * Sets the value of the '{@link metasearch.SimulatedAnnealing#getTempIncrease <em>Temp Increase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Temp Increase</em>' attribute.
	 * @see #getTempIncrease()
	 * @generated
	 */
	void setTempIncrease(double value);

	/**
	 * Returns the value of the '<em><b>Restart No Current Imp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restart No Current Imp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restart No Current Imp</em>' attribute.
	 * @see #setRestartNoCurrentImp(int)
	 * @see metasearch.MetasearchPackage#getSimulatedAnnealing_RestartNoCurrentImp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getRestartNoCurrentImp();

	/**
	 * Sets the value of the '{@link metasearch.SimulatedAnnealing#getRestartNoCurrentImp <em>Restart No Current Imp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restart No Current Imp</em>' attribute.
	 * @see #getRestartNoCurrentImp()
	 * @generated
	 */
	void setRestartNoCurrentImp(int value);

	/**
	 * Returns the value of the '<em><b>Restart No Best Imp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restart No Best Imp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restart No Best Imp</em>' attribute.
	 * @see #setRestartNoBestImp(int)
	 * @see metasearch.MetasearchPackage#getSimulatedAnnealing_RestartNoBestImp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Int" required="true"
	 * @generated
	 */
	int getRestartNoBestImp();

	/**
	 * Sets the value of the '{@link metasearch.SimulatedAnnealing#getRestartNoBestImp <em>Restart No Best Imp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restart No Best Imp</em>' attribute.
	 * @see #getRestartNoBestImp()
	 * @generated
	 */
	void setRestartNoBestImp(int value);

} // SimulatedAnnealing
