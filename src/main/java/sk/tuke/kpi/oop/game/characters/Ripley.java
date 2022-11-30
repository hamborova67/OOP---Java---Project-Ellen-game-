package sk.tuke.kpi.oop.game.characters;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.items.Energy;

public class Ripley extends AbstractActor implements Movable {
    Animation player;
    private Energy energy;
    public Ripley(){
        super("Ellen");
        player = new Animation("sprites/player.png", 32, 32, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(player);
        player.pause();
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    public void startedMoving(Direction direction){

        player.play();
    }
    public void stoppedMoving(){
        player.pause();
    }

    public void setEnergy(Energy energy) {
        this.energy = energy;
    }

    public Energy getEnergy() {
        return energy;
    }
}
