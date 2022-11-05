package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.actions.Invoke;


public class Cooler extends Reactor {
    private Animation coolerAnimation;
    private int pom;
    private Reactor reactor;


    public Cooler(Reactor reactor){
        this.coolerAnimation = new Animation("sprites/fan.png", 32, 32, 0.2f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(coolerAnimation);
        coolerAnimation.pause();
        this.reactor = reactor;
        this.pom=0;
    }

    public void coolReactor(){
        if(reactor==null){
            return;
        }
        if(pom==1){
            if(reactor.getTemperature()>0){
                reactor.decreaseTemperature(1);
            }
        }

    }

    @Override
    public void turnOn() {
        coolerAnimation.play();
        this.pom=1;
    }

    @Override
    public void turnOff() {
        this.coolerAnimation = new Animation("sprites/fan.png", 32, 32, 0.2f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(coolerAnimation);
        coolerAnimation.pause();
        this.pom=0;

    }

    public int isOn(){
        return pom;
    }

    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Loop<>(new Invoke<>(this::coolReactor)).scheduleFor(this);
    }
}
