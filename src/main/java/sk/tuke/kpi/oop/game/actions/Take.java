package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Collectible;

public class Take<K extends Keeper> extends AbstractAction<K> {

    public Take(){

    }
    @Override
    public void execute(float deltaTime) {
        if(getActor()==null || getActor().getScene() ==null){
            setDone(true);
            return;
        }


        for(Actor a : getActor().getScene().getActors()){
            if(a instanceof Collectible){
                try {
                    getActor().getBackpack().add((Collectible) a);
                }catch (IllegalStateException exception){
                    getActor().getScene().getOverlay().drawText(exception.getMessage(), 0, 0).showFor(2);
                }

            }
        }
        setDone(true);
    }

}

