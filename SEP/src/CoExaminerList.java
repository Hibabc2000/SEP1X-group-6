import java.util.ArrayList;

public class CoExaminerList
{
  private ArrayList<Co_examiner> coExaminers;

  public CoExaminerList()
  {
    coExaminers = new ArrayList<>();
  }

  public void addCoExaminer(Object object)
  {
    if (object instanceof Co_examiner)
    {
      coExaminers.add((Co_examiner) object);
    }
  }

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

  public ArrayList<Co_examiner> getAllCoExaminers()
  {
    return new ArrayList<>(coExaminers);
  }
}
