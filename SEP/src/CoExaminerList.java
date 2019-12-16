
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
   *
   * @param object
   * adding co-examiner object to the list
   */
  public void addCoExaminer(Object object)
  {
    if (object instanceof CoExaminer)
    {
      coExaminers.add((CoExaminer) object);
    }
  }

  /**
   * @param c co-examiner object
   * deleting co-examiner object from the list
   */
  public void deleteCoExaminer(CoExaminer c)
  {
    for (CoExaminer coExaminer : coExaminers)
    {
      if(c.equals(coExaminer))
      {
        coExaminers.remove(coExaminer);
        break;
      }
    }
  }

  /**
   *
   * @return an ArrayList of Co-Examiner
   */
  public ArrayList<CoExaminer> getAllCoExaminers()
  {
    return new ArrayList<>(coExaminers);
  }
}
