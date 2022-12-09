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
        if (keyDirectionMap.containsKey(key)) {
            majkis.add(key);

            if(key1==null)
            {
                key1 = key;
            }
            else if(key2==null)
            {
                key2=key;
            }
            updateMove();
        }

    }

    private void updateMove() {
        Direction direction = null;
        int i = 0;
        for (Input.Key kluc:majkis) {
            if (i==0)
                direction=keyDirectionMap.get(kluc);
            if (i==1)
                direction= direction.combine(keyDirectionMap.get(kluc));
            i++;
        }
        if (move!=null) {
            move.stop();
        }

        if (direction!=null) {
            move = new Move<>(direction, Float.MAX_VALUE);
            move.scheduleFor(movable);
        }
    }


    @Override
    public void keyReleased(@NotNull Input.Key key) {
        if(keyDirectionMap.containsKey(key))
        { majkis.remove(key);
                key1 =null;
                key2 =null;
                move.stop();
        }
    }

}


