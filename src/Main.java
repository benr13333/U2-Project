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
        Boolean gameRunning = true;
        while (gameRunning) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "inventory" -> {
                    userInterface.browseInventory();
                }
            }

        }
    }
}