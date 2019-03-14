// Created 03/06/2019
// Any modifications or add-ons will be created on a separate package

package game00;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game 
{
	private Player player;
	private Room[] dungeon;
	
	public Game()
	{
		//player = new Player("Hero", "strong and dependable", 100, 20, 30); // test code this will be a file read from text File
		
		Scanner x = null;
		
		String name ="", description = "", de = "";
		int health =0,attack =0,heal =0, thres = 0, index = 0;
		
		try
		{
			x = new Scanner(new File("Player.txt"));
			
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
		Monster monster1 = null;
		Monster monster2 = null;
		Monster monster3 = null;
		
		try
		{
			x = new Scanner(new File("Monster.txt"));
				
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
		
		try
		{
			x = new Scanner(new File("Rooms.txt"));
			
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
		
		//Monster monster1 = new Monster("Orc", "covered with green blood", 20, 5, 0); // test code

	//	Monster monster2 = new Monster("Skeleton", "funny how it moves", 40, 10, 10); // test code

	//	Monster monster3 = new Monster("Fire dragon", "spout fire with each breath", 100, 20, 40); // test code
		
		
		//dungeon[0] = new Room(1, "a room with an unbearable smell", monster1); // test code
		
	//	dungeon[1] = new Room(2, "dark and cold", monster2); // test code
		
		//dungeon[2] = new TreasureRoom(3, "a giant hall with something shiny on the other end", monster3, "a large pile of gold"); // test code
		
		
		/*
		Create monster1 with name="Orc", description="covered with green blood", hitPoints=20, damage=5, enrageThreshold=0.
				Create room1 with monster1 and description="a room with an unbearable smell".
				Create monster2 with name="Skeleton", description="funny how it moves", hitPoints=40, damage=10, enrageThreshold=10.
				Create room2 with monster2 and description="dark and cold".
				Create monster3 with name="Fire dragon", description="spout fire with each breath", hitPoints=100, damage=20, enrangeThreshold=40.
				Create a TreasureRoom room3 with monster3 and description="a giant hall with something shiny on the other end", and treasure="a large pile of gold".
				Add room1, room2, and room3 to this.dungeon
		*/
		
		
	}
	
	public void play()
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
				System.out.println("Player Dead! "+ player.getName() + "\nIn Room "+ dungeon[i].toString() +"\nGame Over");
			}
		}
		
		
		

		/*
		if(player.isAlive() && dungeon[0].isComplete())
		{
			System.out.println("------------------------------------------------");
			System.out.println("Monster killed - Level Completed");
			System.out.println("------------------------------------------------");
			System.out.println("Player Enter next Room");
			System.out.println("------------------------------------------------");
			dungeon[1].enter(player);
			
		
			if(player.isAlive() && dungeon[1].isComplete())
			{
				System.out.println("------------------------------------------------");
				System.out.println("Monster killed - Level Completed");
				System.out.println("------------------------------------------------");
				System.out.println("Player Enter next Room");
				System.out.println("------------------------------------------------");
				dungeon[2].enter(player);
		
				if(player.isAlive() && dungeon[2].isComplete())
				{
					System.out.println("------------------------------------------------");
					System.out.println("Monster killed - Level Completed");
					System.out.println("------------------------------------------------");
					dungeon[2].enter(player);
					System.out.println("------------------------------------------------");
					System.out.println("Congratulations!! \nYou beat the game!!");
				}
				else
				{
					System.out.println("Player Dead!\nGame Over");
				}
			}
			else 
			{
				System.out.println("Player Dead!\nGame Over");
			}
		}
		else 
		{
			System.out.println("Player Dead!\nGame Over");
		}
		*/
		
	}
	
	public static void main(String[] arg)
	{
		
		Game gameStart = new Game();
		gameStart.play();
		
		
	}

}
