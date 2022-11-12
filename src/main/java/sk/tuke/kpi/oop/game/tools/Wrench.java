package sk.tuke.kpi.oop.game.tools;

import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.DefectiveLight;
import sk.tuke.kpi.oop.game.Reactor;

public class Wrench extends BreakableTool{
    private Animation wrenchAnimation;
    private int remainingUses;
    private DefectiveLight defectiveLight;
    public Wrench(){
        this(2);
    }
    public Wrench(int remainingUses){

        //super(remainingUses); //vzdy ako prvy volat
        this.wrenchAnimation = new Animation("sprites/wrench.png");
        setAnimation(this.wrenchAnimation);
        this.remainingUses=2;


    }
    public int getRemainingUses(){
        return this.remainingUses;
    }
    public void useWith(DefectiveLight defectiveLight) {

        if(defectiveLight==null){
            return;
        }

        if(this.remainingUses<=0){
            getScene().removeActor(this);
            return;
        }
        this.defectiveLight = defectiveLight;
        defectiveLight.repair();
        this.remainingUses--;
        if(this.remainingUses<=0){
            getScene().removeActor(this);

        }

    }
}
