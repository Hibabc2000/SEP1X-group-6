import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @author Oliver Isaac, 293131
 * @version 1.5.6.1
 * this class is just a conTROLLer class for my Room UI.
 */
public class RoomController implements EventHandler<ActionEvent>
{

  @FXML private Button homeButton;
  @FXML private Button roomButton;
  @FXML private Button teacherButton;
  @FXML private Button coExaminerButton;
  @FXML private Button courseButton;
  @FXML private Button scheduleButton;
  @FXML private Button settingsButton;
  @FXML private TextField text1;
  @FXML private TextField text2;
  @FXML private Button delete;
  @FXML private Button edit;
  @FXML private Button update;
  @FXML private ComboBox room;
  @FXML private ComboBox dota;
  @FXML private Label dotaError;
  @FXML private Label seatError;
  @FXML private Label numberError;

  private RoomList rlist;
  private Room temp;
  private String pro = null;
  private byte dotatitonIsInFrench = -1;
  private String number = null;
  private int seat = 0;
  private boolean updateCheck;

  public RoomController() throws IOException, ClassNotFoundException
  {
    rlist = new RoomList();
    FileAdapter fileHandler = new FileAdapter(null);
    Object[] objs = fileHandler.temporaryRead("tempRoom");
    for (Object obj : objs)
    {
      rlist.addRoom((Room) obj);
    }
    try
    {
      room.setItems(FXCollections.observableArrayList(rlist.getAllRooms()));
    }
    catch (NullPointerException ignored)
    {

    }
  }


  public void initialize() throws IOException, ClassNotFoundException
  {
    ArrayList arr = new ArrayList();
    arr.add("HDMI");
    arr.add("VGA");
    arr.add("HDMI and VGA");
    arr.add("none");
    dota.setItems(FXCollections.observableArrayList(arr));
    rlist = new RoomList();
    FileAdapter fileHandler = new FileAdapter(null);
    Object[] objs = fileHandler.temporaryRead("tempRoom");
    for (Object obj : objs)
    {
      rlist.addRoom((Room) obj);
    }
    try
    {
      room.setItems(FXCollections.observableArrayList(rlist.getAllRooms()));
    }
    catch (NullPointerException ignored)
    {

    }
  }
  @Override public void handle(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == homeButton)
    {
      try
      {
        changeScene("home.fxml", actionEvent, rlist);
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
        changeScene("Rooms.fxml", actionEvent, rlist);
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
        changeScene("Teacher.fxml", actionEvent, rlist);
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
        changeScene("Co-examiner.fxml", actionEvent, rlist);
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
        changeScene("addUpdateCourse.fxml", actionEvent, rlist);
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
        changeScene("addUpdateSchedule.fxml", actionEvent, rlist);
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
        changeScene("Settings.fxml", actionEvent, rlist);
      }
      catch (IOException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
  }

  private void changeScene(String target, ActionEvent event, Object list) throws IOException
  {
    FileAdapter fileHandler = new FileAdapter(null);
    fileHandler.temporaryWrite(rlist, "tempRoom");
    Parent parent = FXMLLoader.load(getClass().getResource(target));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.getScene().setRoot(parent);
    stage.show();
  }

  public void update(ActionEvent e)
  {
    if (e.getSource() == update)
    {
      if (text1.getText().length() == 0)
      {
        numberError.setText("Enter valid name");
      }
      else
      {
        numberError.setText("");
        number = text1.getText();
      }

      if (text2.getText().length() == 0)
      {
        seatError.setText("Enter valid id");
      }

      else
        seatError.setText("");
      try
      {
        seat = Integer.parseInt(text2.getText());
        //Catches all NumberFormatExceptions but not other errors
      }
      catch (NumberFormatException ex)
      {
        seatError.setText("Invalid number of students");
      }
      if (seat < 0 || seat == 0)
      {
        seatError.setText("Invalid number of students");
      }
      if (dota.getValue() == null)
      {
        dotaError.setText("Choose a dotation");
      }
      else
        dotaError.setText("");
      try
      {
        pro = (String) dota.getValue();
        if (pro.equals("HDMI"))
        {
          dotatitonIsInFrench = 2;

        }
        else if (pro.equals("VGA"))
        {
          dotatitonIsInFrench = 1;

        }
        else if (pro.contains("and"))
        {
          dotatitonIsInFrench = 3;
        }
        else if (pro.equals("none"))
        {
          dotatitonIsInFrench = 0;
        }

      }
      catch (NullPointerException n)
      {
        dotaError.setText("Choose a dotation");

      }

      if (numberError.getText().length() == 0
          && seatError.getText().length() == 0
          && dotaError.getText().length() == 0)
      {
        temp = new Room(number, seat, dotatitonIsInFrench);
        rlist.addRoom(temp);
      }
      if (updateCheck)
      {
        Object obj = room.getSelectionModel().getSelectedItem();
        if (obj instanceof Room)
        {
          room.getItems().removeAll(obj);
        }
        updateCheck = false;
      }

      if (!room.getItems().contains(temp))
      {
        room.getItems().add(temp);
        room.getSelectionModel().select(room.getItems().size() - 1);

      }

      text1.setText("");
      text2.setText("");
      dota.setValue(null);

    }

  }

  public void delete(ActionEvent e)
  {
    if (e.getSource() == delete)
    {
      Object obj = room.getSelectionModel().getSelectedItem();
      if (obj instanceof Room)
      {
        room.getItems().removeAll(obj);
      }

    }
  }

  public void edit(ActionEvent e) throws InterruptedException
  {
    if (e.getSource() == edit)
    {
      Object obj = room.getSelectionModel().getSelectedItem();
      if (obj instanceof Room)
      {
        text1.setText(((Room) obj).getRoomNumber());
        text2.setText(Integer.toString(((Room) obj).getNumberOfSeats()));
        if (((Room) obj).getProjector() == 1)
        {
          dota.setValue("VGA");
        }
        else if (((Room) obj).getProjector() == 2)
        {
          dota.setValue("HDMI");
        }
        else if (((Room) obj).getProjector() == 3)
        {
          dota.setValue("HDMI and VGA");
        }
        else if (((Room) obj).getProjector() == 0)
        {
          dota.setValue("none");
        }
        updateCheck = true;
      }
    }
  }
}