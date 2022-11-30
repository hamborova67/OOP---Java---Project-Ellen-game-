package sk.tuke.kpi.oop.game.scenarios;


import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.Scenario;
import sk.tuke.kpi.oop.game.Reactor;

public class TrainingGameplay extends Scenario {

    public void setupPlay(Scene scene) {
        Reactor reactor = new Reactor();
        scene.addActor(reactor, 148, 92);

        reactor.turnOn();


    }

}

