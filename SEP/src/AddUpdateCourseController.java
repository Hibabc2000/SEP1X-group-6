import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Kristóf Lénárd, 293110
 * @author Marin Bilba, 293141
 * @version v1.0
 * A class for controlling the course GUI menu.
 */

public class AddUpdateCourseController implements EventHandler<ActionEvent>
{
    @FXML private Button homeButton;
    @FXML private Button roomButton;
    @FXML private Button teacherButton;
    @FXML private Button coExaminerButton;
    @FXML private Button courseButton;
    @FXML private Button scheduleButton;
    @FXML private Button settingsButton;
    private Scene scene;
    private Stage stage;

    public AddUpdateCourseController()
    {
    }

    @Override public void handle(ActionEvent actionEvent)
    {
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
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successful load on Home!");
        alert.showAndWait();
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
          FXMLLoader.load(getClass().getResource("Teacher.fxml"));
          System.out.println("Successful load");
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
      Parent parent = FXMLLoader.load(getClass().getResource("Rooms.fxml"));
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.getScene().setRoot(parent);
      stage.show();
    }
}