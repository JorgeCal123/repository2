package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Club;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Club club;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Interfaz.fxml"));
			Scene scene = new Scene(root,593,260);
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void iniciarClub() {
		club=new Club();
	}
	
	public Club darClub() {
		return club;
	}
}
