package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class doublePlayerInfoController {
	public static Media sound;
	public static MediaPlayer mediaPlayer;
	public static String p0,p1;
	@FXML
	private Button next,exittowindows,back;
	@FXML
	private Label player1,player2;
	@FXML
	private TextField player1Name,player2Name;
	@FXML
	private void Back(ActionEvent event) {
    	sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("gridSingleMulti.fxml"));
			Stage primaryStage = (Stage)next.getScene().getWindow();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void Exit(ActionEvent event) {
		sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
		try {
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
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
	@FXML
	private void Next(ActionEvent event) {
		sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
		try {
			p0=player1Name.getText();
			p1=player2Name.getText();
			Parent root = FXMLLoader.load(getClass().getResource("gridDoubleInstructions.fxml"));
			Stage primaryStage = (Stage)next.getScene().getWindow();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
