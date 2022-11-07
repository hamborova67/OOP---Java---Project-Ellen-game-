package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor{
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
        if(this.pom==false){
            this.pom=true;
            if(flow==true){
                this.lightAnimation = new Animation("sprites/light_on.png");
                setAnimation(lightAnimation);
                return;
            }
            return;
        }
        this.lightAnimation = new Animation("sprites/light_off.png");
        setAnimation(lightAnimation);
        this.pom=false;
    }
    public void setElectricityFlow(boolean flow){
        this.flow = flow;
        if(this.flow==true){
            if(this.pom==true){
                this.lightAnimation = new Animation("sprites/light_on.png");
                setAnimation(lightAnimation);
                return;
            }
        }
        this.lightAnimation = new Animation("sprites/light_off.png");
        setAnimation(lightAnimation);
    }
}
