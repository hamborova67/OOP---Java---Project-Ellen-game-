package sk.tuke.kpi.oop.game.tools;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.Reactor;



public class FireExtinguisher extends BreakableTool<Reactor>{
    private int remainingUses;

    public FireExtinguisher(){
        this(1);

    }
    public FireExtinguisher(int remainingUses){
        super(1);
        Animation extinguisherAnimation = new Animation("sprites/extinguisher.png");
        setAnimation(extinguisherAnimation);
        this.remainingUses =1;

    }
    public int getRemainingUses(){
        return remainingUses;
    }
    @Override
    public void useWith(Reactor reactor){
        if(reactor==null){
            return;
        }
        if(!reactor.extinguish()){
            return;
        }
        if(this.remainingUses<=0){
            getScene().removeActor(this);
            return;
        }
        reactor.extinguish();
        this.remainingUses--;
        if(this.remainingUses<=0){
            getScene().removeActor(this);

        }
    }


}
