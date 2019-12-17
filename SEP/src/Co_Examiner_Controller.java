
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

public class Co_Examiner_Controller implements EventHandler<ActionEvent>
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
  @FXML private ComboBox coExaminersBox;
  @FXML private Label nameFieldError;
  @FXML private Label idFieldError;

  private Scene scene;
  private Stage stage;
  private CoExaminerList list;
  private String nameCoExm = null;
  private String idCoExm = null;
  private CoExaminer buffer;
  private boolean external = false;
  private boolean checkUpdate;

  /**
   *
   * @throws IOException - throws this exception on error while reading file
   * @throws ClassNotFoundException - throws this exception if no such class exists
   * method initialize the courseList object, creates an instance of file Adapter
   * that is reading from the files and add all objects to the combobox
   */
  public void initialize()
      throws IOException, ClassNotFoundException
  {
    list = new CoExaminerList();

    FileAdapter fileHandler = new FileAdapter(null);
    Object[] objs = fileHandler.temporaryRead("tempCoExaminer");
    for (Object obj : objs)
    {
      if(obj instanceof CoExaminer)
      {
        list.addCoExaminer((CoExaminer) obj);
      }
    }
    coExaminersBox.setItems(FXCollections.observableArrayList(list.getAllCoExaminers()));

  }

  /**
   *
   * @param actionEvent action
   * this method handles the scene switch
   */
    @Override public void handle(ActionEvent actionEvent)
    {
      if (actionEvent.getSource() == homeButton)
      {
        try
        {
          changeScene("Home.fxml", actionEvent, list);
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
          changeScene("Rooms.fxml", actionEvent, list);
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
          changeScene("Teacher.fxml", actionEvent, list);
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
          changeScene("Co-examiner.fxml", actionEvent, list);
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
          changeScene("addUpdateCourse.fxml", actionEvent, list);
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
          changeScene("addUpdateSchedule.fxml", actionEvent, list);
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
          changeScene("Settings.fxml", actionEvent, list);
        }
        catch (IOException e)
        {
          e.printStackTrace();
          System.exit(1);
        }
      }
    }

  /**
   *
   * @param e action event parameter
   * @throws InterruptedException
   * method handles the "Update" button in the GUI
   */
  public void update(ActionEvent e) throws InterruptedException
  {
    if (e.getSource() == updateButton)
    {
      //      Name Field Checks
      if (nameField.getText().length() == 0)
      {
        nameFieldError.setText("Enter the Name");
      }
      else
      {
        nameFieldError.setText("");
        nameCoExm = nameField.getText();
      }
      //      Group Name Checks
      if (idField.getText().length() == 0)
      {
        idFieldError.setText("Enter the ID");
      }
      else
      {
        idFieldError.setText("");
        idCoExm = idField.getText();
      }

      if (internalBox.isSelected())
      {
        external = true;
      }
      if (nameFieldError.getText().length() == 0
          && idFieldError.getText().length() == 0)
      {
        //    Creating the Co-Examiner object
        buffer = new CoExaminer(idCoExm,nameCoExm, external);
      }
      //      Adding the object to Co-Exm list
      list.addCoExaminer(buffer);

      //      Add items to combobox
      //      Duplicate checker
      if (checkUpdate)
      {
        Object obj = coExaminersBox.getSelectionModel().getSelectedItem();
        if (obj instanceof CoExaminer)
        {
          coExaminersBox.getItems().removeAll(obj);
        }
        checkUpdate = false;
      }
      if (!(coExaminersBox.getItems().contains(buffer)))
      {
        coExaminersBox.getItems().add(buffer);
        coExaminersBox.getSelectionModel()
            .select(coExaminersBox.getItems().size() - 1);
      }
      //      Set up empty text fields
      nameField.setText("");
      idField.setText("");

    }
  }

  /**
   *
   * @param e action event parameter
   * @throws InterruptedException
   *  method handles the "Edit" button in the GUI
   */
  public void edit(ActionEvent e) throws InterruptedException
  {
    if (e.getSource() == editButton)
    {
      Object obj = coExaminersBox.getSelectionModel().getSelectedItem();
      if (obj instanceof CoExaminer)
      {
        nameField.setText(((CoExaminer) obj).getName());
        idField.setText(((CoExaminer) obj).getID());
        checkUpdate = true;
        if (((CoExaminer) obj).isExternal())
        {
          internalBox.setSelected(true);
        }
        else
        {
          internalBox.setSelected(false);
        }
      }
    }
  }

  /**
   *
   * @param e action event parameter
   * @throws InterruptedException
   *  method handles the "Delete" button in the GUI
   */
  public void delete(ActionEvent e) throws InterruptedException
  {

    if (e.getSource() == deleteButton)
    {
      Object obj = coExaminersBox.getSelectionModel().getSelectedItem();
      if (obj instanceof CoExaminer)
      {
        coExaminersBox.getItems().removeAll(obj);
      }

    }
  }
  private void changeScene(String target, ActionEvent event, Object list) throws IOException
  {
      FileAdapter fileHandler = new FileAdapter(null);
      fileHandler.temporaryWrite(list, "tempCoExaminer");
      Parent parent = FXMLLoader.load(getClass().getResource(target));
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.getScene().setRoot(parent);
      stage.show();
  }
}

