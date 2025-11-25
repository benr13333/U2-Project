import java.util.Scanner;

public class EnemyManager
{
    private Inventory inventory;

    public EnemyManager(Inventory inventory)
    {
        this.inventory = inventory;
    }

   public static Enemy createBasicZombie()
   {
       Enemy basicZombie = new Enemy("Zombie", 100, 8, 20, 10, Enemy.enemyType.UNDEAD, 100);
       return basicZombie;
   }


}
