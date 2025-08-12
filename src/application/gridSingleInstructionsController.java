package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class gridSingleInstructionsController implements Initializable{
	public Timeline timeline;
	public String completeText;
	public static Media sound;
	public static MediaPlayer mediaPlayer;
	private int k=-1;
	public static int jitse=-1;
	private boolean t = false;
	int result,res;
	@FXML
	private Text text;
	@FXML
	private Label battle;
	@FXML
	private Button exittowindows,skip;
	@FXML
	private Button play;
	@FXML
	private Button back;
	@FXML
	private Label chooseHT;
	@FXML
	private Label tossWon;
    @FXML
    private ImageView coin;
    @FXML
    private Button spin;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label ht;
    @FXML
    private RadioButton heads;
    @FXML
    private RadioButton tails;
    @FXML
    private RadioButton first;
    @FXML
    private RadioButton second;
    @FXML
    private void Play(ActionEvent event) {
    	sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        
        mediaPlayer.play();
		try {
			if(first.isSelected()) {
				jitse=1;
				Parent root = FXMLLoader.load(getClass().getResource("gridSingleGamePlay.fxml"));
				Stage primaryStage = (Stage)exittowindows.getScene().getWindow();
				Scene scene = new Scene(root);
		
				primaryStage.setScene(scene);
				
			}
			else if(second.isSelected()) {
				jitse=0;
				Parent root = FXMLLoader.load(getClass().getResource("gridSingleGamePlay.fxml"));
				Stage primaryStage = (Stage)exittowindows.getScene().getWindow();
				Scene scene = new Scene(root);
				
				primaryStage.setScene(scene);
				
			}
			else if(result==k && !first.isSelected() && !second.isSelected()){
				Alert alert = new Alert(AlertType.ERROR, "Please select whether you want to move first or second.", ButtonType.OK);
	           
	            alert.showAndWait();
	            return;

			}
			else if(jitse==-1) {
				Alert alert = new Alert(AlertType.ERROR, "Please spin the coin...", ButtonType.OK);
			    alert.showAndWait();
	            return;
			}
			else {
				Parent root = FXMLLoader.load(getClass().getResource("gridSingleGamePlay.fxml"));
				Stage primaryStage = (Stage)exittowindows.getScene().getWindow();
				Scene scene = new Scene(root);
				
				primaryStage.setScene(scene);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    @FXML
    private void ExitToWindows(ActionEvent event) {
    	sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        
        mediaPlayer.play();
		try {
			Alert alert=new Alert(AlertType.CONFIRMATION);
			
			alert.setTitle("EXIT");
			alert.setHeaderText("Are you sure you want to exit?");
			alert.setContentText("Click OK to exit or Cancel to return.");
			
			if(alert.showAndWait().get()==ButtonType.OK) {
			Stage primaryStage = (Stage)back.getScene().getWindow();
			primaryStage.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    @FXML
	private void Back(ActionEvent event) {
    	sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        
        mediaPlayer.play();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("gridSingleMulti.fxml"));
			Stage primaryStage = (Stage)back.getScene().getWindow();
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
    	timeline.stop();
        text.setText(completeText);
        mediaPlayer.stop();
	    Main.mediaPlayer.play();
		tossWon.setVisible(true);
		battle.setVisible(true);
		play.setVisible(true);
		back.setVisible(true);
		exittowindows.setVisible(true);
		chooseHT.setVisible(true);
		coin.setVisible(true);
		spin.setVisible(true);
		ht.setVisible(true);
		heads.setVisible(true);
		tails.setVisible(true);
		skip.setVisible(false);
    }
    @FXML
    private void Spin(ActionEvent event) {
    	sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        
        mediaPlayer.play();
		try {
			if (t) {
	            Alert alert = new Alert(AlertType.ERROR, "Spin can only be called once!", ButtonType.OK);
	            alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
	            alert.getDialogPane().getStyleClass().add("alert");
	            alert.showAndWait();
	            return;
	        }
			if(heads.isSelected())k=0;
			else if(tails.isSelected())k=1;
			else 
			{
				Alert alert = new Alert(AlertType.ERROR, "Please select your call.", ButtonType.OK);
				alert.getDialogPane().getStylesheets().add(getClass().getResource("alert.css").toExternalForm());
				alert.getDialogPane().getStyleClass().add("alert");
	            alert.showAndWait();
	            return;
			}
			t=true;
			RotateTransition rotateTransition = new RotateTransition();
			rotateTransition.setNode(coin);
			rotateTransition.setDuration(Duration.millis(10));
	        rotateTransition.setByAngle(360);
	        rotateTransition.setCycleCount(100);
	        rotateTransition.setInterpolator(Interpolator.LINEAR);
	        rotateTransition.setAxis(Rotate.X_AXIS);
	        rotateTransition.setOnFinished(e -> {
	        	coin.setRotate(0);
	        	Random random = new Random();
	    	    result = random.nextInt(2);
	    	    if(result==1)ht.setText("TAILS");
	    	    else ht.setText("HEADS");
	    	    ht.setBackground(null);
	    	    ht.setVisible(true);
	    	    if(result==k) {
	    	    	tossWon.setText("You won the toss and you will move ");
	    	    	first.setVisible(true);
	    	    	second.setVisible(true);
	    	    	
	    	    }
	    	    else {
	    	    	
	    	    	
	    	    	Random rand=new Random();
	    	    	res=rand.nextInt(2);
	    	    	jitse=res;
	    	    	if(res==0)tossWon.setText("Computer won the toss and chose to move first");
	    	    	else tossWon.setText("Computer won the toss and chose to move second");
	    	    }
	    	    battle.setText("Click Play to enter the BATTLEGRID!");
	        });
	        rotateTransition.play();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Main.mediaPlayer.stop();
		sound = new Media(getClass().getResource("type.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        
        mediaPlayer.play();
		tossWon.setText("");
		battle.setText("Spin the coin...");
		first.setVisible(false);
		second.setVisible(false);
		tossWon.setVisible(false);
		battle.setVisible(false);
		play.setVisible(false);
		back.setVisible(false);
		exittowindows.setVisible(false);
		chooseHT.setVisible(false);
		coin.setVisible(false);
		spin.setVisible(false);
		ht.setVisible(false);
		heads.setVisible(false);
		tails.setVisible(false);
		FadeTransition fade = new FadeTransition(Duration.seconds(1), battle);
    	fade.setFromValue(1.0);
    	fade.setToValue(0.5);
    	fade.setAutoReverse(true);
    	fade.setCycleCount(Timeline.INDEFINITE);
    	fade.play();
    	completeText = "You are given a 5 X 5 grid.A ball is placed at the bottom left cell initially.In each turn you can move the ball any number of cell rightwards or upwards.Then computer moves according to the rule.The one who can not move anymore loses.The gameplay starts with a coin toss.The winner of toss chooses whether to move first or second.HAVE FUN!";
    	StringBuilder displayedText = new StringBuilder();
    	timeline = new Timeline();
    	
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
    		tossWon.setVisible(true);
    		battle.setVisible(true);
    		play.setVisible(true);
    		back.setVisible(true);
    		exittowindows.setVisible(true);
    		chooseHT.setVisible(true);
    		coin.setVisible(true);
    		spin.setVisible(true);
    		ht.setVisible(true);
    		heads.setVisible(true);
    		tails.setVisible(true);
    		skip.setVisible(false);
    	});

    	timeline.play();

	}
}

    
