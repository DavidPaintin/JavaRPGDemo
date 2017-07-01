import java.util.Scanner;

public class FactoryPatternMage extends GameCharacter implements Runnable{
    private int health =100;
    private String name;
    private Scanner input = new Scanner(System.in);

    private SpellFactory spells;
    public FactoryPatternMage(){
        name = "Factory Pattern Mage";
        spells = new SpellFactory();
    }
    public void run(){
        int task;
        GlobalData.addLivingAlly(this);
        while (health>0){
            System.out.println("1 for attack or 2 for spell");
            task=input.nextInt();
            switch (task){
                case 1:
                    attack(GlobalData.getLivingEnemies().get(0));
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                }
                    break;
                case 2:
                    damageSpell(GlobalData.getLivingEnemies().get(0));
                    try {
                        Thread.sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
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

    public String getName(){
        return name;
    }
    public void damageSpell(GameCharacter character){
        spells.getSpell().castSpell(character);
    }
}
