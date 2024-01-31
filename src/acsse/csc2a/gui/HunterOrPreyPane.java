/**
 * 
 */
package acsse.csc2a.gui;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import acsse.csc2a.file.HunterOrPreyHandler;
import acsse.csc2a.gameLoop.GameLoop;
import acsse.csc2a.model.Charecter;
import acsse.csc2a.model.Hunter;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


/**
 * @author SN MAHLOBO
 *
 */
public class HunterOrPreyPane extends StackPane{
	
	//Declaring final attributes
	private final int HEIGHT = 1000;
	private final int WIDTH = 1200;
	
	//Declaring PathTransition to keep moving the The Preys and Predators
	PathTransition pathTransition;
	
	//Declaring attributes
	private Hunter hunter;
	
	private ArrayList<Charecter> characters;
	
	//Declaring game Loop Variable
	private	GameLoop gameLoop;
	
	//AnimationTimer variables for constantly moving Prey and Predator
	private AnimationTimer animationTimer;
	
	//MenuBar
	private MenuBar menuBar;
	
	//TextArea
	private TextArea textArea;
	
	private BorderPane borderPane;
	
	/**
	 * Constructor
	 * 
	 */
	public HunterOrPreyPane()
	{
		//Instance of Charecter
		characters = new ArrayList<>();
		
		//Instance of GameLoop
		gameLoop = new GameLoop();
		
		//Instance of PathTransition
	
		
		//Creating a Background
		setBackgroundImage();
		
		menuBar = new MenuBar();
		
		Menu menu = new Menu("Save Game State");
		
		MenuItem itemSave = new MenuItem("_Save");
		
		menu.getItems().add(itemSave);
		
		
		menuBar.getMenus().add(menu);
		
		
		 borderPane = new BorderPane();
		 
		 textArea = new TextArea();
		 
		 textArea.setMaxWidth(200);
		
		//Declaring local variables
		Button btnContinue = new Button("Continue");
				
		btnContinue.setLayoutY(140);
		btnContinue.setLayoutX(550);
				
		Button btnNewGame = new Button("New Game");
				
		btnNewGame.setLayoutY(540);
		btnNewGame.setLayoutX(550);
		
		//Declaring TextField to capture HunterID
		Label lblHunterID = new Label("Hunter ID");
		  
		
		TextField txtHunterID = new TextField();
				
		//Button for game Instructions		
		Button btnInstructions =new Button("Instructions");
		
		//Button for seeing Hunter state
		Button btnHunterData = new Button("Hunter Data");
		
		
		
		VBox vBox = new VBox();
				
	
		
		vBox.getChildren().addAll(btnContinue, lblHunterID, txtHunterID, btnNewGame, btnInstructions, textArea,btnHunterData);
		
		borderPane.setRight(vBox);
				
		//Implementing Save Game State item
		itemSave.setOnAction(new EventHandler<ActionEvent>()
				{

						@Override
     				public void handle(ActionEvent event) {
								
								HunterOrPreyHandler handler = new HunterOrPreyHandler();
								
								characters = gameLoop.getCharacters();
								
								handler.writeToBatchFile(characters);
								
								//Creating an instance of hunter
							    hunter = (Hunter) characters.get(0);
								
								handler.writeHunterData(hunter);
								
								System.out.println(" Game State Saved!");
								
							}
					
						});
				
				
		//Implementing Continue Game Button
		btnContinue.setOnAction(new EventHandler<ActionEvent>()
						{

							@Override
							public void handle(ActionEvent event) {
								
								borderPane.setTop(menuBar);
								borderPane.setCenter(gameLoop.getCanvas());
								borderPane.setRight(null);
								
								
								HunterOrPreyHandler handler = new HunterOrPreyHandler();
								
								//Reading Characters from Batch file
								characters = handler.readFromBatchFile();
							    //Reading Hunter information form text File
								hunter = handler.readHunterData();
								
								//Assigning characters in the gameLoop
								gameLoop.setCharacters(characters);
								
								
								//Starting the Game
								startGame();
							}
					
						});
		
		//Implementing NewGame Button
		btnNewGame.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) 
					{
						
						String huntderID = txtHunterID.getText();
						
						//Updating borderPane
						borderPane.setTop(menuBar);
						borderPane.setRight(null);
						borderPane.setCenter(gameLoop.getCanvas());
					
						
						//clearing all characters in the array
						characters.clear();
						//Creating new characters
						characters = gameLoop.createCharacters(huntderID);
						
						//Creating Hunter Instance
						hunter = (Hunter) characters.get(0);
	
						
						//Starting the Game
						startGame();

						
					}
			
				});
		
		
		//Implementing Instructions
		btnInstructions.setOnAction(new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event) {
				
				
                 //setting instructions
				
				//TextArea
		         textArea.setText("(A) press <- move player left\n" + 
                                        "(D) press -> move player right\n" +
                                        "(W) press up move player upwards\n" +
                                        "(S) press down move player\n downwards\n"+ 
                                        "\nAvoid the Predators while\n" +
                                         "hunting all the Prey") ;
				
			}
	
		});
		
		
		
		btnHunterData.setOnAction(new EventHandler<ActionEvent>()
				{

					@Override
					public void handle(ActionEvent event) {
						
						textArea.clear();
						
						HunterOrPreyHandler handler = new HunterOrPreyHandler();
						
						hunter = handler.readHunterData();
						
						textArea.setText("Hunter ID: "+ hunter.getPlayerID() 
						                 +"\nHealth: "+ hunter.getHealth()
						                 +"\nScore: "+ hunter.getScore());
						                 
					}
			
			
				});	
		
		
		
		
		this.getChildren().add(borderPane);
		
		
		this.setHeight(this.HEIGHT);
		this.setWidth(this.WIDTH);
			
		
	}
	
	public GameLoop getGameLoop()
	{
		return gameLoop;
	}
	
	private void startGame()
	{
		
			animationTimer = new AnimationTimer()
				{

					@Override
					public void handle(long arg0) {
						
							
						//Calling the method for moving Animals
					    gameLoop.moveAnimals();
					    
						
						//Displaying the animals at their new location
						characters = gameLoop.getCharacters();
						
						gameLoop.getCanvas().drawCharacters(characters);
					
					}
					
					
				};
				
		
		//Starting AnimationTimer
		animationTimer.start();
		
		
		//Checking if game has ended.
				if(gameLoop.getendGame() == true)
				{
					animationTimer.stop();
					
					//Displaying game Over
					Label lblGameOver = new Label("GAME OVER!!");
					
					lblGameOver.setFont(Font.font(36));
					
					this.borderPane.setCenter(lblGameOver);
				}
				
		
	}
	
	
	
	private void setBackgroundImage()
	{
		Image backgroundImage = null;
		try {
			
			backgroundImage = new Image(Files.newInputStream(Paths.get("animation/backgrounddetailed1.png")),256,256,false,true);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		BackgroundImage backgrond = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
	
	
		this.setBackground(new Background(backgrond));
	}
	
	
	
}