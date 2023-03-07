package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;
import javafx.fxml.*;

public class Main extends Application {
	
	private static Stage stg; //added
	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage; //added
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void changeScene(String fxml) throws IOException
	{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
		stg.show();
	}
}
