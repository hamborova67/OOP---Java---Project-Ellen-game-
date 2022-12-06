package sk.tuke.kpi.oop.game.openables;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.items.Usable;

public class Door extends AbstractActor implements Openable, Usable<Actor> {
    private Animation vdoor;
    public static Topic<Door> DOOR_OPENED;
    public static Topic<Door> DOOR_CLOSED;
    private String name;
    private Orientation orientation;
    enum Orientation { VERTICAL, HORIZONTAL }

    public Door(String name, Orientation orientation){
        this.vdoor = new Animation("sprites/vdoor.png",16,32,0.1f);
        setAnimation(vdoor);
        this.name =name;
        this.orientation=orientation;

    }
    @Override
    public void open() {
        this.vdoor.setPlayMode(Animation.PlayMode.ONCE);
    }

    @Override
    public void close() {
        this.vdoor.setPlayMode(Animation.PlayMode.ONCE_REVERSED);
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void useWith(Actor actor) {

    }

    @Override
    public Class<Actor> getUsingActorClass() {
        return null;
    }
}
