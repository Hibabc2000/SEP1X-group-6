
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Kristóf Lénárd, 293110
 * @version 1.1
 * This is a class of co-examiners list.
 */
public class CoExaminerList implements Serializable
{
  private ArrayList<Co_examiner> coExaminers;

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
    if (object instanceof Co_examiner)
    {
      coExaminers.add((Co_examiner) object);
    }
  }

  /**
   * @param c co-examiner object
   * deleting co-examiner object from the list
   */
  public void deleteCoExaminer(Co_examiner c)
  {
    for (Co_examiner coExaminer : coExaminers)
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
  public ArrayList<Co_examiner> getAllCoExaminers()
  {
    return new ArrayList<>(coExaminers);
  }
}
