import java.util.ArrayList;

public class Inventory
{

    private ArrayList<Item> inventory = new ArrayList<>();

    public void addItem(Item addition)
    {
        inventory.add(addition);
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
