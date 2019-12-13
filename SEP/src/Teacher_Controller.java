import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Kristóf Lénárd, 293110
 * @version v1.0
 * A class for controlling the common GUI elements.
 */

public class Teacher_Controller implements EventHandler<ActionEvent>
{
  @FXML private Button homeButton;
  @FXML private Button roomButton;
  @FXML private Button teacherButton;
  @FXML private Button coExaminerButton;
  @FXML private Button courseButton;
  @FXML private Button scheduleButton;
  @FXML private Button settingsButton;
  @FXML private Button updateButton;
  @FXML private Button editButton;
  @FXML private Button deleteButton;
  @FXML private TextField nameField;
  @FXML private TextField idField;
  @FXML private ComboBox teachersBox;
  private Scene scene;
  private Stage stage;
  private static ArrayList list;

  public Teacher_Controller()
  {
    list = new ArrayList();
  }

  public static ArrayList getList()
  {
    return list;
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

    if(actionEvent.getSource() == updateButton)
    {
      String name = nameField.getText();
      String id = idField.getText();
      Teacher t = new Teacher(id, name);
      list.add(t);
      //System.out.println(t.getName() + "  " + t.getID());
      teachersBox.setItems(FXCollections.observableArrayList(list));
    }
    if(actionEvent.getSource() == editButton)
    {
      Object obj = teachersBox.getSelectionModel().getSelectedItem();
      if (obj instanceof Teacher)
      {
        nameField.setText(((Teacher) obj).getName());
        idField.setText(((Teacher) obj).getID());
      }
    }
    if(actionEvent.getSource() == deleteButton)
    {
      Object obj = teachersBox.getSelectionModel().getSelectedItem();
      if (obj instanceof Teacher)
      {
        list.remove(obj);
        teachersBox.setItems(FXCollections.observableArrayList(list));
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