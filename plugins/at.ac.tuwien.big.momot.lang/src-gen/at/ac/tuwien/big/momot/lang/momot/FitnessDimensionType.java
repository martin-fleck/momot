/**
 */
package at.ac.tuwien.big.momot.lang.momot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Fitness Dimension Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see at.ac.tuwien.big.momot.lang.momot.MomotPackage#getFitnessDimensionType()
 * @model
 * @generated
 */
public enum FitnessDimensionType implements Enumerator
{
  /**
   * The '<em><b>MINIMIZE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MINIMIZE_VALUE
   * @generated
   * @ordered
   */
  MINIMIZE(0, "MINIMIZE", "minimize"),

  /**
   * The '<em><b>MAXIMIZE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MAXIMIZE_VALUE
   * @generated
   * @ordered
   */
  MAXIMIZE(1, "MAXIMIZE", "maximize");

  /**
   * The '<em><b>MINIMIZE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MINIMIZE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MINIMIZE
   * @model literal="minimize"
   * @generated
   * @ordered
   */
  public static final int MINIMIZE_VALUE = 0;

  /**
   * The '<em><b>MAXIMIZE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MAXIMIZE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MAXIMIZE
   * @model literal="maximize"
   * @generated
   * @ordered
   */
  public static final int MAXIMIZE_VALUE = 1;

  /**
   * An array of all the '<em><b>Fitness Dimension Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final FitnessDimensionType[] VALUES_ARRAY =
    new FitnessDimensionType[]
    {
      MINIMIZE,
      MAXIMIZE,
    };

  /**
   * A public read-only list of all the '<em><b>Fitness Dimension Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<FitnessDimensionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Fitness Dimension Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static FitnessDimensionType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      FitnessDimensionType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Fitness Dimension Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static FitnessDimensionType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      FitnessDimensionType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Fitness Dimension Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static FitnessDimensionType get(int value)
  {
    switch (value)
    {
      case MINIMIZE_VALUE: return MINIMIZE;
      case MAXIMIZE_VALUE: return MAXIMIZE;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private FitnessDimensionType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //FitnessDimensionType
