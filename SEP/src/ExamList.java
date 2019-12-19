import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Ali Bahrani, 294418
 * @version 2.0
 */
public class ExamList implements Serializable
{
  private ArrayList<Exam> exams;

  /**
   * No-arg constructor
   */
  public ExamList()
  {
    exams = new ArrayList<>();
  }

  /**
   * add an exam
   *
   * @param exam exam object
   */
  public void addExam(Exam exam)
  {
    exams.add(exam);
  }

  /**
   * Returns a list of exams
   *
   * @return array list of exams
   */
  public ArrayList<Exam> getAllExams()
  {
    if (exams != null)
    {
      return new ArrayList<>(exams);
    }
    return new ArrayList<>();
  }

  /**
   * Deletes an exam on specific index
   *
   * @param index index
   */
  public void deleteExam(int index)
  {
    exams.remove(index);
  }

  /**
   * add an exam at a specific index
   *
   * @param index index
   * @param exam  exam object
   */
  public void addExamAtIndex(int index, Exam exam)
  {
    exams.add(index, exam);
  }

}
