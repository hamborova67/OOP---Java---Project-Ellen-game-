package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Hammer extends AbstractActor {
    private Animation hammerAnimation;
    private int remainingUses;
    public Hammer(){
        this.hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(this.hammerAnimation);
        this.remainingUses=1;

    }
    public int getRemainingUses(){
        return this.remainingUses;
    }
    public void use(){
        this.remainingUses--;
        if(this.remainingUses==0){
            getScene().removeActor(this);
        }
    }

}
