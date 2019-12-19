import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Kristóf Lénárd, 293110
 * @version 1.1
 * This is a class of co-examiners list.
 */
public class CoExaminerList implements Serializable
{
  private ArrayList<CoExaminer> coExaminers;

  /**
   * No argument constructor, co-examiners list initialization
   */
  public CoExaminerList()
  {
    coExaminers = new ArrayList<>();
  }

  /**
   * @param object adding co-examiner object to the list
   */
  public void addCoExaminer(Object object)
  {
    if (object instanceof CoExaminer)
    {
      coExaminers.add((CoExaminer) object);
    }
  }

  /**
   * @return an ArrayList of Co-Examiner
   */
  public ArrayList<CoExaminer> getAllCoExaminers()
  {
    return new ArrayList<>(coExaminers);
  }
}
