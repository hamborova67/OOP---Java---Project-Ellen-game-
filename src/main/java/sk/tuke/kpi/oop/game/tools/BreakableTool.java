package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;

public  abstract class BreakableTool<A extends Actor> extends AbstractActor implements Usable<A>{
    private int remainingUses;

    protected  BreakableTool(){

    } //toto som si domyslela
    protected BreakableTool(int remainingUses){
        this.remainingUses = remainingUses;

    }
    public int getUses(){
        return this.remainingUses;
    }

    public void useWith(Actor actor){
        if(actor == null){
            return;
        }
        if(this.remainingUses<=0){
            getScene().removeActor(actor);
            return;
        }
        this.remainingUses--;

    }

}
