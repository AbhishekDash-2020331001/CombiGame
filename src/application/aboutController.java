package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class aboutController implements Initializable{
	public Timeline timeline;
	public String completeText;
	@FXML
	private Button submit,skip;
	@FXML
	private Label reviewRequest,nameLabel,reviewLabel;
	@FXML
	private Text text;
	@FXML
	private TextField nameText,reviewText;
	public static Media sound;
	public static MediaPlayer mediaPlayer;
	@FXML
	private void Submit(ActionEvent event) {
		sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
		String n=nameText.getText(),r=reviewText.getText();
		File file=new File("Public_Review.txt");
		try {
			file.createNewFile();
			FileWriter fileWriter=new FileWriter("Public_Review.txt",true);
			fileWriter.write("Name : "+n+"\n"+"Review : "+r+"\n\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Stage primaryStage = (Stage)submit.getScene().getWindow();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@FXML
	private void Skip(ActionEvent event) {
		sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Stage primaryStage = (Stage)submit.getScene().getWindow();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		reviewRequest.setVisible(false);
		reviewLabel.setVisible(false);
		reviewText.setVisible(false);
		nameLabel.setVisible(false);
		nameText.setVisible(false);
		submit.setVisible(false);
		skip.setVisible(false);
		completeText = "This game is a project created as a coursework of Object Oriented Progamming Language under the guidance of Mr. Eamin Rahman,an honorable faculty member of Computer Science department,SUST. Java has been used as programming language in this project along with stylesheets written in CSS.It is a grid-based game where players take turns moving a ball on a 5x5 grid. The objective is to strategically outmaneuver the opponent and be the last player able to make a move. Have fun playing!";
    	StringBuilder displayedText = new StringBuilder();
    	timeline = new Timeline();
    	Main.mediaPlayer.stop();
		sound = new Media(getClass().getResource("type.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        FadeTransition fade = new FadeTransition(Duration.seconds(1), reviewRequest);
    	fade.setFromValue(1.0);
    	fade.setToValue(0.5);
    	fade.setAutoReverse(true);
    	fade.setCycleCount(Timeline.INDEFINITE);
    	fade.play();
    	for (int i = 0; i < completeText.length(); i++) {
    	    KeyFrame keyFrame = new KeyFrame(Duration.millis(50 * i), event -> {
    	        displayedText.append(completeText.charAt(displayedText.length()));
    	        text.setText(displayedText.toString());
    	    });
    	    timeline.getKeyFrames().add(keyFrame);
    	}

    	timeline.setOnFinished(event -> {
    	    mediaPlayer.stop();
    	    Main.mediaPlayer.play();
    		reviewRequest.setVisible(true);
    		reviewLabel.setVisible(true);
    		reviewText.setVisible(true);
    		nameLabel.setVisible(true);
    		nameText.setVisible(true);
    		submit.setVisible(true);
    		skip.setVisible(true);
    	});

    	timeline.play();

		
	}
	
}
