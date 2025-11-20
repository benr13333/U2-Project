import java.util.Scanner;


public class UI
{
    Scanner scanner = new Scanner(System.in);

    boolean hasAnswered = false;

    Player player = Player.currentPlayer();

    public void browseInventory()
    {
        while (!hasAnswered)
        {
            System.out.println("INVENTORY");
            System.out.println("===========================");
            System.out.println("1.) See Weapons");
            System.out.println("2.) See Potions");

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
    }


    public void seePotions()
    {
        player.getInventory().printPotions();
    }
}
