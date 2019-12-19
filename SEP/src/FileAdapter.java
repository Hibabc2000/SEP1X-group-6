import persistence.MyXmlConverter;
    import persistence.XmlConverterException;

    import java.io.IOException;
    import java.util.ArrayList;

public class FileAdapter
{
  private String fileName;
  private MyFileIO ioHandler;

  public FileAdapter(String name)
  {
    fileName = name;
    ioHandler = new MyFileIO();
  }

  /**
   *
   * @param obj
   * @param tempFileName file name
   * @throws IOException throws this exception on error while reading file
   * Use the MyFileIO class to save all lists object in their files
   */
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
    else if(obj instanceof RoomList)
    {
      ioHandler.writeToFile(tempFileName, ((RoomList) obj).getAllRooms().toArray());
    }
    else if(obj instanceof ExamList)
    {
      ioHandler.writeToFile(tempFileName, ((ExamList) obj).getAllExams().toArray());
    }
    else if(obj instanceof ArrayList)
    {
      ioHandler.writeToFile(tempFileName, ((ArrayList)obj).toArray());
    }
  }
  /**
   *
   * @param tempFileName file name
   * @return the objects that read from the file
   * @throws IOException throws this exception on error while reading file
   * @throws ClassNotFoundException throws this exception if no such class exists
   */
  public Object[] temporaryRead(String tempFileName)
      throws IOException, ClassNotFoundException
  {
    return ioHandler.readArrayFromFile(tempFileName);
  }

  public void exportToXML(ExamList object, String filename) throws XmlConverterException
  {

    MyXmlConverter xmlConverter = new MyXmlConverter(filename);
    xmlConverter.toXml(object, filename);
  }
}
