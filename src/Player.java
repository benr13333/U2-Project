import java.util.Scanner;
import java.util.ArrayList;

public class Player
{
    private PlayerClass playerClass;
    private String name;

    private int vigor;
    private int strength;
    private int defense;
    private int intelligence;


    private int critMultiplier;
    private int evadeChance;


    private int maxHealth;
    private int currentHealth;

    private Inventory inventory = new Inventory();
    private Item equippedWeapon;


    public enum PlayerClass
    {
        WARRIOR(12, 15, 10, 6, 2, 5),
        ROGUE(8, 10, 6, 8, 4, 20 ),
        MAGE(7, 4, 5, 18, 3, 8 ),
        GUARDIAN(16, 9, 15, 5, 1, 3);

        private int vigor;
        private int strength;
        private int defense;
        private int intelligence;
        private int critMultiplier;
        private int evadeChance;

        PlayerClass(int vigor, int strength, int defense, int intelligence, int critMultiplier, int evadeChance)
        {
            this.vigor = vigor;
            this.strength = strength;
            this.defense = defense;
            this.intelligence = intelligence;
            this.critMultiplier = critMultiplier;
            this.evadeChance = evadeChance;
        }

        //getters
        public int getVigor()
        {
            return vigor;
        }
        public int getStrength()
        {
            return strength;
        }
        public int getDefense()
        {
            return defense;
        }
        public int getIntelligence()
        {
            return intelligence;
        }
        public int getCritMultiplier()
        {
            return critMultiplier;
        }
        public int getEvadeChance()
        {
            return evadeChance;
        }
    }


    public Player(String name, PlayerClass playerClass)
    {
        this.name = name;
        this.playerClass = playerClass;

        this.vigor = playerClass.getVigor();
        this.strength = playerClass.getStrength();
        this.defense = playerClass.getDefense();
        this.intelligence = playerClass.getIntelligence();
        this.critMultiplier = playerClass.getCritMultiplier();
        this.evadeChance = playerClass.getEvadeChance();

        calculateStats();

        switch(playerClass)
        {
            case WARRIOR -> inventory.addItem(ItemManager.createBasicSword());
            case MAGE -> inventory.addItem(ItemManager.createBasicStaff());
            case ROGUE -> inventory.addItem(ItemManager.createBasicDagger());
            case GUARDIAN -> inventory.addItem(ItemManager.createBasicWarHammer());
        }
    }


    private void calculateStats()
    {
        this.maxHealth = vigor * 10;
        this.currentHealth = maxHealth;

    }


    public static Player playerCreation()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Name Is: " + playerName);
        utils.printEllipses(3, 300);

        System.out.println("CHOOSE A CLASS");
        System.out.println(
                String.format("%-12s %-12s %-12s %-12s", "WARRIOR", "ROGUE", "MAGE", "GUARDIAN") +
                        "\n" +
                        String.format("%-12s %-12s %-12s %-12s", "------------", "------------", "------------", "------------") +
                        "\n" +
                        String.format("%-12s %-12s %-12s %-12s", "Vigor: 12", "Vigor: 8", "Vigor: 7", "Vigor: 16") +
                        "\n" +
                        String.format("%-12s %-12s %-12s %-12s", "Str: 15", "Str: 10", "Str: 4", "Str: 9") +
                        "\n" +
                        String.format("%-12s %-12s %-12s %-12s", "Def: 10", "Def: 6", "Def: 5", "Def: 15") +
                        "\n" +
                        String.format("%-12s %-12s %-12s %-12s", "Int: 6", "Int: 8", "Int: 18", "Int: 5") +
                        "\n" +
                        String.format("%-12s %-12s %-12s %-12s", "Crit: 2", "Crit: 4", "Crit: 3", "Crit: 1") +
                        "\n" +
                        String.format("%-12s %-12s %-12s %-12s", "Evade: 5", "Evade: 20", "Evade: 8", "Evade: 3")
        );

        Player player = null;

        Boolean hasAnswered = false;

        while (hasAnswered == false) {
            System.out.print("Choose Your Class: ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("warrior")) {
                 player = new Player(playerName, PlayerClass.WARRIOR);
                hasAnswered = true;
            }
            else if (answer.equalsIgnoreCase("rogue")) {
                 player = new Player(playerName, PlayerClass.ROGUE);
                hasAnswered = true;
            }
            else if (answer.equalsIgnoreCase("mage")) {
                 player = new Player(playerName, PlayerClass.MAGE);
                hasAnswered = true;
            }
            else if (answer.equalsIgnoreCase("guardian")) {
                 player = new Player(playerName, PlayerClass.GUARDIAN);
                hasAnswered = true;
            }
            else
            {
                System.out.println("Please enter a valid class");
            }
        }

        System.out.println("PLAYER CREATED" );
        currentPlayer = player;
        return player;
    }


    //This makes multiple players not work but I probably won't do that so it doesn't matter
    //It also saves me a bunch of time
    private static Player currentPlayer;

    public static Player currentPlayer()
    {
        return currentPlayer;
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


    //INVENTORY STUFF

    //Getter
    public Inventory getInventory()
    {
        return inventory;
    }

    //Modify Inventory

    public void equipWeapon(Scanner scanner, Inventory inventory)
    {
        ArrayList<Item> weapons = inventory.printWeaponsAndReturnList();

        if (weapons.isEmpty())
        {
            System.out.println("You have no weapons to equip.");
            return;
        }

        System.out.print("Choose a weapon by number: ");
        String input = scanner.nextLine();
        int choice;
        choice = Integer.parseInt(input);

        if (choice < 1 || choice > weapons.size()) {
            System.out.println("You don't have this many weapons!");
            return;
        }

        Item selected = weapons.get(choice - 1);
        equippedWeapon = selected;
        System.out.println("Equipped: " + selected.getName());
    }


}

