package application;

import java.util.Scanner;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import BusinessLogic.*;


public class authorizeRestaurantController implements Initializable{
	
	Controller contr = new Controller();
	
	@FXML
    private Button backButton;

	@FXML
    private TableColumn<Restaurant, String> addCol;

    @FXML
    private TableColumn<Restaurant, Integer> idCol;

    @FXML
    private TableColumn<Restaurant, String> nameCol;

    @FXML
    private TableColumn<Restaurant, String> emailCol;
    
    @FXML
    private Button authButton;
    
    @FXML
    private TableView<Restaurant> restaurantTable;
    
    @FXML
    void authAct(ActionEvent event) throws IOException {
    	
    	if (restaurantTable.getSelectionModel().getSelectedIndex() == -1)
    	{
    		Alert alertObj = new Alert(Alert.AlertType.WARNING);
    		alertObj.setHeaderText("There is no Restaurant selected");
    		alertObj.setTitle("Warning");
    		alertObj.setContentText("Please select a Restuarant before pressing the authorize button.");
    		alertObj.showAndWait();
    	}
    	else
    	{
    		Restaurant restObj = restaurantTable.getSelectionModel().getSelectedItem();
    		contr.authorizeRestaurant(restObj);
    		
    		Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
    		alertObj.setHeaderText("SUCCESSFULL");
    		alertObj.setTitle("Successfull");
    		alertObj.setContentText("The selected Restaurant has been successfully authorized!");
    		alertObj.showAndWait();
    		
    		Main m = new Main();
    		m.changeScene("authorizeRestaurant.fxml");
    	}

    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<Restaurant> restList = contr.selectRestaurant();
		ArrayList<Restaurant> listToShow = new ArrayList<>();
		
		for (Restaurant obj : restList)
		{
			if (obj.getAuthorize().equals("no"))
				listToShow.add(obj);
		}
		
		ObservableList<Restaurant> data = FXCollections.observableArrayList(listToShow);
		
		idCol.setCellValueFactory(new PropertyValueFactory<Restaurant,Integer>("restId"));
		nameCol.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("name"));
		addCol.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("address"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("email"));
		
		restaurantTable.setItems(data);

	}
    
    
    @FXML
    void backAck(ActionEvent event) throws IOException {
    	
    	Main m = new Main();
		m.changeScene("adminPortal.fxml");

    }
    
    
	
}
