import java.util.Scanner;


public class UI
{
    Scanner scanner = new Scanner(System.in);

    Scanner input = new Scanner(System.in);

    boolean hasAnswered = false;

    Player player = Player.currentPlayer();
    ItemManager itemManager = new ItemManager(player.getInventory());


    public void browseInventory()
    {
        hasAnswered = false;

        while (!hasAnswered)
        {

            System.out.println("INVENTORY");
            System.out.println("===========================");
            System.out.println("1.) See Weapons");
            System.out.println("2.) See Potions");
            System.out.println("3.) Equip Weapon");
            System.out.println("9.) Leave");
            System.out.println("Equipped Weapon: " + player.getEquippedWeapon());
            System.out.println("Coins: " + player.getCurrentCoins());

            int answer;
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Invalid Input! Try again. \n");
                utils.delay(200);
                continue;
            }
            switch (answer) {
                case 1 -> {
                    seeWeapons();
                    hasAnswered = true;
                }
                case 2 -> {
                    seePotions();
                    hasAnswered = true;
                }
                case 3 ->
                {
                    equipWeapon();
                    hasAnswered = true;
                }
                case 9 ->
                {
                    hasAnswered = true;
                    break;
                }
                default -> {
                    System.out.println("Invalid Input! Try again. \n");
                    utils.delay(200);
                }
            }
        }
    }


    public void seeWeapons()
    {
        player.getInventory().printWeapons();
        hasAnswered = false;
    }


    public void seePotions()
    {
        player.getInventory().printPotions();
        hasAnswered = false;
    }

    public void equipWeapon()
    {
        player.equipWeapon(input, player.getInventory());
        hasAnswered = false;
    }

    public void printStats()
    {
        player.printStats();
    }


    //cheats
    public void openCheatMenu()
    {
        Scanner scanner = new Scanner(System.in);

        Scanner input = new Scanner(System.in);

        boolean hasAnswered = false;

        hasAnswered = false;

        Player player = Player.currentPlayer();

        while (!hasAnswered)
        {

            System.out.println("CHEATS");
            System.out.println("===========================");
            System.out.println("1.) Create New Weapon");
            System.out.println("2.) Create New Enemy");
            System.out.println("8.) Set Coin Amount");
            System.out.println("9.) Set Player Level");
            System.out.println("Player Name: " + player.getName());
            System.out.println("Coins: " + player.getCurrentCoins());
            System.out.println("===========================");



            int answer;
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Invalid Input! Try again. \n");
                utils.delay(200);
                continue;
            }
            switch (answer) {
                case 1 ->
                {
                    hasAnswered = true;
                    itemManager.createNewWeapon();
                }
                case 2 ->
                {
                    hasAnswered = true;
                    //EnemyManager.createNewEnemy();
                }
                case 8 ->
                {
                    hasAnswered = true;
                    setCoins();
                }
                case 9 ->
                {
                    hasAnswered = true;
                    setLevelMenu();
                }

                default -> {
                    System.out.println("Invalid Input! Try again. \n");
                    utils.delay(200);
                }
            }
        }
    }

    public void openUpgradeMenu()
    {
        Scanner scanner = new Scanner(System.in);

        Scanner input = new Scanner(System.in);

        boolean hasAnswered = false;

        hasAnswered = false;

        Player player = Player.currentPlayer();

        while (!hasAnswered)
        {

            System.out.println("=== UPGRADE MENU ===");
            System.out.println("Level: " + player.getLevel());
            System.out.println("Coins: " + player.getCurrentCoins());
            System.out.println("1. Vigor (" + player.getVigor() + ") - Increases Health");
            System.out.println("2. Strength (" + player.getStrength() + ") - Increases Attack");
            System.out.println("3. Defense (" + player.getDefense() + ") - Reduces Damage");
            System.out.println("4. Intelligence (" + player.getIntelligence() + ")");
            System.out.println("5. Exit");

            int answer;
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Invalid Input! Try again. \n");
                utils.delay(200);
                continue;
            }
            switch (answer) {
                case 1 ->
                {
                    hasAnswered = true;
                    player.upgradeStat("Vigor");
                }
                case 2 ->
                {
                    hasAnswered = true;
                    player.upgradeStat("Strength");
                }
                case 3 ->
                {
                    hasAnswered = true;
                    player.upgradeStat("Defense");
                }
                case 4 ->
                {
                    hasAnswered = true;
                    player.upgradeStat("Intelligence");
                }
                case 5 ->
                {
                    hasAnswered = true;
                    break;
                }

                default -> {
                    System.out.println("Invalid Input! Try again. \n");
                    utils.delay(200);
                }
            }
        }
    }

    public void setLevelMenu()
    {
        System.out.println("\n=== SET LEVEL ===");
        System.out.println("1. Vigor (" + player.getVigor() + ") - Increases Health");
        System.out.println("2. Strength (" + player.getStrength() + ") - Increases Attack");
        System.out.println("3. Defense (" + player.getDefense() + ") - Reduces Damage");
        System.out.println("4. Intelligence (" + player.getIntelligence() + ")");
        System.out.println("5. Exit");

        int answer;
        if (scanner.hasNextInt()) {
            answer = scanner.nextInt();
        } else {
            scanner.next();
            System.out.println("Invalid Input! Try again. \n");
            utils.delay(200);
            return;
        }

        if (answer == 5)
        {
            return;
        }

        System.out.println("Set Level To?");
        int level;
        if (scanner.hasNextInt()) {
            level = scanner.nextInt();
        } else {
            scanner.next();
            System.out.println("Invalid Input! Try again. \n");
            utils.delay(200);
            return;
        }

        switch (answer) {
            case 1 ->
            {
                hasAnswered = true;
                player.setLevel("Vigor", level);
            }
            case 2 ->
            {
                hasAnswered = true;
                player.setLevel("Strength", level);
            }
            case 3 ->
            {
                hasAnswered = true;
                player.setLevel("Defense", level);
            }
            case 4 ->
            {
                hasAnswered = true;
                player.setLevel("Intelligence", level);
            }
            case 5 ->
            {
                hasAnswered = true;
                break;
            }

            default -> {
                System.out.println("Invalid Input! Try again. \n");
                utils.delay(200);
            }
        }
    }

    public void setCoins()
    {
        int setCoinsTo;
        System.out.print("Set Coins To? ");
        if (scanner.hasNextInt())
        {
            setCoinsTo = scanner.nextInt();
        }
        else
        {
            scanner.next();
            System.out.println("Invalid Input! Coins not set.\n");
            return;
        }
        player.setCoins(setCoinsTo);
        System.out.println("New Coins Amount: " + player.getCurrentCoins());
        utils.delay(100);
    }

}
