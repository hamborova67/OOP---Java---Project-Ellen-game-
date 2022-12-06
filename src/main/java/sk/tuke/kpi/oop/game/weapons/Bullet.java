package sk.tuke.kpi.oop.game.weapons;

import sk.tuke.kpi.gamelib.framework.AbstractActor;

public class Bullet extends AbstractActor implements Fireable {
    public Bullet(){

    }


    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getAmmo() {
        return 0;
    }

    @Override
    public void reload(int newAmmo) {

    }
}
