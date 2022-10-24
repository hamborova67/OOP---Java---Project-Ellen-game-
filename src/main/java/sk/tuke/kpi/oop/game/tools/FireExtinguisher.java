package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;

public class FireExtinguisher extends BreakableTool{
    private int uses;
    private Animation extinguisherAnimation;

    public void FireExtinguisher(){
        //super(1);
        this.extinguisherAnimation = new Animation("sprites/reactor_extinguished.png");
        setAnimation(this.extinguisherAnimation);
    }
}
