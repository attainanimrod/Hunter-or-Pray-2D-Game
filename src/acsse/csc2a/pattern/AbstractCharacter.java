/**
 * 
 */
package acsse.csc2a.pattern;


/**
 * @author SN MAHLOBO
 *
 */
public abstract interface AbstractCharacter {
	
	
	
	/**
	 * Method for Creating a Hunter
	 * @param xCoordinate
	 *                   x-position of the Hunter
	 *@param yCoordinate                   
	 *                   y-position of the Hunter
	 *@param hunterID
	 *                   ID or name of the Hunter
	 *                   
	 */
	public abstract CharacterProduct produceHunter(Integer xCoordinate, Integer yCoordinate, String hunterID);
	
	
	
	/**
	 * Method for Creating a Prey
	 * @param xCoordinate
	 *                   x-position of the Prey
	 *@param yCoordinate                   
	 *                   y-position of the Prey
	 *                   
	 */
	public abstract CharacterProduct producePrey(Integer xCoordinate, Integer yCoordinate);

	
	
	/**
	 * Method for Creating a Predator
	 * @param xCoordinate
	 *                   x-position of the Predator
	 *@param yCoordinate                   
	 *                   y-position of the Predator
	 *                   
	 */
	public abstract CharacterProduct producePredator(Integer xCoordinate, Integer yCoordinate);
}
