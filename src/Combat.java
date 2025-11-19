public class Combat
{
    private Player player;
    private Enemy enemy;

    public Combat(Player player, Enemy enemy)
    {
        this.player = player;
        this.enemy = enemy;
    }



    public void Start()
    {
        System.out.println("You are fighting a " + enemy.getName());

        while (player.isAlive() && enemy.isAlive())
        {
            playerTurn();

            if (!enemy.isAlive())
            {
                System.out.println("Victory!");
                break;
            }
            enemyTurn();
            if (!player.isAlive()) {
                System.out.println("You have died.");
                break;
            }
        }

    }


    public void playerTurn()
    {

    }


    public void enemyTurn()
    {
        
    }
}
