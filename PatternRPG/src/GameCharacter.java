public abstract class GameCharacter{
    private int health = 100;
    private int basicDamage = 10;
    private int armour =0;
    private String name;
    private boolean enemy;

    public void attack(GameCharacter character){
        character.takeDamage(basicDamage - character.getArmour());
    }

    public  void takeDamage(int damage){
        setHealth(getHealth()-damage);
        if(getHealth()<=0){
            System.out.println(getName() +" has taken a fatal wound");
        }
    }

    public int getArmour() {
        return armour;
    }



    public boolean isEnemy(){
        return enemy;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }
}
