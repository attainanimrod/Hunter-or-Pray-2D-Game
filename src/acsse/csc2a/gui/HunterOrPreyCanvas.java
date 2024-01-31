/**
 * 
 */
package acsse.csc2a.gui;

import java.util.ArrayList;

import acsse.csc2a.gameLoop.GameLoop;
import acsse.csc2a.model.Charecter;
import acsse.csc2a.model.Hunter;
import acsse.csc2a.model.Predator;
import acsse.csc2a.model.Prey;
import acsse.csc2a.pattern.CharacterFactory;
import acsse.csc2a.pattern.DrawGameVisitor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author SN MAHLOBO
 *
 */
public class HunterOrPreyCanvas extends Canvas{
	
	//Declaring final attributes
	private final int originalTileSize = 16;
	private final int scale = 3;
	private final int tileSize = originalTileSize * scale;// This will be the size of my Icons
	
	//Screen Height and Width
	private final int HEIGHT = tileSize * 12;
	private final int WIDTH = tileSize * 20;
	
	//Declaring ArrayList attribute
	private ArrayList<Charecter> characters;
	private Hunter hunter ;
	
	//Declaring DrawGameVisitor variable
	private DrawGameVisitor visitor;

	
 /**
  * Constructor 
  * 
  */
	public HunterOrPreyCanvas()
	{
		//Creating instances of
		   //ArrayList  
		characters = new ArrayList<>();
		
		   //DrawGameVisitor
		visitor = new DrawGameVisitor();
		
		
		this.setHeight(HEIGHT);
		this.setWidth(WIDTH);
	}

	
	
	/**
	 * Method for drawing Characters
	 * @param characters
	 *                  ArrayList of Character data type
	 *                  
	 */
	public void drawCharacters(ArrayList<Charecter> characters)
	{
		this.characters = characters;
		
		//calling the redrawCharacters method
		this.redrawCharacters();
	}
	
	
	private void redrawCharacters()
	{
	     //Declaring local variable
		 GraphicsContext gc = this.getGraphicsContext2D();
		 
		 gc.clearRect(0, 0, WIDTH, HEIGHT);
		 //setting GraphicsContext of visitor
		 visitor.setGraphicsContext(gc);
		 
		 //Crearing the canvas
		 
		 
		 for(Charecter character: this.characters)
		 {
			 if(character instanceof Hunter)
			 {
				 character.accept(visitor);
			 }
			 else if(character instanceof Prey )
			 {
				 character.accept(visitor);
			 }
			 else if(character instanceof Predator)
			 {
				 character.accept(visitor);
			 }
			 
		 }
		
	}




	
		
	
}
