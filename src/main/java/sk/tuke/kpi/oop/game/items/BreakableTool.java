package sk.tuke.kpi.oop.game.items;
import sk.tuke.kpi.gamelib.Actor;
import sk.tuke.kpi.gamelib.framework.AbstractActor;

public  abstract class BreakableTool<A extends Actor> extends AbstractActor implements Usable<A>{
    private int remainingUses;

    protected  BreakableTool(){

    } //toto som si domyslela
    protected BreakableTool(int remainingUses){
        this.remainingUses = remainingUses;

    }
    public int getRemainingUses(){
        return this.remainingUses;
    }

    public void useWith(A actor){
        if(actor == null){
            return;
        }
        if(this.remainingUses<=0){
            getScene().removeActor(this);
            return;
        }
        this.remainingUses--;
        if(this.remainingUses<=0){
            getScene().removeActor(this);
        }

    }

}
