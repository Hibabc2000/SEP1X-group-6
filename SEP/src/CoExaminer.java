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
   * This method is a four-argument constructor for co-examiners.
   */
  public CoExaminer(String ID, String name,
      boolean external)
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
   * @param external This is the boolean we set the external variable to.
   * This method sets whether a co-examiner is external or internal.
   */
  public void setExternal(boolean external)
  {
    this.external = external;
  }

  /**
   *
   * @return name, id and internal/external boolean state
   */
  @Override public String toString()
  {
    String ret = "Name: " + this.getName() + ", ID: " + this.getID() + ", Internal: ";
    ret += external;
    return ret;
  }

  /**
 *
 * @param obj
 * @return a boolean true if objects are equal or false if they are not
 * Methods returns whether the objects are equal or not
 */
  public boolean equals(Object obj){
    if(!(obj instanceof CoExaminer))
      return false;
    CoExaminer other=(CoExaminer)obj;
    return super.equals(other)&&external==other.external;
  }
}
