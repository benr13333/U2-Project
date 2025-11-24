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

            int answer = scanner.nextInt();
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
            System.out.println("Player Name: " + player.getName());
            System.out.println("===========================");



            int answer = scanner.nextInt();
            switch (answer) {
                case 1 ->
                {
                    hasAnswered = true;
                    itemManager.createNewWeapon();
                }
                default -> {
                    System.out.println("Invalid Input! Try again. \n");
                    utils.delay(200);
                }
            }
        }
    }
}
