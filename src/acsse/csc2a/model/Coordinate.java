/**
 * 
 */
package acsse.csc2a.model;

/**
 * @author SN MAHLOBO
 *
 */
public class Coordinate implements java.io.Serializable{

	//Declaring variables
	private Integer xCoordinate;
	private Integer yCoordinate;
	
	/**
	 * Constructor
	 * 
	 */
	public Coordinate(Integer xPosition, Integer yPosition)
	{
		//Initialising Coordinate
		this.xCoordinate = xPosition;
		this.yCoordinate = yPosition;
		
	}
	
	/**
	 * Method to get xCoordiate
	 * @return xCoordinate
	 * 
	 */
	public Integer getXCoordinate()
	{
		return this.xCoordinate;
	}
	
	/**
	 * Method to get yCoordiate
	 * @return yCoordinate
	 * 
	 */
	public Integer getYCoordinate()
	{
		return this.yCoordinate;
	}
	
	
	
	
	/**
	 * Method to set yCoordiate
	 * @param yCoordinate
	 * 
	 */
	public void setYCoordinate(Integer yPosition)
	{
		this.yCoordinate = yPosition;
	}
	
	
	/**
	 * Method to set xCoordiate
	 * @param xCoordinate
	 * 
	 */
	public void setXCoordinate(Integer xPosition)
	{
		this.xCoordinate = xPosition;
	}
}
