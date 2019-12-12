public class Student extends Person
{
  /**
   * @author Kristóf Lénárd, 293110
   * @version 1.0
   * This is a class for all persons, used only in inheritance.
   */

  public Student(String ID, String name)
  {
    /**
     * This method is a three-argument constructor for students.
     */
    super(ID, name);
  }

  @Override public void setID(String ID)
  {
    /**
     * @param ID The ID of the student we want to add.
     * This method evaluates and adds an ID to a Student.
     */
    int check = 0;
    try
    {
      check = Integer.parseInt(ID);
    }
    catch (Exception e)
    {
      System.out.println("Incorrect Student ID");
      check = 0;
    }
    finally
    {
      if (check != 0)
      {
        super.setID(ID);
      }
      else
      {
        System.out.println("Enter a new Student ID and try again.");
      }
    }
  }
}