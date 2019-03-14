// Created 03/06/2019
// Any modifications or add-ons will be created on a separate package

package game00;

public class Creature 
{
	private String name;
	private String description;
	private int hitPoints;
	private int damage;
	private Room room;
	
	//// Constructor 
	
	public Creature(String name, String description, int hitPoint, int damage)
	{
		this.name = name;
		this.description = description;
		this.hitPoints = hitPoint;
		this.damage = damage;
		room = null;
	}
	
	/// Getters 
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getHitPoints()
	{
		return hitPoints;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public Room getRoom()
	{
		return room;
	}
	
	
	/// Setters
	
	public void setHitPoints(int a)
	{
		hitPoints = a;
	}
	
	public void setDamage(int a)
	{
		damage = a;
	}
	
	public void setRoom(Room a)
	{
		room = a;
	}
	
	// // functions
	
	public void attack(Creature creature)
	{
		
		System.out.println(this.name + " attacks target "+creature.name +", dealing damage " + this.damage);
		creature.takeDamage(damage);
	}
	
	public boolean isAlive()     // is true only when the creature has positive hitPoints (Meaning Health)
	{
		if(hitPoints >= 1)
		{
			return true;
		}
		
		return false;
	}
	
	public void takeDamage(int damage)   // Subtract the hitPoints (can not go below zero
	{
		if(hitPoints > 0)
		{
			hitPoints -= damage;
			if(hitPoints <= 0)
			{
				hitPoints = 0;
			}
		}
		else 
		{
			hitPoints = 0;
		}
	}
	
	public String toString()
	{
		
		String str = String.format("Name: %10s, \nDescription: %20s, hitPoints: %03d, Damage: %02d", 
				name, description, hitPoints, damage);
		return str;
	}

}

















