package sk.tuke.kpi.oop.game.weapons;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Bullet extends AbstractActor implements Fireable {
    private int speed;
    private int ammo;

    public Bullet(){
        Animation bullet =  new Animation("sprites/bullet.png",16,16);
        speed=1;

    }


    @Override
    public int getSpeed() {
        return speed;
    }

}
