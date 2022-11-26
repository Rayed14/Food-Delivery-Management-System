package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class customerCancelOrderController {
	 @FXML
	    private TableColumn<?, ?> OrderDate;

	    @FXML
	    private TableColumn<?, ?> OrderID;

	    @FXML
	    private TableView<?> OrdersTable;

	    @FXML
	    private TableColumn<?, ?> Orderstatus;

	    @FXML
	    private Button returnToPortal;

	    @FXML
	    private Button selectOrderButton;

	    @FXML
	    void selectOrdertoCancel(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("CustomerOrderCancellationForm.fxml");
	    }

	    @FXML
	    void toCustomerPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("CustomerPage.fxml");
	    }
}
