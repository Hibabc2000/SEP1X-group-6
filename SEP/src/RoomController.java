
import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.fxml.FXML;

    import javafx.scene.control.Button;
    import javafx.scene.control.ChoiceBox;
    import javafx.scene.control.TextField;
    import javafx.scene.input.MouseEvent;

    import java.util.ArrayList;

public class RoomController implements EventHandler<ActionEvent>
{/**
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

  public void Choice(ActionEvent e)
  {
    if(e.getSource() == room){}

  }
  public void starting(MouseEvent event){
    Load();
  }
  public void starting2(MouseEvent event){
     init();
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
    String v = "Saccharin";
    list2.add(m);
    list2.add(z);
    list2.add(v);
    dota.setItems(FXCollections.observableArrayList(list2));
    dota.show();
  }

  @Override public void handle(ActionEvent actionEvent)
  {
    //starting();
  }
}