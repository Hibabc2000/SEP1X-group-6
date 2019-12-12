/**
 * @author Kristóf Lénárd, 293110
 * @version 1.0
 * This is a class for all persons, used only in inheritance.
 */
public abstract class Person
{
  private String ID;
  private String name;
  /**
   * This method is a three-argument constructor for all persons.
   */
  public Person(String ID, String name)
  {
    this.ID = ID;
    this.name = name;
  }

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
   * @return The name of this person.
   * Returns the name of a person.
   */
  public String getLastName()
  {
    return name;
  }
  /**
   * @param name The name of the new person.
   * Sets the name of a person
   */
  public void setLastName(String name)
  {
    this.name = name;
  }
}
