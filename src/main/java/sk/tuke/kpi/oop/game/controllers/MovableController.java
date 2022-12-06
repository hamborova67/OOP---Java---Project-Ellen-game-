package sk.tuke.kpi.oop.game.controllers;
import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Move;

import java.util.Map;

public class MovableController implements KeyboardListener {
    private Map<Input.Key, Direction> keyDirectionMap = Map.ofEntries(
        Map.entry(Input.Key.UP, Direction.NORTH),Map.entry(Input.Key.DOWN, Direction.SOUTH),
        Map.entry(Input.Key.LEFT, Direction.WEST),Map.entry(Input.Key.RIGHT, Direction.EAST)
    );

    private Direction direction;

    private Movable movable;

    private Move<Movable> move;
    public MovableController(Movable movable){
            this.movable = movable;
    }


    @Override
    public void keyPressed(Input.@NotNull Key key) {
        KeyboardListener.super.keyPressed(key);

        if(move != null){
            move.stop();
        }
        if(keyDirectionMap.containsKey(key)){
            //PressedKey.add(key);

            Direction newDirection = this.keyDirectionMap.get(key);

            this.move = new Move<>(newDirection, Float.MAX_VALUE);

                this.move.scheduleFor(this.movable);

        }
    }





    @Override
    public void keyReleased(Input.@NotNull Key key) {
        KeyboardListener.super.keyReleased(key);

        if(keyDirectionMap.containsKey(key)){
            move.stop();

        }


    }
}
