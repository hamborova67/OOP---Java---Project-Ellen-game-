package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Controller extends AbstractActor {
    public Animation controllerAnimation;

    public Controller(){
        this.controllerAnimation = new Animation("sprites/switch.png");
        setAnimation(this.controllerAnimation);

    }
    public int toggle(){
        if(toggle()==1){
            return 0;
        }
        return 1;
    }
}
