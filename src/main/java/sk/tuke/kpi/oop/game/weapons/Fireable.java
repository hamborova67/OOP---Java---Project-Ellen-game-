package sk.tuke.kpi.oop.game.weapons;

import sk.tuke.kpi.oop.game.Movable;

public interface Fireable extends Movable {
    int getAmmo();
    void reload(int newAmmo);
}
