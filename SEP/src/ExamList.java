import java.io.Serializable;
import java.util.ArrayList;
//the class is temporary
public class ExamList implements Serializable
{
  private ArrayList<Exam> exams;
  public ExamList()
  {
    exams = new ArrayList<>();
  }
  public void addExam(Exam exam)
  {
    exams.add(exam);
  }
  public ArrayList<Exam> getAllExams()
  {
    if (exams != null)
    {
      return new ArrayList<>(exams);
    }
    return new ArrayList<>();
  }
  public void deleteExam(int index)
  {
    exams.remove(index);
  }
  public void addExamAtIndex(int index, Exam exam)
  {
    exams.add(index,exam);
  }


}
