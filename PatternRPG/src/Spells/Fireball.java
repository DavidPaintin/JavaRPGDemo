
public class Fireball implements Spell {
    public int manacost=10;
    public String name = "Fireball";
    public void castSpell(GameCharacter target) {
        System.out.println("Casting Spells.Fireball!");
        target.takeDamage(25);
    }
}
