package sk.tuke.kpi.oop.game.actions;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.actions.Action;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;



public class Move<X extends Movable> implements Action<Movable> {

    private Movable actor;
    private float duration;
    private boolean action;
    private int delta;
    private Direction direction;
    public Move(Direction direction, float duration) {
        this.duration=duration;
        this.direction = direction;
        this.action=false;

    }
    public Move(Direction direction) {
        this.direction=direction;
        this.duration=0;
        this.action = false;
    }



    @Override
    public void setActor(@Nullable Movable actor) {
        this.actor = actor;
    }

    public Movable getActor() {
        return actor;
    }
    public boolean isDone(){
      return action;
    }
    public void reset(){
        this.action=false;
    }

    @Override
    public void execute(float deltaTime) {
        delta += deltaTime;
        this.actor.startedMoving(direction);
        int speed = actor.getSpeed();
        if(delta>=duration){
            action = true;
        }
        this.actor.setPosition(actor.getPosX() + speed* direction.getDx(), actor.getPosY() + speed*direction.getDy());
        this.actor.stoppedMoving();
    }

    public void stop(){
        this.action=true;
        this.actor.stoppedMoving();
    }


}
