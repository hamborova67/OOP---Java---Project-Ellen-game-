package sk.tuke.kpi.oop.game;


import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.Scenario;

public class Gameplay extends Scenario {

    public void setupPlay(Scene scene) {
        Reactor reactor = new Reactor();
        scene.addActor(reactor, 148, 92);
        reactor.turnOn();

    }

}

