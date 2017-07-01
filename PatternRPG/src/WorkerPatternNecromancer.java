import sun.nio.ch.ThreadPool;


import java.io.Reader;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class WorkerPatternNecromancer extends GameCharacter implements Runnable {
    private String name;
    private int health = 100;
    private Scanner reader = new Scanner(System.in);
    private int minionCount = 0;

    public WorkerPatternNecromancer() {
        name = "Decorator Pattern Necromancer";
    }

    public String getName() {
        return name;
    }

    @Override
    public synchronized int getHealth() {
        return health;
    }

    public synchronized void setHealth(int health) {
        this.health = health;
    }

    public void attack(GameCharacter character){
        character.takeDamage(10);
        setHealth(getHealth()+5);
    }

    public void run() {
        int task;
        GlobalData.addLivingAlly(this);
        while (health > 0) {
            System.out.println("enter next move 1 for minions 2 for attack");
            task = reader.nextInt();
            switch (task) {
                case 1:
            if (minionCount <= 4) {
                Minion newMinion = new BasicMinion(minionCount++);
                Thread newThread = new Thread(newMinion);
                newThread.start();try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            break;
                case 2:
                    attack(GlobalData.getLivingEnemies().get(0));
                    try {
                        Thread.sleep(1500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
            }
        }
        GlobalData.removeLivingAlly(this);

    }
            }
