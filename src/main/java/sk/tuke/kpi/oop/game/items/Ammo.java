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
        if(actor==null){
            return;
        }

        if(actor.getFirearm().getMaxAmmo() > actor.getFirearm().getAmmo()){
            actor.getFirearm().reload(50);
            if(getScene()!=null){
                getScene().removeActor(this);
            }
        }

    }

    @Override
    public Class<Armed> getUsingActorClass() {
        return Armed.class;
    }
}
