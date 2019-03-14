// Created 03/06/2019
// Any modifications or add-ons will be created on a separate package

package game00;

public class Player extends Creature
{
	private int healAmount;

	public Player(String name, String description, int hitPoint, int damage, int healAmount) {
		super(name, description, hitPoint, damage);
		this.healAmount = healAmount;
		
	}
	
	public void heal()  // this method increase hitPoints
	{
		System.out.println(this.getName() + " is healed by " + healAmount);
		this.setHitPoints(getHitPoints() + healAmount); 
	}

}
