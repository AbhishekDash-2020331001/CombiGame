package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class soundController {
	public static Media soun;
	public static MediaPlayer mediaPlayer;
	@FXML
	private RadioButton on,off;
	@FXML
	private Button back;
	@FXML
	private void Back(ActionEvent event) {
		soun = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(soun);
        
        mediaPlayer.play();
		if(on.isSelected()) {
			Main.mediaPlayer.play();
			Main.s=1;
		}
		else if(off.isSelected()) {
			Main.mediaPlayer.stop();
			Main.s=0;
		}
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Stage primaryStage = (Stage)on.getScene().getWindow();
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void initialize() {
		if(Main.s==0)off.setSelected(true);
		else if(Main.s==1)on.setSelected(true);
	}
}
