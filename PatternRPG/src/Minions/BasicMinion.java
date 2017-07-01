import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;

public class BasicMinion extends GameCharacter implements Minion{
    private Random rand = new Random();
    private int health=50;
    private int basicDamage = 10;
    private String name;
    private  boolean enemy=false;

    public void attack(GameCharacter target){
        target.takeDamage(basicDamage);
    }
    public BasicMinion(int num){
        name="Minion "+num;
        GlobalData.addLivingAlly(this);
    }

    public String getName() {
        return name;
    }

    public void run(){
        while(health>0) {
            if(GlobalData.getLivingEnemies().size()>0) {
                GameCharacter target = GlobalData.getLivingEnemies().get(rand.nextInt(GlobalData.getLivingEnemies().size()));
                attack(target);
            }
            System.out.println("Minion " +name + "running");
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        GlobalData.removeLivingAlly(this);
    }

    @Override
    public synchronized int getHealth() {
        return health;
    }

    public synchronized void setHealth(int health) {
        this.health = health;
    }
}
