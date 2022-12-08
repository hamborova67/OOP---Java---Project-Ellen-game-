package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Armed;


public class Ammo extends AbstractActor implements Usable<Armed> {


    public Ammo(){
        Animation ammo = new Animation("sprites/ammo.png",16,16);
        setAnimation(ammo);
    }

    @Override
    public void useWith(Armed actor) {
        if(actor.getFirearm().getAmmo()>=500){
            return;
        }

        actor.getFirearm().setAmmo(actor.getFirearm().getAmmo()+50);
        if(actor.getFirearm().getAmmo()>500){
            actor.getFirearm().setAmmo(500);
        }
        getScene().removeActor(this);
    }

    @Override
    public Class<Armed> getUsingActorClass() {
        return Armed.class;
    }
}
