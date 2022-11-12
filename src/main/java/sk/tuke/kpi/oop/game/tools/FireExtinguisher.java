package sk.tuke.kpi.oop.game.tools;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;



public class FireExtinguisher extends BreakableTool<Reactor>{

    private Animation extinguisherAnimation;

    private int remainingUses;

    private Reactor reactor;

    public FireExtinguisher(){
        this(1);

    }
    public FireExtinguisher(int remainingUses){
        super(1);
        this.extinguisherAnimation = new Animation("sprites/extinguisher.png");

        setAnimation(this.extinguisherAnimation);
        this.remainingUses=1;
    }
    public int getRemainingUses(){
        return this.remainingUses;
    }

    public void useWith(){
        if(reactor==null){
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
