
public class LightningStrike implements Spell {
    public void castSpell(GameCharacter target) {
        System.out.println("lighting strike");
        target.takeDamage(target.getHealth()/2);
    }
}
