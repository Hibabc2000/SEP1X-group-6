import java.util.ArrayList;

public class Home
{

    public byte getDay(Exam exam)
    {
        return exam.getDate().getDay();
    }
    public byte getStartHour(Exam exam)
    {
        return exam.getDate().getStartHour();
    }
    public byte getEndHour(Exam exam)
    {
        return exam.getDate().getEndHour();
    }
    public byte getWeek(Exam exam)
    {
        return exam.getDate().getWeek();
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
