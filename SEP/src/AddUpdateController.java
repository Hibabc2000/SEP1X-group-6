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

  public AddUpdateController()
  {
    exmtyp = new ComboBox();
    ObservableList<String> list = FXCollections.observableArrayList("1","2","3","4");
    exmtyp.setItems(list);

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

    tchr.setItems(FXCollections.observableArrayList(Teacher_Controller.getList()));

    cexmnr.setItems(FXCollections.observableArrayList(CoExaminerList.getAllCoExaminers()));

    exmBox.setItems(FXCollections.observableArrayList(ExamList.getAllExams()));




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
        changeScene("Home.fxml", actionEvent);
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
  }


  private void changeScene(String target, ActionEvent event) throws IOException
  {
    Parent parent = FXMLLoader.load(getClass().getResource(target));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.getScene().setRoot(parent);
    stage.show();
  }

}


