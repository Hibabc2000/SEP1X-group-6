import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class HomeController implements EventHandler<ActionEvent>
{
    @FXML private TableView tableView;
    @FXML private TableColumn Week;
    @FXML private TableColumn Date;
    @FXML private TableColumn Course;
    @FXML private TableColumn NumStud;
    @FXML private TableColumn Type;
    @FXML private TableColumn Time;
    @FXML private TableColumn Room;
    @FXML private TableColumn Teacher;

    public HomeController()
    {
    }

    public void handle(ActionEvent actionEvent)
    {

    }
}
