package sk.tuke.kpi.oop.game.actions;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Collectible;

public class Drop<K extends Keeper> extends AbstractAction<K> {
    private Collectible collectible;
    public Drop(){

    }
    @Override
    public void execute(float deltaTime) {
        if(getActor().getBackpack().peek() ==null || getActor() ==null || getActor().getScene()==null){
            setDone(true);
            return;
        }

        collectible = getActor().getBackpack().peek();
        getActor().getScene().addActor(collectible, getActor().getPosX(), getActor().getPosY());
        getActor().getBackpack().remove(collectible);
        setDone(true);


    }
}

