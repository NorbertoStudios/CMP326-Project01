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
		
		String dashes = "------------------------------------------------";
		String newLine = "\n";
		
		System.out.println();
		System.out.println(dashes);
		
		//log.fileOutput(dashes);
		log.appendStrToFile(dashes+newLine);
		
		System.out.println("Battle begins: " + player.getName() + " vs " + monster.getName());
		
		log.appendStrToFile("Battle begins: " + player.getName() + " vs " + monster.getName()+newLine);
		//log.fileOutput(dashes);
		
		while(player.isAlive())
		{
			// Players turn
			System.out.println();
			System.out.println(dashes);
			log.appendStrToFile(dashes+newLine);
			
		System.out.println("Player turn: " + player.getName() +" has " +player.getHitPoints() +" hitPoints" 
		+ " and " + monster.getName() + " has "+ monster.getHitPoints() +" hitPoints");
		
		log.appendStrToFile("Player turn: " + player.getName() +" has " +player.getHitPoints() +" hitPoints" 
		+ " and " + monster.getName() + " has "+ monster.getHitPoints() +" hitPoints"+newLine);
		
		System.out.println(dashes);
		log.appendStrToFile(dashes+newLine);
		
			System.out.println("Do you want to Attack or Heal? Press A to attack or H for heal");
			log.appendStrToFile("Do you want to Attack or Heal? Press A to attack or H for heal" + newLine);
			
			String a = in.next();
			
			if(a.equals("a") || a.equals("A"))
			{
				System.out.println(dashes);
				player.attack(monster);
				
				if(monster.isAlive() )
				{
					System.out.println("Monster: "+monster.getName()+" = "+monster.getHitPoints()+" hitPoints" 
											+"\n"+ "Player: "+player.getName()+" = "+player.getHitPoints()+" hitPoints");
					log.appendStrToFile(dashes+newLine+"Monster: "+monster.getName()+" = "+monster.getHitPoints()+" hitPoints" 
											+"\n"+ "Player: "+player.getName()+" = "+player.getHitPoints()+" hitPoints"+newLine);
					System.out.println(dashes);
					System.out.println("Monster turn: " + monster.getName() +" has " +monster.getHitPoints() 
											+ " and " + player.getName() + " has "+ player.getHitPoints() +" hitPoints");
					System.out.println(dashes);
					log.appendStrToFile(dashes+newLine+"Monster turn: " + monster.getName() +" has " +monster.getHitPoints() 
					+ " and " + player.getName() + " has "+ player.getHitPoints() +" hitPoints"+newLine+dashes+newLine);
					
					// if is true run it but if its already true skip
					if(monster.canEnrage())
					{
						
							monster.enrage();
							
							monster.attack(player);
							System.out.println("Monster: "+monster.getName()+" = "+monster.getHitPoints()+" hitPoints" 
												+"\n"+ "Player: "+player.getName()+" = "+player.getHitPoints()+" hitPoints");
						
						
					}
					else
					{
						monster.attack(player);
						System.out.println("Monster: "+monster.getName()+" = "+monster.getHitPoints()+" hitPoints" 
											+"\n"+ "Player: "+player.getName()+" = "+player.getHitPoints()+" hitPoints");
						
					}
					
					
				}
				else
				{break;}
				
				
			}
			else if(a.equals("h") || a.equals("H"))
			{
				System.out.println(dashes);
				player.heal();
				System.out.println("Monster: "+monster.getName()+" = "+monster.getHitPoints()+" hitPoints" 
										+"\n"+ "Player: "+player.getName()+" = "+player.getHitPoints()+" hitPoints");
				log.appendStrToFile(dashes+newLine+"Monster: "+monster.getName()+" = "+monster.getHitPoints()+" hitPoints" 
						+"\n"+ "Player: "+player.getName()+" = "+player.getHitPoints()+" hitPoints"+newLine);
				if(monster.isAlive() )
				{
					System.out.println(dashes);
					System.out.println("Monster turn: " + monster.getName() +" has " +monster.getHitPoints() 
											+ " and " + player.getName() + " has "+ player.getHitPoints() +" hitPoints");
					log.appendStrToFile(dashes+newLine+"Monster turn: " + monster.getName() +" has " +monster.getHitPoints() 
					+ " and " + player.getName() + " has "+ player.getHitPoints() +" hitPoints"+newLine+dashes+newLine);
					System.out.println(dashes);
					if(monster.canEnrage())
					{
						monster.attack(player);
						System.out.println("Monster: "+monster.getName()+" = "+monster.getHitPoints()+" hitPoints" 
											+"\n"+ "Player: "+player.getName()+" = "+player.getHitPoints()+" hitPoints");
					}
					else
					{
						monster.attack(player);
						System.out.println("Monster: "+monster.getName()+" = "+monster.getHitPoints()+" hitPoints" 
											+"\n"+ "Player: "+player.getName()+" = "+player.getHitPoints()+" hitPoints");
						
						
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
				log.appendStrToFile("\nWARNING\n!!!!!!Wrong character, Please try again!!!!!"+newLine);
			}
			
		}
		// Monster turns
		
		
		
	}
	

}
