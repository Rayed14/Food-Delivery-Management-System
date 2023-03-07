package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class adminPortalController {
	
	@FXML
    private Button logoutButt;

	@FXML
    private Button authResButton;
	
    @FXML
    private Button authRidButton;

    @FXML
    void selectRestaurant(ActionEvent event) throws IOException {

    	Main m = new Main();
		m.changeScene("authorizeRestaurant.fxml");
    	
    }
    
    @FXML
    void selectRider(ActionEvent event) throws IOException {

    	Main m = new Main();
		m.changeScene("authorizeRider.fxml");
    	
    }
    
    @FXML
    void logoutAct(ActionEvent event) throws IOException {

    	Main m = new Main();
		m.changeScene("Home.fxml");
    	
    }
	
}
