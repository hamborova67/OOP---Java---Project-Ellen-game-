package sk.tuke.kpi.oop.game.items;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.DefectiveLight;


public class Wrench extends BreakableTool<DefectiveLight> implements Collectible{

    private int remainingUses;

    public Wrench(){
        this(2);
    }
    public Wrench(int remainingUses){

        super(remainingUses);
        Animation wrenchAnimation = new Animation("sprites/wrench.png");
        setAnimation(wrenchAnimation);
        this.remainingUses=2;


    }
    public int getRemainingUses(){
        return this.remainingUses;
    }
    @Override
    public void useWith(DefectiveLight defectiveLight) {

        if(defectiveLight==null){
            return;
        }

        if(this.remainingUses<=0){
            getScene().removeActor(this);
            return;
        }
        if(!defectiveLight.repair()){
            return;
        }
        defectiveLight.repair();
        this.remainingUses--;
        if(this.remainingUses<=0){
            getScene().removeActor(this);

        }

    }

    @Override
    public Class<DefectiveLight> getUsingActorClass() {
        return null;
    }


}
