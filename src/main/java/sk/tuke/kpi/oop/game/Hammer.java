package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Hammer extends AbstractActor {
    private Animation hammerAnimation;
    public Hammer(){
        this.hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(this.hammerAnimation);

    }
}
