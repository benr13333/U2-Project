public class Enemy
{

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int strength;
    private int defense;

    private enemyType type;

    public enum enemyType
    {
        UNDEAD,
        GOBLIN;
    }

    public Enemy(String name, int maxHealth, int strength, int defense, enemyType type)
    {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.strength = strength;
        this.defense = defense;

        this.type = type;
    }

    public String getName()
    {
        return name;
    }
    public int getCurrentHealth()
    {
        return currentHealth;
    }
    public int getStrength()
    {
        return strength;
    }
    public int getDefense()
    {
        return defense;
    }

    public boolean isAlive()
    {
        if(currentHealth > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}