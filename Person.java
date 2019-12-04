public abstract class Person
{
  /**
   * @author Kristóf Lénárd, 293110
   * @version 1.0
   * This is a class for all persons, used only in inheritance.
   */
  private String ID;
  private String firstName;

  public Person(String ID, String firstName, String lastName)
  {
    /**
     * This method is a three-argument constructor for all persons.
     */
    this.ID = ID;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  private String lastName;

  public String getID()
  {
    /**
     * @return The ID of this person.
     * Returns the ID of a person.
     */
    return ID;
  }

  public void setID(String ID)
  {
    /**
     * @param ID The ID of the new person.
     * Sets the ID of a person
     */
    this.ID = ID;
  }

  public String getFirstName()
  {
    /**
     * @return The first name of this person.
     * Returns the first name of a person.
     */
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    /**
     * @param firstName The first name of the new person.
     * Sets the first name of a person
     */
    this.firstName = firstName;
  }

  public String getLastName()
  {
    /**
     * @return The last name of this person.
     * Returns the last name of a person.
     */
    return lastName;
  }

  public void setLastName(String lastName)
  {
    /**
     * @param lastName The last name of the new person.
     * Sets the last name of a person
     */
    this.lastName = lastName;
  }
}
