package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.actions.PerpetualReactorHeating;
import sk.tuke.kpi.oop.game.tools.Hammer;

public class Reactor extends AbstractActor {
    private int temperature;
    private int damage;
    private int running;
    Light light;
    private Animation normalAnimation;

    public Reactor(){
        this.temperature = 0;
        this.damage = 0;
        this.running = 0;
        this.light = light;
        this.normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normalAnimation);
        turnOff();

    }
    public int getTemperature(){
        return this.temperature;
    }
    public int getDamage(){
        return this.damage;
    }
    public void increaseTemperature(int increment){
            if(running==0){
                return;
            }
            this.temperature =  this.temperature + increment;

            if(getTemperature()>=2000){
                this.damage =   ((this.temperature-2000) / 40) ;
            }
            if(getDamage()>=33 ){
                if(getDamage()>=66 ){
                   this.temperature = this.temperature + increment+(increment/2);
                   this.damage =   ((this.temperature-2000) / 40) ;
                }else{
                    this.temperature = this.temperature + (increment*2);
                    this.damage =   ((this.temperature-2000) / 40) ;
                }
            }
            if(getDamage()>100 && getTemperature()>6000){
                this.damage = 100;
                this.temperature = 6000;
            }

        updateAnimation();
        }
        public void  decreaseTemperature(int decrement) {

            if (getDamage() >= 50) {
                this.temperature = this.temperature - (decrement / 2);
                if (getDamage() >= 100) {
                    this.temperature = getTemperature();
                }

            } else {
                this.temperature = this.temperature - decrement;
            }

            updateAnimation();
        }

        public void updateAnimation(){
                if(getTemperature()>=4000){
                    this.normalAnimation = new Animation("sprites/reactor_hot.png", 80, 80, 0.05f, Animation.PlayMode.LOOP_PINGPONG);
                    setAnimation(normalAnimation);
                }
                if(getTemperature()>=6000){
                    turnOff();
                    this.normalAnimation = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
                    setAnimation(normalAnimation);
                }
                if(getTemperature()<=4000){
                    this.normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
                    setAnimation(normalAnimation);
                }


}
        public void repairWith (Hammer hammer){
            if(hammer==null){
                return;
            }
            if(getDamage()>=50){
                this.damage=this.damage-50;
            }else{
                this.damage=0;
            }
            //Math.max(0,30);Math.max(0,-30);
            hammer.use();
        }
        public void turnOn(){
            running=1;
        }
        public void turnOff(){
            running=0;
            this.temperature=getTemperature();
            updateAnimation();

        }
        public int isRunning(){
            return running;
        }


        public void addLight(){
            light.setElectricityFlow(true);
        }
        public void removeLight(){
            light.setElectricityFlow(false);
        }
        @Override
        public void addedToScene(@NotNull Scene scene) {
            super.addedToScene(scene);
            // v metode addedToScene triedy Reactor
            new PerpetualReactorHeating(1).scheduleFor(this);
        }
}
