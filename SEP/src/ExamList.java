import java.io.Serializable;
import java.util.ArrayList;
//the class is temporary
public class ExamList implements Serializable
{
  private static ArrayList<Exam> exams;
  public ExamList()
  {
    exams = new ArrayList<>();
  }
  public void addExam(Exam exam)
  {
    exams.add(exam);
  }
  public static ArrayList<Exam> getAllExams()
  {
    if (exams != null)
    {
      return new ArrayList<>(exams);
    }
    return new ArrayList<>();
  }
}
