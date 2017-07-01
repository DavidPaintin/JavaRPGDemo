import java.util.Random;

public class MageEnemy extends Enemy implements Runnable {
    private int health =80;
    private Random rand = new Random();
    private static int count=0;
    private String name;
    public MageEnemy(){
        setName("Enemy Mage "+count);
        increaseCount();
    }
    private synchronized static void increaseCount(){
        count++;
    }
    public void attack(GameCharacter target){
        target.takeDamage(5);
        for (GameCharacter ch: GlobalData.getLivingAllies()){
            ch.takeDamage(5);
        }
    }
    public void run(){
        System.out.println("Enemy mage attacks");
        GlobalData.addLivingEnemy(this);
        while(health>0){
            attack(GlobalData.getLivingAllies().get(rand.nextInt(GlobalData.getLivingAllies().size())));
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        GlobalData.removeLivingEnemy(this);
    }
    public void setHealth(int health){
        this.health=health;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String getName() {
        return name;
    }
}
