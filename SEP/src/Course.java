import java.io.Serializable;

/**
 *@author Marin Bilba, 293141
 *@version 1.2
 */
public class Course implements Serializable
{
  private String courseName;
  private String group;
  private int nrStudents;
  private int semester;

  /**
   *  @param courseName name of the course
   * @param group group name
   * @param nrStudents total number of students
   * @param semester course semester
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
   * @param courseName the course name
   * sets the course name
   */
  public void setCourseName(String courseName)
  {
    this.courseName = courseName;
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
   * @param group
   * sets the group name
   */
  public void setGroup(String group)
  {
    this.group = group;
  }

  /**
   *
   * @return total number of students
   */
  public int getNrStudents()
  {
    return nrStudents;
  }

  /**
   *
   * @param nrStudents total number of students
   */
  public void setNrStudents(int nrStudents)
  {
    this.nrStudents = nrStudents;
  }

  /**
   *
   * @return semester
   */
  public int getSemester()
  {
    return semester;
  }

  /**
   *
   * @param semester
   */
  public void setSemester(int semester)
  {
    this.semester = semester;
  }

  @Override public String toString()
  {
    return courseName + " | " + group
        + " | " +  + nrStudents +" | "+ semester;
  }
  public boolean equals(Object obj){
  if(!(obj instanceof Course))
    return false;
  Course other=(Course)obj;
  return courseName.equals(other.courseName)&&group.equals(other.group)&&nrStudents==other.nrStudents&&semester==other.semester;
}

}




