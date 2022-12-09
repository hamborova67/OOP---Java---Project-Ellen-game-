package sk.tuke.kpi.oop.game.behaviours;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.actions.Move;

public class RandomlyMoving implements Behaviour<Movable>{
    public RandomlyMoving(){

    }

    @Override
    public void setUp(Movable movable) {
        if (movable==null) {
            return;
        }
        new Loop<>(new ActionSequence<>(new Invoke<>(this::RandomeMove), new Wait<>(3))).scheduleFor(movable);
    }

    private void RandomeMove(Movable movable) {

        if(movable==null){
            return;
        }

        int X = (int) (Math.random() * 1) ;
        int Y = (int) (Math.random() * 1) ;

        int Xz = (int) (Math.random() * 1) ;
        int Yz = (int) (Math.random() * 1) ;

        if(Xz==0){
            X=X-1;
        }
        if(Yz==0){
            Y=Y-1;
        }

        Direction direction = null;

        for (Direction value : Direction.values()) {
            if (X == value.getDx() && Y == value.getDy()) {
                direction = value;
            }
        }
        if(direction==null){
            return;
        }

        movable.getAnimation().setRotation(direction.getAngle());
        new Move<>(direction, 2).scheduleFor(movable);
    }


}
