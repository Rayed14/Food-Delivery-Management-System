package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class riderPageController {

    @FXML
    private Button logoutButton;

    @FXML
    private Button viewOrderButton;
    
    @FXML
    private Button viewYourOrders;
    
    @FXML
    void RiderOrderPage(ActionEvent event) throws IOException {

    	Main m = new Main();
    	m.changeScene("RiderViewOrders.fxml");
    	
    }

    @FXML
    void AcceptOrderPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RiderAcceptOrder.fxml");
    }

    @FXML
    void goBacktoHome(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("Home.fxml");
    }
}
