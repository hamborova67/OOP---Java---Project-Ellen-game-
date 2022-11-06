package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.framework.Player;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;


public class Helicopter extends AbstractActor {



    private int x,y;

    public Helicopter(){
        Animation helicopterAnimation = new Animation("sprites/heli.png",64, 64, 0.2f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(helicopterAnimation);
    }
    public void searchAndDestroy() {
        new Loop<>(new Invoke<>(this::hunt)).scheduleFor(this);
    }

    public void hunt(){
        Player player = getScene().getLastActorByType(Player.class);

        if (this.getPosX() != player.getPosX() || this.getPosY() != player.getPosY() ) {
            if(this.getPosX() < player.getPosX()) {
                x = this.getPosX() + 1;
            } else {
                x = this.getPosX() - 1;
            }
            if(this.getPosY() < player.getPosY()) {
                y = this.getPosY() + 1;
            } else {
                y = this.getPosY() - 1;
            }
            this.setPosition(x, y);
        }else{
            player.setEnergy(player.getEnergy()-1);
        }






    }

}
