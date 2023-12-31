//package sud;
//UPDATED!

class Player extends Creature
{
	private Item [] inventory;
	int xCoor,yCoor;

	final private Equipable[] equips = new Equipable[6]; //Head, Body, Legs, Arms, Arms, Accessory Accessory
		
		//Creating a new character
		public Player(String name, int mHP, int cHP, int att, int def, int spd)
		{
			super(name, mHP, cHP, att, def, spd, 0, 1);
			inventory = new Item[5]; //will grow and shrink as necessary.
		}
		
		//Loading an old character
		public Player(String name, int mHP, int cHP, int att, int def, int spd, int exp, int lvl)
		{
			super(name, mHP, cHP, att, def, spd, exp, lvl);
			inventory = new Item[5]; //will grow and shrink as necessary.
		}
		
		public void Equip(Equipable gear)
		{
			//Waiting for input
			if(equips[gear.getSlot()] == null)
			{
				equips[gear.getSlot()] = gear;
			}
			else
			{
				//ask user if they want to replace current gear.
				//if yes, equipment trades places with inventory item
				//if no, do nothing.
				
			}
		}
		
		public Item[] getInventory()
		{
			return inventory;
		}
	
}