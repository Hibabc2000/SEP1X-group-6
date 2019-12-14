import javafx.collections.FXCollections;
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
import java.io.IOException;
import java.util.ArrayList;

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
  private ExamList exams;

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

  private void changeScene(String target, ActionEvent event, Object list)
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
}
