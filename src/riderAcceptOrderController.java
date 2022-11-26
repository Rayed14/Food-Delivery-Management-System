package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class riderAcceptOrderController {
	@FXML
    private TableColumn<?, ?> OrderDate;

    @FXML
    private TableView<?> OrdersTable;

    @FXML
    private TableColumn<?, ?> Orderstatus;

    @FXML
    private TableColumn<?, ?> deliveryAddress;

    @FXML
    private TableColumn<?, ?> orderID;

    @FXML
    private Button returnToPortal;

    @FXML
    private Button selectOrderButton;

    @FXML
    void selectOrdertoDeliver(ActionEvent event) {
    	
    }

    @FXML
    void toRiderPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RiderPage.fxml");
    }
}
