/**
 *@author Marin Bilba, 293141
 *@version 1.0.0.0
 */
import java.util.ArrayList;
public class Class
{
  private String className;
  private ArrayList<Student> students;

  /**
   *
   * @param className
   * @param students
   */
  public Class(String className, ArrayList<Student> students)
  {
    this.className = className;
    students = new ArrayList<Student>();
  }
  public ArrayList<Student> getAllStudentsOfClass(String className)
  {
 return students;
  }
}