
package gigabytesub;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jaski
 */
public class ViewPageController implements Initializable {

    
    //The first paramaeter within the TableView<> is the type of genric table, and the second parameter is the datatype of the values in each cell
    @FXML
    private TableView<Member> memberTable;
    @FXML
    private TableColumn<Member, String> memberIDCol;
    @FXML
    private TableColumn<Member, String> memberFNameCol;
    @FXML
    private TableColumn<Member, String> memberLNameCol;
    @FXML
    private TableColumn<Member, String> memberAddCol;
    @FXML
    private TableColumn<Member, String> memberPhoneID;
    @FXML
    private TableColumn<Member, String> memberEmailCol;
    @FXML
    private TextField viewMemberText;
    
    // ObservableList is the list of objects of individual data types, that is the Member,Plan or Trainer class whis is pushed to tables in the FXML file
    ObservableList<Member> tupleListMember= FXCollections.observableArrayList();
    ObservableList<Member> tupleListDetails= FXCollections.observableArrayList();
    ObservableList<Plan> tupleListPlan= FXCollections.observableArrayList();
    ObservableList<Trainer> tupleListTrainer= FXCollections.observableArrayList();
    ObservableList<Member> tupleListDelete= FXCollections.observableArrayList();
    //databease variables
     //Create a function of the DBConnector class
    DbConnector obj=new DbConnector();
    // the COnnectDB() of the DBConnector class returns the connection to the SQL server
    Connection conn=obj.ConnectDB();
    //this is a general varible defined for most of the SQL queries used in the class, this is to avoid creation of new variables
    Statement stmtMemberTable;
    
    @FXML
    private Button idSearchSubmit;
    @FXML
    private TableView<Member> detailsTable;
    @FXML
    private TableColumn<Member, String> detailsFName;
    @FXML
    private TableColumn<Member, String> detailsLName;
    @FXML
    private TableColumn<Member, String> detailsAddress;
    @FXML
    private TableColumn<Member, String> detailsPhone;
    @FXML
    private TableColumn<Member, String> detailsEmail;
    @FXML
    private TextField idSearchText;
    @FXML
    private Label mainText;
    @FXML
    private TableView<Plan> planTable;
    @FXML
    private TableColumn<Plan, String> planIdCol;
    @FXML
    private TableColumn<Plan, String> planNameCol;
    @FXML
    private TableColumn<Plan, String> planFeeCol;
    @FXML
    private TableView<Trainer> trainerTable;
    @FXML
    private TableColumn<Trainer, String> trainerIdCol;
    @FXML
    private TableColumn<Trainer, String> trainerNameCol;
    @FXML
    private TableColumn<Trainer, String> trainerFeeCol;
    @FXML
    private TableColumn<Member, String> delIdCol;
    @FXML
    private TableColumn<Member, String> delFNameCol;
    @FXML
    private TableColumn<Member, String> delLNameCol;
    @FXML
    private TableColumn<Member, String> delAddCol;
    @FXML
    private TableColumn<Member, String> delPhoneCol;
    @FXML
    private TableColumn<Member, String> delEmailCol;
    @FXML
    private TextField deleteIDText;
    @FXML
    private Button delSubmit;
    @FXML
    private TableView<Member> delTable;
    @FXML
    private Button closeBtn;

    
    
     public void memberTableLoader(String name)
    {
        tupleListMember.clear();
          try
            {
                  stmtMemberTable = conn.createStatement();
                  
                    String sql;
                    sql = "SELECT * FROM customers Where `FirstName` = '"+name+"'" + " OR `LastName`= '"+name+"'" + " OR `MemberID`= '"+name+"'" ;
                    ResultSet rs = stmtMemberTable.executeQuery(sql);
                 //STEP 5: Extract data from result set
                    while(rs.next()){
                        Member tobj=new Member(rs.getInt("MemberID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Address"),rs.getString("City"),rs.getInt("Govt.ID"),rs.getString("Gender"),rs.getInt("Phone"),rs.getString("Email"),rs.getInt("Age"),rs.getInt("PlanID"),rs.getInt("TrainerID"));
                        tupleListMember.add(tobj);
                    }
                    
                    memberIDCol.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
                    memberFNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
                    memberLNameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
                    memberAddCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
                    memberPhoneID.setCellValueFactory(new PropertyValueFactory<>("Phone"));
                    memberEmailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
                   
                     if(tupleListMember.size()== 0)
                    {
                        mainText.setText("Sorry No Member Found");
                        
                    }
                    else
                    {
                        mainText.setText("Sucessfully Loaded Data");
                    }
                    memberTable.setItems(tupleListMember);
                    
                    
            }
            
            catch (Exception e)
            {
                System.out.println("DB Error"+e);
            }
        
    }
    
    public void detailsLoader(String memberId)
    {
        tupleListDetails.clear();
          try
            {
                  stmtMemberTable = conn.createStatement();
                  
                    String sql;
                    sql = "SELECT * FROM customers Where `MemberID`= '"+memberId+"'" ;
                    ResultSet rs = stmtMemberTable.executeQuery(sql);
                 //STEP 5: Extract data from result set
                    while(rs.next()){
                        Member tobj=new Member(rs.getInt("MemberID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Address"),rs.getString("City"),rs.getInt("Govt.ID"),rs.getString("Gender"),rs.getInt("Phone"),rs.getString("Email"),rs.getInt("Age"),rs.getInt("PlanID"),rs.getInt("TrainerID"));
                        tupleListDetails.add(tobj);
                    }
                    
                    
                    detailsFName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
                    detailsLName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
                    detailsAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
                    detailsPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
                    detailsEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
                    
                    if(tupleListDetails.size()== 0)
                    {
                        mainText.setText("Sorry No Member Found");
                        
                    }
                    else
                    {
                        mainText.setText("Sucessfully Loaded Data");
                    }
                    
                    detailsTable.setItems(tupleListDetails);
                    
                    
            }
            
            catch (Exception e)
            {
                System.out.println("DB Error:"+e);
            }
        
    }
    
    public void planLoader(String planId)
    {
        tupleListPlan.clear();
          try
            {
                  stmtMemberTable = conn.createStatement();
                  
                    String sql;
                    sql = "SELECT * FROM plans Where `PlanID` = '"+planId+"'" ;
                    ResultSet rs = stmtMemberTable.executeQuery(sql);
                 //STEP 5: Extract data from result set
                    while(rs.next()){
                        Plan pobj=new Plan(rs.getInt("PlanID"),rs.getString("PlanName"),rs.getInt("monthlyFee"),rs.getString("Description"));
                        tupleListPlan.add(pobj);
                    }
                    
                    planIdCol.setCellValueFactory(new PropertyValueFactory<>("PlanID"));
                    planNameCol.setCellValueFactory(new PropertyValueFactory<>("PlanName"));
                    planFeeCol.setCellValueFactory(new PropertyValueFactory<>("MonthlyFee"));
                    
                    planTable.setItems(tupleListPlan);
            }
            
            catch (Exception e)
            {
                System.out.println("DB Error:"+e);
            }
    }
    
     public void trainerLoader(String trainerId)
    {
        tupleListTrainer.clear();
          try
            {
                  stmtMemberTable = conn.createStatement();
                  
                    String sql;
                    sql = "SELECT * FROM trainer Where `TrainerID` = '"+trainerId+"'" ;
                    ResultSet rs = stmtMemberTable.executeQuery(sql);
                 //STEP 5: Extract data from result set
                    while(rs.next()){
                        Trainer tobj=new Trainer(rs.getInt("TrainerID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getInt("SessionFee"));
                        tupleListTrainer.add(tobj);
                    }
                    
                    trainerIdCol.setCellValueFactory(new PropertyValueFactory<>("TrainerID"));
                    trainerNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
                    trainerFeeCol.setCellValueFactory(new PropertyValueFactory<>("SessionFee"));
                    
                    trainerTable.setItems(tupleListTrainer);
            }
            
            catch (Exception e)
            {
                System.out.println("DB Error:"+e);
            }
    }
    //this function refreshes all the data in the Accordion, which is planLoader, trainerLoader
    @FXML
    public void triggerDetails()
    {
        String memberId=idSearchText.getText();
        detailsLoader(memberId);
        String planID=Integer.toString(tupleListDetails.get(0).getPlanID());
        String trainerID=Integer.toString(tupleListDetails.get(0).getTrainerID());
        // planLoader here is called to get the new data, i.e. plan details of the ID that the user just entered
        planLoader(planID);
        //trainerLoader here is called to get the  new data, i.e. the trainer information for the ID user just entered
        trainerLoader(trainerID);
        
    }
    //this function listens for event changes in the search text box, and calls the loader function everytime it detects a change.
    public void tableChanger()
    {
        viewMemberText.textProperty().addListener((observable, oldValue, newValue) -> {
            
            memberTableLoader(newValue);
        });
       
                       
    }
    
    public void delTableLoader()
    {
        tupleListDelete.clear();
          try
            {
                  stmtMemberTable = conn.createStatement();
                  
                    String sql;
                    sql = "SELECT * FROM customers" ;
                    ResultSet rs = stmtMemberTable.executeQuery(sql);
                 //STEP 5: Extract data from result set
                    while(rs.next()){
                        Member tobj=new Member(rs.getInt("MemberID"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Address"),rs.getString("City"),rs.getInt("Govt.ID"),rs.getString("Gender"),rs.getInt("Phone"),rs.getString("Email"),rs.getInt("Age"),rs.getInt("PlanID"),rs.getInt("TrainerID"));
                        tupleListDelete.add(tobj);
                    }
                    
                    delIdCol.setCellValueFactory(new PropertyValueFactory<>("MemberID"));
                    delFNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
                    delLNameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
                    delAddCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
                    delPhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));
                    delEmailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
                   
                    
                    
                    delTable.setItems(tupleListDelete);
                    
                    
            }
            
            catch (Exception e)
            {
                System.out.println("DB Error"+e);
            }
    }
    
    public void deleteMember(String id)
    {
         try
            {
                  stmtMemberTable = conn.createStatement();
                  
                    String sql;
                    sql = "DELETE FROM customers Where `MemberID`= '"+id+"'" ;
                    //we use Prapared statemenmts for update actions like DELETE or INSERT
                    PreparedStatement prpstmt=conn.prepareStatement(sql);
                    prpstmt.execute();
                    System.out.println("Sucess");
                    delTableLoader();  
                    
            }
            
            catch (Exception e)
            {
                System.out.println("DB Error:"+e);
            }
     
    }
    @FXML
    public void deleteMemberSubmit()
    {
        deleteMember(deleteIDText.getText());
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        memberTableLoader(" ");
        //detailsLoader("10001");
        //the tableChanger() is initially loaded to detect or listen for event changes in the view textbox, to display result as  the user hits a value
        tableChanger();
        //Initially loading the Delete Table to get data from db and add in the delete table
        delTableLoader();
       // planLoader(" ");
        //trainerLoader(" ");
    }    
    
}
