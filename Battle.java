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
		System.out.println("------------------------------------------------");
		System.out.println("Battle begins: " + player.getName() + " vs " + monster.getName());
		
		while(player.isAlive())
		{
			// Players turn
			System.out.println("------------------------------------------------");
			
		System.out.println("Player turn: " + player.getName() +" has " +player.getHitPoints() +" hitPoints" 
		+ " and " + monster.getName() + " has "+ monster.getHitPoints() +" hitPoints");
		
		System.out.println("------------------------------------------------");
		
			System.out.println("Do you want to Attack or Heal? Press A to attack or H for heal");
			
			String a = in.next();
			if(a.equals("a") || a.equals("A"))
			{
				System.out.println("------------------------------------------------");
				player.attack(monster);
				if(monster.isAlive() )
				{
					System.out.println("Monster "+monster.getHitPoints());
					System.out.println("Player "+player.getHitPoints());
					System.out.println("------------------------------------------------");
					System.out.println("Monster turn: " + monster.getName() +" has " +monster.getHitPoints() 
					+ " and " + player.getName() + " has "+ player.getHitPoints() +" hitPoints");
					System.out.println("------------------------------------------------");
					
					if(monster.canEnrage())
					{
						monster.enrage();
						monster.attack(player);
						System.out.println("Monster "+monster.getHitPoints());
						System.out.println("Player "+player.getHitPoints());
						
					}
					else
					{
						monster.attack(player);
						System.out.println("Monster "+monster.getHitPoints());
						System.out.println("Player "+player.getHitPoints());
						
					}
					
					
				}
				else
				{break;}
				
				
			}
			else if(a.equals("h") || a.equals("H"))
			{
				System.out.println("------------------------------------------------");
				player.heal();
				System.out.println("Monster "+monster.getHitPoints());
				System.out.println("Player "+player.getHitPoints());
				if(monster.isAlive() )
				{
					System.out.println("------------------------------------------------");
					System.out.println("Monster turn: " + monster.getName() +" has " +monster.getHitPoints() 
					+ " and " + player.getName() + " has "+ player.getHitPoints() +" hitPoints");
					System.out.println("------------------------------------------------");
					if(monster.canEnrage())
					{
						monster.attack(player);
						System.out.println("Monster "+monster.getHitPoints());
						System.out.println("Player "+player.getHitPoints());
						
					}
					else
					{
						monster.attack(player);
					System.out.println("Monster "+monster.getHitPoints());
					System.out.println("Player "+player.getHitPoints());
						
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
