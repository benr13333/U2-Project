import java.util.ArrayList;

public class Inventory
{

    private ArrayList<Item> inventory = new ArrayList<>();

    public void addItem(Item addition)
    {
        inventory.add(addition);
    }

    public void printInventory()
    {
        for(int i = 0; i <= inventory.size() - 1; i++)
        {
            inventory.get(i).printItemStats();
        }
    }


}
