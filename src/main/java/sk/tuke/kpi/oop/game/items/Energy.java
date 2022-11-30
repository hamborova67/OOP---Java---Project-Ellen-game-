package sk.tuke.kpi.oop.game.items;


import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Ripley;

public class Energy extends AbstractActor implements Usable<Ripley>{
    private Animation energy;
    private int zdravie;

    public Energy(){
        energy = new Animation("sprites/energy.png",16,16);
        setAnimation(energy);
    }

    @Override
    public void useWith(Ripley actor) {
        if(zdravie>=100){
            return;
        }
        zdravie = 100;
        getScene().removeActor(this);


    }
}
