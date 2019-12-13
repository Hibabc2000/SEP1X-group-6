import java.util.ArrayList;
//the class is temporary
public class ExamList
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
    return new ArrayList<>(exams);
  }
}
