// Created 03/06/2019
// Any modifications or add-ons will be created on a separate package
package game00;

import java.util.Scanner;

public class Battle 
{
	private Player player;
	private Monster monster;
	
	private Scanner in = new Scanner(System.in);
	
	
	
	public Battle(Player player, Monster monster)
	{
		this.player = player;
		this.monster = monster;
	}
	
	public void run()
	{
		Game log = new Game();
		
		String playerStatus = "Player: "+player.getName()+" = "+player.getHitPoints();
		String monsterStatus = "Monster: "+monster.getName()+" = "+monster.getHitPoints();
		String dashes = "------------------------------------------------";
		String newLine = "\n";
		
		System.out.println();
		System.out.println(dashes);
		
		//log.fileOutput(dashes);
		log.appendStrToFile(dashes+newLine);
		
		System.out.println("Battle begins: " + player.getName() + " vs " + monster.getName());
		
		//log.fileOutput("Battle begins: " + player.getName() + " vs " + monster.getName());
		//log.fileOutput(dashes);
		
		while(player.isAlive())
		{
			// Players turn
			System.out.println();
			System.out.println(dashes);
			
		System.out.println("Player turn: " + player.getName() +" has " +player.getHitPoints() +" hitPoints" 
		+ " and " + monster.getName() + " has "+ monster.getHitPoints() +" hitPoints");
		
		System.out.println(dashes);
		
			System.out.println("Do you want to Attack or Heal? Press A to attack or H for heal");
			
			String a = in.next();
			if(a.equals("a") || a.equals("A"))
			{
				System.out.println(dashes);
				player.attack(monster);
				if(monster.isAlive() )
				{
					System.out.println(monsterStatus +"\n"+ playerStatus);
					System.out.println(dashes);
					System.out.println("Monster turn: " + monster.getName() +" has " +monster.getHitPoints() 
					+ " and " + player.getName() + " has "+ player.getHitPoints() +" hitPoints");
					System.out.println(dashes);
					
					if(monster.canEnrage())
					{
						monster.enrage();
						monster.attack(player);
						System.out.println(monsterStatus +"\n"+ playerStatus);
						
					}
					else
					{
						monster.attack(player);
						System.out.println(monsterStatus +"\n"+ playerStatus);
						
					}
					
					
				}
				else
				{break;}
				
				
			}
			else if(a.equals("h") || a.equals("H"))
			{
				System.out.println(dashes);
				player.heal();
				System.out.println(monsterStatus +"\n"+ playerStatus);
				if(monster.isAlive() )
				{
					System.out.println(dashes);
					System.out.println("Monster turn: " + monster.getName() +" has " +monster.getHitPoints() 
					+ " and " + player.getName() + " has "+ player.getHitPoints() +" hitPoints");
					System.out.println(dashes);
					if(monster.canEnrage())
					{
						monster.attack(player);
						System.out.println(monsterStatus +"\n"+ playerStatus);
					}
					else
					{
						monster.attack(player);
						System.out.println(monsterStatus +"\n"+ playerStatus);
						
					}
					
				}
				else
				{
					break;
				}
				
			}
			else
			{
				System.err.println("Wrong character, Please try again");
			}
			
		}
		// Monster turns
		
		
		
	}
	

}
