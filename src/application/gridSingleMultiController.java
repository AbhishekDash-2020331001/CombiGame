package application;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class gridSingleMultiController {
	public static Media sound;
	public static MediaPlayer mediaPlayer;
	@FXML
	private Label choice;
	@FXML
	private Button next;
	@FXML
	private Button back;
	@FXML
	private RadioButton singlePlayer;
	@FXML
	private RadioButton doublePlayer;
	@FXML
	private Button exittowindows;
	@FXML
	private void Next(ActionEvent event) {
		sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        
        mediaPlayer.play();
		try {
			if(singlePlayer.isSelected()) {
				Parent root = FXMLLoader.load(getClass().getResource("gridSingleInstructions.fxml"));
				Stage primaryStage = (Stage)next.getScene().getWindow();
				Scene scene = new Scene(root);
				
				primaryStage.setScene(scene);
				
			}
			else if(doublePlayer.isSelected()) {
				Parent root = FXMLLoader.load(getClass().getResource("doublePlayerInfo.fxml"));
				Stage primaryStage = (Stage)next.getScene().getWindow();
				Scene scene = new Scene(root);
				
				primaryStage.setScene(scene);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void Back(ActionEvent event) {
		sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        
        mediaPlayer.play();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("chooseGame.fxml"));
			Stage primaryStage = (Stage)next.getScene().getWindow();
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void exitToWindows(ActionEvent event) {
		sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        
        mediaPlayer.play();
		try {
			Alert alert=new Alert(AlertType.CONFIRMATION);
			
			alert.setTitle("EXIT");
			alert.setHeaderText("Are you sure you want to exit?");
			alert.setContentText("Click OK to exit or Cancel to return.");
			
			if(alert.showAndWait().get()==ButtonType.OK) {
			Stage primaryStage = (Stage)next.getScene().getWindow();
			primaryStage.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void initialize() {
		FadeTransition fade = new FadeTransition(Duration.seconds(1), choice);
    	fade.setFromValue(1.0);
    	fade.setToValue(0.5);
    	fade.setAutoReverse(true);
    	fade.setCycleCount(Timeline.INDEFINITE);
    	fade.play();
	}
}
