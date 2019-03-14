// Created 03/06/2019
// Any modifications or add-ons will be created on a separate package

package game00;

public class Room 
{
	private int roomIndex;
	private String description;
	private Monster monster;
	
	public Room(int roomIndex, String description, Monster monster)
	{
		this.roomIndex = roomIndex;
		this.description = description;
		this.monster = monster;
	}
	
	public void enter(Player player)
	{
		System.out.println("Player name: "+ player.getName()
				+ "\nThis Room is " + this.description + ", \nand has Monster " + this.monster);
		Battle begins = new Battle(player, monster);
		begins.run();
		isComplete();
	}
	
	public boolean isComplete()   // return true if monster is dead
	{
		if(!monster.isAlive())
		{
			System.out.println("Monster killed - Level Completed");
			System.out.println("------------------------------------------------");
			if(roomIndex < 3)
			{
				System.out.println("Player Enter next Room");
				System.out.println("------------------------------------------------");
			}
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		String str = String.format("Room index %2d, decription %20s, monster name %20s", roomIndex, description, monster.getName());
		return str;
	}

}
