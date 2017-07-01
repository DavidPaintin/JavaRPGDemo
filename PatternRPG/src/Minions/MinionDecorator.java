public abstract class MinionDecorator implements Minion {
    public Minion decoratedMinion;
    public MinionDecorator(Minion decoratedMinion){
        this.decoratedMinion=decoratedMinion;
    }
}
