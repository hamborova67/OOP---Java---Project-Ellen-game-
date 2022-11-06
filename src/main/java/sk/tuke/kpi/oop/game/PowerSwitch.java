package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.graphics.Color;

public class PowerSwitch extends AbstractActor {
    private Animation controllerAnimation;
    private Switchable switchable;
    private int switch01;
    public PowerSwitch(Switchable switchable){


        this.switchable =  switchable;
        this.controllerAnimation = new Animation("sprites/switch.png");
        setAnimation(this.controllerAnimation);

    }
    public Switchable getSwitchable(){
        return this.switchable;
    }

    public void switchOn(){
            //turnOn();
            getAnimation().setTint(Color.WHITE);
    }

    public void switchOff(){
            //switchable.turnOff();
            getAnimation().setTint(Color.GRAY);

    }

    /*
    public void toggle(){
        if(switch01 ==1 ){
            switchable.turnOn();
            switch01=0;
            return;
        }
        switchable.turnOff();
    }
     */


}
