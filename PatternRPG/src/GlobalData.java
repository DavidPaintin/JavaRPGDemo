import java.util.ArrayList;

public class GlobalData {

    private static ArrayList<GameCharacter> livingAllies=new ArrayList<>();
    private static ArrayList<GameCharacter> livingEnemies=new ArrayList<>();


    public static ArrayList<GameCharacter> getLivingAllies() {
        return livingAllies;
    }
    public static ArrayList<GameCharacter> getLivingEnemies() {
        return livingEnemies;
    }
    public static synchronized void addLivingAlly(GameCharacter character) {
        livingAllies.add(character);
    }
    public static void addLivingEnemy(GameCharacter character) {
        livingEnemies.add(character);
    }
    public static void removeLivingAlly(GameCharacter character){
        livingAllies.remove(character);
    }
    public static void removeLivingEnemy(GameCharacter character){
        livingEnemies.remove(character);
    }
}
