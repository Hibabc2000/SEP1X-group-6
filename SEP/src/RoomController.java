
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.fxml.FXML;

    import javafx.scene.control.Button;
    import javafx.scene.control.ChoiceBox;
    import javafx.scene.control.TextField;
    import javafx.scene.input.MouseEvent;

    import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

/**
 * @author Kristóf Lénárd, 293110
 * @version v1.0
 * A class for controlling the common GUI elements.
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
  private Scene scene;
  private Stage stage;

  public RoomController()
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





























/**
 *@author Oliver Isaac, 293131
 *@version 1.0.0.0
 *this class is just a conTROLLer class for my Room UI.
 */
  private ArrayList<String> list;
  private ArrayList<String> list2;
  @FXML private TextField text1;
  @FXML private TextField text2;
  @FXML private Button delete;
  @FXML private Button edit;
  @FXML private Button update;
  @FXML private ChoiceBox room;
  @FXML private ChoiceBox dota;
  private RoomList rlist;

  public void update(ActionEvent e)
  {
    if(e.getSource() == update)
    {Room temp = new Room();
    temp.setRoomNumber(text1.getText());
    int sit = Integer.parseInt(text2.getText()) ;
    temp.setNumberOfSeats(sit);
    String pro = (String)room.getValue();
    if (pro.equals("HDMI")) {temp.setProjector((byte) 1);}
      else if (pro.equals("VGA")) {temp.setProjector((byte) 2);}
      if (pro.equals("HDMI and VGA")) {temp.setProjector((byte) 3);}
      if (pro.equals("none")) {temp.setProjector((byte) 0);}
      else temp.setProjector((byte) -1);
      int choice = JOptionPane
          .showConfirmDialog(null, "Are you sure you want to update the room?");
      if(choice==JOptionPane.YES_OPTION) {rlist.addRoom(temp);}
      else if(choice==JOptionPane.NO_OPTION){}

    }
    if(e.getSource()==delete)
    { String temp = (String)room.getValue();
      ArrayList<Room> trump =  new ArrayList<>(rlist.getAllRooms().size());
      for (int i=0; i<trump.size();i++)
      {
        if (trump.get(i).getRoomNumber().equals(temp)) {rlist.getAllRooms().remove(i);}
      }

    }

  }
  public void starting(MouseEvent event){
    Load();
  }
  public void starting2(MouseEvent event){ init();

  }

  private void Load() {
    list = new ArrayList<String>();
    String a = "301a";
    String b = "302a";
    String c = "303a";
    list.add(a);
    list.add(b);
    list.add(c);
    room.setItems(FXCollections.observableArrayList(list));
    room.show();
  }

  private void init() {
    list2 = new ArrayList<String>();
    String m = "HDMI";
    String z = "VGA";
    String v = "HDMI and VGA";
    String k = "none";
    list2.add(m);
    list2.add(z);
    list2.add(v);
    list2.add(k);
    dota.setItems(FXCollections.observableArrayList(list2));
    dota.show();
  }

}