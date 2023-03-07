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


public class authorizeRiderController implements Initializable{
	
	Controller contr = new Controller();
	
	@FXML
    private Button goBackButt;

	@FXML
    private TableColumn<Rider, Integer> liscCol;

    @FXML
    private TableColumn<Rider, Integer> idCol;

    @FXML
    private TableColumn<Rider, String> nameCol;

    @FXML
    private TableColumn<Rider, String> emailCol;
    
    @FXML
    private Button authButton;
    
    @FXML
    private TableView<Rider> riderTable;
    
    @FXML
    void authAct(ActionEvent event) throws IOException {
    	
    	if (riderTable.getSelectionModel().getSelectedIndex() == -1)
    	{
    		Alert alertObj = new Alert(Alert.AlertType.WARNING);
    		alertObj.setHeaderText("There is no Rider selected");
    		alertObj.setTitle("Warning");
    		alertObj.setContentText("Please select a Rider before pressing the authorize button.");
    		alertObj.showAndWait();
    	}
    	else
    	{
    		Rider ridObj = riderTable.getSelectionModel().getSelectedItem();
    		contr.authorizeRider(ridObj);
    		
    		Alert alertObj = new Alert(Alert.AlertType.INFORMATION);
    		alertObj.setHeaderText("SUCCESSFULL");
    		alertObj.setTitle("Successfull");
    		alertObj.setContentText("The selected Rider has been successfully authorized!");
    		alertObj.showAndWait();
    		
    		Main m = new Main();
    		m.changeScene("authorizeRider.fxml");
    	}

    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<Rider> ridList = contr.selectRider();
		ArrayList<Rider> listToShow = new ArrayList<>();
		
		for (Rider obj : ridList)
		{
			if (obj.getAuthorize().equals("no"))
				listToShow.add(obj);
		}
		
		
		ObservableList<Rider> data = FXCollections.observableArrayList(listToShow);
		
		idCol.setCellValueFactory(new PropertyValueFactory<Rider,Integer>("riderId"));
		nameCol.setCellValueFactory(new PropertyValueFactory<Rider,String>("name"));
		liscCol.setCellValueFactory(new PropertyValueFactory<Rider,Integer>("liscenceNo"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Rider,String>("email"));
		
		
		riderTable.setItems(data);
	}
    
    
    
    @FXML
    void boBackAct(ActionEvent event) throws IOException {
    	
    	Main m = new Main();
		m.changeScene("adminPortal.fxml");

    }
    
	
}
