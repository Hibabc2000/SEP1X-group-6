import java.util.ArrayList;

public class TeacherList
{
  /**
   * @author Kristóf Lénárd, 293110
   * @version 1.0
   * this class contains the teachers
   */
  private static ArrayList<Teacher> teachers;

  public TeacherList()
  {
    teachers = new ArrayList<Teacher>();
  }

  /**
   * @return an array list containing all of the teachers
   * returns all of the teachers in an array list
   */
  public static ArrayList getAllTeachers()
  {
    return new ArrayList<Teacher>(teachers);
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
    TeacherList tmp =(TeacherList)obj;
    if(teachers.size() != getAllTeachers().size())
    {
      return false;
    }
    for (int x0 = 0; x0 < teachers.size(); x0 ++)
    {
      if(!teachers.get(x0).equals(getAllTeachers().get(x0)))
      {
        return false;
      }
    }
    return true;
  }

  /**
   * @return a copy of teacherList
   * return a copy of the teacherList object
   */
  public TeacherList copy()
  {
    TeacherList tmp = new TeacherList();
    for (Teacher teacher : teachers)
    {
      tmp.addTeacher(teacher);
    }
    return tmp;
  }

  private void addTeacher(Teacher t)
  {
    teachers.add(t);
  }
}
