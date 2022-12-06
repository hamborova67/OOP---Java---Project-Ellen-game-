package sk.tuke.kpi.oop.game.actions;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Disposable;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.items.Usable;


public class Use<A extends Actor> extends AbstractAction<A> {
    private Usable<A> usableActor;
    public Use(Usable<A> usable){
       this.usableActor=usable;
    }
    public Disposable scheduleForIntersectingWith(Actor mediatingActor){

        return null;
    }

    @Override
    public void execute(float deltaTime) {
        usableActor.useWith(getActor());
        setDone(true);
    }
}
