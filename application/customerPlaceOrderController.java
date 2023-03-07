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

public class customerPlaceOrderController implements Initializable {
	
	Controller contr = new Controller();
	
	@FXML
    private TableColumn<Restaurant, String> RestaurantAddress;

    @FXML
    private TableColumn<Restaurant, String> RestaurantContact;

    @FXML
    private TableColumn<Restaurant, Integer> RestaurantID;

    @FXML
    private TableColumn<Restaurant, String> RestaurantName;

    @FXML
    private TableView<Restaurant> RestaurantTable;

    @FXML
    private Button returnToPortal;

    @FXML
    private Button selectOrderButton;

    @FXML
    void selectOrdertoCancel(ActionEvent event) throws IOException {
    	
    	if (RestaurantTable.getSelectionModel().getSelectedIndex() == -1)
    	{
    		Alert alertObj = new Alert(Alert.AlertType.WARNING);
    		alertObj.setHeaderText("There is no Restaurantselected");
    		alertObj.setTitle("Warning");
    		alertObj.setContentText("Please select a Restaurant before pressing the select button.");
    		alertObj.showAndWait();
    	}
    	else
    	{
    		Restaurant selectedRest = RestaurantTable.getSelectionModel().getSelectedItem();

    		
    		contr.setCurrentRestaurant(selectedRest);
    		System.out.println(selectedRest.getRestId());

    		Main m = new Main();
        	m.changeScene("CustomerShowRestaurantMenu.fxml");
    	}
    	
    	
    }
    
    
    @Override
  	public void initialize(URL arg0, ResourceBundle arg1) {
      	
      	ArrayList<Restaurant> restList = contr.getRestaurants();
  		
  		ObservableList<Restaurant> data = FXCollections.observableArrayList(restList);

  		RestaurantAddress.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("address"));
  		RestaurantContact.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("phNumber"));
  		RestaurantID.setCellValueFactory(new PropertyValueFactory<Restaurant,Integer>("restId"));
  		RestaurantName.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("name"));

  		RestaurantTable.setItems(data);

  	}
    

    @FXML
    void toCustomerPage(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("CustomerPage.fxml");
    }
}
