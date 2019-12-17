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
  @FXML private Label errorID;
  @FXML private Label errorName;

  private boolean updateCheck;
  private TeacherList teacherList;
  private Teacher t;
  private String name;
  private String id;

  public void initialize() throws IOException, ClassNotFoundException
  {
    teacherList = new TeacherList();
    FileAdapter fileHandler = new FileAdapter(null);
    Object[] objs = fileHandler.temporaryRead("tempTeacher");
    for (Object obj : objs)
    {
      teacherList.addTeacher((Teacher) obj);
    }
    teachersBox.setItems(FXCollections.observableArrayList(teacherList.getAllTeachers()));
  }

  @Override public void handle(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == homeButton)
    {
      try
      {
        changeScene("home.fxml", actionEvent, teacherList);
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
        changeScene("Rooms.fxml", actionEvent, teacherList);
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
        changeScene("Teacher.fxml", actionEvent, teacherList);
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
        changeScene("Co-examiner.fxml", actionEvent, teacherList);
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
        changeScene("addUpdateCourse.fxml", actionEvent, teacherList);
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
        changeScene("addUpdateSchedule.fxml", actionEvent, teacherList);
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
        changeScene("Settings.fxml", actionEvent, teacherList);
      }
      catch (IOException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
  }
  public void update(ActionEvent e)
  {
    if (e.getSource() == updateButton)
    {
      if (nameField.getText().length() == 0)
      {
        errorName.setText("Enter valid name");
      }
      else
      {
        errorName.setText("");
        name=nameField.getText();
      }

      if (idField.getText().length() == 0)
      {
        errorID.setText("Enter valid id");
      }
      else
      {
        errorID.setText("");
        id=idField.getText();
      }

      if (errorName.getText().length() == 0 && errorID.getText().length() == 0)
      {
        t = new Teacher(id, name);
        teacherList.addTeacher(t);
      }
      if (updateCheck)
      {
        Object obj = teachersBox.getSelectionModel().getSelectedItem();
        if (obj instanceof Teacher)
        {
          teachersBox.getItems().removeAll(obj);
        }
        updateCheck = false;
      }

      if (!teachersBox.getItems().contains(t))
      {
        teachersBox.getItems().add(t);
        teachersBox.getSelectionModel().select(teachersBox.getItems().size()-1);
      }

      nameField.setText("");
      idField.setText("");

    }

  }
  public void edit(ActionEvent e)
  {
    if (e.getSource() == editButton)
    {
      Object obj = teachersBox.getSelectionModel().getSelectedItem();
      if (obj instanceof Teacher)
      {
        nameField.setText(((Teacher) obj).getName());
        idField.setText(((Teacher) obj).getID());
        updateCheck = true;
      }
    }
  }
  public void delete(ActionEvent e)
  {
    if (e.getSource() == deleteButton)
    {
      Object obj = teachersBox.getSelectionModel().getSelectedItem();
      if (obj instanceof Teacher)
      {
        teachersBox.getItems().removeAll(obj);
      }
    }
  }

  private void changeScene(String target, ActionEvent event, Object list) throws IOException
  {
    FileAdapter fileHandler = new FileAdapter(null);
    fileHandler.temporaryWrite(teacherList, "tempTeacher");
    Parent parent = FXMLLoader.load(getClass().getResource(target));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.getScene().setRoot(parent);
    stage.show();
  }
}