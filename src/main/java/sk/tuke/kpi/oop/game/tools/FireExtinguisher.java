package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;

public class FireExtinguisher extends BreakableTool{

    private Animation extinguisherAnimation;

    public FireExtinguisher(){
        this(1);
    }
    public FireExtinguisher(int remainingUses){
        super(1);
        this.extinguisherAnimation = new Animation("sprites/reactor_extinguished.png");
        setAnimation(this.extinguisherAnimation);
    }
}
