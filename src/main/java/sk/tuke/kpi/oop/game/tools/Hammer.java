package sk.tuke.kpi.oop.game.tools;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;

public class Hammer extends BreakableTool{
    private Animation hammerAnimation;
    private int remainingUses;
    private Reactor reactor;
    public Hammer(){
        this(2);
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
    public void useWith(Reactor reactor) {
        if(this==null){
            return;
        }

        if(this.remainingUses<=0){
            getScene().removeActor(this);
            return;
        }
        this.getReactor(reactor);
        reactor.repair();
        this.remainingUses--;
        if(this.remainingUses<=0){
            getScene().removeActor(this);

        }

    }
    public void getReactor(Reactor reactor){
        this.reactor = reactor;
    }



}
