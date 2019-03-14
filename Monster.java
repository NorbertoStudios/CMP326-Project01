// Created 03/06/2019
// Any modifications or add-ons will be created on a separate package

package game00;

public class Monster extends Creature
{
	
	private boolean isEnraged;
	private int enrageThreshold;
	
	public Monster(String name, String description, int hitPoint, int damage, int enrageThreshold) {
		super(name, description, hitPoint, damage);
		this.enrageThreshold = enrageThreshold;
		this.isEnraged = false;
		
	}
	
	public boolean canEnrage()   /// this will return true if Mosnter hitPoints falls below the threshold
	{
		if(this.getHitPoints() < enrageThreshold)
		{
			return true;
		}
		return false;
	}
	
	public void enrage()  // this method will double the damage
	{
			System.out.println("The Monster is enrage!! his attacks are now double");
			this.setDamage(getDamage()* 2);
		
	}
	

}
