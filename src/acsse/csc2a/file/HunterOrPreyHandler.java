/**
 * 
 */
package acsse.csc2a.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import acsse.csc2a.model.Charecter;
import acsse.csc2a.model.Hunter;


/**
 * @author SN MAHLOBO
 *
 */
public class HunterOrPreyHandler {

	//Declaring variable
	private ArrayList<Charecter> charecters;
	private int numCharacters;
	
	/**
	 * Constructor
	 * 
	 */
	public HunterOrPreyHandler()
	{
		//
		this.charecters = new ArrayList<Charecter>();
	}
	
	
	/**
	 * Method for saving characters to Batch file
	 * @param characters
	 *                  ArrayList of Character
	 *                  
	 */
	public void writeToBatchFile(ArrayList<Charecter> characters)
	{
		//
		this.charecters = characters;
		
		//getting the number of characters to be written to file
		this.numCharacters = this.charecters.size();
		
		
		try (ObjectOutputStream objOut= new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("data","gameState.dat")))))
		{
			objOut.writeInt(numCharacters);
			
			//Looping through the ArrayList and storing the instance in the file
			for(Charecter character: characters)
			{
				objOut.writeObject(character);
			}
			
		}
		catch(FileNotFoundException fE)
		{
			fE.printStackTrace();
		}
		
		catch(IOException IOE)
		{
			IOE.printStackTrace();
		}
	}
	
	
	
	/**
	 * Method for reading characters from Batch file
	 * @return characters
	 *                              ArrayList of Character
	 *                              
	 */
	public ArrayList<Charecter> readFromBatchFile()
	{
		try(ObjectInputStream objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("data","gameState.dat")))))
		{
			
			//Reading the integer -> representing the number of characters in the file
			this.numCharacters = objIn.readInt();
			
			//Using for loop to get all the characters in file
			for(int c = 0 ; c< numCharacters ; c++ )
			{
				
				//
				Charecter tempCharacter = (Charecter) objIn.readObject();
			
				this.charecters.add(tempCharacter);
			}
		}
		catch(FileNotFoundException fE)
		{
	       fE.printStackTrace();
		}
		catch(IOException IOE)
		{
			IOE.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		return this.charecters;
		
	}
	
	
	
	/**
	 * /**
	 * Method for reading Hunter data from Text file
	 * @return hunter
	 *                              an instance of Hunter
	 *                              
	 */
	public void writeHunterData(Hunter hunter)
	{
		
		try(PrintWriter textOut = new PrintWriter(new File("data", "HunterData.txt")))
		{
			
			textOut.println(hunter.getPlayerID() + " " + hunter.getHealth() + " " + hunter.getScore() + " " + hunter.getXCoordinate() + " " + hunter.getYCoordinate());
		
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * /**
	 * Method for reading Hunter data from Text file
	 * @return hunter
	 *                              an instance of Hunter
	 *                              
	 */
	 public Hunter readHunterData()
	 {
		 Hunter hunter = null;
		 
	
		 try( Scanner textin = new Scanner(new File("data","HunterData.txt")))
		 {
			 //looping through text File
			 while(textin.hasNext())
			 {
				 String line = textin.nextLine();
				 
				 StringTokenizer hunterToken = new StringTokenizer(line," ");
				 
				 String hunterID = hunterToken.nextToken();
				 Integer health = Integer.parseInt(hunterToken.nextToken());
				 Integer score  = Integer.parseInt(hunterToken.nextToken());
				 Integer xCoordinate = Integer.parseInt(hunterToken.nextToken());
				 Integer yCoordinate = Integer.parseInt(hunterToken.nextToken());
				 
				 
				 hunter = new Hunter( xCoordinate, yCoordinate, hunterID);
				 
				 hunter.setScore(score);
				 hunter.setHealth(health);
				 
				 
			 }
			 
			 
		 }
		 catch(FileNotFoundException e)
		 {
			 e.printStackTrace();
		 }
				
		 
		 return hunter;
	 }
}
