import java.io.Serializable;

/**
 * @author Marin Bilba, 293141
 * @version 1.2
 */
public class Course implements Serializable
{
  private String courseName;
  private String group;
  private int nrStudents;
  private int semester;

  /**
   * @param courseName name of the course
   * @param group      group name
   * @param nrStudents total number of students
   * @param semester   course semester
   */
  public Course(String courseName, String group, int nrStudents, int semester)
  {
    this.courseName = courseName;
    this.group = group;
    this.nrStudents = nrStudents;
    this.semester = semester;
  }

  /**
   * @return course name
   * Returns the Course Name
   */
  public String getCourseName()
  {
    return courseName;
  }

  /**
   * @return group name
   * return the group name
   */
  public String getGroup()
  {
    return group;
  }

  /**
   * @return total number of students
   */
  public int getNrStudents()
  {
    return nrStudents;
  }

  /**
   * @return semester number
   */
  public int getSemester()
  {
    return semester;
  }

  /**
   * @return course name, group, number of students and semester number
   */
  @Override public String toString()
  {
    return courseName + group + " | " + +nrStudents + " | " + semester;
  }

  /**
   * @param obj - course to evaluate whether this is equal to
   * @return a boolean true if objects are equal or false if they are not
   * Methods returns whether the objects are equal or not
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Course))
      return false;
    Course other = (Course) obj;
    return courseName.equals(other.courseName) && group.equals(other.group)
        && nrStudents == other.nrStudents && semester == other.semester;
  }

}




