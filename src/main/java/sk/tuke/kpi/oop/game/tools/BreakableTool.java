package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.framework.AbstractActor;

public  abstract class BreakableTool extends AbstractActor {
    private int remainingUses;

    protected  BreakableTool(){
        this(1);
    } //toto som si domyslela
    protected BreakableTool(int remainingUses){
        this.remainingUses = remainingUses;

    }
    public int getUses(){
        return this.remainingUses;
    }
    public void use(){
        if(this.remainingUses<=0){
            return;
        }
        this.remainingUses--;

    }

}
