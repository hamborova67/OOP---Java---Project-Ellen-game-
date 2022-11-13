package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Disposable;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class DefectiveLight extends Light implements Repairable {
    private Animation lightAnimation;
    private Disposable dispose1;
    private int z;
    public DefectiveLight(){
        this.lightAnimation = new Animation("sprites/light_off.png");
        setAnimation(lightAnimation);
        z=0;
    }
    public void cyklusBlik(){

        dispose1 = new Loop<>(new Invoke<>(this::blik)).scheduleFor(this);
    }
    public void blik(){
        int x = (int)(Math.random() * 20);
        if(x==1){
            toggle();
        }



    }
    public boolean repair(){
        dispose1.dispose();
        this.turnOn();
        this.lightAnimation = new Animation("sprites/light_on.png");
        setAnimation(lightAnimation);
        dispose1 = new ActionSequence<>(
            new Wait<>(10),
            new Loop<>(new Invoke<>(this::cyklusBlik))
        ).scheduleFor(this);
        return false;

    }



    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        new Invoke<>(this::cyklusBlik).scheduleFor(this);

    }
}
