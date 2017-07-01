
public class SiphonLife implements Spell {
    public void castSpell(GameCharacter target) {
        target.takeDamage(20);
        for (GameCharacter ch: GlobalData.getLivingEnemies()){
            System.out.println("Siphon Life");
                ch.takeDamage(-10);
        }
    }
}
