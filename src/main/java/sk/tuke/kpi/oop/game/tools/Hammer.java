package sk.tuke.kpi.oop.game.tools;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Hammer extends BreakableTool{
    private Animation hammerAnimation;
    private int remainingUses;
    public Hammer(){
        this(1);
    }
    public Hammer(int remainingUses){
        super(remainingUses); //vzdy ako prvy volat
        this.hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(this.hammerAnimation);
        this.remainingUses=1;

    }
    public int getRemainingUses(){
        return this.remainingUses;
    }
    public void useWith() {
        if(this.remainingUses<=0){
            getScene().removeActor(this);
            return;
        }
        this.remainingUses--;

    }

}
