package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class SmartCooler extends Cooler{

    private Reactor reactor;
    public SmartCooler(Reactor reactor){
        super(reactor);
        this.reactor =reactor;
    }

    @Override
    public void coolReactor() {
        if(reactor==null){
            return;
        }
        if(reactor.getTemperature()<= 1500){
            turnOff();
        }
        if(reactor.getTemperature()>=2500){
            turnOn();
        }

        if(isOn()){
            reactor.decreaseTemperature(1);
        }
    }

    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Loop<>(new Invoke<>(this::coolReactor)).scheduleFor(this);
    }



}
