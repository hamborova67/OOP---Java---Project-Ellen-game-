package sk.tuke.kpi.oop.game;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor implements Switchable, EnergyConsumer{
    private Animation lightAnimation;
    private Animation lightAnimation_on;

    private boolean pom;
    private boolean flow;
    public Light(){

        this.pom=false;
        this.flow = false;
        this.lightAnimation = new Animation("sprites/light_off.png");
        this.lightAnimation_on = new Animation("sprites/light_on.png");
        setAnimation(lightAnimation);
    }

    public void toggle(){
        if(!this.isOn()){
            this.turnOn();
            if(this.flow){

                setAnimation(lightAnimation_on);
                return;
            }
            return;
        }

        setAnimation(lightAnimation);
        this.turnOff();
    }
    public void setPowered(boolean flow){
        this.flow=flow;
        if(this.flow || this.pom){


                setAnimation(lightAnimation_on);
                return;

        }

        setAnimation(lightAnimation);
    }
    @Override
    public void turnOn(){
        if(this.flow) {

            setAnimation(lightAnimation_on);

        }
        this.pom = true;

    }
    @Override
    public void turnOff(){

        setAnimation(lightAnimation);
        this.pom = false;
    }
    @Override
    public boolean isOn(){
        return this.pom;
    }
}
