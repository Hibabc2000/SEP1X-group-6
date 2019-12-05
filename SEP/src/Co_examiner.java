/**
 * @author Kristóf Lénárd, 293110
 * @version 1.0
 * This is a class for all persons, used only in inheritance.
 */
public class Co_examiner extends Person
{
  private boolean external;

  /**
   * This method is a four-argument constructor for co-examiners.
   */
  public Co_examiner(String ID, String firstName, String lastName,
      boolean external)
  {
    super(ID, firstName, lastName);
    this.external = external;
  }
  /**
   * @return A boolean that is true if the co-examiner is external.
   * This method returns whether the co-examiner is external or internal.
   */
  public boolean isExternal()
  {
    return external;
  }
  /**
   * @param external This is the boolean we set the external variable to.
   * This method sets whether a co-examiner is external or internal.
   */
  public void setExternal(boolean external)
  {
    this.external = external;
  }
}
