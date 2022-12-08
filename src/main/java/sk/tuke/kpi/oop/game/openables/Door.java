package sk.tuke.kpi.oop.game.openables;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.items.Usable;

public class Door extends AbstractActor implements Openable, Usable<Actor> {
    private Animation vdoorc;
    private Animation vdooro;
    private Animation hdoorc;
    private Animation hdooro;
    public static final Topic<Door> DOOR_OPENED  = Topic.create("door opened", Door.class);;
    public static final Topic<Door> DOOR_CLOSED = Topic.create("door closed", Door.class);
    private String name;
    private Orientation orientation;
    private boolean door;

    enum Orientation { VERTICAL, HORIZONTAL }

    public Door(String name, Orientation orientation){

        this.name =name;
        this.orientation=orientation;
        this.door=false;

        if(Orientation.VERTICAL==orientation){
            this.vdoorc = new Animation("sprites/vdoor.png",16,32,0.1f, Animation.PlayMode.ONCE);
            this.vdooro = new Animation("sprites/vdoor.png",16,32,0.1f, Animation.PlayMode.ONCE_REVERSED);
            setAnimation(vdoorc);
        }

        if(Orientation.HORIZONTAL==orientation){
            this.hdoorc = new Animation("sprites/vdoor.png",16,32,0.1f, Animation.PlayMode.ONCE);
            this.hdooro = new Animation("sprites/vdoor.png",16,32,0.1f, Animation.PlayMode.ONCE_REVERSED);
            setAnimation(hdoorc);
        }



    }
    @Override
    public void open() {
        door=true;
        this.vdoorc.setPlayMode(Animation.PlayMode.ONCE);
    }

    @Override
    public void close() {
        door=false;
        this.vdoorc.setPlayMode(Animation.PlayMode.ONCE_REVERSED);
        //getScene().getMessageBus().subscribe(Door.DOOR_CLOSED,);
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public void useWith(Actor actor) {
        if(door==false){
            open();
        }else {
            close();
        }
    }

    @Override
    public Class<Actor> getUsingActorClass() {
        return Actor.class;
    }
}
