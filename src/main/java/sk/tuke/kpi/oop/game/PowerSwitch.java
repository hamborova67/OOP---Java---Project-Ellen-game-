package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.graphics.Color;

public class PowerSwitch extends AbstractActor implements Switchable {
    private Animation controllerAnimation;
    private Switchable switchable;
    private boolean switch01;
    public PowerSwitch(Switchable switchable){

        this.switchable =  switchable;
        setAnimation(this.controllerAnimation);

    }

    public Switchable getDevice(){
        return this.switchable;
    }

    public void switchOn(){
            switchable.turnOn();
            getAnimation().setTint(Color.WHITE);
    }

    public void switchOff(){
            switchable.turnOff();
            getAnimation().setTint(Color.GRAY);

    }

    /*
    public void toggle(){
        if(switchable.isOn() == true ){
            switchable.turnOn();
            return;
        }
        switchable.turnOff();
    }
     */

    public void turnOn(){
        this.switch01 = true;
    }
    public void turnOff(){
        this.switch01 = false;
    }
    public boolean isOn(){
        return this.switch01;
    }







}
