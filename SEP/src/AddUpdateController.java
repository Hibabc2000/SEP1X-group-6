import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AddUpdateController implements EventHandler<ActionEvent>
{
  @FXML private Button homeButton;
  @FXML private Button roomButton;
  @FXML private Button teacherButton;
  @FXML private Button coExaminerButton;
  @FXML private Button courseButton;
  @FXML private Button scheduleButton;
  @FXML private Button settingsButton;
  @FXML private Button editB;
  @FXML private Button updateB;
  @FXML private Button deleteB;
  @FXML private ComboBox exmtyp;
  @FXML private ComboBox crs;
  @FXML private ComboBox roomC;
  @FXML private ComboBox tchr;
  @FXML private ComboBox<Co_examiner> cexmnr;
  @FXML private DatePicker dateBox;
  @FXML private TextArea alertBox;
  @FXML private ComboBox exmBox;
  private Scene scene;
  private Stage stage;
  private TeacherList teacherList;
  private CoExaminerList coExaminerList;
  private RoomList roomList;
  private CourseList courseList;
  private ExamList examList;


  public void initialize()
  {
    exmtyp.getItems().addAll("oral","Written");
  }
  public AddUpdateController()
      throws IOException, ClassNotFoundException, NoSuchFieldException,
      IllegalAccessException
  {
    teacherList = new TeacherList();
    coExaminerList = new CoExaminerList();
    roomList = new RoomList();
    courseList = new CourseList();
    examList = new ExamList();
    FileAdapter fileHandler = new FileAdapter(null);
    Object[] objs = fileHandler.temporaryRead("tempTeacher");
    for (Object obj:objs)
    {
      teacherList.addTeacher((Teacher) obj);
    }
    for(Object t : teacherList.getAllTeachers())
    {
      System.out.println(t);
    }
    //tchr.setItems(FXCollections.observableArrayList(teacherList.getAllTeachers()));
    transferMessage(teacherList, "teacherList", "tchr");
    objs = fileHandler.temporaryRead("tempCoExaminer");
    for (Object obj:objs)
    {
      if(obj instanceof Co_examiner)
      {
        coExaminerList.addCoExaminer(obj);
      }
    }
    objs = fileHandler.temporaryRead("tempRoom");
    for (Object obj:objs)
    {
      if(obj instanceof Room)
      {
        roomList.addRoom((Room) obj);
      }
    }
  }

  @Override public void handle(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == updateB)
    {

    }
    if(actionEvent.getSource() == editB)
    {

    }
    if(actionEvent.getSource() == deleteB)
    {

    }

    if (actionEvent.getSource() == homeButton)
    {
      try
      {
        changeScene("home.fxml", actionEvent, null);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
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
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
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
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
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
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
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
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
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
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
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
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
  }

  private void changeScene(String target, ActionEvent event, TeacherList list)
      throws IOException, NoSuchFieldException, IllegalAccessException
  {
    if(target.equals("addUpdateSchedule.fxml"))
    {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(target));
      Parent parent = loader.load();
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      AddUpdateController control = loader.getController();
      control.transferMessage(list, "teacherList", "tchr");
      stage.getScene().setRoot(parent);
      stage.show();
    }
    else
    {
      FileAdapter fileHandler = new FileAdapter(null);
      fileHandler.temporaryWrite(list, "tempExams");
      Parent parent = FXMLLoader.load(getClass().getResource(target));
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.getScene().setRoot(parent);
      stage.show();
    }
  }

  /**
   * This method transfers an object to AddUpdateController, and loads it into its relevant ComboBox
   * @param message - the object we want to pass as a message
   * @param name - the name of the field in AddUpdateController
   * @param target - the name of the ComboBox we want to set
   * @throws NoSuchFieldException - method throws this exception if the target field does not exist.
   * @throws IllegalAccessException - method throws this exception if it does not have access to the target variable
   */
  public void transferMessage(Object message, String name, String target)
      throws NoSuchFieldException, IllegalAccessException
  {
    getClass().getDeclaredField(name).set(this, message);
    System.out.println(message);
    if (target.equals("tchr"))
    {
      if(tchr != null)
      {
        tchr.setItems(FXCollections.observableArrayList(teacherList.getAllTeachers()));
      }
      else System.out.println("TCHR is null");
    }
    if(target.equals("cexmnr"))
    {
      cexmnr.setItems(FXCollections.observableArrayList(coExaminerList.getAllCoExaminers()));
    }

 if(target.equals("crs")){
      crs.setItems(FXCollections.observableArrayList(courseList.getAllCourses()));
    }
 else System.out.println("CRS is null");
    }
  }




