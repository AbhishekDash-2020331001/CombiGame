package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class lastDoubleController implements Initializable{
	public static String players[]=gridDoubleInstructionsController.players;
	public int winner=gridDoubleGamePlayController.winner;
	public static Media sound;
	public static MediaPlayer mediaPlayer;
	@FXML
	public ImageView image;
    @FXML
    private Label msg,won,name;
    @FXML
    private Button home,exit;
    @FXML
	private void Home(ActionEvent event) {
    	sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        
        mediaPlayer.play();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Stage primaryStage = (Stage)home.getScene().getWindow();
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
			
			alert.setTitle("EXIT");
			alert.setHeaderText("Are you sure you want to exit?");
			alert.setContentText("Click OK to exit or Cancel to return.");
			
			if(alert.showAndWait().get()==ButtonType.OK) {
			Stage primaryStage = (Stage)home.getScene().getWindow();
			primaryStage.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		msg.setText("Congratulations "+players[winner]+"!");
		won.setText("Better luck next time "+players[1-winner]+"...");
		name.setText(players[winner]);
	}
	
}
