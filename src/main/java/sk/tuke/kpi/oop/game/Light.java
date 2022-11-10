package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor implements Switchable{
    private Animation lightAnimation;

    private boolean pom;
    private boolean flow;
    public Light(){

        this.pom=false;
        this.flow = false;
        this.lightAnimation = new Animation("sprites/light_off.png");
        setAnimation(lightAnimation);
    }

    public void toggle(){
        if(!this.isOn()){
            this.turnOn();
            if(this.flow){
                this.lightAnimation = new Animation("sprites/light_on.png");
                setAnimation(lightAnimation);
                return;
            }
            return;
        }
        this.lightAnimation = new Animation("sprites/light_off.png");
        setAnimation(lightAnimation);
        this.turnOff();
    }
    public void setElectricityFlow(boolean flow){
        this.flow = flow;
        if(this.flow){
            if(this.pom){
                this.lightAnimation = new Animation("sprites/light_on.png");
                setAnimation(lightAnimation);
                return;
            }
        }
        this.lightAnimation = new Animation("sprites/light_off.png");
        setAnimation(lightAnimation);
    }
    public void turnOn(){
        this.pom = true;
    }
    public void turnOff(){
        this.pom = false;
    }
    public boolean isOn(){
        return this.pom;
    }
}
