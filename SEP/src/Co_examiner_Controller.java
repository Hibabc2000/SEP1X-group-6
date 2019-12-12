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

public class Co_examiner_Controller implements EventHandler<ActionEvent>
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
  @FXML private CheckBox internalBox;
  @FXML private ComboBox<Co_examiner> coExaminersBox;
  private ArrayList<Co_examiner> list;
  private Scene scene;
  private Stage stage;

  public Co_examiner_Controller()
  {
    list = new ArrayList<Co_examiner>();
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
      Alert alert = new Alert(Alert.AlertType.INFORMATION,
          "Successful load on Home!");
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
        changeScene("Co_examiner.fxml", actionEvent);
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
      boolean external = false;
      if(internalBox.isSelected())
      {
        external = true;
      }
      Co_examiner t = new Co_examiner(id, name, external);
      list.add(t);
      System.out.println(t.getName() + "  " + t.getID());
      coExaminersBox.setItems(FXCollections.observableArrayList(list));
    }
    if(actionEvent.getSource() == editButton)
    {
      Object obj = coExaminersBox.getSelectionModel().getSelectedItem();
      if (obj instanceof Co_examiner)
      {
        nameField.setText(((Co_examiner) obj).getName());
        idField.setText(((Co_examiner) obj).getID());
        if(((Co_examiner) obj).isExternal())
        {
          internalBox.setSelected(true);
        }
        else
        {
          internalBox.setSelected(false);
        }
      }
    }
    if(actionEvent.getSource() == deleteButton)
    {
      Object obj = coExaminersBox.getSelectionModel().getSelectedItem();
      if (obj instanceof Co_examiner)
      {
        list.remove(obj);
        coExaminersBox.setItems(FXCollections.observableArrayList(list));
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

