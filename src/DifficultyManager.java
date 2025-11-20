import java.util.Scanner;

public class DifficultyManager
{
    public enum difficulty {
        EASY(0.75, 0.75),
        MEDIUM(1, 1),
        HARD(1.25, 1.25);


        private double enemyHealthMultiplier;
        private double playerHealthMultiplier;


        difficulty(double enemyHealthMultiplier, double playerHealthMultiplier) {
            this.enemyHealthMultiplier = enemyHealthMultiplier;
            this.playerHealthMultiplier = playerHealthMultiplier;
        }


        //return statements
        public double getEnemyHealthMultiplier() {
            return enemyHealthMultiplier;
        }


        public double getPlayerHealthMultiplier() {
            return playerHealthMultiplier;
        }
    }


    //handle difficulty within the method so main doesn't get messy
    public static difficulty askForDifficulty()
    {
        Scanner scanner = new Scanner(System.in);
        difficulty currentDifficulty = difficulty.HARD;
        boolean confirmedDifficulty = false;


        System.out.println("Select your difficulty:");
        System.out.print("EASY \nMEDIUM \nHARD\n");


        while(!confirmedDifficulty) {
            String selectedDifficulty = scanner.nextLine();


            if (selectedDifficulty.equalsIgnoreCase("EASY")) {
                currentDifficulty = difficulty.EASY;
                confirmedDifficulty = true;
            }
            if (selectedDifficulty.equalsIgnoreCase("MEDIUM")) {
                currentDifficulty = difficulty.MEDIUM;
                confirmedDifficulty = true;
            }
            if (selectedDifficulty.equalsIgnoreCase("HARD")) {
                currentDifficulty = difficulty.HARD;
                confirmedDifficulty = true;
            }
        }
        return currentDifficulty;
    }
}
