import java.io.Serializable;

/**
 * @author Kristóf Lénárd, 293110
 * @version 1.0
 * This is a class for all persons, used only in inheritance.
 */
public class CoExaminer extends Person implements Serializable
{
  private boolean external;

  /**
   * This method is a three-argument constructor for co-examiners.
   * @param external Boolean that is true if the CoExaminer is external.
   * @param ID The ID of the co-examiner
   * @param name The name of the co-examiner
   */
  public CoExaminer(String ID, String name, boolean external)
  {
    super(ID, name);
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
   * @return name, id and internal/external boolean state
   */
  @Override public String toString()
  {
    String ret =
        "Name: " + this.getName() + ", ID: " + this.getID() + ", Internal: ";
    ret += external;
    return ret;
  }

  /**
   * @param obj - the object that is evaluated for equality
   * @return a boolean true if objects are equal or false if they are not
   * Methods returns whether the objects are equal or not
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof CoExaminer))
      return false;
    CoExaminer other = (CoExaminer) obj;
    return super.equals(other) && external == other.external;
  }
}
