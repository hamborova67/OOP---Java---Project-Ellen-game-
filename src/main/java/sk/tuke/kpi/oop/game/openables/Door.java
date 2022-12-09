package sk.tuke.kpi.oop.game.openables;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.map.MapTile;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.items.Usable;

public class Door extends AbstractActor implements Openable, Usable<Actor> {
    private Animation doorc;

    public static final Topic<Door> DOOR_OPENED  = Topic.create("door opened", Door.class);
    public static final Topic<Door> DOOR_CLOSED = Topic.create("door closed", Door.class);

    private boolean door;

    enum Orientation { VERTICAL, HORIZONTAL }

    public Door(String name, Orientation orientation){
        super(name);
        this.door=false;
        if(Orientation.VERTICAL==orientation){
            this.doorc = new Animation("sprites/vdoor.png",16,32,0.1f, Animation.PlayMode.ONCE_REVERSED);
        }
        if(Orientation.HORIZONTAL==orientation){
            this.doorc = new Animation("sprites/hdoor.png",16,32,0.1f, Animation.PlayMode.ONCE_REVERSED);
        }
        setAnimation(doorc);
        doorc.pause();

    }
    @Override
    public void open() {
        if(getScene()!=null){
            return; }
        getScene().getMessageBus().publish(DOOR_OPENED,this);
        door=true;
        this.doorc.setPlayMode(Animation.PlayMode.ONCE);
        getScene().getMap().getTile(getPosX() / 16, getPosY() / 16 + 1).setType(MapTile.Type.CLEAR);
        getScene().getMap().getTile(getPosX() / 16, getPosY() / 16 ).setType(MapTile.Type.CLEAR);
        doorc.play();
        doorc.pause();

    }

    @Override
    public void close() {
        if(getScene()!=null){return;}
        getScene().getMessageBus().publish(DOOR_CLOSED,this);
        door=false;
        this.doorc.setPlayMode(Animation.PlayMode.ONCE_REVERSED);
        getScene().getMap().getTile(getPosX() / 16, getPosY() / 16 + 1).setType(MapTile.Type.WALL);
        getScene().getMap().getTile(getPosX() / 16, getPosY() / 16 ).setType(MapTile.Type.WALL);
        doorc.play();
        doorc.pause();
    }

    @Override
    public boolean isOpen() {
        return door;
    }

    @Override
    public void useWith(Actor actor) {
        if(!door){
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
