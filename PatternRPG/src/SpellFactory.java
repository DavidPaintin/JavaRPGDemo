import java.util.Random;

public class SpellFactory {
    Random rand = new Random();
    public Spell getSpell(){
        int r = rand.nextInt(10);
        switch (r){
            case 1:case 2:case 3:   return new Fireball();
            case 0: case 4: case 5: return new IceShards();
            case 6: case 7: case 8: return new LightningStrike();
            case 9: return new SiphonLife();
            default: return new Fireball();
        }

   }
}
