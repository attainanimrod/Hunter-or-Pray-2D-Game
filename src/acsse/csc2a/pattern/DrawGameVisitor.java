/**
 * 
 */
package acsse.csc2a.pattern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import acsse.csc2a.model.ANIMAL_NAME;
import acsse.csc2a.model.Hunter;
import acsse.csc2a.model.Predator;
import acsse.csc2a.model.Prey;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @author SN MAHLOBO
 *
 */
public class DrawGameVisitor implements IDrawGameVisior{

	//Final variable
	private final int ICONHEIGHT = 30;
	private final int ICONWEDTH = 30;
	
	//Declaring GraphicsContext
	private GraphicsContext gc;
		
		/**
		 * Constructor
		 * 
		 */
		public DrawGameVisitor()
		{
			gc = null;
		}
		
		/**
		 * Method for setting GraphicsContext
		 * @param gc
		 *          GraphicsContext
		 *          
		 */
		public void setGraphicsContext(GraphicsContext gc)
		{
			this.gc = gc;
		}
		
		
	@Override
	public void visit(Hunter hunter) {
		
		

		Image image = null;
		try {
			
			image = new Image(Files.newInputStream(Paths.get("animation/Hunter.png")));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		gc.drawImage(image, hunter.getXCoordinate(), hunter.getYCoordinate(), ICONWEDTH, ICONHEIGHT);
		

		
		
	}

	@Override
	public void visit(Predator predator) {

		
		Image image = null;

		if(predator.getName() == ANIMAL_NAME.LION)
		{
			
			try {
				
				image = new Image(Files.newInputStream(Paths.get("animation/Lion.png")));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			gc.drawImage(image, predator.getXCoordinate(), predator.getYCoordinate(), ICONHEIGHT, ICONWEDTH);
			
		}
		else if(predator.getName() == ANIMAL_NAME.CHEETAH)
		{
			
			try {
				
				image = new Image(Files.newInputStream(Paths.get("animation/Cheetah.png")));
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			gc.drawImage(image, predator.getXCoordinate(), predator.getYCoordinate(), ICONWEDTH, ICONHEIGHT);
			
		}
		else if(predator.getName() == ANIMAL_NAME.WOLVE)
		{
			
			try {
				
				image = new Image(Files.newInputStream(Paths.get("animation/Wolve.png")));
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			gc.drawImage(image, predator.getXCoordinate(), predator.getYCoordinate(), ICONWEDTH, ICONHEIGHT);
		}
		

		
		
	}

	@Override
	public void visit(Prey prey) {
	
		
		Image image = null;
		
		if(prey.getName() == ANIMAL_NAME.RABBIT)
		{
			
			try {
				
				image = new Image(Files.newInputStream(Paths.get("animation/Rabbit.png")));
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			gc.drawImage(image, prey.getXCoordinate(), prey.getYCoordinate(), ICONWEDTH, ICONHEIGHT);
			
		}
		 if(prey.getName() == ANIMAL_NAME.SPRINGBOK)
		{
			
			try {
				
				image = new Image(Files.newInputStream(Paths.get("animation/Springbok.png")));
				
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			gc.drawImage(image, prey.getXCoordinate(), prey.getYCoordinate(), ICONWEDTH, ICONHEIGHT);
			
		}
		else if(prey.getName() == ANIMAL_NAME.ZEBRA)
		{
		    try {
		    	
				image = new Image(Files.newInputStream(Paths.get("animation/Zebra.png")));
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			gc.drawImage(image, prey.getXCoordinate(), prey.getYCoordinate(), ICONWEDTH, ICONHEIGHT);
		}
		


		
	}
	
	

}
