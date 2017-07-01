public class Main {

    public static void main(String[] args) {
        FactoryPatternMage mage = new FactoryPatternMage();
        WorkerPatternNecromancer necro =new WorkerPatternNecromancer();
        Thread t1 = new Thread(necro);
        Thread t2 = new Thread(mage);
        EnemyPool enemies = new EnemyPool();
        Thread t0 = new Thread(enemies);
        t0.start();
        t1.start();
        t2.start();
        int failsafe=0;
        while(GlobalData.getLivingAllies().size()>0 && failsafe<20){
            try {
                Thread.sleep(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            if(GlobalData.getLivingAllies().size()==0){
                failsafe++;
            }
        }
    }
}
