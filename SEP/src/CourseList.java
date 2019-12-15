import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Marin Bilba, 293141
 * @version 1.0
 * This class stores all the created courses
 */
public class CourseList implements Serializable
{
  private ArrayList<Course> courses;

  /**
   * No-Arg constructor
   * ArrayList (courses) initialization
   */
  public CourseList()
  {
    courses = new ArrayList<>();
  }

  /**
   * @param course
   * adding course object to the list
   */
  public void addCourse(Course course)
  {
    courses.add(course);
  }

  /**
   *
   * @return an ArrayList of Courses
   */
  public ArrayList<Course> getAllCourses()
  {
    return new ArrayList<>(courses);
  }

  /**
   *
   * @return courses list
   */
  @Override public String toString()
  {
    return "CourseList{" + "courses=" + courses + '}';
  }
}
