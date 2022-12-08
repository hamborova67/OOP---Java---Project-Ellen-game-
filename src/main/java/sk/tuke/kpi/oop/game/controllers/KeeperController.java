package sk.tuke.kpi.oop.game.controllers;
import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.actions.Drop;
import sk.tuke.kpi.oop.game.actions.Shift;
import sk.tuke.kpi.oop.game.actions.Take;

public class KeeperController implements KeyboardListener {
    private Keeper keeper;
    public KeeperController(Keeper keeper){
            this.keeper = keeper;
    }
    @Override
    public void keyReleased(Input.@NotNull Key key) {
        KeyboardListener.super.keyReleased(key);

        if(key == Input.Key.ENTER){ //take
            new Take<>().scheduleFor(keeper);
        }
        if(key == Input.Key.BACKSPACE){ //drop
            new Drop<>().scheduleFor(keeper);
        }
        if(key == Input.Key.S){ //shift
            new Shift<>().scheduleFor(keeper);
        }

    }
}
