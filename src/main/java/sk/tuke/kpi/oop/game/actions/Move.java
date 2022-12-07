package sk.tuke.kpi.oop.game.actions;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.actions.Action;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;



public class Move<A extends Movable> implements Action<A> {

    private A actor;
    private float duration;
    private boolean action;
    private float delta;
    private boolean prvykrat;


    private Direction direction;
    public Move(Direction direction, float duration) {
        this.duration=duration;
        this.direction = direction;
        this.action=false;
        this.delta = 0;
        this.prvykrat=false;


    }
    public Move(Direction direction) {
        this.direction=direction;
        this.duration=0;
        this.action = false;
        this.delta = 0;
        this.prvykrat = false;

    }

    @Override
    public void setActor(@Nullable A actor) {
        this.actor = actor;
    }

    public A getActor() {
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
        if(actor == null){
            return;
        }
        if(!prvykrat){
            this.actor.startedMoving(direction);
            prvykrat=true;
        }

        if(actor.getScene().getMap().intersectsWithWall(this.actor)){
            //this.actor.setPosition(this.actor.getPosX() - this.direction.getDx() , this.actor.getPosY() - this.direction.getDy() );

        }else{
            this.actor.setPosition(this.actor.getPosX() + (this.actor.getSpeed()*this.direction.getDx() ), this.actor.getPosY() + (this.actor.getSpeed()*this.direction.getDy()) );

        }

        if (this.direction.getDx() == 0 && this.direction.getDy() == 0) {
            this.actor.getAnimation().stop();
        }
        delta += deltaTime;
        if (duration<=delta) {
            stop();
        }
    }

    public void stop(){
        this.action=true;
        if(actor!=null){
            this.actor.stoppedMoving();
        }
    }



}
