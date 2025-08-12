package application;

import java.util.Timer;
import java.util.TimerTask;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;


public class gridSingleGamePlayController implements Initializable{
	public static Media sound;
	public static MediaPlayer mediaPlayer;
	public static int winner;
	public int jitse,row,col;
	@FXML
	private Button undo;
	@FXML
	private ImageView im;
	@FXML
	private Button fu;
	@FXML
	private Label move;
	@FXML
	private Button back;
	@FXML
	private Button next;
	@FXML
	private Button exit;
	public Integer rowIndex;
	public Integer colIndex;
	@FXML
    private Button b1;
    @FXML
    private Button b2;@FXML
    private Button b3;@FXML
    private Button b4;@FXML
    private Button b5;@FXML
    private Button b6;@FXML
    private Button b8;@FXML
    private Button b9;@FXML
    private Button b7;@FXML
    private Button b10;@FXML
    private Button b11;@FXML
    private Button b12;@FXML
    private Button b13;@FXML
    private Button b14;@FXML
    private Button b15;@FXML
    private Button b16;@FXML
    private Button b17;@FXML
    private Button b18;@FXML
    private Button b19;@FXML
    private Button b20;@FXML
    private Button b21;@FXML
    private Button b22;@FXML
    private Button b23;@FXML
    private Button b24;@FXML
    private Button b25;
    @FXML
    private Label cd;
    public Duration duration;
    public Timeline timeline;
    public KeyFrame keyFrame;
    @FXML
    private GridPane grid;
    @FXML
    private Circle ball;
    @FXML
    private Label battle;
    int tim=4;
    int rem=4;
    public void updateLabel() {
    	cd.setText(""+rem+"");
    }
    @FXML
    private void Undo(){
    	sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        //mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    	grid.getChildren().remove(ball); 
        GridPane.setConstraints(ball, col,row); 
        grid.getChildren().add(ball);
        timeline.stop();
        im.setVisible(false);
		cd.setVisible(false);
		undo.setVisible(false);
		move.setText("Your Turn...");
		jitse=1;
    }
    @FXML
	private void Next(ActionEvent event) {
    	sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        //mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("last.fxml"));
			Stage primaryStage = (Stage)next.getScene().getWindow();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setScene(scene);
			//primaryStage.setMaximized(true);
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
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
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
    
    @FXML
    private void handleButtonClick(ActionEvent event) {
    	sound = new Media(getClass().getResource("button.mp3").toString());
        mediaPlayer = new MediaPlayer(sound);
        
        mediaPlayer.play();
    	if(jitse==0) {
    		Alert alert = new Alert(AlertType.ERROR, "Wait for computer's move!", ButtonType.OK);
            
            alert.showAndWait();
            return;
    	}
        if (event.getSource() instanceof Button) {
            Button clickedButton = (Button) event.getSource();
       
            
            rowIndex = GridPane.getRowIndex(clickedButton);
            colIndex = GridPane.getColumnIndex(clickedButton);
            
            Integer collIndex = GridPane.getColumnIndex(ball);
        	Integer rowwIndex = GridPane.getRowIndex(ball);
        	if(rowwIndex==null)row=0;
        	else row=rowwIndex.intValue();
        	if(collIndex==null)col=0;
        	else col=collIndex.intValue();
        	
            if(rowIndex==null && colIndex==null) {
            	
            	if(row!=0 && col!=0 || (row==0 && col==0)) {
            		Alert alert = new Alert(AlertType.ERROR, "Illegal Move!", ButtonType.OK);
                    
                    alert.showAndWait();
                    return;
            	}
            	grid.getChildren().remove(ball);
                GridPane.setConstraints(ball, 0, 0);
                grid.getChildren().add(ball);
                im.setVisible(true);
        		cd.setVisible(true);
        		undo.setVisible(true);
                rem=tim;
                move.setText("Computer will move shortly...");
                jitse=0;
                updateLabel();
                duration=Duration.seconds(1);
                keyFrame=new KeyFrame(duration,eventt ->{
                	rem--;
                	updateLabel();
                	if(rem<=0) {
                		jitse=0;
                        move.setText("Computer's turn!");
                        computer();
                	}
                });
                timeline=new Timeline(keyFrame);
                timeline.setCycleCount(tim);
                timeline.play();
            }
            else if(colIndex==null) {
            	if((row!=rowIndex.intValue() && col!=0) || (row==rowIndex.intValue() && col==0)|| row<rowIndex.intValue()||col>0) {
            		Alert alert = new Alert(AlertType.ERROR, "Illegal Move!", ButtonType.OK);
                    
                    alert.showAndWait();
                    return;
            	}
            	grid.getChildren().remove(ball); 
                GridPane.setConstraints(ball, 0, rowIndex.intValue()); 
                grid.getChildren().add(ball);
                im.setVisible(true);
        		cd.setVisible(true);
        		undo.setVisible(true);
                rem=tim;
                move.setText("Computer will move shortly...");
                updateLabel();
                jitse=0;
                duration=Duration.seconds(1);
                keyFrame=new KeyFrame(duration,eventt ->{
                	rem--;
                	updateLabel();
                	if(rem<=0) {
                		jitse=0;
                        move.setText("Computer's turn!");
                        computer();
                	}
                });
                timeline=new Timeline(keyFrame);
                timeline.setCycleCount(tim);
                timeline.play();

                
            }
            else if(rowIndex==null) {
            	if((row!=0 && colIndex.intValue()!=col) ||(row==0 && colIndex.intValue()==col)||row<0 || col>colIndex.intValue()) {
            		Alert alert = new Alert(AlertType.ERROR, "Illegal Move!", ButtonType.OK);
                    
                    alert.showAndWait();
                    return;
            	}
            	grid.getChildren().remove(ball); 
                GridPane.setConstraints(ball, colIndex.intValue(), 0); 
                grid.getChildren().add(ball);
                if(colIndex.intValue()==4) {
                	move.setText("You Won!");
                	winner=0;
                	sound = new Media(getClass().getResource("finish.mp3").toString());
                    mediaPlayer = new MediaPlayer(sound);
                    
                    mediaPlayer.play();
                	return;
                }
                im.setVisible(true);
        		cd.setVisible(true);
        		undo.setVisible(true);
                rem=tim;
                jitse=0;
                move.setText("Computer will move shortly...");
                updateLabel();
                duration=Duration.seconds(1);
                keyFrame=new KeyFrame(duration,eventt ->{
                	rem--;
                	updateLabel();
                	if(rem<=0) {
                		jitse=0;
                        move.setText("Computer's turn!");
                        computer();
                	}
                });
                timeline=new Timeline(keyFrame);
                timeline.setCycleCount(tim);
                timeline.play();

            }
            
            else {
            	
            	if((row!=rowIndex.intValue() && colIndex.intValue()!=col) ||(row==rowIndex.intValue() && colIndex.intValue()==col)||row<rowIndex.intValue()||col>colIndex.intValue()) {
            		Alert alert = new Alert(AlertType.ERROR, "Illegal Move!", ButtonType.OK);
                    
                    alert.showAndWait();
                    return;
            	}
            	grid.getChildren().remove(ball); 
                GridPane.setConstraints(ball, colIndex.intValue(), rowIndex.intValue());
                grid.getChildren().add(ball); 
                im.setVisible(true);
        		cd.setVisible(true);
        		undo.setVisible(true);
                rem=tim;
                jitse=0;
                move.setText("Computer will move shortly...");
                updateLabel();
                duration=Duration.seconds(1);
                keyFrame=new KeyFrame(duration,eventt ->{
                	rem--;
                	updateLabel();
                	if(rem<=0) {
                		jitse=0;
                        move.setText("Computer's turn!");
                        computer();
                	}
                });
                timeline=new Timeline(keyFrame);
                timeline.setCycleCount(tim);
                timeline.play();

                
            }
        }
        
    }
    public void computer(){
    	im.setVisible(false);
    	undo.setVisible(false);
    	cd.setVisible(false);
    	move.setText("Computer's turn");
    	Integer columnIndex = GridPane.getColumnIndex(ball);
    	Integer rowIndex = GridPane.getRowIndex(ball);
    	System.out.println("comp "+rowIndex+" "+columnIndex);
    	int row,col;
    	if(rowIndex==null)row=0;
    	else row=rowIndex.intValue();
    	if(columnIndex==null)col=0;
    	else col=columnIndex.intValue();
    	
    	Random random = new Random();
    	
        int minValue = col+1;
        int maxValue = 4;
        int nr=0,nc=0,rand=0;
        int mod=maxValue - minValue + 1;
if(row==0) {
        	
        	nr=0;nc=4;
        	grid.getChildren().remove(ball);
            GridPane.setConstraints(ball, 4, row);
            grid.getChildren().add(ball); 
        }
        else if(col==4) {
        	
        	nc=4;nr=0;
        	grid.getChildren().remove(ball);
            GridPane.setConstraints(ball, col, 0);
            grid.getChildren().add(ball);
        }
        else if(mod!=0) {
        	int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
            
            nc=randomNumber;
            minValue=0;
            maxValue=row-1;
            randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
            nr=randomNumber;
            rand=random.nextInt(2);
            
            if(rand==0) {
        		nr=row;
        		grid.getChildren().remove(ball);
                GridPane.setConstraints(ball, nc, row);
                grid.getChildren().add(ball); 
        	}
        	else {
                nc=col;
        		grid.getChildren().remove(ball);
                GridPane.setConstraints(ball, col, nr);
                grid.getChildren().add(ball);
        	}
        }
        
        
        
        if(nr==0 && nc==4) {
        	move.setText("Computer Won!");
        	winner=1;
        	sound = new Media(getClass().getResource("finish.mp3").toString());
            mediaPlayer = new MediaPlayer(sound);
            
            mediaPlayer.play();
        	return;
        }
        jitse=1;
        move.setText("Your turn");
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		im.setVisible(false);
		cd.setVisible(false);
		undo.setVisible(false);
		jitse=gridSingleInstructionsController.jitse;
		TranslateTransition transition = new TranslateTransition(Duration.seconds(4), battle);
		transition.setFromX(-500); 
	    transition.setToX(500); 
        transition.setCycleCount(TranslateTransition.INDEFINITE); 
        transition.setAutoReverse(true); 
        transition.play(); 
        FadeTransition fade = new FadeTransition(Duration.seconds(1), move);
    	fade.setFromValue(1.0);
    	fade.setToValue(0.5);
    	fade.setAutoReverse(true);
    	fade.setCycleCount(Timeline.INDEFINITE);
    	fade.play();
    	move.setText("Game will start shortly...");
    	duration=Duration.seconds(1);
        keyFrame=new KeyFrame(duration,eventt ->{
        	rem--;
        	if(rem<=0) {
                if(jitse==0) {
            		computer();
            	}
            	else move.setText("Your turn");
        	}
        });
        timeline=new Timeline(keyFrame);
        timeline.setCycleCount(tim);
        timeline.play();
    	
	}
}
