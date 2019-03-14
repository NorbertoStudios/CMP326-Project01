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
	}
	
	public boolean isComplete()   // return true if monster is dead
	{
		if(!monster.isAlive())
		{
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
