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
import java.time.LocalDate;

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
  @FXML private ComboBox<CoExaminer> cexmnr;
  @FXML private DatePicker dateBox;
  @FXML private TextArea alertBox;
  @FXML private ComboBox exmBox;
  @FXML private ComboBox sHour;
  @FXML private ComboBox sMinute;
  @FXML private ComboBox eHour;
  @FXML private ComboBox eMinute;
  private Scene scene;
  private Stage stage;
  private TeacherList teacherList;
  private CoExaminerList coExaminerList;
  private RoomList roomList;
  private CourseList courseList;
  private ExamList examList;
  private boolean updateCheck = false;
  private OurDate tmpDate;

  public void initialize()
      //**************
      throws IOException, ClassNotFoundException, NoSuchFieldException,
      IllegalAccessException
      //**************
  {
    exmtyp.getItems().addAll("Oral", "Written");
    for (int x0 = 0; x0 < 59; x0++)
    {
      sHour.getItems().add(x0);
      eHour.getItems().add(x0);
    }
    for (int x0 = 0; x0 < 23; x0++)
    {
      sMinute.getItems().add(x0);
      eMinute.getItems().add(x0);
    }
    //*******************
    teacherList = new TeacherList();
    coExaminerList = new CoExaminerList();
    roomList = new RoomList();
    courseList = new CourseList();
    examList = new ExamList();
    FileAdapter fileHandler = new FileAdapter(null);
    Object[] objs = fileHandler.temporaryRead("tempTeacher");
    for (Object obj:objs)
    {
      teacherList.addTeacher((Teacher) obj);
    }
    //tchr.setItems(FXCollections.observableArrayList(teacherList.getAllTeachers()));
    objs = fileHandler.temporaryRead("tempCoExaminer");
    for (Object obj:objs)
    {
      if(obj instanceof CoExaminer)
      {
        coExaminerList.addCoExaminer(obj);
      }
    }
    objs = fileHandler.temporaryRead("tempRoom");
    for (Object obj:objs)
    {
      if(obj instanceof Room)
      {
        roomList.addRoom((Room) obj);
      }
    }
    objs = fileHandler.temporaryRead("tempCourse");
    for (Object obj:objs)
    {
      courseList.addCourse((Course) obj);
    }

    objs = fileHandler.temporaryRead("tempRoom");
    for (Object obj:objs)
    {
      roomList.addRoom((Room) obj);
    }
    transferMessage(teacherList, "teacherList", "tchr");
    transferMessage(courseList, "courseList", "crs");
    transferMessage(roomList, "roomList", "roomC");
    transferMessage(coExaminerList, "coExaminerList", "cexmnr");

    //*******************
  }

  public AddUpdateController()
      throws IOException, ClassNotFoundException, NoSuchFieldException,
      IllegalAccessException
  {
/*
    teacherList = new TeacherList();
    coExaminerList = new CoExaminerList();
    roomList = new RoomList();
    courseList = new CourseList();
    examList = new ExamList();
    FileAdapter fileHandler = new FileAdapter(null);

    Object[] objs = fileHandler.temporaryRead("tempTeacher");
    for (Object obj : objs)
    {
      teacherList.addTeacher((Teacher) obj);
    }
    for (Object t : teacherList.getAllTeachers())
    {
      System.out.println(t);
    }
    objs = fileHandler.temporaryRead("tempCoExaminer");
    for (Object obj : objs)
    {
      if (obj instanceof Co_examiner)
      {
        coExaminerList.addCoExaminer(obj);
      }
    }
    objs = fileHandler.temporaryRead("tempRoom");
    for (Object obj : objs)
    {
      if (obj instanceof Room)
      {
        roomList.addRoom((Room) obj);
      }
    }

 */
  }

  @Override public void handle(ActionEvent actionEvent)
  {

    if (actionEvent.getSource() == updateB)
    {

      String str = "";
      alertBox.setText("");
      if(!updateCheck)
      {
        boolean isThereAnyConflict = false;
        if((exmtyp.getValue() != null)&&(crs.getValue() != null)&&(tchr.getValue() != null)&&(cexmnr.getValue() != null)&&(sMinute.getValue() != null)&&(sHour.getValue() != null)&&(eMinute.getValue() !=null)&&(eHour.getValue() != null))
        {
          LocalDate value = dateBox.getValue();
          if (value != null)
          {
            tmpDate = new OurDate(value.getDayOfMonth(), value.getMonthValue(),
                value.getYear(), (int) sHour.getValue(), (int) eHour.getValue(),
                (int) sMinute.getValue(), (int) eMinute.getValue());
          }
          Exam newExam = new Exam();
          newExam.scheduleExam((String) exmtyp.getValue(),(Course) crs.getSelectionModel().getSelectedItem(),(Teacher)tchr.getSelectionModel().getSelectedItem(),cexmnr.getSelectionModel().getSelectedItem(),tmpDate,(Room)roomC.getSelectionModel().getSelectedItem());
          if (examList.getAllExams().size() != 0)
          {
            for (int x0 = 0; x0 < examList.getAllExams().size(); x0++)
            {
              isThereAnyConflict = examList.getAllExams().get(x0).detectConflict(newExam);
              str = "the exam conflicts with " + examList.getAllExams().get(x0);
            }
          }
          if(!isThereAnyConflict)
          {
            examList.addExam(newExam);
          }
        }
        if(exmtyp == null)
        {
          str += "exam type not selected \n";
        }
        if(crs == null)
        {
          str += "Course is not selected\n";
        }
        if(tchr == null)
        {
          str += "Teacher is not selected\n";
        }
        if(cexmnr == null)
        {
          str += "Co-Examiner is not selected\n";
        }
        if(sHour == null)
        {
          str += "Starting Hour is not selected\n";
        }
        if(eMinute == null)
        {
          str += "Ending minute is not selected\n";
        }
        if(eHour == null)
        {
          str += "Ending hour is not selected\n";
        }
        if(sMinute == null)
        {
          str += "Starting minute is not selected\n";
        }
        alertBox.setText(str);
      }
      else
      {
        alertBox.setText("");
        boolean isThereAnyConflict = false;
        Exam tempExam =(Exam) exmBox.getSelectionModel().getSelectedItem();
        examList.deleteExam(exmBox.getSelectionModel().getSelectedIndex());
        if((exmtyp.getValue() != null)&&(crs.getValue() != null)&&(tchr.getValue() != null)&&(cexmnr.getValue() != null)&&(sMinute.getValue() != null)&&(sHour.getValue() != null)&&(eMinute.getValue() !=null)&&(eHour.getValue() != null))
        {
          LocalDate value = dateBox.getValue();
          if (value != null)
          {
            tmpDate = new OurDate(value.getDayOfMonth(), value.getMonthValue(),
                value.getYear(), (int) sHour.getValue(), (int) eHour.getValue(),
                (int) sMinute.getValue(), (int) eMinute.getValue());
          }
          tempExam.scheduleExam((String) exmtyp.getValue(),(Course) crs.getSelectionModel().getSelectedItem(),(Teacher)tchr.getSelectionModel().getSelectedItem(),cexmnr.getSelectionModel().getSelectedItem(),tmpDate,(Room)roomC.getSelectionModel().getSelectedItem());

          if (examList.getAllExams().size() != 0)
          {
            for (int x0 = 0; x0 < examList.getAllExams().size(); x0++)
            {
              isThereAnyConflict = examList.getAllExams().get(x0).detectConflict(tempExam);
              str = "the exam conflicts with " + examList.getAllExams().get(x0);
            }
          }
          if(!isThereAnyConflict)
          {
            examList.addExamAtIndex(exmBox.getSelectionModel().getSelectedIndex(),tempExam);
          }


        }
        updateCheck = false;
      }
      exmBox.setItems(FXCollections.observableArrayList(examList.getAllExams()));
    }
    if (actionEvent.getSource() == editB)
    {
      alertBox.setText("");
      if(exmBox.getValue() != null)
      {
        Exam upExam = (Exam)exmBox.getSelectionModel().getSelectedItem();
        updateCheck = true;
        exmtyp.setValue(upExam.getExamType());
        tchr.setValue(upExam.getTeacher());
        crs.setValue(upExam.getCourse());
        roomC.setValue(upExam.getRoom());
        cexmnr.setValue(upExam.getCoExaminer());
        sHour.setValue(upExam.getDate().getStartHour());
        eHour.setValue(upExam.getDate().getEndHour());
        eMinute.setValue(upExam.getDate().geteMinute());
        sMinute.setValue(upExam.getDate().getsMinute());
        dateBox.setValue(LocalDate.of(upExam.getDate().getYear(),upExam.getDate().getMonth(),upExam.getDate().getDay()));
      }

    }
    if (actionEvent.getSource() == deleteB)
    {
      alertBox.setText("");
      examList.deleteExam(exmBox.getSelectionModel().getSelectedIndex());
    }

    if (actionEvent.getSource() == homeButton)
    {
      try
      {
        changeScene("home.fxml", actionEvent, examList);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }

    if (actionEvent.getSource().equals(roomButton))
    {
      try
      {
        changeScene("Rooms.fxml", actionEvent, examList);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(teacherButton))
    {
      try
      {
        changeScene("Teacher.fxml", actionEvent, examList);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(coExaminerButton))
    {
      try
      {
        changeScene("Co-examiner.fxml", actionEvent, examList);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(courseButton))
    {
      try
      {
        changeScene("addUpdateCourse.fxml", actionEvent, examList);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(scheduleButton))
    {
      try
      {
        changeScene("addUpdateSchedule.fxml", actionEvent, examList);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
    if (actionEvent.getSource().equals(settingsButton))
    {
      try
      {
        changeScene("Settings.fxml", actionEvent, examList);
      }
      catch (IOException | NoSuchFieldException | IllegalAccessException e)
      {
        e.printStackTrace();
        System.exit(1);
      }
    }
  }

  private void changeScene(String target, ActionEvent event, ExamList examList)
      throws IOException, NoSuchFieldException, IllegalAccessException
  {
    /*
    if (target.equals("addUpdateSchedule.fxml"))
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
      fileHandler.temporaryWrite(examList, "tempExams");
      Parent parent = FXMLLoader.load(getClass().getResource(target));
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.getScene().setRoot(parent);
      stage.show();
    //}
  }

  /**
   * This method transfers an object to AddUpdateController, and loads it into its relevant ComboBox
   *
   * @param message - the object we want to pass as a message
   * @param name    - the name of the field in AddUpdateController
   * @param target  - the name of the ComboBox we want to set
   * @throws NoSuchFieldException   - method throws this exception if the target field does not exist.
   * @throws IllegalAccessException - method throws this exception if it does not have access to the target variable
   */
  public void transferMessage(Object message, String name, String target)
      throws NoSuchFieldException, IllegalAccessException
  {
    getClass().getDeclaredField(name).set(this, message);
    System.out.println(message);
    if (target.equals("tchr"))
    {
      if (tchr != null)
      {
        tchr.setItems(FXCollections.observableArrayList(teacherList.getAllTeachers()));
      }
      else
        System.out.println("TCHR is null");
    }
    if (target.equals("cexmnr"))
    {
      cexmnr.setItems(FXCollections.observableArrayList(coExaminerList.getAllCoExaminers()));
    }

    if (target.equals("crs"))
    {
      if (crs != null)
      {
        crs.setItems(FXCollections.observableArrayList(courseList.getAllCourses()));
      }
      else
        System.out.println("CRS is null");
    }
    if (target.equals("roomC"))
    {
      if (roomC != null)
      {
        roomC.setItems(FXCollections.observableArrayList(roomList.getAllRooms()));
      }
      else
        System.out.println("room is null");
    }
  }
}




