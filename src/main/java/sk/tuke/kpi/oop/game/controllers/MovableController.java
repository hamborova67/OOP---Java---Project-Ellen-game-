package sk.tuke.kpi.oop.game.controllers;
import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Disposable;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Move;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MovableController implements KeyboardListener {
    private Map<Input.Key, Direction> keyDirectionMap = Map.ofEntries(
        Map.entry(Input.Key.UP, Direction.NORTH),Map.entry(Input.Key.DOWN, Direction.SOUTH),
        Map.entry(Input.Key.LEFT, Direction.WEST),Map.entry(Input.Key.RIGHT, Direction.EAST)
    );

    private Movable movable;
    private Set<Input.Key> majkis;
    private Input.Key key1 =null;
    private Input.Key key2 =null;
    private Direction direction1;
    private Disposable disposable;
    private Move<Movable> move;
    public MovableController(Movable movable){
        majkis= new HashSet<>();
        this.movable = movable;
    }


    @Override
    public void keyPressed(@NotNull Input.Key key) {
        KeyboardListener.super.keyPressed(key);

        if(keyDirectionMap.containsKey(key)){
            if(move != null){
            move.stop();
            disposable.dispose();
            move=null;
        }
            majkis.add(key);
            if(key1==null)
                key1 = key;

            if(key2==null)
                key2=key;

            direction1 = null;
            for (Input.Key ki:majkis) {
                    direction1=keyDirectionMap.get(ki);
            }
            if (direction1!=null) {
                move = new Move<>(direction1, Float.MAX_VALUE);
                disposable=move.scheduleFor(movable);
            }
        }
    }

    @Override
    public void keyReleased(@NotNull Input.Key key) {
        KeyboardListener.super.keyReleased(key);
        majkis.remove(key);
        if (key1 == key)
            key1 = null;

        if (key2 == key)
            key2 = null;

        if (keyDirectionMap.containsKey(key)) {
            if (move != null) {
                move.stop();
                disposable.dispose();
                move = null;
            }
            direction1 = null;

            int i = 0;
            for (Input.Key ki : majkis) {
                if (i == 0)
                    direction1 = keyDirectionMap.get(ki);
                if (i == 1)
                    direction1 = direction1.combine(keyDirectionMap.get(ki));
                i++;
            }

            if (direction1 != null) {
                move = new Move<>(direction1, Float.MAX_VALUE);
                disposable = move.scheduleFor(movable);
            }
        }
    }
}
