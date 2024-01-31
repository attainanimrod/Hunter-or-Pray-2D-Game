/**
 * 
 */
package acsse.csc2a.model;

import java.util.Random;

import acsse.csc2a.pattern.IDrawGameVisior;
import acsse.csc2a.pattern.IDrawableGame;


/**
 * @author SN MAHLOBO
 *
 */


public abstract class Charecter implements java.io.Serializable, IDrawableGame{
	
	//private variables
	protected Coordinate coordinate;
	private Integer canvasHeight = 576;
	private Integer canvasWidth = 960;
	
	/**
	 * Constructor
	 * @param xCoordinate
	 * @param yCoordinate
	 * 
	 */
	public Charecter(Integer xCoordinate, Integer yCoordinate)
	{
		
		coordinate = new Coordinate(xCoordinate, yCoordinate);
		
	}
	
	
	
	/**
	 * Method returns xCoordinate of the Character
	 * @return xCoordinate
	 * 
	 */
	public Integer getXCoordinate()
	{
		return this.coordinate.getXCoordinate();
	}
	
	
	/**
	 * Method returns yCoordinate of the Character
	 * @return yCoordinate
	 * 
	 */
	public Integer getYCoordinate()
	{
		return this.coordinate.getYCoordinate();
	}
	
	
	/**
	 * Method sets the xCoorinate of the Character
	 * @param xCoordinate
	 * 
	 */
	public void setXCoordinate(Integer xPosition)
	{
		this.coordinate.setXCoordinate(xPosition);
	}
	
	
	/**
	 * Method sets the yCoorinate of the Character
	 * @param yCoordinate
	 * 
	 */
	public void setYCoordinate(Integer yPosition)
	{
		this.coordinate.setYCoordinate(yPosition);
	}
	

	
	
	/**
	 * Abstract Method
	 * 
	 */
	public void move()
	{
		
		Random random = new Random();
		
		Integer xPosition = coordinate.getXCoordinate() + random.nextInt(-1, 2) *30;
		
		
		//Updating the Character Position
		if(xPosition>=0 && xPosition <= canvasWidth)
		{
			this.coordinate.setXCoordinate(xPosition);
		}
		
		Integer yPosition = coordinate.getYCoordinate() + random.nextInt(-1,2) *30;
		
		if(yPosition >=0 &&  yPosition <= canvasHeight)
		{
			this.coordinate.setYCoordinate(yPosition);
		}
		
		
	}
	
	@Override
	public void accept(IDrawGameVisior visitor) 
	{
		
	}
	
}
