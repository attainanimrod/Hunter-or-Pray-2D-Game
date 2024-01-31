/**
 * 
 */
package acsse.csc2a.model;

import acsse.csc2a.pattern.CharacterProduct;
import acsse.csc2a.pattern.IDrawGameVisior;
import acsse.csc2a.pattern.IDrawableGame;

/**
 * @author SN MAHLOBO
 *
 */
@SuppressWarnings("serial")
public class Hunter extends Charecter implements CharacterProduct, IDrawableGame{

	//Declaring Attributes
	private String playerID;
	private Integer health;
	private Integer score;
	/**
	 * Constructor
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param playerID
	 */
	public Hunter(Integer xCoordinate, Integer yCoordinate, String playerID) {
		
		//Calling Abstract or Super Class
		super(xCoordinate, yCoordinate);
		
		//Setting PLayerID
		this.playerID = playerID;
		
		this.score = 0;
		
		this.health =100;
	}
	
	
	/**
	 * Method getting PlayerID
	 * @return playerID
	 * 
	 */
	public String getPlayerID()
	{
		return this.playerID;
	}

	
	/**
	 * Method getting health
	 * @return health
	 * 
	 */
	public Integer getHealth()
	{
		return this.health;
	}
	
	
	/**
	 * Method getting score
	 * @return score
	 * 
	 */
	public Integer getScore()
	{
		return this.score;
	}
	
	
	
	
	/**
	 * Method setting PlayerID
	 *@param playerID
	 * 
	 */
	public void setPlayerID(String playerID)
	{
		this.playerID = playerID;
	}
	
	
	/**
	 * Method setting health
	 *@param health
	 * 
	 */
	public void setHealth(Integer health)
	{
		this.health = health;
	}
	
	
	/**
	 * Method setting score
	 *@param score
	 * 
	 */
	public void setScore(Integer score)
	{
		this.score = score;
	}
	
	/**
	 * Method for updating health
	 *@param damage
	 *             damage value of a Predator
	 * 
	 */
	public void updateHealth(Integer damage)
	{
		this.health = this.health - damage;
	}
	
	/**
	 * Method updating score
	 *@param points
	 *             The amount of points a Prey has
	 * 
	 */
	public void updateScore(Integer points)
	{
		this.score += points;
	}
	
	
	
	
	@Override
	public void move()
	{
		//super.move();
	}

	@Override
	public void description()
	{
		System.out.println();
	}


	@Override
	public void accept(IDrawGameVisior visitor) 
	{
		visitor.visit(this);
	}
}
