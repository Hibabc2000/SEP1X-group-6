import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.lang.reflect.Field;
import java.util.ArrayList;

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
  @FXML private ComboBox cexmnr;
  @FXML private DatePicker dateBox;
  @FXML private TextArea alertBox;
  @FXML private ComboBox exmBox;
  private Scene scene;
  private Stage stage;
  private TeacherList teacherList;
  private CoExaminerList coExaminerList;

  public AddUpdateController()
  {
    /*
    exmtyp.getItems().add("Oral");
    exmtyp.getItems().add("Written");

    ArrayList<Room> tmp = RoomList.getAllRooms();
    for(int x0 = 0; x0 < tmp.size(); x0++)
    {
      roomC.getItems().add(tmp.get(x0).getRoomNumber());
    }


    for(int x0 = 0; x0 < CourseList.getAllCourses().size(); x0++)
    {
      crs.getItems().add(CourseList.getAllCourses().get(x0).getCourseName());
    }

    dateBox = new DatePicker();

    tchr.setItems(FXCollections.observableArrayList(teacherList));

    cexmnr.setItems(FXCollections.observableArrayList(coExaminerList));

    exmBox.setItems(FXCollections.observableArrayList(ExamList.getAllExams()));*/
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
      //save data to file
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
      tchr.setItems(FXCollections.observableArrayList(teacherList.getAllTeachers()));
    }
    if(target.equals("cexmnr"))
    {
      cexmnr.setItems(FXCollections.observableArrayList(coExaminerList.getAllCoExaminers()));
    }
  }
}


