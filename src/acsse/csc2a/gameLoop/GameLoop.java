/**
 * 
 */
package acsse.csc2a.gameLoop;

import java.util.ArrayList;

import acsse.csc2a.gui.HunterOrPreyCanvas;
import acsse.csc2a.gui.HunterOrPreyPane;
import acsse.csc2a.model.Charecter;
import acsse.csc2a.model.Hunter;
import acsse.csc2a.model.Predator;
import acsse.csc2a.model.Prey;
import acsse.csc2a.pattern.CharacterFactory;
import javafx.scene.Scene;

/**
 * @author SN MAHLOBO
 *
 */
public class GameLoop {

	//Declaring Global variable
	private HunterOrPreyCanvas canvas;
	private ArrayList<Charecter> characters;
	
	private Hunter hunter;
	//Keeping track of the Number of Prey Alive
	private Integer intPreyCaptured = 0;
	//Variable to check if game if over
	private Boolean endGame ;
	/**
	 * Constructor
	 * 
	 */
	public GameLoop()
	{
		
		characters = new ArrayList<>();	
		
		canvas = new HunterOrPreyCanvas();

		endGame = false;
	}
	
	
	/**
	 * Method for moving both Prey and Predator
	 */
	public void moveAnimals()
	{
		 characters = movingPredators(characters);
		 characters = movingPrey(characters);
	}
	
	
	/**
	 * Method for returning characters
	 * @return characters
	 *                   ArrayLisf of Characters in the game
	 */
	public ArrayList<Charecter> getCharacters()
	{
		return this.characters;
	}
	
	
	
	
	/**
	 * Method for getting endGame variable
	 * @return endGame
	 *                boolean value which determines if the game has ended
	 */
	public Boolean getendGame()
	{
		return this.endGame;
	}
	
	
	
	
	/**
	 * Method for returning hunter
	 * @return hunter
	 *               Game hunter Charecter
	 *               
	 */
	public Hunter getHunter()
	{
		return this.hunter;
	}
	
	
	/**
	 * Method for getting canvas
	 * @return canvas
	 *                HunterOrPrecanvas value
	 *                
	 */
	public HunterOrPreyCanvas getCanvas()
	{
		return this.canvas;
	}
	
	
	/**
	 * Method for moving the Hunter
	 * @hunterOrPreyPane
	 *                  instance of  HunterOrPreyPane
	 *                  
	 */
	public void movingHunter(Scene scene)
	{
		if(hunter != null )
		{
		scene.setOnKeyReleased((event)-> 
		{
			
			switch(event.getCode())
			{
			
			case S :
				
				if(hunter.getYCoordinate()+30 <= 576)
				{
					hunter.setYCoordinate(hunter.getYCoordinate() + 30);
				}
				
				break;
				
			case W : 
				
				if(hunter.getYCoordinate() - 30 >= 0)
				{
					hunter.setYCoordinate(hunter.getYCoordinate() - 30);
				}
				
				break;
				
			case D :
				
				if(hunter.getXCoordinate() + 30 <= 960)
				{
					hunter.setXCoordinate(hunter.getXCoordinate() + 30);
				}
				
				break;
				
			case A :
				
				if(hunter.getXCoordinate() - 30 >= 0)
				{
					hunter.setXCoordinate(hunter.getXCoordinate() - 30);
					
				}
				
			default:
				
		//		System.out.println("Use UP, DOWN, LEFT and RIGHT buttons to move the Hunter!!");
				
				break;
			}
			
			//Updating the Hunter in the Characters ArrayList
			characters.set(0, hunter);
			
			//Check if the Player has captured a Prey or has been Attacked by Predator
		    characters = checkForAttacks(characters);
			
		    
			this.getCanvas().drawCharacters(characters);
		});
		
		}
	}
	
	
	/**
	 * Method for moving Prey
	 * @param characters
	 *                  ArrayList of Game Characters
	 * @return characters
	 *                  ArrayList of Game Characters
	 *                  
	 */
	private ArrayList<Charecter> movingPrey(ArrayList<Charecter> characters)
	{
		
		int intLength = characters.size();
		
		for (int s=0; s<intLength; s++)
		{	
			
			//Updating Prey
			 if(characters.get(s) instanceof Prey)
			{
				Prey prey = (Prey) characters.get(s);	
				
					prey.move();
					
					characters.set(s, prey);
					
					//Checking if Prey is not captured
				characters = checkForAttacks(characters);
				
			}
			
		}
		
		//Drawing the canvas using the updated ArrayList
		this.getCanvas().drawCharacters(characters);
		
		return characters;
		
		
	}
	
	
	
	/**
	 * Method for moving Predators
	 * @param characters
	 *                  ArrayList of Game Characters
	 *@return characters  
	 *                  ArrayList of Game Characters                
	 *                  
	 */
	private ArrayList<Charecter> movingPredators(ArrayList<Charecter> characters)
	{
			
	    int intLength = characters.size();
			
		for (int s=0; s<intLength; s++)
		   {
			
			//Updating Predators, moving them.
			 if(characters.get(s) instanceof Predator)
			  {
				Predator predator = (Predator) characters.get(s);
				
				//Checking if Predator did not attack the Hunter
				if(predator.getXCoordinate() == hunter.getXCoordinate() && predator.getYCoordinate() == hunter.getYCoordinate())
				{
					hunter.updateHealth(predator.getDamage());
					
					//Updating the Hunter variable in the ArrayList
					characters.set(0, hunter);
					
					if(hunter.getHealth() <=0)
					{
						this.endGame = true;
					}
				}
				
				//Moving All the Predators in the direction of the Hunter since he is hurt and they can smell his blood
				if(hunter.getHealth() <100)
				{
					if(hunter.getXCoordinate() > predator.getXCoordinate())
					{
						predator.setXCoordinate(predator.getXCoordinate() - 30);
					}
					else if(hunter.getXCoordinate() < predator.getXCoordinate())
					{
						predator.setXCoordinate(predator.getXCoordinate() + 30);
					}
					
					else if(hunter.getYCoordinate() > predator.getYCoordinate())
					{
						predator.setYCoordinate(predator.getYCoordinate() -30);
					}
					else if(hunter.getYCoordinate() < predator.getYCoordinate())
					{
						predator.setYCoordinate(predator.getYCoordinate() -30);
					}
					
				}
				else
				{
					predator.move();
				}
				
				//
				characters.set(s, predator);
				
				//Checking if the Predator did not Attack the Hunter
				characters = checkForAttacks(characters);
			  }
			}
		
		//Drawing the canvas using the updated ArrayList
		this.getCanvas().drawCharacters(characters);
		
		return characters;
		
		}
	
	
	/**
	 * Method for Checking if the Hunter has come across a Prey or Predator
	 * @param characters
	 * @return characters
	 * 
	 */
	private ArrayList<Charecter> checkForAttacks(ArrayList<Charecter> characters)
	{
		
		int intLength = characters.size();
		
		for(int i=0; i<intLength; i++)
		{
			//checking if Character is a Prey
			 if(characters.get(i) instanceof Prey)
				{
					Prey prey = (Prey) characters.get(i);	
					
					//Checking if the Prey if captured or not
					if(prey.getXCoordinate() == hunter.getXCoordinate() & prey.getYCoordinate() == hunter.getYCoordinate())
					{
						prey.setCaptured(true);
						
						System.out.println(prey.getName() +" is CAPTURED!");
						
						//Updating Hunter's Score
						hunter.updateScore(prey.getPoints());
						
						//Updating the Hunter variable in the ArrayList
						characters.set(0, hunter);
						
						//Deleting the Prey from ArrayList if it has been captured
						characters.remove(i);
						
						//Updating the Number of Prey captured
						intPreyCaptured +=1;
						
						//Checking and updating the end of  endGame variable
						if(intPreyCaptured == 12)
						{
							endGame = true;
						}
					}

				}
			 
			 
			 //Checking is Character is Predator
			 if(characters.get(i) instanceof Predator)
			 {
				    Predator predator = (Predator) characters.get(i);
					
					//Checking if Predator did not attack the Hunter
					if(predator.getXCoordinate() == hunter.getXCoordinate() & predator.getYCoordinate() == hunter.getYCoordinate())
					{
						hunter.updateHealth(predator.getDamage());
						
						System.out.println(predator.getName() +" has ATTACKED YOU!");
						
						//Updating the Hunter variable in the ArrayList
						characters.set(0, hunter);
						
						if(hunter.getHealth() <=0)
						{
							this.endGame = true;
						}
				 
			        }
			 }
		}
		
		return characters;
		
	}
	
		
		/**
		 * Method for creating Characters
		 * @param hunterName
		 * @return character
		 */
	    public ArrayList<Charecter> createCharacters(String hunterName)
			{
				
				CharacterFactory factory = new CharacterFactory();
				
				//Creating a Hunter
				hunter =  (Hunter) factory.produceHunter(30, 30, hunterName);
				
				characters.add(hunter);
				
				//creating 5 Predators
				for(int predator =0; predator<5; predator++)
				{
					characters.add((Charecter) factory.producePredator(480, 270));
				}
				
				//Creating Preys
				for(int prey = 0; prey<4; prey++)
				{
					characters.add((Charecter) factory.producePrey(0, 540));
				}
				
				for(int prey = 0; prey<4; prey++)
				{
					characters.add((Charecter) factory.producePrey(930, 540));
				}
				
				for(int prey = 0; prey<4; prey++)
				{
					characters.add((Charecter) factory.producePrey(930, 0));
				}
				
				
				return characters;
				
			}
	   
	    
	    
	    /**
		 * Method for setting characters
		 * @param characters 
		 *                  ArrayList of Charecter
		 *                  
		 */
		public void setCharacters(ArrayList<Charecter> characters)
		{
			this.characters = characters;
			
			this.hunter = (Hunter) characters.get(0);
		}
		
		
}


