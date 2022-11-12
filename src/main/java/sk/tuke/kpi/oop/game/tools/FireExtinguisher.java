package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;

public class FireExtinguisher extends BreakableTool{

    private Animation extinguisherAnimation;

    private int remainingUses;

    public FireExtinguisher(){
        this(1);

    }
    public FireExtinguisher(int remainingUses){
        super(1);
        this.extinguisherAnimation = new Animation("sprites/extinguisher.png");
        setAnimation(this.extinguisherAnimation);
        this.remainingUses=1;
    }
    public int getRemainingUses(){
        return this.remainingUses;
    }
    public void useWith(){
        if(this.remainingUses<=0){
            getScene().removeActor(this);
            return;
        }
        this.remainingUses--;

    }
}
