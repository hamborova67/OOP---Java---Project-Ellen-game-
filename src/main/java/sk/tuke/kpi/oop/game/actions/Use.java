package sk.tuke.kpi.oop.game.actions;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.items.Usable;


public class Use extends AbstractAction {
    private Usable usableActor;
    public Use(Actor actor){
        usableActor.useWith(getActor());
    }


    @Override
    public void execute(float deltaTime) {

    }
}
