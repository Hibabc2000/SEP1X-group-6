import java.util.ArrayList;

public class Home
{

  public int getDay(Exam exam)
  {
    return (int) exam.getDate().getDay();
  }

  public int getStartHour(Exam exam)
  {
    return exam.getDate().getStartHour();
  }

  public int getEndHour(Exam exam)
  {
    return exam.getDate().getEndHour();
  }

  public int getWeek(Exam exam)
  {
    return (int) exam.getDate().getWeek();
  }

  public String getCourseName(Exam exam)
  {
    return exam.getCourse().getCourseName();
  }

  public int getStudentsNumber(Exam exam)
  {
    return exam.getCourse().getNrStudents();
  }

  public int getSemester(Exam exam)
  {
    return exam.getCourse().getSemester();
  }

  public String getRoomNumber(Exam exam)
  {
    return exam.getRoom().getRoomNumber();
  }

  public String getTeacherName(Exam exam)
  {
    return exam.getTeacher().getName();
  }
}
