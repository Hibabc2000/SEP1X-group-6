import java.io.IOException;

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
    ioHandler.writeToFile(tempFileName, ((TeacherList) obj).getAllTeachers().toArray());
  }

  public Object[] temporaryRead(String tempFileName)
      throws IOException, ClassNotFoundException
  {
    return ioHandler.readArrayFromFile(tempFileName);
  }
}
