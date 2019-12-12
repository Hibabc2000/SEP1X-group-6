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
  private Scene scene;
  private Stage stage;

  public AddUpdateController()
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
        changeScene("Course.fxml", actionEvent);
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

  // Controller settings
  @FXML private ComboBox courses;
  @FXML private Button update;
  @FXML private TextField name;
  @FXML private TextField group;
  @FXML private TextField nrStudents;
  @FXML private TextField semester;

  @FXML private Label nameError;
  @FXML private Label groupError;
  @FXML private Label nrStudentsError;
  @FXML private Label semesterError;
  @FXML private Label updatedNotification;

  private boolean updateCheck=false;
private  Course buffer;
  String courseName = null;
  String groupName=null;
  int numberOfStudents = 0;
  int semesterNumber = 0;
  public void update(ActionEvent e)
  {
    if (e.getSource() == update)
    {

      //      Name Field Checks
      if (name.getText().length() == 0)
      {
        nameError.setText("Enter the course name");
      }
      else
      {
        nameError.setText("");
        courseName = name.getText();

      }
      //      Group Name Checks
      if (group.getText().length() == 0)
      {
        groupError.setText("Enter the group name");
      }
      else
      {
        groupError.setText("");
        groupName = group.getText();

      }
      //      Number of Students check
      if (nrStudents.getText().length() == 0)
      {
        nrStudentsError.setText("Enter the number of Students");
      }
      else
      {
        nrStudentsError.setText("");
        try
        {
          numberOfStudents = Integer.parseInt(nrStudents.getText());
          //Catches all NumberFormatExceptions but not other errors
        }
        catch (NumberFormatException ex)
        {
          nrStudentsError.setText("Invalid number of students");
        }
        if (numberOfStudents < 0 || numberOfStudents == 0)
        {
          nrStudentsError.setText("Invalid number of students");
        }
      }
      //      Semester Number check
      if (nrStudents.getText().length() == 0)
      {
        semesterError.setText("Enter the semester number");
      }
      else
      {
        semesterError.setText("");
        try
        {
          semesterNumber = Integer.parseInt(semester.getText());
          //Catches all NumberFormatExceptions but not other errors
        }
        catch (NumberFormatException ex)
        {
          semesterError.setText("Invalid semester number");
        }
        if (semesterNumber < 0 || semesterNumber == 0)
        {
          semesterError.setText("Invalid semester number");
        }
      }
    }
    if (courseName != null && groupName != null
        && nrStudentsError.getText().length() == 0
        && semesterError.getText().length() == 0)
    {
      buffer = new Course(courseName, groupName, numberOfStudents,
          semesterNumber);
      System.out.println(semesterNumber);

      //      Add items to combobox
//     Duplicate checker
      if (courses.getItems().size() == 0)
      {
        courses.getItems().addAll(buffer.getCourseName() + "-" + buffer.getGroup());
      }
      else
      {
        for (int i = 0; i < courses.getItems().size(); i++)
        {
          if (!(courses.getItems().get(i).equals(buffer.getCourseName() + "-" + buffer.getGroup())))
          {
            courses.getItems().addAll(buffer.getCourseName() + "-" + buffer.getGroup());
          }
          else
          {
            return;
          }
        }
      }
    }
  }
}


