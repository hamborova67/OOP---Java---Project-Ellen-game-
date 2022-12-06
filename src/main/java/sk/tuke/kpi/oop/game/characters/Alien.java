package sk.tuke.kpi.oop.game.characters;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.graphics.Point;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.behaviours.Behaviour;

public class Alien implements Alive, Enemy, Movable {

    public Alien(){
        Animation alien = new Animation("sprites/alien.png",32,32,0.1f);

    }
    public Alien(int healthValue, Behaviour<? super Alien> behaviour){

    }

    @Override
    public Health getHealth() {
        return null;
    }

    @Override
    public int getPosX() {
        return 0;
    }

    @Override
    public int getPosY() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public @NotNull String getName() {
        return null;
    }

    @Override
    public @NotNull Animation getAnimation() {
        return null;
    }

    @Override
    public @Nullable Scene getScene() {
        return null;
    }

    @Override
    public @NotNull Point getPosition() {
        return null;
    }

    @Override
    public void setPosition(int posX, int posY) {

    }

    @Override
    public void addedToScene(@NotNull Scene scene) {

    }

    @Override
    public void removedFromScene(@NotNull Scene scene) {

    }

    @Override
    public boolean intersects(@NotNull Actor actor) {
        return false;
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}
