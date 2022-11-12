package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;

public  abstract class BreakableTool extends AbstractActor implements Usable{
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
        if(this.remainingUses<=0){
            getScene().removeActor(this);
            return;
        }
        this.remainingUses--;

    }

}
