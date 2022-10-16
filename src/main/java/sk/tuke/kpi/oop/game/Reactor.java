package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Reactor extends AbstractActor {
    private int temperature;
    private int damage;
    private Animation normalAnimation;

    public Reactor(){
        this.temperature = 0;
        this.damage = 0;
        this.normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(normalAnimation);
    }
    public int getTemperature(){
        return this.temperature;
    }
    public int getDamage(){
        return this.damage;
    }
    public void increaseTemperature(int increment){

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
                    this.normalAnimation = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
                    setAnimation(normalAnimation);
                }
                if(getTemperature()<=4000){
                    this.normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
                    setAnimation(normalAnimation);
                }


}
        public void repairWith (Hammer hammer){
            if(hammer==NULL){
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

        }
        public void turnOff(){

        }
        public int isRunning(){

        }
    }
