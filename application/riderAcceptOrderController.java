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

public class riderAcceptOrderController implements Initializable {
	
	Controller contr = new Controller();
	
	@FXML
    private TableColumn<orderRestaurantCustomer, String> OrderDate;

    @FXML
    private TableView<orderRestaurantCustomer> OrdersTable;

    @FXML
    private TableColumn<orderRestaurantCustomer, String> Orderstatus;

    @FXML
    private TableColumn<orderRestaurantCustomer, String> deliveryAddress;

    @FXML
    private TableColumn<orderRestaurantCustomer, Integer> orderID;
    
    @FXML
    private TableColumn<orderRestaurantCustomer, String> rest;

    @FXML
    private Button returnToPortal;

    @FXML
    private Button selectOrderButton;
    @FXML
    void selectOrdertoDeliver(ActionEvent event) throws IOException {
    	
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
    		orderRestaurantCustomer returnObj = OrdersTable.getSelectionModel().getSelectedItem();
			
			if (!returnObj.getOrderStatus().equals("prepared"))
			{
				Alert alertObj = new Alert(Alert.AlertType.WARNING);
	    		alertObj.setHeaderText("Correct Order not Selected");
	    		alertObj.setTitle("Warning");
	    		alertObj.setContentText("Please select a prepared Order.");
	    		alertObj.showAndWait();
			}
			else
			{
				ArrayList<Order> orderList = contr.getAllOrders();
				Order orderObj = new Order();
				
				for (Order obj : orderList)
				{
					if (obj.getOrderId() == returnObj.getOrderId())
					{
						orderObj = obj;
						break;
					}
				}
				
				contr.acceptOrderRider(orderObj);
    			
    			Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
        		alertObj.setHeaderText("SUCCESSFULL");
        		alertObj.setTitle("Successful");
        		alertObj.setContentText("The selected Order is successfully processed, and its status updated.");
        		alertObj.showAndWait();
        		
        		Main m = new Main();
        		m.changeScene("RiderAcceptOrder.fxml");
			}
    	}
    	
    	
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
		ArrayList<Order> orderList = contr.getAllOrders();
		ArrayList<Restaurant> restList = contr.getRestaurants();
		ArrayList<Customer> custList = contr.getCustomers();
		
		ArrayList<orderRestaurantCustomer> showList = new ArrayList<orderRestaurantCustomer>();
		
		for (Order obj : orderList)
		{
			String deliverAddress = "";
			String restName = "";
			
			for (Customer obj2 : custList)
			{
				if (obj.getCustId() == obj2.getCustId())
				{
					deliverAddress = obj2.getAddress();
					break;
				}
			}
			
			for (Restaurant obj2 : restList)
			{
				if (obj.getRestId() == obj2.getRestId())
				{
					restName = obj2.getName();
					break;
				}
			}

			orderRestaurantCustomer object = new orderRestaurantCustomer(obj.getOrderId(), obj.getDateCreated(), obj.getOrderStatus(), deliverAddress, restName);
			showList.add(object);
		}
		
		ObservableList<orderRestaurantCustomer> data = FXCollections.observableArrayList(showList);
		
		Orderstatus.setCellValueFactory(new PropertyValueFactory<orderRestaurantCustomer,String>("orderStatus"));
		orderID.setCellValueFactory(new PropertyValueFactory<orderRestaurantCustomer,Integer>("orderId"));
		OrderDate.setCellValueFactory(new PropertyValueFactory<orderRestaurantCustomer,String>("orderDate"));
		deliveryAddress.setCellValueFactory(new PropertyValueFactory<orderRestaurantCustomer,String>("deliverAddress"));
		rest.setCellValueFactory(new PropertyValueFactory<orderRestaurantCustomer,String>("rest"));
		
		OrdersTable.setItems(data);
		

	}

    @FXML
    void toRiderPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RiderPage.fxml");
    }
}
