package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class customerPlaceOrderController {
	@FXML
    private TableColumn<?, ?> RestaurantAddress;

    @FXML
    private TableColumn<?, ?> RestaurantContact;

    @FXML
    private TableColumn<?, ?> RestaurantID;

    @FXML
    private TableColumn<?, ?> RestaurantName;

    @FXML
    private TableView<?> RestaurantTable;

    @FXML
    private Button returnToPortal;

    @FXML
    private Button selectOrderButton;

    @FXML
    void selectOrdertoCancel(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("CustomerShowRestaurantMenu.fxml");
    }

    @FXML
    void toCustomerPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("CustomerPage.fxml");
    }
}
