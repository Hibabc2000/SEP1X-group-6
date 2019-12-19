import java.io.Serializable;
import java.util.ArrayList;

public class TeacherList implements Serializable
{
  /**
   * @author Kristóf Lénárd, 293110
   * @version 1.0
   * this class contains the teachers
   */
  private ArrayList<Teacher> teachers;

  public TeacherList()
  {
    teachers = new ArrayList<Teacher>();
  }

  /**
   * @return an array list containing all of the teachers
   * returns all of the teachers in an array list
   */
  public ArrayList getAllTeachers()
  {
    return new ArrayList<>(teachers);
  }

  /**
   * @param obj a teacherList object
   * @return a boolean with the value of the two teacherList object equality
   * compares the teacherList to another
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof TeacherList))
    {
      return false;
    }
    TeacherList tmp = (TeacherList) obj;
    if (teachers.size() != getAllTeachers().size())
    {
      return false;
    }
    for (int x0 = 0; x0 < teachers.size(); x0++)
    {
      if (!teachers.get(x0).equals(getAllTeachers().get(x0)))
      {
        return false;
      }
    }
    return true;
  }

  /**
   * @param t teacher object
   *          add a new teacher to the Teacher list
   */
  public void addTeacher(Teacher t)
  {
    teachers.add(t);
  }

  /**
   * @param t teacher object
   *          delete the teacher object from the Teacher list
   */
  public void deleteTeacher(Teacher t)
  {
    int index = 0;
    for (Teacher teacher : teachers)
    {
      if (t.equals(teacher))
      {
        teachers.remove(teacher);
        break;
      }
      index++;
    }
  }
}
