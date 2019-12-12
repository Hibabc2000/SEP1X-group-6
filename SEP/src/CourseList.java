import java.util.ArrayList;

/**
 * @author Marin Bilba, 293141
 * @version 1.0
 * This class stores all the created courses
 */
public class CourseList
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
}
