package sk.tuke.kpi.oop.game.controllers;
import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.actions.Drop;
import sk.tuke.kpi.oop.game.actions.Shift;
import sk.tuke.kpi.oop.game.actions.Take;
import sk.tuke.kpi.oop.game.actions.Use;
import sk.tuke.kpi.oop.game.items.Collectible;
import sk.tuke.kpi.oop.game.items.Usable;

public class KeeperController implements KeyboardListener {
    private Keeper keeper;
    public KeeperController(Keeper keeper){
            this.keeper = keeper;
    }
    @Override
    public void keyPressed(@NotNull Input.Key key) {
        KeyboardListener.super.keyPressed(key);

        if(key == Input.Key.ENTER){ //take
            new Take<>().scheduleFor(keeper);
        }
        if(key == Input.Key.BACKSPACE){ //drop
            new Drop<>().scheduleFor(keeper);
        }
        if(key == Input.Key.S){ //shift
            new Shift<>().scheduleFor(keeper);
        }
        if(key == Input.Key.U){ //use
            if(keeper.getScene()==null){
                return;
            }
            for(Actor actor1 : keeper.getScene().getActors()){
                if(actor1 instanceof Usable && actor1.intersects(keeper)){
                    Use<?> myUse =  new Use<>((Usable<?>)actor1);
                    myUse.scheduleForIntersectingWith(keeper);
                }
            }

        }
        if(key == Input.Key.B){
            Collectible peek = keeper.getBackpack().peek();
            if(peek==null){
                return;
            }
            if(peek instanceof Usable){
                new Use<>((Usable<?>)peek).scheduleForIntersectingWith(keeper);
            }
        }
    }
}
