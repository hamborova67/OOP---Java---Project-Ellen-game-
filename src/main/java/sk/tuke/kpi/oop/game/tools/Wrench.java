package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.DefectiveLight;
import sk.tuke.kpi.oop.game.Reactor;

public class Wrench extends BreakableTool<DefectiveLight>{

    private int remainingUses;

    public Wrench(){
        this(2);
    }
    public Wrench(int remainingUses){

        //super(remainingUses); //vzdy ako prvy volat
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


}
