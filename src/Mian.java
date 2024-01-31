

import java.nio.file.Files;
import java.nio.file.Paths;

import acsse.csc2a.gui.HunterOrPreyPane;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


/**
 * @author SN MAHLOBO
 * Main Class, which will launch the Game
 *
 */
public class Mian extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

     launch(args);
     
	}     


	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		
		//Setting Title on top of Stage
		primaryStage.setTitle("Hunter Or Prey");
		
		
		//Setting Game Icon
		Image icon = new Image(Files.newInputStream(Paths.get("animation/GameIcon.png")));
		
		primaryStage.getIcons().add(icon);
		
		
		//Setting the Scene
		HunterOrPreyPane root = new HunterOrPreyPane();
			
		Scene scene = new Scene(root,960,600);
		
		//Listening to keys pressed for moving the Hunter.
		scene.setOnKeyReleased(new EventHandler<KeyEvent>()
				{

					@Override
					public void handle(KeyEvent event) 
					{
						
						System.out.println(event.getCode());
						
						root.getGameLoop().movingHunter(scene);
						
					}
			
				});
		
		//Showing the Game Scene on Stage.
		primaryStage.setScene(scene);
		
				
		//Showing Stage
		primaryStage.show();
		
		
		
		
	
		
	}

	
	
}
