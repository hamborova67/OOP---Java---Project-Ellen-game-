package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Controller extends AbstractActor {
    public Animation controllerAnimation;
    private Reactor reactor;
    int switch01;
    public Controller( Reactor reactor){

        this.switch01 =1;
        this.reactor =  reactor;
        this.controllerAnimation = new Animation("sprites/switch.png");
        setAnimation(this.controllerAnimation);

    }
    public void toggle(){
        if(switch01 ==1 ){
            reactor.turnOn();
            switch01=0;
            return;
        }
        reactor.turnOff();
    }

}
