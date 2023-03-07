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

public class restaurantOrderPageController implements Initializable {
	
	Controller contr = new Controller();
	
	 @FXML
	    private TableColumn<Order, String> OrderDate;

	    @FXML
	    private TableView<Order> OrdersTable;

	    @FXML
	    private TableColumn<Order, String> Orderstatus;

	    @FXML
	    private TableColumn<Order, Integer> itemID;

	    @FXML
	    private Button returnToPortal;

	    @FXML
	    private Button selectOrderButton;

	    @FXML
	    void selectOrdertoProcess(ActionEvent event) throws IOException {
	    	
	    	if (OrdersTable.getSelectionModel().getSelectedIndex() == -1)
	    	{
	    		Alert alertObj = new Alert(Alert.AlertType.WARNING);
	    		alertObj.setHeaderText("There is no Order selected");
	    		alertObj.setTitle("Warning");
	    		alertObj.setContentText("Please select an Order before pressing the select Order button.");
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
    	    		alertObj.setContentText("Please select a new Order.");
    	    		alertObj.showAndWait();
    			}
    			else
    			{
    				contr.processOrderRestaurant(orderObj);
        			
        			Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
            		alertObj.setHeaderText("SUCCESSFULL");
            		alertObj.setTitle("Successful");
            		alertObj.setContentText("The selected Order is successfully processed, and its status updated.");
            		alertObj.showAndWait();
            		
            		Main m = new Main();
            		m.changeScene("RestaurantOrderPage.fxml");
    			}
    			
    			
    		}

	    }
	    
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			ArrayList<Order> orderList = contr.getOrders();
			
			ObservableList<Order> data = FXCollections.observableArrayList(orderList);

			OrderDate.setCellValueFactory(new PropertyValueFactory<Order,String>("dateCreated"));
			Orderstatus.setCellValueFactory(new PropertyValueFactory<Order,String>("orderStatus"));
			itemID.setCellValueFactory(new PropertyValueFactory<Order,Integer>("orderId"));


			OrdersTable.setItems(data);

		}

	    @FXML
	    void toRestaurantPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("RestaurantPage.fxml");
	    }
}
