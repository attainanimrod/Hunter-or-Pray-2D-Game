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
public class Predator extends Charecter implements CharacterProduct, IDrawableGame{
	//Declaring attributes
	private Integer damage;
	private ANIMAL_NAME name;
	
	
	
	/**
	 * Constructor
	 * @param canvasHeight
	 * @param canvasWedht
	 * @param name
	 * 
	 */
	public Predator(Integer xCoordinate, Integer yCoordinate)
	{
		super(xCoordinate, yCoordinate);
		
		
		//Setting name of Prey
		Random random = new Random();
				
		Integer animal = random.nextInt(1,4);
				
		if(animal==1)
		{
			this.name = ANIMAL_NAME.LION;
		}
		else if(animal==2)
		{
			this.name = ANIMAL_NAME.CHEETAH;
		}
		else if(animal==3)
		{
			this.name = ANIMAL_NAME.WOLVE;
		}
				
				
		//Setting Damage
		switch(this.name)
		{
		 case LION:
			
			this.damage = 40;
			break;
			
		 case CHEETAH:
			 
			 this.damage = 25;
			 break;
			 
		 case WOLVE:
			 
			 this.damage = 20;
			 break;
			 
		 default:
				
				System.out.println("ERROR in allocating DAMAGE for PREDATOR");
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
	 * Method to get damage
	 * @return damage
	 * 
	 */
	public Integer getDamage()
	{
		return this.damage;
	}
	
	
	
@Override
public void description()
{
	System.out.println("You are being attacked by a " + this.name );
}




@Override
public void accept(IDrawGameVisior visitor) 
{
	visitor.visit(this);
}
}
