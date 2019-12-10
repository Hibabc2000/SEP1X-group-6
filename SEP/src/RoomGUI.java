import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;

public class RoomGUI extends Application
{ /**
 *@author Oliver Isaac, 293131
 *@version 1.0.0.0
 *this class is just a GUI for the Room part
 */
  public void start(Stage window) throws IOException
  {
    window.setTitle("Room");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("Rooms.fxml"));
    Scene scene = new Scene(loader.load());
    window.setScene(scene);
    window.show();







  }
}