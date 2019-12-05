/**
 * @author Kristóf Lénárd, 293110
 * @version 1.0
 * This is a class for all persons, used only in inheritance.
 */
public abstract class Person
{
  private String ID;
  private String firstName;

  /**
   * This method is a three-argument constructor for all persons.
   */
  public Person(String ID, String firstName, String lastName)
  {
    this.ID = ID;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  private String lastName;

  /**
   * @return The ID of this person.
   * Returns the ID of a person.
   */

  public String getID()
  {
    return ID;
  }

  /**
   * @param ID The ID of the new person.
   * Sets the ID of a person
   */
  public void setID(String ID)
  {
    this.ID = ID;
  }
  /**
   * @return The first name of this person.
   * Returns the first name of a person.
   */
  public String getFirstName()
  {
    return firstName;
  }
  /**
   * @param firstName The first name of the new person.
   * Sets the first name of a person
   */
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  /**
   * @return The last name of this person.
   * Returns the last name of a person.
   */
  public String getLastName()
  {
    return lastName;
  }
  /**
   * @param lastName The last name of the new person.
   * Sets the last name of a person
   */
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }
}
