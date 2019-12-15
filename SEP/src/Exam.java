import java.io.Serializable;
import java.util.ArrayList;

public class Exam implements Serializable
{
  private String examType;
  private Room room;
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
    this.room = null;
  }
  public void scheduleExam(String examType, Course course, Teacher teacher, Co_examiner coExaminer,OurDate date, Room inroom)
  {
    this.examType = examType;
    this.course=course;
    this.teacher=teacher;
    this.coExaminer=coExaminer;
    this.date=date;
    this.room=inroom;
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

  public void setRoom(Room room)
  {
    this.room = room;
  }

  public Room getRoom()
  {
    return room;
  }
  public void setTeacher(Teacher teacher)
  {
    this.teacher = teacher;
  }
  public boolean detectConflict(Exam exam)
  {
    if(date.compare(exam.getDate()))
    {
      if(room.equals(exam.getRoom()))
      {
        return true;
      }
      if(teacher.equals(exam.getTeacher())){return true;}
      if(coExaminer.equals(exam.getCoExaminer())){return true;}
    }
    return false;
  }
  public boolean equals(Exam exam)
  {
    if ((teacher.equals(exam.getTeacher()))&&(coExaminer.equals(exam.getCoExaminer()))&&(course.equals(getCourse()))&&(room.equals(exam.getRoom()))&&(date.equals(exam.getDate()))){return true;}
    else {return false;}
  }
}

