package sk.tuke.kpi.oop.game.tools;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;


public class Hammer extends BreakableTool<Reactor>{

    private int remainingUses;

    public Hammer(){
        this(1);
    }
    public Hammer(int remainingUses){

        super(remainingUses); //vzdy ako prvy volat
        Animation hammerAnimation = new Animation("sprites/hammer.png");
        setAnimation(hammerAnimation);
        this.remainingUses=remainingUses;


    }
    public int getRemainingUses(){
        return this.remainingUses;
    }

    public void useWith(Reactor reactor) {
        if(reactor==null){
            return;
        }
        if(!reactor.repair()){
            return;
        }
        reactor.repair();
        this.remainingUses--;
        if(this.remainingUses<=0){
            getScene().removeActor(this);

        }
    }




}
