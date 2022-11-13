package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Mjolnir extends Hammer{

    private int remainingUses;

    public Mjolnir(){
        super( 4);
    }
    public Mjolnir(int remainingUses){
        super(remainingUses); //vzdy ako prvy volat
        Animation hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(hammerAnimation);
        this.remainingUses=4;

    }
    public int getRemainingUses(){
        return this.remainingUses;
    }


    public void useWith(Reactor reactor) {
        if(reactor==null){
            return;
        }
        if(this.remainingUses<=0){
            getScene().removeActor(this);
            return;
        }
        this.remainingUses--;

    }

}
