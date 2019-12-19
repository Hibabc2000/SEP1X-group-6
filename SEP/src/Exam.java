import java.io.Serializable;
import java.util.SimpleTimeZone;

/**
 * @author Ali Bahrani, 294418
 * @version 2.0
 */
public class Exam implements Serializable
{
  private String examType;
  private Room room;
  private Course course;
  private Teacher teacher;
  private CoExaminer coExaminer;
  private OurDate date;

  /**
   * No-arg constructor
   */
  public Exam()
  {
    examType = null;
    course = null;
    room = null;
    teacher = null;
    date = null;
    coExaminer = null;
    this.room = null;
  }

  /**
   * @param examType   exam type: "oral" or written
   * @param course     course object
   * @param teacher    teacher object
   * @param coExaminer CoExaminer object
   * @param date       date object
   * @param inRoom     room object
   *                   This method is scheduling an exam
   */
  public void scheduleExam(String examType, Course course, Teacher teacher,
      CoExaminer coExaminer, OurDate date, Room inRoom)
  {
    this.examType = examType;
    this.course = course;
    this.teacher = teacher;
    this.coExaminer = coExaminer;
    this.date = date;
    this.room = inRoom;

  }
  //***************************
  // METHODS USED TO GET TableView (HomeController) COLUMNS.

  /**
   * @return time
   */
  public String getTime()
  {
    return date.getStartHour() + ":" + date.getsMinute() + "-" + date
        .getEndHour() + ":" + date.geteMinute();
  }

  /**
   * @return number of students
   */
  public String getNumStud()
  {
    return course.getNrStudents() + "";
  }

  /**
   * @return week
   */
  public String getWeek()
  {
    return date.getWeek() + "";
  }

  /**
   * @return teacher name
   */
  public String getTeacherName()
  {
    return teacher.getName();
  }

  /**
   * @return day
   */
  public String getDay()
  {
    return date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
  }

  /**
   * @return room number
   */
  public String getRoomNumber()
  {
    return room.getRoomNumber();
  }

  /**
   * @return course name
   */
  public String getCourseName()
  {
    return course.getCourseName() + course.getGroup();
  }
  //***************************

  /**
   * @return exam type
   */
  public String getExamType()
  {
    return examType;
  }

  /**
   * @return date
   */
  public OurDate getDate()
  {
    return date;
  }

  /**
   * @return co-examiner
   */
  public CoExaminer getCoExaminer()
  {
    return coExaminer;
  }

  /**
   * @return course
   */
  public Course getCourse()
  {
    return course;
  }

  /**
   * @return teacher
   */
  public Teacher getTeacher()
  {
    return teacher;
  }

  /**
   * @param course course object
   *               sets course Name
   */
  public void setCourse(Course course)
  {
    this.course = course;
  }

  /**
   * sets room Number
   *
   * @param room room object
   */
  public void setRoom(Room room)
  {
    this.room = room;
  }

  /**
   * @return room
   */
  public Room getRoom()
  {
    return room;
  }

  /**
   * set teacher
   *
   * @param teacher teacher object
   */
  public void setTeacher(Teacher teacher)
  {
    this.teacher = teacher;
  }

  /**
   * @param exam exam object
   * @return true/false weather there is a conflict or not
   */
  public boolean detectConflict(Exam exam)
  {
    if (date.compare(exam.getDate()))
    {
      if (room.equals(exam.getRoom()))
      {
        return true;
      }
      if (teacher.equals(exam.getTeacher()))
      {
        return true;
      }
      if (coExaminer.equals(exam.getCoExaminer()))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * @param exam - exam to evalute whether this is equal to
   * @return a boolean true if objects are equal or false if they are not
   * Method returns whether the objects are equal or not
   */
  public boolean equals(Exam exam)
  {
    if ((teacher.equals(exam.getTeacher())) && (coExaminer
        .equals(exam.getCoExaminer())) && (course.equals(getCourse())) && (room
        .equals(exam.getRoom())) && (date.equals(exam.getDate())))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public String toString()
  {
    return course.toString() + "at" + date.getYear() + "/" + date.getMonth()
        + "/" + date.getDay() + "(week" + date.getWeek() + ")";
  }
}

