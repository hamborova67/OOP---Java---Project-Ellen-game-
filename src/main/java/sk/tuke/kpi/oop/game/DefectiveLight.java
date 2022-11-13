package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Disposable;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.actions.ActionSequence;
import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.actions.Wait;
import sk.tuke.kpi.gamelib.framework.actions.Loop;

public class DefectiveLight extends Light implements Repairable {

    private Disposable dispose1;

    public DefectiveLight(){

    }

    public void blik(){
        int x = (int)(Math.random() * 20);
        if(x==1){
            toggle();
        }



    }
    public boolean repair(){
        if(dispose1==null){
            return false;
        }else{
            dispose1.dispose();
        }

        this.turnOn();
        dispose1 = new ActionSequence<>(
            new Wait<>(10),
            new Loop<>(new Invoke<>(this::blik))
        ).scheduleFor(this);
        return false;

    }



    @Override
    public void addedToScene(@NotNull Scene scene) {
        super.addedToScene(scene);
        dispose1 = new Loop<>(new Invoke<>(this::blik)).scheduleFor(this);


    }
}
