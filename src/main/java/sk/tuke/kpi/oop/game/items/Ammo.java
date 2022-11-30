package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Ripley;


public class Ammo extends AbstractActor implements Usable<Ripley>{
    private Animation ammo;
    private int naboje;
    public Ammo(){
        ammo = new Animation("sprites/ammo.png",16,16);
        setAnimation(ammo);
    }

    @Override
    public void useWith(Ripley actor) {
        if(naboje>=500){
            return;
        }
        naboje=naboje+50;
        getScene().removeActor(this);
    }
}
