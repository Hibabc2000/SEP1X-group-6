import java.util.ArrayList;

public class CoExaminerList
{
  private static ArrayList<Co_examiner> coExaminers;
  public CoExaminerList()
  {
    coExaminers = new ArrayList<>();
  }
  public void addCoExaminer(Object object)
  {
    if(!(object instanceof Co_examiner)){}
    else
    {
      coExaminers.add((Co_examiner) object);
    }
  }
  public static ArrayList<Co_examiner> getAllCoExaminers()
  {
    ArrayList<Co_examiner> tmp = new ArrayList<>(coExaminers);
    return tmp;
  }
}
