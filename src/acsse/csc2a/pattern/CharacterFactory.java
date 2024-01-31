/**
 * 
 */
package acsse.csc2a.pattern;

import acsse.csc2a.model.Hunter;
import acsse.csc2a.model.Predator;
import acsse.csc2a.model.Prey;

/**
 * @author SN MAHLOBO
 *
 */
public class CharacterFactory implements AbstractCharacter{

	@Override
	public CharacterProduct produceHunter(Integer xCoordinate, Integer yCoordinate, String hunterID) {
		
		//creating new instance of Hunter
		Hunter hunter = new Hunter(xCoordinate, yCoordinate, hunterID);
		
		return hunter;
	}

	@Override
	public CharacterProduct producePrey(Integer xCoordinate, Integer yCoordinate) {
		
		//Creating new Instance of Prey
		Prey prey = new Prey(xCoordinate, yCoordinate);
		
		return prey;
	}

	@Override
	public CharacterProduct producePredator(Integer xCoordinate, Integer yCoordinate) {
		
		//Creating new Instance of Predator
		Predator predator = new Predator(xCoordinate, yCoordinate);
		
		return predator;
	}
	
	

}
