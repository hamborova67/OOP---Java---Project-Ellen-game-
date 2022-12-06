package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Collectible;

public class Take<K extends Keeper> extends AbstractAction<K> {

    private Keeper keeper;
    private Collectible collectible;
    private  Exception boa;
    public Take(){

    }
    private void add(){
        try {
            keeper.getBackpack().add(collectible);
            // kod ktory moze sposobit vynimku
        } catch (Exception ex) {
            ex.getMessage();
            if(ex.getMessage().equals(new IllegalStateException())){

            }

            // spracovanie vynimky typu Exception
            // spravu vynimky ziskate metodou ex.getMessage()
        }
    }
    @Override
    public void execute(float deltaTime) {
        for(Actor a : getActor().getScene().getActors()){
            if(a instanceof Collectible){
                getActor().getBackpack().add((Collectible) a);
            }
        }
        setDone(true);
    }
}

