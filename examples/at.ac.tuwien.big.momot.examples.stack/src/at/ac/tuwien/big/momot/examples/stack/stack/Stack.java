/**
 */
package at.ac.tuwien.big.momot.examples.stack.stack;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link at.ac.tuwien.big.momot.examples.stack.stack.Stack#getId <em>Id</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.stack.stack.Stack#getLoad <em>Load</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.stack.stack.Stack#getLeft <em>Left</em>}</li>
 * <li>{@link at.ac.tuwien.big.momot.examples.stack.stack.Stack#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see at.ac.tuwien.big.momot.examples.stack.stack.StackPackage#getStack()
 * @model
 * @generated
 */
public interface Stack extends EObject {
   /**
    * Returns the value of the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Id</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Id</em>' attribute.
    * @see #setId(String)
    * @see at.ac.tuwien.big.momot.examples.stack.stack.StackPackage#getStack_Id()
    * @model required="true"
    * @generated
    */
   String getId();

   /**
    * Returns the value of the '<em><b>Left</b></em>' reference.
    * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.stack.stack.Stack#getRight
    * <em>Right</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Left</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Left</em>' reference.
    * @see #setLeft(Stack)
    * @see at.ac.tuwien.big.momot.examples.stack.stack.StackPackage#getStack_Left()
    * @see at.ac.tuwien.big.momot.examples.stack.stack.Stack#getRight
    * @model opposite="right" required="true"
    * @generated
    */
   Stack getLeft();

   /**
    * Returns the value of the '<em><b>Load</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Load</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Load</em>' attribute.
    * @see #setLoad(int)
    * @see at.ac.tuwien.big.momot.examples.stack.stack.StackPackage#getStack_Load()
    * @model required="true"
    * @generated
    */
   int getLoad();

   /**
    * Returns the value of the '<em><b>Right</b></em>' reference.
    * It is bidirectional and its opposite is '{@link at.ac.tuwien.big.momot.examples.stack.stack.Stack#getLeft
    * <em>Left</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Right</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * 
    * @return the value of the '<em>Right</em>' reference.
    * @see #setRight(Stack)
    * @see at.ac.tuwien.big.momot.examples.stack.stack.StackPackage#getStack_Right()
    * @see at.ac.tuwien.big.momot.examples.stack.stack.Stack#getLeft
    * @model opposite="left" required="true"
    * @generated
    */
   Stack getRight();

   /**
    * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.stack.stack.Stack#getId <em>Id</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Id</em>' attribute.
    * @see #getId()
    * @generated
    */
   void setId(String value);

   /**
    * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.stack.stack.Stack#getLeft <em>Left</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Left</em>' reference.
    * @see #getLeft()
    * @generated
    */
   void setLeft(Stack value);

   /**
    * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.stack.stack.Stack#getLoad <em>Load</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Load</em>' attribute.
    * @see #getLoad()
    * @generated
    */
   void setLoad(int value);

   /**
    * Sets the value of the '{@link at.ac.tuwien.big.momot.examples.stack.stack.Stack#getRight <em>Right</em>}'
    * reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * 
    * @param value
    *           the new value of the '<em>Right</em>' reference.
    * @see #getRight()
    * @generated
    */
   void setRight(Stack value);

} // Stack
