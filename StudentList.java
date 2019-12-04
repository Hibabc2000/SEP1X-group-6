import java.util.ArrayList;

public class StudentList
{
  /**
   * @author Kristóf Lénárd, 293110
   * @version 1.0
   * This is a class for all students, used as a collective.
   */
  private static ArrayList<Student> allStudents;

  public static void addStudent(Student student)
  {
    /**
     * @param student A student we add to the list.
     * This method adds a student to the list of all students.
     */
    allStudents.add(student);
  }

  public static ArrayList<Student> getAllStudents()
  {
    /**
     * @return An ArrayList of students.
     * This method returns all students, regardless of any conditions.
     */
    return allStudents;
  }
}
