package sk.tuke.kpi.oop.game.behaviours;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.messages.Topic;

import java.util.function.Predicate;

public class Observing<T, A extends Actor> implements Behaviour<A> {
    private Topic<T> topic;
    private Predicate<T> predicate;
    private Behaviour<A> delegate;
    public Observing(Topic<T> topic, Predicate<T> predicate, Behaviour<A> delegate){

    }

    @Override
    public void setUp(A actor) {

    }
}
