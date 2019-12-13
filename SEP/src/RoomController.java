import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    rooms = new ArrayList();
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
    Parent parent = FXMLLoader.load(getClass().getResource(target));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.getScene().setRoot(parent);
    stage.show();
  }

  /**
   * @author Oliver Isaac, 293131
   * @version 1.5.6.1
   * this class is just a conTROLLer class for my Room UI.
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
  private ArrayList rooms;
  @FXML private Label dotaError;
  @FXML private Label seatError;
  @FXML private Label numberError;

  public void update(ActionEvent e)
  { // UPDATE BUTTON
    if (e.getSource() == update)
    { boolean ready1=true;
      boolean ready2=true;
      boolean ready3=true;
      Room temp = new Room();
      temp.setRoomNumber(text1.getText());
      int sit;

      try
      {
        String pro = (String) dota.getValue();
        if (pro.equals("HDMI"))
        {
          temp.setProjector((byte) 1); dotaError.setText("");ready1=true;
          System.out.println(pro);
        }
        else if (pro.equals("VGA"))
        {
          temp.setProjector((byte) 2);dotaError.setText("");ready1=true;
        }
        else if (pro.contains("and"))
        {
          temp.setProjector((byte) 3);dotaError.setText("");ready1=true;
        }
        else if (pro.equals("none"))
        {
          temp.setProjector((byte) 0);dotaError.setText("");ready1=true;
        }
        else
        {temp.setProjector((byte) -1); dotaError.setText("Choose a dotation");ready1=false;
          System.out.println(pro);}




      }
      catch (NullPointerException n)
      {dotaError.setText("Choose a dotation");ready1=false;}





      if (text1.getText().length() == 0)
      {
        numberError.setText("Enter the room number"); ready2=false;
      }
      else if (text1.getText().length()>0){numberError.setText("");temp.setRoomNumber(text1.getText());ready2=true;}
      if (text2.getText().length() == 0)
      {
        seatError.setText("Enter the number of seats");ready3=false;
      }


      else if (text2.getText().length() >0)
      {
        try
        {
          sit = Integer.parseInt(text2.getText());
          temp.setNumberOfSeats(sit);
          seatError.setText("");
          ready3=true;
          //Catches all NumberFormatExceptions
        }
        catch (NumberFormatException l)
        {
          seatError.setText("Invalid number of students");
          ready3=false;
        }

      } else {seatError.setText(""); ready3=true; sit = Integer.parseInt(text2.getText());
        temp.setNumberOfSeats(sit);}
      System.out.println(ready1);
      System.out.println(ready2);
      System.out.println(ready3);


      if (ready1==true && ready2==true && ready3==true) {boolean  ready4=false;
        if (rooms.size() > 0) {
          for(int p =0; p<rooms.size();p++)
          {
            if ( text1.getText().equals(((Room) rooms.get(p)).getRoomNumber()))
            { ready4 = true;
              dotaError.setText("");
              seatError.setText("");
              numberError.setText("");
              int choice1 = JOptionPane.showConfirmDialog(null,
                  "Are you sure you want to change the information about this room?");
              if (choice1 == JOptionPane.YES_OPTION)
              {
                rooms.set(p, temp);
                System.out.println(temp);
                dota.setValue(null);
                text1.setText("");
                text2.setText("");

              }
              else if (choice1 == JOptionPane.NO_OPTION)
              {
              }}
          } if(ready4==false) {dotaError.setText("");
            seatError.setText("");
            numberError.setText("");
            int choice2 = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to update the room?");
            if (choice2 == JOptionPane.YES_OPTION)
            {
              rooms.add(temp);
              System.out.println(temp);
              dota.setValue(null);
              text1.setText("");
              text2.setText("");

            }
            else if (choice2 == JOptionPane.NO_OPTION)
            {
            }}



        }
        else
        {
          dotaError.setText("");
          seatError.setText("");
          numberError.setText("");
          int choice = JOptionPane.showConfirmDialog(null,
              "Are you sure you want to update the room?");
          if (choice == JOptionPane.YES_OPTION)
          {
            rooms.add(temp);
            System.out.println(temp);
            dota.setValue(null);
            text1.setText("");
            text2.setText("");

          }
          else if (choice == JOptionPane.NO_OPTION)
          {
          }
        }

      }
    }






    // DELETE BUTTON
    if (e.getSource() == delete)
    {
      String temp = (String) room.getValue();

      for (int i = 0; i < rooms.size(); i++)
      {
        if (((Room) rooms.get(i)).getRoomNumber().equals(temp))
        {
          int choice = JOptionPane.showConfirmDialog(null,
              "Are you sure you want to delete this room?");
          if (choice == JOptionPane.YES_OPTION)
          {
            rooms.remove(i);
            text1.setText(""); text2.setText("");

          }
          else if (choice == JOptionPane.NO_OPTION)
          {
          }












        }
      }

    }
    // EDIT BUTTON
    if (e.getSource() == edit)
    {
      String choice = (String) room.getValue();

      for (int i = 0; i < rooms.size(); i++)
      {
        if (((Room)rooms.get(i)).getRoomNumber().equals(choice))
        {
          text1.setText(((Room)rooms.get(i)).getRoomNumber());
          text2.setText(Integer.toString(((Room)rooms.get(i)).getNumberOfSeats()));
          if (((Room)rooms.get(i)).getProjector() == 0)
          {
            dota.setValue("none");
          }
          else if (((Room)rooms.get(i)).getProjector() == 1)
          {
            dota.setValue("HDMI");
          }
          else if (((Room)rooms.get(i)).getProjector() == 2)
          {
            dota.setValue("VGA");
          }
          else if (((Room)rooms.get(i)).getProjector() == 3)
          {
            dota.setValue("HDMI and VGA");
          }
          else if (((Room)rooms.get(i)).getProjector() == -1)
          {
            System.out.println("error");
          }
        }

      }
    }
  }


  public void starting(MouseEvent event)
  {
    Load();
  }

  public void starting2(MouseEvent event)
  {
    init();

  }

  private void Load()
  {
    list = new ArrayList<String>();
    for(int i =0; i<rooms.size();i++)
    {
      list.add(((Room)rooms.get(i)).getRoomNumber());
    }


    room.setItems(FXCollections.observableArrayList(list));

    room.show();
  }

  private void init()
  {
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