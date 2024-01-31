/**
 * 
 */
package acsse.csc2a.model;

import java.util.Random;

import acsse.csc2a.pattern.CharacterProduct;
import acsse.csc2a.pattern.IDrawGameVisior;
import acsse.csc2a.pattern.IDrawableGame;

/**
 * @author SN MAHLOBO
 *
 */
@SuppressWarnings("serial")
public class Prey extends Charecter implements CharacterProduct, IDrawableGame{
	//Declaring attributes
	private Boolean captured;
	private Integer points;
	private ANIMAL_NAME name;

	
	
	/**
	 * Constructor
	 * @param xCoordinate
	 * @param yCoordinate
	 * 
	 */
	public Prey(Integer xCoordinate, Integer yCoordinate)
	{
		//calling Super Class
		super(xCoordinate, yCoordinate);
		
		//Setting capture to be False (Prey is not captured yet)
		this.captured = false;
		
		//Setting name of Prey
		Random random = new Random();
		
		Integer animal = random.nextInt(1,4);
		
		if(animal==1)
		{
			this.name = ANIMAL_NAME.SPRINGBOK;
		}
		else if(animal==2)
		{
			this.name = ANIMAL_NAME.RABBIT;
		}
		else if(animal==3)
		{
			this.name = ANIMAL_NAME.ZEBRA;
		}
		
		
		//Setting points for Prey
		switch (this.name)
		{
		
		case ZEBRA:
			
			this.points = 35;
			break;
		
		case RABBIT:
			
			this.points = 20;
		    break;
		    
		case SPRINGBOK:
			
			this.points = 50;
			break;
			
			default:
				
				System.out.println("ERROR in allocating POINTS for Prey ");
				
		}

	}
	
	/**
	 * Method to get name
	 * @return name
	 * 
	 */
	public ANIMAL_NAME getName()
	{
		return this.name;
	}
	
	
	
	/**
	 * Method to get points
	 * @return point
	 * 
	 */
	public Integer getPoints()
	{
		return this.points;
	}
	
	
	/**
	 * Method to get captured
	 * @return captured
	 * 
	 */
	public Boolean getCaptured()
	{
		return this.captured;
	}
	
	
	

	
	/**
	 * Method to set captured
	 * @param captured
	 * 
	 */
	public void setCaptured(Boolean captured)
	{
		this.captured = captured;
	}
	
	
	@Override
	public void description()
	{
		System.out.println("You have captured: " + this.name + " and gained "+ this.points + " points!");
	}

	@Override
	public void accept(IDrawGameVisior visitor) 
	{
		visitor.visit(this);
	}
}
