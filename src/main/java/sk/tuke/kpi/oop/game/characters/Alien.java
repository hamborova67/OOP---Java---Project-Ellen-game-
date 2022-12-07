package sk.tuke.kpi.oop.game.characters;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.oop.game.behaviours.Behaviour;

public class Alien extends AbstractActor implements Alive, Enemy, Movable {
    private int speed;
    private Health health;
    public Alien(){
        Animation alien = new Animation("sprites/alien.png",32,32,0.1f);

    }
    public Alien(int healthValue, Behaviour<? super Alien> behaviour){
        speed=1;
        health = new Health(healthValue,100);
    }


    @Override
    public Health getHealth() {
        return health;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
