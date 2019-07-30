
package gigabytesub;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jaski
 */
public class HomePageController implements Initializable {

    @FXML
    private Button addBtn;
    @FXML
    private Button viewBtn;

    
    @FXML
    private void changeRequest(ActionEvent event) throws Exception
    {
        if(event.getSource()==addBtn)
        {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("RegistrationPage.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setHeight(677);
            window.setWidth(920);
            window.setTitle("Register Page");
            window.setScene(tableViewScene);
            window.show();
        }
        else if(event.getSource()==viewBtn)
        {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("ViewPage.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setHeight(750);
            window.setWidth(925);
            window.setTitle("View Page");
            window.setScene(tableViewScene);
            window.show();

        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
