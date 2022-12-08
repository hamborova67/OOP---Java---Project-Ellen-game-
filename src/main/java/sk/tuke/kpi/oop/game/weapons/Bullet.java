package sk.tuke.kpi.oop.game.weapons;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Alive;

public class Bullet extends AbstractActor implements Fireable {
    private int speed;


    public Bullet(){
        Animation bullet =  new Animation("sprites/bullet.png",16,16);
        setAnimation(bullet);
        speed=4;
    }


    @Override
    public int getSpeed() {
        return speed;
    }

    private void shootAlive(){
        if(getScene().getActors()==null){
            return;
        }
        for (Actor actor : getScene().getActors()) {
            if (this.intersects(actor) && (actor instanceof Alive)) {
                ((Alive) actor).getHealth().drain(10);
                getScene().removeActor(this);
                collidedWithWall();
            }
        }

    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Loop<>(
            new Invoke<>(this::shootAlive)
        ).scheduleFor(this);

    }

    @Override
    public void collidedWithWall() {
        getScene().removeActor(this);
    }
}
