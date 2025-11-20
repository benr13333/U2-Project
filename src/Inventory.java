import java.util.ArrayList;

public class Inventory
{

    private ArrayList<Item> inventory = new ArrayList<>();

    public void addItem(Item addition)
    {
        inventory.add(addition);
    }

    public ArrayList<Item> printWeaponsAndReturnList() {
        ArrayList<Item> weapons = new ArrayList<>();
        int count = 1;

        for (Item item : inventory) {
            if (item.getType() == Item.ItemType.WEAPON) {
                System.out.println(count + ") " + item);
                System.out.println("----------------");
                weapons.add(item);
                count++;
            }
        }

        return weapons; // filtered weapon list
    }


    public void printWeapons()
    {
        for(int i = 0; i <= inventory.size() - 1; i++)
        {
            Item item = inventory.get(i);
            if (item.getType() == Item.ItemType.WEAPON)
            {
                System.out.println(item); // calls toString()
                System.out.println("----------------");
            }
        }
    }

    public void printPotions()
    {
        for(int i = 0; i <= inventory.size() - 1; i++)
        {
            Item item = inventory.get(i);
            if (item.getType() == Item.ItemType.CONSUMABLE)
            {
                System.out.println(item); // calls toString()
                System.out.println("----------------");
            }
        }
    }







}
