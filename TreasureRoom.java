// Created 03/06/2019
// Any modifications or add-ons will be created on a separate package

package game00;

public class TreasureRoom extends Room
{

	private String treasure;
	
	public TreasureRoom(int roomIndex, String description, Monster monster, String treasure) 
	{
		super(roomIndex, description, monster);
		this.treasure = treasure;
	}
	@Override
	public void enter(Player player)
	{
		if(!super.isComplete())
		{
		super.enter(player);
		}
		else if(super.isComplete())
		{
			// this should only be displayed if the monster is kill
			System.out.println("You explored the room and found the hidden treasure! \n" + treasure); 
		}
		
	}
	

}
