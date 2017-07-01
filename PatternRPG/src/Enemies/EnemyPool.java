import java.util.Random;

public class EnemyPool implements Runnable {
    private Random rand = new Random();

    public void run() {
        while (true) {
            if (GlobalData.getLivingEnemies().size() < 10) {
                int select = rand.nextInt(3);
                Enemy enemy;
                switch (select) {
//                    case 4:
//                        enemy = new MeleeEnemy();
//                        break;
//                    case 5:
//                        enemy = new RangedEnemy();
//                        break;
                    default:
                        enemy = new MageEnemy();
                }
                Thread thread = new Thread(enemy);
                thread.start();

            }
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
            }
        }
    }
}