package sk.tuke.kpi.oop.game.characters;

public class Health {
    private int initHealth;
    private int maxHealth;
    public Health(int initHealth, int maxHealth){
        this.initHealth = initHealth;
        this.maxHealth = maxHealth;
    }
    public Health(int initHealth){
        this.initHealth = initHealth;
    }
    public int getValue(){
        return initHealth;
    }
    public void refill(int amount){
        initHealth=initHealth+amount;
        if(initHealth>maxHealth){
            initHealth=maxHealth;
        }
    }
    public void restore(){
        initHealth=maxHealth;
    }
    public void drain(int amount){
        if(initHealth>0){
            initHealth=initHealth-amount;
        }


    }
    public void exhaust(){

    }
    public void onExhaustion(ExhaustionEffect effect){

    }
    @FunctionalInterface
    public interface ExhaustionEffect {
        void apply();
    }
}
