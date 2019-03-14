// Created 03/06/2019
// Any modifications or add-ons will be created on a separate package

package game00;

import java.io.File;
import java.util.Scanner;

public class Game 
{
	private Player player;
	private Room[] dungeon;
	
	public Game()
	{
		player = new Player("Hero", "strong and dependable", 100, 20, 30); // test code this will be a file read from hdd
		dungeon = new Room[3];
		

		Monster monster1 = new Monster("Orc", "covered with green blood", 20, 5, 0); // test code

		Monster monster2 = new Monster("Skeleton", "funny how it moves", 40, 10, 10); // test code

		Monster monster3 = new Monster("Fire dragon", "spout fire with each breath", 100, 20, 40); // test code
		
		
		dungeon[0] = new Room(1, "a room with an unbearable smell", monster1); // test code
		
		dungeon[1] = new Room(2, "dark and cold", monster2); // test code
		
		dungeon[2] = new TreasureRoom(3, "a giant hall with something shiny on the other end", monster3, "a large pile of gold"); // test code
		
		dungeon[0].enter(player);
		
		if(player.isAlive() && dungeon[0].isComplete())
		{
			dungeon[1].enter(player);
		
			if(player.isAlive() && dungeon[1].isComplete())
			{
				dungeon[2].enter(player);
		
				if(player.isAlive() && dungeon[2].isComplete())
				{
					dungeon[2].enter(player);
					System.out.println("You beat the game!!");
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
		//Scanner x;
		//System.out.println(player.toString());
		//File gameLog = new File("GameLog.txt");
		//System.out.println(player.getName());
		//System.out.println(dungeon.toString());
		
		
		
	}
	
	
	public static void main(String[] arg)
	{
		//player = new Player("Hero", "strong and dependable", 100, 20, 30);
		Game gameStart = new Game();
		gameStart.play();
		
		
	}

}
