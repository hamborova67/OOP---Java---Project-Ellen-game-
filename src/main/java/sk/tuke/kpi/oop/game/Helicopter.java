package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;


public class Helicopter extends AbstractActor {

    private Animation helicopterAnimation;

    public Helicopter(){
        this.helicopterAnimation = new Animation("sprites/heli.png",64, 64, 0.2f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(helicopterAnimation);
    }
    public void searchAndDestroy() {

    }

}
