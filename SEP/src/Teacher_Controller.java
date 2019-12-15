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

  private Scene scene;
  private Stage stage;
  private TeacherList list;
  //******
  private TeacherList teacherList;
  //******

  //************************
  public void initialize()
      throws IOException, ClassNotFoundException, NoSuchFieldException,
      IllegalAccessException
  {
    teacherList = new TeacherList();
    FileAdapter fileHandler = new FileAdapter(null);
    Object[] objs = fileHandler.temporaryRead("tempTeacher");
    for (Object obj : objs)
    {
      teacherList.addTeacher((Teacher) obj);
    }

    teachersBox.setItems(
        FXCollections.observableArrayList(teacherList.getAllTeachers()));
  }
  //************************

  @Override public void handle(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == homeButton)
    {
      try
      {
        changeScene("home.fxml", actionEvent, list);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException | ClassNotFoundException e)
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
      catch (IOException | NoSuchFieldException | IllegalAccessException | ClassNotFoundException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(teacherButton))
    {
      try
      {
        changeScene("Teacher.fxml", actionEvent, list);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException | ClassNotFoundException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(coExaminerButton))
    {
      try
      {
        changeScene("Co-examiner.fxml", actionEvent, list);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException | ClassNotFoundException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(courseButton))
    {
      try
      {
        changeScene("addUpdateCourse.fxml", actionEvent, list);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException | ClassNotFoundException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(scheduleButton))
    {
      try
      {
        changeScene("addUpdateSchedule.fxml", actionEvent, list);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException | ClassNotFoundException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(settingsButton))
    {
      try
      {
        changeScene("Settings.fxml", actionEvent, list);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException | ClassNotFoundException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
/*
    if(actionEvent.getSource() == updateButton)
    {
      String name = nameField.getText();
      String id = idField.getText();
      Teacher t = new Teacher(id, name);
      list.addTeacher(t);
      teachersBox.setItems(FXCollections.observableArrayList(list.getAllTeachers()));
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
        list.deleteTeacher((Teacher) obj);
        teachersBox.setItems(FXCollections.observableArrayList(list.getAllTeachers()));
      }
    }
    */
    //***************
    if (actionEvent.getSource() == updateButton)
    {
      String name = nameField.getText();
      String id = idField.getText();
      if (name.length() == 0 || id.length() == 0)
      {
        errorName.setText("Enter the name");
        errorID.setText("Enter the ID");
      }
      else
      {
        if (updateCheck)
        {
          Object obj = teachersBox.getSelectionModel().getSelectedItem();
          if (obj instanceof Teacher)
          {
            teachersBox.getItems().removeAll(obj);
          }
          updateCheck = false;
        }


        Teacher t = new Teacher(id, name);
        teacherList.addTeacher(t);
        if (!teachersBox.getItems().contains(t))
        {
          teachersBox.getItems().add(t);
          teachersBox.getSelectionModel()
              .select(teachersBox.getItems().size() - 1);
        }
        nameField.setText("");
        idField.setText("");

      }
    }
    if (actionEvent.getSource() == editButton)
    {
      Object obj = teachersBox.getSelectionModel().getSelectedItem();
      if (obj instanceof Teacher)
      {
        nameField.setText(((Teacher) obj).getName());
        idField.setText(((Teacher) obj).getID());
        teachersBox.setItems(
            FXCollections.observableArrayList(teacherList.getAllTeachers()));
        updateCheck = true;
      }
    }
    if (actionEvent.getSource() == deleteButton)
    {
      Object obj = teachersBox.getSelectionModel().getSelectedItem();
      if (obj instanceof Teacher)
      {
        teacherList.deleteTeacher((Teacher) obj);
        teachersBox.setItems(
            FXCollections.observableArrayList(teacherList.getAllTeachers()));
      }
    }
    //****************
  }

  private void changeScene(String target, ActionEvent event, Object list)
      throws IOException, NoSuchFieldException, IllegalAccessException,
      ClassNotFoundException
  {
    /*
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
    */

    FileAdapter fileHandler = new FileAdapter(null);
    fileHandler.temporaryWrite(list, "tempTeacher");
    Parent parent = FXMLLoader.load(getClass().getResource(target));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.getScene().setRoot(parent);
    stage.show();
    //}
  }
}