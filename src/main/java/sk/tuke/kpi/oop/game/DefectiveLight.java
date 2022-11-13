package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.actions.Invoke;
import sk.tuke.kpi.gamelib.framework.actions.Loop;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class DefectiveLight extends Light implements Repairable {
    private Animation lightAnimation;
    private int z;
    public DefectiveLight(){
        this.lightAnimation = new Animation("sprites/light_off.png");
        setAnimation(lightAnimation);
        z=0;
    }
    public void cyklusBlik(){
        new Loop<>(new Invoke<>(this::blik)).scheduleFor(this);
    }
    public void blik(){
        int x = (int)(Math.random() * 20);
        if(x==1){
            toggle();
        }


    }
    public boolean repair(){
        if(z==0){
            z=1;

        this.lightAnimation = new Animation("sprites/light_on.png");
        setAnimation(lightAnimation);
        lightAnimation.setFrameDuration(10);
        cyklusBlik();
        z=0;
        return true;
        }
        return false;
    }
}
