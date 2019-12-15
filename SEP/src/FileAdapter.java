import java.io.IOException;
import java.util.Arrays;

public class FileAdapter
{
  private String fileName;
  private MyFileIO ioHandler;

  public FileAdapter(String name)
  {
    fileName = name;
    ioHandler = new MyFileIO();
  }

  public void temporaryWrite(Object obj, String tempFileName) throws IOException
  {
    if(obj instanceof TeacherList)
    {
      ioHandler.writeToFile(tempFileName, ((TeacherList) obj).getAllTeachers().toArray());
    }
    else if(obj instanceof CoExaminerList)
    {
      ioHandler.writeToFile(tempFileName, ((CoExaminerList) obj).getAllCoExaminers().toArray());
    }
    else if(obj instanceof CourseList)
    {
      ioHandler.writeToFile(tempFileName, ((CourseList) obj).getAllCourses().toArray());
    }
  }

  public Object[] temporaryRead(String tempFileName)
      throws IOException, ClassNotFoundException
  {
    Object[] arr = ioHandler.readArrayFromFile(tempFileName);
    return arr;
  }
}
