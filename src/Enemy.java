public class Enemy
{
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int strength;
    private int defense;
    private int level;  // Added level field

    private enemyType type;

    public enum enemyType
    {
        UNDEAD,
        GOBLIN;
    }

    // Updated constructor with level
    public Enemy(String name, int maxHealth, int strength, int defense, int level, enemyType type)
    {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.strength = strength;
        this.defense = defense;
        this.level = level;
        this.type = type;
    }

    // Getters
    public String getName()
    {
        return name;
    }
    public int getCurrentHealth()
    {
        return currentHealth;
    }
    public int getMaxHealth()
    {
        return maxHealth;
    }
    public int getStrength()
    {
        return strength;
    }
    public int getDefense()
    {
        return defense;
    }
    public int getLevel()
    {
        return level;
    }

    // Calculates how much damage enemy takes after defense reduction and variance
    public int calculateDamageTaken(int incomingDamage, int defense)
    {
        // Calculate damage reduction with diminishing returns
        double damageReduction = (double) defense / (defense + 100);

        // Apply damage reduction
        double rawDamage = incomingDamage * (1 - damageReduction);

        // Add random variance
        double variance = utils.randomDouble(0.9, 1.1);
        rawDamage *= variance;

        // Minimum damage is 1
        int finalDamage = (int) Math.max(1, Math.round(rawDamage));

        return finalDamage;
    }

    // Enemy takes damage and currentHealth is updated
    public void takeDamage(int damage)
    {
        int damageTaken = calculateDamageTaken(damage, defense);
        currentHealth -= damageTaken;
        if(currentHealth < 0)
        {
            currentHealth = 0;
        }
    }


    public boolean isAlive()
    {
        return currentHealth > 0;
    }


    public int calculateDamageDealt()
    {
        double scalingFactor = 1.5;

        // Base damage plus level scaling
        double rawDamage = strength + level * scalingFactor;

        // Apply variance
        double variance = utils.randomDouble(0.9, 1.1);
        rawDamage *= variance;

        // Minimum damage is 1
        return Math.max(1, (int) Math.round(rawDamage));
    }
}
