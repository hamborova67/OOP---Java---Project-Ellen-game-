package sk.tuke.kpi.oop.game.characters;
import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.GameApplication;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.items.Backpack;


public class Ripley extends AbstractActor implements Movable, Keeper, Alive {
    private Animation player;
    private int energy;

    private int ammo;
    private Backpack ruksak= new Backpack("Ripley's backpack",10);

    public static Topic<Ripley> RIPLEY_DIED;
    private Health health;
    private int speed;
    public Ripley(){
        super("Ellen");
        player = new Animation("sprites/player.png", 32, 32, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(player);
        player.pause();
        setEnergy(50);
        setAmmo(400);
        speed=1;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void startedMoving(Direction direction){
        this.player.setRotation(direction.getAngle());
        this.player.play();

    }
    public void stoppedMoving(){
        this.player.pause();
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);

    }

    @Override
    public Backpack getBackpack() {
        return ruksak;
    }
    public void showRipleyState(){
        int windowHeight = getScene().getGame().getWindowSetup().getHeight();
        int yTextPos = windowHeight - GameApplication.STATUS_LINE_OFFSET;
        getScene().getGame().getOverlay().drawText("| Energy: "+this.getEnergy()+" | Ammo: "+this.getAmmo(), 100 , yTextPos);
    }

    @Override
    public Health getHealth() {
        return null;
    }
}
