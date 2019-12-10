import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * @author Kristóf Lénárd, 293110
 * @version v1.0
 * A class for controlling the common GUI elements.
 */

public class General_Controller implements EventHandler<ActionEvent>
{
    @FXML private Button homeButton;
    @FXML private Button roomButton;
    @FXML private Button teacherButton;
    @FXML private Button coExaminerButton;
    @FXML private Button courseButton;
    @FXML private Button scheduleButton;
    @FXML private Button settingsButton;

    @Override public void handle(ActionEvent actionEvent)
    {
      if (actionEvent.getSource().equals(homeButton))
      {
        try
        {
          FXMLLoader.load(getClass().getResource("..\\fxml\\Home.fxml"));
          Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successful load on Home!");
          alert.show();
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
          FXMLLoader.load(getClass().getResource("..\\fxml\\Rooms.fxml"));
          System.out.println("Successful load");
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
          FXMLLoader.load(getClass().getResource("..\\fxml\\Teacher.fxml"));
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
          FXMLLoader.load(getClass().getResource("..\\fxml\\Co-examiner.fxml"));
          System.out.println("Successful load");
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
          FXMLLoader.load(getClass().getResource("..\\fxml\\Course.fxml"));
          System.out.println("Successful load");
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
          FXMLLoader.load(getClass().getResource("..\\fxml\\addUpdateCourse.fxml"));
          System.out.println("Successful load");
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
          FXMLLoader.load(getClass().getResource("..\\fxml\\settings.fxml"));
          System.out.println("Successful load");
        }
        catch (IOException e)
        {
          e.printStackTrace();
          System.exit(1);
        }
      }
    }
}
