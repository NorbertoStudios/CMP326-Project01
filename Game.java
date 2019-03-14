// Created 03/06/2019
// Any modifications or add-ons will be created on a separate package

package game00;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Instant;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Game 
{
	private Player player;
	private Room[] dungeon;
	
	//Additions
	PrintWriter outStream = null;
	private static final String PATH_TO_FILE = "src/game00/file/";
	
	public Game()
	{

		Scanner x = null;
		
		// Accessing the player
		
		String name ="", description = "", de = "";
		int health =0,attack =0,heal =0, thres = 0, index = 0;
		
		try
		{
			x = new Scanner(new File(PATH_TO_FILE +"Player.txt"));
			
				name = x.nextLine();
				description = x.nextLine();
		
				health = x.nextInt();
				attack = x.nextInt();
				heal = x.nextInt();
				
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File Not Found!");
		}
		finally
		{
			if(x != null)
			{
				x.close();
			}
		}
		
		player = new Player(name, description,health,attack,heal);
		
		dungeon = new Room[3];
		
		// Creating the monster place holders
		
		Monster monster1 = null;
		Monster monster2 = null;
		Monster monster3 = null;
		
		try
		{
			x = new Scanner(new File(PATH_TO_FILE +"Monster.txt"));
				
			monster1 = new Monster(name = x.nextLine(), description = x.nextLine(), health = x.nextInt(), attack = x.nextInt(), thres = x.nextInt());
			x.nextLine();
			x.nextLine();
			monster2 = new Monster(name = x.nextLine(), description = x.nextLine(), health = x.nextInt(), attack = x.nextInt(), thres = x.nextInt());
			x.nextLine();
			x.nextLine();
			monster3 = new Monster(name = x.nextLine(), description = x.nextLine(), health = x.nextInt(), attack = x.nextInt(), thres = x.nextInt());
			
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File Not Found!");
		}
		finally
		{
			if(x != null)
			{
				x.close();
			}
		}
		////// Adding it to Room[]
		try
		{
			x = new Scanner(new File(PATH_TO_FILE + "Rooms.txt"));
			
			index = x.nextInt();
			x.nextLine();
			description = x.nextLine();
			dungeon[0] = new Room(index, description, monster1);
			
			x.nextLine();
			
			index = x.nextInt();
			x.nextLine();
			description = x.nextLine();
			dungeon[1] = new Room(index, description, monster2);
			
			x.nextLine();
			
			index = x.nextInt();
			x.nextLine();
			description = x.nextLine();
			name = x.nextLine();
			dungeon[2] = new TreasureRoom(index, description, monster3, name);
			
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File Not Found!");
		}
		finally
		{
			if(x != null)
			{
				x.close();
			}
		}
		
	}
	
	public void play()
	{
		// Creating the file to stored the logs
	//	createFile();
		
        // ++++++++ Game Start +++++++++++
		gameStarted();
		
	}
	
	
	public void fileOutput(String str)
	{
		//createFile();
		outStream.print(str);
		outStream.flush();
		
		if(dungeon[dungeon.length-1].isComplete() || !player.isAlive())
		{
			outStream.close();
		}
		
	}
	
	public String test()
	{
		String str = null;
		
		System.out.println("ONE");
		
		// Storing the output to consoleStorage
		ByteArrayOutputStream consoleStorage = new ByteArrayOutputStream();
		
		PrintStream newConsole = System.out;
		
		System.setOut(new PrintStream(consoleStorage));
		
		//Here all system.out.println() calls will be store in consoleStorage
		System.out.println("TWO");
		
		newConsole.println(consoleStorage.toString());
		
		System.setOut(newConsole);
		
		return str = consoleStorage.toString();
	}
	
	public void appendStrToFile(String str) 
	{ 
		// get the calendar and date and time 
		Calendar cal = Calendar.getInstance();
        cal.setTime(Date.from(Instant.now()));
        // format the srting to print date and time in file plus the name
        String gameLog = String.format(
                "GameLog-%1$tY-%1$tm-%1$td-%1$tk-%1$tS-%1$tp.txt", cal);
		
		try { 

			// Open given file in append mode. 
			BufferedWriter out = new BufferedWriter( 
					new FileWriter(PATH_TO_FILE +"Logs/"+ gameLog, true)); 
			out.write(str); 
			out.close(); 
		} 
		catch (IOException e) { 
			System.out.println("exception occoured" + e); 
		} 
	} 
	
	public void createFile()
	{
		// get the calendar and date and time 
				Calendar cal = Calendar.getInstance();
		        cal.setTime(Date.from(Instant.now()));
		        // format the srting to print date and time in file plus the name
		        String gameLog = String.format(
		                "GameLog-%1$tY-%1$tm-%1$td-%1$tk-%1$tS-%1$tp.txt", cal);
		        
				// Create a file game log and wrtie to it
		        
				try
				{
					outStream = new PrintWriter(PATH_TO_FILE +"Logs/"+ gameLog);
				
				}
				catch(FileNotFoundException e)
				{
					System.out.println("Could not create " + e);
					System.err.println("the messange was " + e.getMessage());
					//e.printStackTrace();
				}
				
	}
	
	public void gameStarted()
	{
		dungeon[0].enter(player);
		for(int i = 0; i < dungeon.length; i++)
		{
			if(player.isAlive() && dungeon[i].isComplete())
			{
				
				if(i == dungeon.length - 1)
				{
					System.out.println("------------------------------------------------");
					System.out.println("Monster killed - Level Completed");
					System.out.println("------------------------------------------------");
					
					dungeon[dungeon.length-1].enter(player);
					
					System.out.println("------------------------------------------------");
					System.out.println("Congratulations!! \nYou beat the game!!");
					
				}
				else
				{
					System.out.println("************************************************");
					System.out.println("------------------------------------------------");
					System.out.println("Monster killed - Level Completed");
					System.out.println("------------------------------------------------");
					System.out.println("Player Enter next Room");
					System.out.println("------------------------------------------------");
					
					dungeon[i + 1].enter(player);
				}
			}
			else
			{
				System.out.println("Player Dead! "+ player.getName() + " Dies young" + "\nIn "+ dungeon[i].toString() +"\nGame Over");
				break;
			}
		}
		
	}
	
	public static void main(String[] arg)
	{
		
		Game gameStart = new Game();
		gameStart.play();
		
		
	}

}
