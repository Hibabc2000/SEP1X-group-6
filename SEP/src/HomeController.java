import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import persistence.XmlConverterException;

public class HomeController implements EventHandler<ActionEvent>
{
  @FXML private TableView tableView;
  @FXML private TableColumn Week;
  @FXML private TableColumn Date;
  @FXML private TableColumn Course;
  @FXML private TableColumn NumStud;
  @FXML private TableColumn Type;
  @FXML private TableColumn Time;
  @FXML private TableColumn Room;
  @FXML private TableColumn Teacher;
  @FXML private Button homeButton;
  @FXML private Button roomButton;
  @FXML private Button teacherButton;
  @FXML private Button coExaminerButton;
  @FXML private Button courseButton;
  @FXML private Button scheduleButton;
  @FXML private Button settingsButton;
  @FXML private Button exportButton;
  private ExamList exams;
  public void initialize()
      throws IOException, ClassNotFoundException, NoSuchFieldException,
      IllegalAccessException
  {
    ArrayList<OurDate> dates = new ArrayList<>();
    TeacherList teacherList = new TeacherList();
    CourseList courseList = new CourseList();
    CoExaminerList coExaminerList = new CoExaminerList();
    RoomList roomList = new RoomList();

    File existence = new File("tempCourse");
    FileAdapter fileHandler = new FileAdapter(null);
    if(!existence.exists())
    {
      fileHandler.temporaryWrite(courseList, "tempCourse");
    }
    existence = new File("tempTeacher");
    if(!existence.exists())
    {
      fileHandler.temporaryWrite(teacherList, "tempTeacher");
    }
    existence = new File("tempCoExaminer");
    if(!existence.exists())
    {
      fileHandler.temporaryWrite(coExaminerList, "tempCoExaminer");
    }
    existence = new File("tempRoom");
    if(!existence.exists())
    {
      fileHandler.temporaryWrite(roomList, "tempRoom");
    }
    existence = new File("tempExam");
    if(!existence.exists())
    {
      fileHandler.temporaryWrite(exams, "tempExam");
    }
    Object[] objs = fileHandler.temporaryRead("tempExam");
    for (Object obj:objs)
    {
      exams.addExam((Exam) obj);
    }
    existence = new File("tempSEDates");
    if(!existence.exists())
    {
      fileHandler.temporaryWrite(dates,"tempSEDates");
    }

  }


  public HomeController()
  {
    exams = new ExamList();
  }

  @Override public void handle(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == homeButton)
    {
      try
      {
        changeScene("home.fxml", actionEvent, null);
      }
      catch (IOException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }

    if (actionEvent.getSource().equals(roomButton))
    {
      try
      {
        changeScene("Rooms.fxml", actionEvent, null);
      }
      catch (IOException e )
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(teacherButton))
    {
      try
      {
        changeScene("Teacher.fxml", actionEvent, null);
      }
      catch (IOException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(coExaminerButton))
    {
      try
      {
        changeScene("Co-examiner.fxml", actionEvent, null);
      }
      catch (IOException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(courseButton))
    {
      try
      {
        changeScene("addUpdateCourse.fxml", actionEvent, null);
      }
      catch (IOException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(scheduleButton))
    {
      try
      {
        changeScene("addUpdateSchedule.fxml", actionEvent, null);
      }
      catch (IOException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(settingsButton))
    {
      try
      {
        changeScene("Settings.fxml", actionEvent, null);
      }
      catch (IOException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(exportButton))
    {
      try
      {
        export(exams, "dotation.xml");
      }
      catch (XmlConverterException ignored)
      {

      }
    }
  }

  private void changeScene(String target, ActionEvent event, Object list) throws IOException
  {
      Parent parent = FXMLLoader.load(getClass().getResource(target));
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.getScene().setRoot(parent);
      stage.show();
  }

  private void export(ExamList examList, String fileName) throws XmlConverterException
  {
    FileAdapter adapter = new FileAdapter(null);
    adapter.exportToXML(examList, fileName);
  }
}
