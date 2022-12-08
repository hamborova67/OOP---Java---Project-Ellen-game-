package sk.tuke.kpi.oop.game.characters;

import java.util.List;

public class Health {
    private List<ExhaustionEffect> effectList ;
    private int initHealth;
    private int maxHealth;
    public Health(int initHealth, int maxHealth){
        this.initHealth = initHealth;
        this.maxHealth = maxHealth;
    }
    public Health(int initHealth){
        this.initHealth = initHealth;
        this.maxHealth= initHealth;
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
        exhaust();
    }
    public void exhaust(){
        this.initHealth=0;
        if(effectList == null){
            return;
        }
        effectList.forEach(ExhaustionEffect::apply);
    }
    public void onExhaustion(ExhaustionEffect effect){
        if(effect==null){
            return;
        }
        effectList.add(effect);
    }
    @FunctionalInterface
    public interface ExhaustionEffect {
        void apply();
    }
}
