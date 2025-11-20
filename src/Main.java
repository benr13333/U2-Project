import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Player.playerCreation();

        Main game = new Main();
        game.Start();
    }

    public void Start() {
        UI userInterface = new UI();
        Scanner scanner = new Scanner(System.in);
        Boolean inputActive = true;
        while (inputActive) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "help" ->
                {
                    System.out.println("\nHELP COMMANDS \n========================");
                    System.out.println("\"inventory\" - opens the players inventory");
                }
                case "inventory" -> {
                    userInterface.browseInventory();
                }
                default ->
                {
                    System.out.println("\"Invalid command. Type \\\"help\\\" for a list of commands.");
                }

            }

        }
    }
}