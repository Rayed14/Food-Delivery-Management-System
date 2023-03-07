package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {
	@FXML
    private Button adminButton;

    @FXML
    private Button customerButton;

    @FXML
    private Button restaurantButton;

    @FXML
    private Button riderButton;

    @FXML
    void adminLoginPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("AdminLogin.fxml");
    }

    @FXML
    void customerLoginPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("CustomerLogin.fxml");
    }

    @FXML
    void restaurantLoginPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RestaurantLogin.fxml");
    }

    @FXML
    void riderLoginPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RiderLogin.fxml");
    }
}
