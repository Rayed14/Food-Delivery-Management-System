package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class customerCancelOrderFormController {
	@FXML
    private TextArea CancellationDescription;

    @FXML
    private TextField OrderID;

    @FXML
    private TextField RestaurantName;

    @FXML
    private Button SubmitFormButton;

    @FXML
    private Button toPortalButton;

    @FXML
    private Label warning;

    @FXML
    void CancelOrder(ActionEvent event) throws IOException {
    	
    	Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
    	alertObj.setHeaderText("SUCCESSFULL");
   		alertObj.setTitle("Successfull");
    	alertObj.setContentText("The selected Order has been cancelled!");
    	alertObj.showAndWait();
    		
   		Main m = new Main();
   		m.changeScene("CustomerCancelOrder.fxml");
    }

    @FXML
    void toCustomerPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("CustomerPage.fxml");
    }
}
