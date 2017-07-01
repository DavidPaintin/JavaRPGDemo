
public class IceShards implements Spell {
    public void castSpell(GameCharacter target){
        for (GameCharacter ch: GlobalData.getLivingEnemies()){
            System.out.println("Ice Shards!");
                ch.takeDamage(10);
        }
    }
}
