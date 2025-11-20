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


    //override the Object.toString class so that I can just print the string in Inventory and not get some weird hash
    @Override
    public String toString()
    {
        if (type == ItemType.WEAPON)
        {
            return String.format("Name: %s, Damage: %d", name, damage);
        }
        else if (type == ItemType.CONSUMABLE)
        {
            return String.format("Name: %s, Heal: %d", name, healAmount);
        }
        else
        {
            return name;
        }
    }

    public ItemType getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }



    /*
    Deprecated to adhere to OOP standards
    public void printWeaponList() {
        if (type == ItemType.WEAPON) {
            System.out.println("Name: " + name);
            System.out.println("Damage: " + damage);
        }
    }
    public void printPotionList() {
        if (type == ItemType.CONSUMABLE) {
            System.out.println("Name: " + name);
            System.out.println("Status Change" + healAmount);
        }
    }

     */

    /*
    Deprecated
    public void printItemStats()
    {
        if (type == ItemType.WEAPON) {
            System.out.println(name);
            System.out.println(type);
            System.out.println(damage);
        }
        else if (type == ItemType.CONSUMABLE)
        {
            System.out.println(name);
            System.out.println(type);
            System.out.println(healAmount);
        }
    }

     */

}
