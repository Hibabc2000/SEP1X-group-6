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

  public CourseList()
  {
    courses = new ArrayList<>();
  }

  public void addCourse(Course course)
  {
    courses.add(course);
  }

  public ArrayList<Course> getAllCourses()
  {
    return new ArrayList<>(courses);
  }
}
