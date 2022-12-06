package sk.tuke.kpi.oop.game.items;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Ripley;

public class Energy extends AbstractActor implements Usable<Ripley>{


    public Energy(){
        Animation energy = new Animation("sprites/energy.png",16,16);
        setAnimation(energy);
    }


    @Override
    public void useWith(Ripley actor) {

        if(actor.getEnergy()>=100){
            return;
        }


        if(actor.getPosX() == this.getPosX() || actor.getPosY() == this.getPosY()){
            actor.setEnergy(100);
            getScene().removeActor(this);
            //System.out.println("ahoj"+actor.getEnergy());
        }



    }

    @Override
    public Class<Ripley> getUsingActorClass() {
        return null;
    }
}
