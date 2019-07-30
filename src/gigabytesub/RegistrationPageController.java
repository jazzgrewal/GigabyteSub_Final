
package gigabytesub;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author jaski
 */
public class RegistrationPageController implements Initializable {

    @FXML
    private AnchorPane submitDiv;
    @FXML
    private AnchorPane closeDiv;
    @FXML
    private Button subBtn;
    @FXML
    private Button closeBtn;
    
    
    @FXML
    private ComboBox<Plan> comboPlan;
    @FXML
    private TextField planNameText;
    @FXML
    private TextField planFeeText;
    @FXML
    private TextArea planDesctriptionText;
    
    //Database stuff
    DbConnector obj=new DbConnector();
    Connection conn=obj.ConnectDB();
    Statement stmtPlan,stmt1,stmtTrainer,stmtSchedule;
    ObservableList<Plan> tupleListPlan= FXCollections.observableArrayList();
    ObservableList<Trainer> tupleListTrainer= FXCollections.observableArrayList();
    ObservableList<Schedule> tupleListSchedule= FXCollections.observableArrayList();
    
    @FXML
    private TextField memFNameText;
    @FXML
    private TextField memLNameText;
    @FXML
    private TextField memIdText;
    @FXML
    private TextField memAddText;
    @FXML
    private TextField memCityText;
    @FXML
    private TextField memGovText;
    @FXML
    private TextField memGenText;
    @FXML
    private TextField memPhoneText;
    @FXML
    private TextField memMailText;
    @FXML
    private TextField memAgeText;
    @FXML
    private Label planWarn;
    
    
    @FXML
    private ComboBox<Trainer> comboTrainer;
    @FXML
    private TextField trainerFNameText;
    @FXML
    private TextField trainerLNameText;
    @FXML
    private TextField trainerFeeText;
    
    
    @FXML
    private TableView<Schedule> schedTable;
    @FXML
    private TableColumn<Schedule, String> schedIdCol;
    @FXML
    private TableColumn<Schedule, String> schedDayCol;
    @FXML
    private TableColumn<Schedule, String> schedSTimeCol;
    @FXML
    private TableColumn<Schedule, String> schedETimeCol;
    @FXML
    private TableColumn<Schedule, String> schedTrainerCol;
    
    
    

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void divClicked(ActionEvent event)
    {
        if(event.getSource()==subBtn)
        {
            System.out.println("Submit Div clicked");
        }
        else if(event.getSource()==closeBtn)
        {
            System.out.println("Close div clicked");
        }     
    }
    
        public void comboFillerPlan(){
             try
                {
                   // conn=obj.ConnectDB();
                    stmtPlan = conn.createStatement();
                    String sql;
                    sql = "SELECT * FROM plans";
                    ResultSet rs = stmtPlan.executeQuery(sql);
                 //STEP 5: Extract data from result set
                    while(rs.next()){
                        Plan pobj=new Plan(rs.getInt("PlanID"),rs.getString("PlanName"),rs.getInt("monthlyFee"),rs.getString("Description"));
                        tupleListPlan.add(pobj);
                    }
                    
                    comboPlan.setItems(tupleListPlan);
                    
                    
                    comboPlan.setConverter(new StringConverter<Plan>() {

                        @Override
                        public String toString(Plan object) {
                            return object.getPlanName();
                        }

                        @Override
                        public Plan fromString(String string) {
                            return comboPlan.getItems().stream().filter(ap -> 
                                ap.getPlanName().equals(string)).findFirst().orElse(null);
                        }
                    });
                    
                    //changing state code now
                    
                    comboPlan.valueProperty().addListener(new ChangeListener<Plan>(){
                        @Override
                            public void changed(ObservableValue observable, Plan oldValue, Plan newValue) {
                            planNameText.setText(newValue.getPlanName());
                            planFeeText.setText(Integer.toString(newValue.getMonthlyFee()));
                            planDesctriptionText.setText(newValue.getDescription());
                            subBtn.setDisable(false);
                            planWarn.setVisible(false);
                            
                        }
                        
                    });
                 //we wont close the conn connection
                }
                catch(Exception e)
                {
                System.out.print("Do not connect to DB - Error:"+e);
                }
     
    }
    
        public void comboFillerTrainer(){
             try
                {
                   // conn=obj.ConnectDB();
                    stmtTrainer = conn.createStatement();
                    String sql;
                    sql = "SELECT * FROM trainer";
                    ResultSet rs = stmtTrainer.executeQuery(sql);
                 //STEP 5: Extract data from result set
                    while(rs.next()){
                        Trainer tobj=new Trainer(rs.getInt("TrainerID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getInt("SessionFee"));
                        tupleListTrainer.add(tobj);
                    }
                    
                    comboTrainer.setItems(tupleListTrainer);
                    
                    
                    comboTrainer.setConverter(new StringConverter<Trainer>() {

                        @Override
                        public String toString(Trainer object) {
                            return object.getFirstName();
                        }

                        @Override
                        public Trainer fromString(String string) {
                            return comboTrainer.getItems().stream().filter(ap -> 
                                ap.getFirstName().equals(string)).findFirst().orElse(null);
                        }
                    });
                    
                    //changing state code now
                    
                    comboTrainer.valueProperty().addListener(new ChangeListener<Trainer>(){
                        @Override
                            public void changed(ObservableValue observable, Trainer oldValue, Trainer newValue) {
                            trainerFNameText.setText(newValue.getFirstName());
                            trainerLNameText.setText(newValue.getLastName());
                            trainerFeeText.setText(Integer.toString(newValue.getSessionFee()));
                            tupleListSchedule.clear();
                            schedTableLoader(newValue.getTrainerID());
                            subBtn.setDisable(false);
                            planWarn.setVisible(false);
                            
                        }
                        
                    });

                    
                
                 //we wont close the conn connection
                }
                catch(Exception e)
                {
                System.out.print("Do not connect to DB - Error:"+e);
                }
     
    }
        
        public void schedTableLoader(int trainID)
        {
            try
            {
                  stmtSchedule = conn.createStatement();
                    String sql;
                    sql = "SELECT * FROM schedule Where TrainerID = "+trainID ;
                    ResultSet rs = stmtSchedule.executeQuery(sql);
                 //STEP 5: Extract data from result set
                    while(rs.next()){
                        Schedule tobj=new Schedule(rs.getInt("ScheduleID"),rs.getString("Day"),rs.getString("StartTime"),rs.getString("EndTime"),rs.getInt("TrainerID"));
                        tupleListSchedule.add(tobj);
                    }
                    
                    schedTrainerCol.setCellValueFactory(new PropertyValueFactory<>("TrainerID"));
                    schedDayCol.setCellValueFactory(new PropertyValueFactory<>("Day"));
                    schedSTimeCol.setCellValueFactory(new PropertyValueFactory<>("StartTime"));
                    schedETimeCol.setCellValueFactory(new PropertyValueFactory<>("EndTime"));
                    
                    
                    
                    schedTable.setItems(tupleListSchedule);
                    
                    
            }
            
            catch (Exception e)
            {
                System.out.println("DB Error"+e);
            }
        }
        
    @FXML
    public void submitForm(ActionEvent e) throws SQLException
    {
        stmt1 = conn.createStatement();
            String fNameText=memFNameText.getText();
            String lNameText=memLNameText.getText();
            String idText=memIdText.getText();
            String addText=memAddText.getText();
            String cityText=memCityText.getText();
            String govText=memGovText.getText();
            String genText=memGenText.getText();
            String phoneText=memPhoneText.getText();
            String mailText=memMailText.getText();
            String ageText=memAgeText.getText();
            //String planText="101";
            boolean comboPlanStateEmpty=comboPlan.getSelectionModel().isEmpty();
            boolean comboTrainerStateEmpty=comboTrainer.getSelectionModel().isEmpty();
            if(comboPlanStateEmpty || comboTrainerStateEmpty)
            {
                planWarn.setVisible(true);
                subBtn.setDisable(true);
            }
            
            else
            {
                int planText=comboPlan.getSelectionModel().getSelectedItem().getPlanID();
                int trainerText=comboTrainer.getSelectionModel().getSelectedItem().getTrainerID();         
                String sql2;
                sql2 = "INSERT INTO `customers` (`MemberID`, `FirstName`, `LastName`, `Address`, `City`, `Govt.ID`, `Gender`, `Phone`, `Email`, `Age`, `PlanID`, `TrainerID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

                PreparedStatement prpstmt=conn.prepareStatement(sql2);
                prpstmt.setInt(1, Integer.parseInt(idText));
                prpstmt.setString(2, fNameText);
                prpstmt.setString(3, lNameText);
                prpstmt.setString(4, addText);
                prpstmt.setString(5, cityText);
                prpstmt.setInt(6, 12345698);
                prpstmt.setString(7, genText);
                prpstmt.setString(8, phoneText);
                prpstmt.setString(9, mailText);
                prpstmt.setInt(10, Integer.parseInt(ageText));
                prpstmt.setInt(11, planText);
                prpstmt.setInt(12, trainerText);

                prpstmt.execute();
            }
           
            System.out.println("done updation");
            //to update the table eveery time we click submit
            
        }
    
    @FXML
    private void changeRequest(ActionEvent event) throws Exception
    {
        
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setHeight(555);
            window.setWidth(870);
            window.setTitle("Home Page");
            window.setScene(tableViewScene);
            window.show();
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboFillerPlan();
        comboFillerTrainer();
    }    
    
}
