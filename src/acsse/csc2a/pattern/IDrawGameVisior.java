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
public interface IDrawGameVisior {

	
	//
	void visit(Hunter hunter);
	void visit(Predator predator);
	void visit(Prey prey);
}
