public class Item
{
    private String name;
    private String itemType;

    private int damage;
    private int healAmount;

    private ItemType type;


    public enum ItemType
    {
        WEAPON,
        CONSUMABLE;
    }

    public Item(String name, ItemType type, int damage, int healAmount) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.healAmount = healAmount;
    }

    public void printItemStats()
    {
        if (type == ItemType.WEAPON) {
            System.out.println(name);
            System.out.println(type);
            System.out.println(damage);
        }
        else
        {
            //implement later
        }
    }

}
