import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import persistence.XmlConverterException;

/**
 * @author Silvestru Mindrila, 293135
 * @version 2.2
 */
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

  /**
   * @throws IOException            throws this exception on error while reading file
   * @throws ClassNotFoundException throws this exception if no such class exists
   *                                Method initialize the table view and filling it with exam components(exam type, date,teacher,co-examiner ,course,room)
   *                                Creates an instance of file Adapter that is reading from the files and add all objects to the combobox
   */
  public void initialize() throws IOException, ClassNotFoundException

  {

    ArrayList<OurDate> dates = new ArrayList<>();
    TeacherList teacherList = new TeacherList();
    CourseList courseList = new CourseList();
    CoExaminerList coExaminerList = new CoExaminerList();
    RoomList roomList = new RoomList();

    File existence = new File("tempCourse");
    FileAdapter fileHandler = new FileAdapter(null);
    if (!existence.exists())
    {
      fileHandler.temporaryWrite(courseList, "tempCourse");
    }
    existence = new File("tempTeacher");
    if (!existence.exists())
    {
      fileHandler.temporaryWrite(teacherList, "tempTeacher");
    }
    existence = new File("tempCoExaminer");
    if (!existence.exists())
    {
      fileHandler.temporaryWrite(coExaminerList, "tempCoExaminer");
    }
    existence = new File("tempRoom");
    if (!existence.exists())
    {
      fileHandler.temporaryWrite(roomList, "tempRoom");
    }
    existence = new File("tempExam");
    if (!existence.exists())
    {
      fileHandler.temporaryWrite(exams, "tempExam");
    }
    Object[] objs = fileHandler.temporaryRead("tempExam");
    for (Object obj : objs)
    {
      exams.addExam((Exam) obj);
    }
    existence = new File("tempSEDates");
    if (!existence.exists())
    {
      fileHandler.temporaryWrite(dates, "tempSEDates");
    }

    //***************************
    // TableView columns settings
    Time = new TableColumn<Exam, String>("Time");
    Time.setCellValueFactory(new PropertyValueFactory<Exam, String>("time"));
    NumStud = new TableColumn<Exam, String>("Nr. of Students");
    NumStud
        .setCellValueFactory(new PropertyValueFactory<Exam, String>("numStud"));
    Room = new TableColumn<Exam, String>("Room");
    Room.setCellValueFactory(
        new PropertyValueFactory<Exam, String>("roomNumber"));
    Course = new TableColumn<Exam, String>("Course");
    Course.setCellValueFactory(
        new PropertyValueFactory<Exam, String>("courseName"));
    Date = new TableColumn<Exam, String>("Date");
    Date.setCellValueFactory(new PropertyValueFactory<Exam, String>("day"));
    Teacher = new TableColumn<Exam, String>("Teacher");
    Teacher.setCellValueFactory(
        new PropertyValueFactory<Exam, String>("teacherName"));
    Type = new TableColumn<Exam, String>("Type");
    Type.setCellValueFactory(
        new PropertyValueFactory<Exam, String>("examType"));
    Week = new TableColumn<Exam, String>("Week");
    Week.setCellValueFactory(new PropertyValueFactory<Exam, String>("week"));
    tableView.getColumns()
        .addAll(Teacher, Date, Course, Room, Type, Week, NumStud, Time);
    tableView.getItems().addAll(exams.getAllExams());
    //***************************
  }

  /**
   * No-arg constructor
   */
  public HomeController()
  {
    exams = new ExamList();
  }

  /**
   * @param actionEvent action
   *                    this method handles the scene switch when the according button is pressed
   */
  @Override public void handle(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == homeButton)
    {
      try
      {
        changeScene("home.fxml", actionEvent);
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
        changeScene("Rooms.fxml", actionEvent);
      }
      catch (IOException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(teacherButton))
    {
      try
      {
        changeScene("Teacher.fxml", actionEvent);
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
        changeScene("Co-examiner.fxml", actionEvent);
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
        changeScene("addUpdateCourse.fxml", actionEvent);
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
        changeScene("addUpdateSchedule.fxml", actionEvent);
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
        changeScene("Settings.fxml", actionEvent);
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
        export("dotation.xml");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Schedule successfully exported!");
      }
      catch (XmlConverterException | IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR,
            "Error exporting the schedule! Please try again.");
        alert.showAndWait();
      }
    }
  }

  /**
   * @param target fxml target
   * @param event  action event
   * @throws IOException throws this exception on error while reading file
   *                     This method handles changing the scene
   */
  private void changeScene(String target, ActionEvent event) throws IOException
  {
    Parent parent = FXMLLoader.load(getClass().getResource(target));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.getScene().setRoot(parent);
    stage.show();
  }

  /**
   * @param fileName filename
   * @throws XmlConverterException  throws an error of xml converter
   * @throws IOException            throws this exception on error while reading file
   * @throws ClassNotFoundException throws this exception if no such class exists
   *                                Begins the process that exports the schedule to an Xml file
   */
  private void export(String fileName)
      throws XmlConverterException, IOException, ClassNotFoundException
  {
    FileAdapter fileAdapter = new FileAdapter(null);
    Object[] arr = fileAdapter.temporaryRead("tempExam");
    for (Object obj : arr)
    {
      exams.addExam((Exam) obj);
    }
    fileAdapter.exportToXML(exams, fileName);
  }
}
