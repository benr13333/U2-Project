public class EnemyManager
{
   public static Enemy createBasicZombie()
   {
       Enemy basicZombie = new Enemy("Zombie", 100, 8, 20, 10, Enemy.enemyType.UNDEAD);
       return basicZombie;
   }

}
