package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class customerCancelOrderController implements Initializable {
	
	Controller contr = new Controller();
	
	@FXML
    private TextArea CancellationText;

    @FXML
    private TableColumn<Order, String> OrderDate;

    @FXML
    private TableColumn<Order, Integer> OrderID;

    @FXML
    private TextField OrderIDText;

    @FXML
    private TableView<Order> OrdersTable;

    @FXML
    private TableColumn<Order, String> Orderstatus;

    @FXML
    private TextField RestaurantNameText;

    @FXML
    private Button returnToPortal;

    @FXML
    private Button selectOrderButton;

    @FXML
    void selectOrdertoCancel(ActionEvent event) throws IOException {
    	
    	if (OrdersTable.getSelectionModel().getSelectedIndex() == -1)
    	{
    		Alert alertObj = new Alert(Alert.AlertType.WARNING);
    		alertObj.setHeaderText("There is no Order selected");
    		alertObj.setTitle("Warning");
    		alertObj.setContentText("Please select an Order before pressing the cancel Order button.");
    		alertObj.showAndWait();
    	}
    	
    	else
    	{
    		Order orderObj = OrdersTable.getSelectionModel().getSelectedItem();
			
			if (!orderObj.getOrderStatus().equals("new"))
			{
				Alert alertObj = new Alert(Alert.AlertType.WARNING);
	    		alertObj.setHeaderText("Correct Order not Selected");
	    		alertObj.setTitle("Warning");
	    		alertObj.setContentText("You can only cancel a new Order. Select Again.");
	    		alertObj.showAndWait();
			}
			
			contr.cancelOrder(orderObj);
    		
    		Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
        	alertObj.setHeaderText("SUCCESSFULL");
       		alertObj.setTitle("Successfull");
        	alertObj.setContentText("The selected Order has been cancelled!");
        	alertObj.showAndWait();
        		
       		Main m = new Main();
       		m.changeScene("CustomerPage.fxml");
    	}
    	
    	
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<Order> orderList = contr.getCustomerOrders();
		
		ObservableList<Order> data = FXCollections.observableArrayList(orderList);

		OrderDate.setCellValueFactory(new PropertyValueFactory<Order,String>("dateCreated"));
		Orderstatus.setCellValueFactory(new PropertyValueFactory<Order,String>("orderStatus"));
		OrderID.setCellValueFactory(new PropertyValueFactory<Order,Integer>("orderId"));


		OrdersTable.setItems(data);

	}
    
    
    @FXML
    void selectOrderSelect(ActionEvent event) {

    	Order orderObj = OrdersTable.getSelectionModel().getSelectedItem();
    	
    	ArrayList<Restaurant> allRestaurants = contr.getRestaurants();
    	
    	OrderIDText.setText(String.valueOf(orderObj.getOrderId()));
    	for (Restaurant obj : allRestaurants)
    	{
    		if (obj.getRestId() == orderObj.getRestId())
    		{
    			RestaurantNameText.setText(obj.getName());
    			break;
    		}
    	}
    	
    }

    @FXML
    void toCustomerPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("CustomerPage.fxml");
    }
}
