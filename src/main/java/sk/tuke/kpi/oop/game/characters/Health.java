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
        return 0;
    }
    public void refill(int amount){

    }
    public void restore(){

    }
    public void drain(int amount){

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
