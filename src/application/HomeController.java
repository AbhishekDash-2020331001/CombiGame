package application;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.AnchorPane;

public class HomeController {
	public static Media soun;
	public static MediaPlayer mediaPlayer;
	@FXML
	RadioButton on,off;
	@FXML
	AnchorPane pane;
	@FXML
	private Label welcome;
	@FXML
	private Button start,back;
	@FXML
	private Button exit,sound,about;
	@FXML
	private void About(ActionEvent event) {
		soun = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(soun);
        mediaPlayer.play();
        try {
			Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
			Stage primaryStage = (Stage)about.getScene().getWindow();
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void Back(ActionEvent event) {
		soun = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(soun);
        
        mediaPlayer.play();
		if(on.isSelected())Main.mediaPlayer.play();
		else if(off.isSelected())Main.mediaPlayer.stop();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Stage primaryStage = (Stage)on.getScene().getWindow();
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void Sound(ActionEvent event) {
		soun = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(soun);
        
        mediaPlayer.play();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("sound.fxml"));
			Stage primaryStage = (Stage)start.getScene().getWindow();
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void Start(ActionEvent event) {
		soun = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(soun);
        
        mediaPlayer.play();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("chooseGame.fxml"));
			Stage primaryStage = (Stage)start.getScene().getWindow();
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void Exit(ActionEvent event) {
		soun = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(soun);
       
        mediaPlayer.play();
		try {
			Alert alert=new Alert(AlertType.CONFIRMATION);
			
			alert.setTitle("EXIT");
			alert.setHeaderText("Are you sure you want to exit?");
			alert.setContentText("Click OK to exit or Cancel to return.");
			
			if(alert.showAndWait().get()==ButtonType.OK) {
			Stage primaryStage = (Stage)start.getScene().getWindow();
			primaryStage.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void initialize() {
		FadeTransition fade = new FadeTransition(Duration.seconds(1), welcome);
    	fade.setFromValue(1.0);
    	fade.setToValue(0.5);
    	fade.setAutoReverse(true);
    	fade.setCycleCount(Timeline.INDEFINITE);
    	fade.play();
	}
}
