import java.util.ArrayList;

public class Exam
{
  private String examType;
  private ArrayList<Room> room;
  private Course course;
  private Teacher teacher;
  private Co_examiner coExaminer;
  private OurDate date;
  public Exam()
  {
    examType= null;
    course = null;
    room = null;
    teacher=null;
    date=null;
    coExaminer=null;
    room = new ArrayList<>();
  }
  public Exam(String examType, Course course, Teacher teacher, Co_examiner coExaminer,OurDate date, Room inroom)
  {
    this.examType = examType;
    this.course=course;
    this.teacher=teacher;
    this.coExaminer=coExaminer;
    this.date=date;
    room = new ArrayList<>();
    room.add(inroom);
  }
  public void addroom(Room rm1)
  {
    room.add(rm1);
  }
  public String getExamType()
  {
    return examType;
  }

  public OurDate getDate()
  {
    return date;
  }

  public Co_examiner getCoExaminer()
  {
    return coExaminer;
  }

  public Course getCourse()
  {
    return course;
  }

  public Teacher getTeacher()
  {
    return teacher;
  }

  public void setCoExaminer(Co_examiner coExaminer)
  {
    this.coExaminer = coExaminer;
  }

  public void setCourse(Course course)
  {
    this.course = course;
  }

  public void setDate(OurDate date)
  {
    this.date = date;
  }

  public void setExamType(String examType)
  {
    this.examType = examType;
  }

  public void setRoom(ArrayList<Room> room)
  {
    this.room = room;
  }

  public void setTeacher(Teacher teacher)
  {
    this.teacher = teacher;
  }
  public boolean detectConflict(Exam exam)
  {
    int x0 = exam.room.size();
    int x1 = room.size();
    if(x0 <= x1)
    {
      for( int i = 0; i < x1; i++)
      {
        for (int j = 0; j < x0; j++)
        {

        }
      }
    }
  }
}
