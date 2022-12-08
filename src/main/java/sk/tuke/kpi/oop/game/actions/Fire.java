package sk.tuke.kpi.oop.game.actions;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.characters.Armed;
import sk.tuke.kpi.oop.game.weapons.Fireable;

public class Fire<A extends Armed> extends AbstractAction<A> {
    public Fire(){

    }

    @Override
    public void execute(float deltaTime) {
        if(getActor() ==null || isDone()){
            setDone(true);
            return;
        }

        Fireable fireable = getActor().getFirearm().fire();

        if(fireable==null){
            setDone(true);
            return;
        }

        int x = Direction.fromAngle(getActor().getAnimation().getRotation()).getDx();
        int y = Direction.fromAngle(getActor().getAnimation().getRotation()).getDy();
        Scene scene = getActor().getScene();
        Direction smergulky = Direction.fromAngle(getActor().getAnimation().getRotation());
        if(scene==null || smergulky==null){
            setDone(true);
            return;
        }

        scene.addActor(fireable,getActor().getPosX()+x,getActor().getPosY()+y);
        fireable.startedMoving(smergulky);
        new Move<Fireable>(smergulky,Float.MAX_VALUE).scheduleFor(fireable);








    }
}
