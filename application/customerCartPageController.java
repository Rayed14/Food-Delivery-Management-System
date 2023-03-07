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

public class customerCartPageController implements Initializable  {
	
	Controller contr = new Controller();
	
	 @FXML
	    private Button ConfirmOrderButoon;

	    @FXML
	    private TableColumn<FoodItem, String> FoodItemDescription;

	    @FXML
	    private TableColumn<FoodItem, Integer> FoodItemID;

	    @FXML
	    private TableColumn<FoodItem, String> FoodItemName;

	    @FXML
	    private TableColumn<FoodItem, Double> FoodItemPrice;

	    @FXML
	    private TableView<FoodItem> OrderedItemsTable;

	    @FXML
	    private Button returnToMenu;

	    @FXML
	    void ConfirmOrderandGotoPortal(ActionEvent event) throws IOException {
	    	
	    	contr.setOrder();
	    	
	    	contr.emptyCart();
	    	
	    	Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
	    	alertObj.setHeaderText("ORDER SUCCESSFULL");
	   		alertObj.setTitle("Order Placed");
	    	alertObj.setContentText("Order has been Placed!");
	    	alertObj.showAndWait();
	    	
	    	Main m = new Main();
	    	m.changeScene("CustomerPage.fxml");
	    }
	    
	    
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
	    	
	    	ArrayList<FoodItem> customerFoodList = contr.getCustomerFoodList();
	    	
			ObservableList<FoodItem> data = FXCollections.observableArrayList(customerFoodList);

			FoodItemName.setCellValueFactory(new PropertyValueFactory<FoodItem,String>("foodName"));
			FoodItemPrice.setCellValueFactory(new PropertyValueFactory<FoodItem,Double>("price"));
			FoodItemID.setCellValueFactory(new PropertyValueFactory<FoodItem,Integer>("itemId"));
			FoodItemDescription.setCellValueFactory(new PropertyValueFactory<FoodItem,String>("details"));

			OrderedItemsTable.setItems(data);

		}

	    @FXML
	    void toMenuPage(ActionEvent event) throws IOException {
	    	Main m = new Main();
	    	m.changeScene("CustomerShowRestaurantMenu.fxml");
	    }
}
