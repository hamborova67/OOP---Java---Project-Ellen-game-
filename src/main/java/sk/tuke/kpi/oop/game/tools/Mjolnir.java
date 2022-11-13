package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Mjolnir extends Hammer{

    private int Uses;

    public Mjolnir(){
        super( 4);
    }
    public Mjolnir(int Uses){
        //super(Uses); //vzdy ako prvy volat
        Animation hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(hammerAnimation);
        this.Uses=4;

    }
    public int getRemainingUses(){
        return this.Uses;
    }


    public void useWith(Reactor reactor) {
        if(reactor==null){
            return;
        }
        if(this.Uses<=0){
            getScene().removeActor(this);
            return;
        }
        this.Uses--;

    }

}
