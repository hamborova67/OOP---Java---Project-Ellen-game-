package sk.tuke.kpi.oop.game.openables;
import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.map.MapTile;
import sk.tuke.kpi.gamelib.messages.Topic;
import sk.tuke.kpi.oop.game.items.Usable;

public class Door extends AbstractActor implements Openable, Usable<Actor> {
    private Animation doorc;

    public static final Topic<Door> DOOR_OPENED  = Topic.create("door opened", Door.class);
    public static final Topic<Door> DOOR_CLOSED = Topic.create("door closed", Door.class);

    private boolean mojedvere;
    private boolean raz ;
    private final String sourceVertical = "sprites/vdoor.png";

    private Orientation orientation;
    private enum Orientation { VERTICAL, HORIZONTAL }

    public Door(String name, Orientation orientation){
        super(name);
        mojedvere=false;
        String sourceHorizontal = "sprites/hdoor.png";
        this.orientation=orientation;
        this.raz=false;
        if(Orientation.VERTICAL==orientation){
            this.doorc = new Animation(sourceVertical,16,32,0.1f, Animation.PlayMode.ONCE);
        }
        if(Orientation.HORIZONTAL==orientation){
            this.doorc = new Animation(sourceHorizontal,32,16,0.1f, Animation.PlayMode.ONCE);

        }if(doorc!=null){
            setAnimation(doorc);
            doorc.stop();
        }

    }

    public Door() {
        this.doorc = new Animation(sourceVertical,16,32,0.1f, Animation.PlayMode.ONCE);
        setAnimation(doorc);
        doorc.stop();
        mojedvere = false;
        orientation=Orientation.VERTICAL;

    }



    @Override
    public void open() {
        mojedvere= true;
        if(getScene()==null){
            return;
        }

        getScene().getMessageBus().publish(DOOR_OPENED, this);
        getScene().getMap().getTile(getPosX() / 16, getPosY() / 16).setType(MapTile.Type.CLEAR);
        if(Orientation.VERTICAL==orientation){
            getScene().getMap().getTile(getPosX() / 16, getPosY() / 16 + 1).setType(MapTile.Type.CLEAR);
        }
        if(Orientation.HORIZONTAL==orientation){
            getScene().getMap().getTile(getPosX() / 16+1, getPosY() / 16).setType(MapTile.Type.CLEAR);
        }
        getAnimation().setPlayMode(Animation.PlayMode.ONCE_REVERSED);

        myDoorSwitch();

    }

    @Override
    public void close() {
        mojedvere = false;
        if(getScene()==null){
            return;
        }
        if(Orientation.VERTICAL==orientation){
            getScene().getMap().getTile(getPosX() / 16, getPosY() / 16 + 1).setType(MapTile.Type.WALL);
        }
        getScene().getMessageBus().publish(DOOR_CLOSED, this);
        getScene().getMap().getTile(getPosX() / 16, getPosY() / 16).setType(MapTile.Type.WALL);
        if(Orientation.HORIZONTAL==orientation){
            getScene().getMap().getTile(getPosX() / 16+1, getPosY() / 16).setType(MapTile.Type.WALL);
        }
        getAnimation().setPlayMode(Animation.PlayMode.ONCE);
        myDoorSwitch();
    }
    public void myDoorSwitch(){
        getAnimation().play();
        getAnimation().stop();
    }


    @Override
    public boolean isOpen() {
        return mojedvere;
    }

    @Override
    public void useWith(Actor actor) {
        if(!isOpen()){
            open();
        }else {
           close();
        }
    }

    @Override
    public Class<Actor> getUsingActorClass() {
        return Actor.class;
    }
    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        if(getScene()!=null && !raz &&!isOpen()){

                getScene().getMap().getTile(getPosX() / 16, getPosY() / 16).setType(MapTile.Type.WALL);
                if(Orientation.VERTICAL==orientation){
                    getScene().getMap().getTile(getPosX() / 16, getPosY() / 16 + 1).setType(MapTile.Type.WALL);
                }
                if(Orientation.HORIZONTAL==orientation){
                    getScene().getMap().getTile(getPosX() / 16+1, getPosY() / 16).setType(MapTile.Type.WALL);
                }
                raz=true;

        }

    }





}
