//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class Settings_Controller implements EventHandler<ActionEvent> {
  @FXML
  private Button homeButton;
  @FXML
  private Button roomButton;
  @FXML
  private Button teacherButton;
  @FXML
  private Button coExaminerButton;
  @FXML
  private Button courseButton;
  @FXML
  private Button scheduleButton;
  @FXML
  private Button settingsButton;
  @FXML
  private Button confirm;
  @FXML
  private DatePicker stDate;
  @FXML
  private DatePicker enDate;
  @FXML Button reset;
  private OurDate startDate;
  private OurDate endDate;
  private ArrayList<OurDate> dates;
  private boolean aaaa;

  public Settings_Controller()
  {
  }

  public void initialize() throws IOException, ClassNotFoundException {
    this.dates = new ArrayList();
    this.startDate = new OurDate(1, 1, 1);
    this.endDate = new OurDate(1, 1, 1);
    FileAdapter fileHandler = new FileAdapter((String)null);
    Object[] objs = fileHandler.temporaryRead("tempSEDates");
    if (objs.length != 0 && objs.length != 1) {
      OurDate tsd = (OurDate)objs[0];
      OurDate ted = (OurDate)objs[1];
      if (tsd.getYear() != 1 && ted.getYear() != 1) {
        this.startDate = tsd;
        this.endDate = ted;
        this.stDate.setValue(LocalDate.of(this.startDate.getYear(), this.startDate.getMonth(), this.startDate.getDay()));
        this.enDate.setValue(LocalDate.of(this.endDate.getYear(), this.endDate.getMonth(), this.endDate.getDay()));
        this.dates.add(0, this.startDate);
        this.dates.add(1, this.endDate);
        this.aaaa = true;
      }
    } else {
      this.aaaa = false;
    }

  }

  private void changeScene(String target, ActionEvent event, Object list) throws IOException {
    FileAdapter fileHandler = new FileAdapter((String)null);
    fileHandler.temporaryWrite(list, "tempSEDates");
    Parent parent = (Parent)FXMLLoader.load(this.getClass().getResource(target));
    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    stage.getScene().setRoot(parent);
    stage.show();
  }

  public void handle(ActionEvent actionEvent) {
    if (actionEvent.getSource() == this.confirm && this.enDate.getValue() != null && this.stDate.getValue() != null) {
      this.startDate = new OurDate(((LocalDate)this.stDate.getValue()).getDayOfMonth(), ((LocalDate)this.stDate.getValue()).getMonthValue(), ((LocalDate)this.stDate.getValue()).getYear());
      this.endDate = new OurDate(((LocalDate)this.enDate.getValue()).getDayOfMonth(), ((LocalDate)this.enDate.getValue()).getMonthValue(), ((LocalDate)this.enDate.getValue()).getYear());
      if (this.aaaa) {
        this.dates.remove(0);
        this.dates.remove(1);
      }

      this.dates.add(0, this.startDate);
      this.dates.add(1, this.endDate);
    }

    if (actionEvent.getSource() == this.homeButton) {
      try {
        this.changeScene("home.fxml", actionEvent, this.dates);
      } catch (IOException var9) {
        var9.printStackTrace();
        System.exit(1);
      }
    }

    if (actionEvent.getSource() == reset) {
      try
      {
        File file1 = new File("tempCoExaminer");
        File file2 = new File("tempCourse");
        File file3 = new File("tempExam");
        File file4 = new File("tempRoom");
        File file5 = new File("tempSEDates");
        File file6 = new File("tempTeacher");
        if (file1.delete()&&
        file2.delete()&&
        file3.delete()&&
        file4.delete()&&
        file5.delete()&&
        file6.delete())
        {
          System.out.println("delete successful");
        }
        this.changeScene("home.fxml", actionEvent, null);
      }
      catch (IOException var9) {
        var9.printStackTrace();
        System.exit(1);
      }
    }

    if (actionEvent.getSource().equals(this.roomButton)) {
      try {
        this.changeScene("Rooms.fxml", actionEvent, this.dates);
      } catch (IOException var8) {
        var8.printStackTrace();
        System.exit(1);
      }
    }

    if (actionEvent.getSource().equals(this.teacherButton)) {
      try {
        this.changeScene("Teacher.fxml", actionEvent, this.dates);
      } catch (IOException var7) {
        var7.printStackTrace();
        System.exit(1);
      }
    }

    if (actionEvent.getSource().equals(this.coExaminerButton)) {
      try {
        this.changeScene("Co-examiner.fxml", actionEvent, this.dates);
      } catch (IOException var6) {
        var6.printStackTrace();
        System.exit(1);
      }
    }

    if (actionEvent.getSource().equals(this.courseButton)) {
      try {
        this.changeScene("addUpdateCourse.fxml", actionEvent, this.dates);
      } catch (IOException var5) {
        var5.printStackTrace();
        System.exit(1);
      }
    }

    if (actionEvent.getSource().equals(this.scheduleButton)) {
      try {
        this.changeScene("addUpdateSchedule.fxml", actionEvent, this.dates);
      } catch (IOException var4) {
        var4.printStackTrace();
        System.exit(1);
      }
    }

    if (actionEvent.getSource().equals(this.settingsButton)) {
      try {
        this.changeScene("Settings.fxml", actionEvent, this.dates);
      } catch (IOException var3) {
        var3.printStackTrace();
        System.exit(1);
      }
    }

  }
}
