package sk.tuke.kpi.oop.game;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.actions.PerpetualReactorHeating;
import java.util.HashSet;
import java.util.Set;

public class Reactor extends AbstractActor implements Switchable, Repairable{
    private int temperature;
    private int damage;
    private boolean running;
    private Set<EnergyConsumer> devices;
    private EnergyConsumer energyConsumer;

    private Animation normalAnimation, normalAnimation_hot, normalAnimation_broken, normalAnimation_on;

    public Reactor(){
        this.temperature = 0;
        this.damage = 0;
        this.running = false;


        devices = new HashSet<>();
        this.normalAnimation = new Animation("sprites/reactor.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        this.normalAnimation_broken = new Animation("sprites/reactor_broken.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        this.normalAnimation_hot = new Animation("sprites/reactor_hot.png", 80, 80, 0.05f, Animation.PlayMode.LOOP_PINGPONG);
        this.normalAnimation_on = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
         setAnimation(normalAnimation);


    }
    public int getTemperature(){
        return this.temperature;
    }
    public int getDamage(){
        return this.damage;
    }
    public void increaseTemperature(int increment){

            if(!running){
                return;
            }
            if(increment<=0){
                return;
            }

            this.temperature =  this.temperature + increment;
            if(getTemperature()>=2000){

                this.damage =   ((this.temperature-2000) / 40) ;

            }
            if(getDamage()>=33 && getDamage()<=66 ){

                   this.temperature = this.temperature + (int)Math.floor(increment*1.5);

                }
            if(getDamage()>66){
                    this.temperature = this.temperature + (2*increment);

            }

            if(getTemperature()>=6000){
                this.damage = 100;

            }
            updateAnimation();

        }
        public void  decreaseTemperature(int decrement) {
            if(!isOn()){
                return;
            }
            if(decrement<=0){
                return;
            }
            if(getDamage()>=100 && !running){
                return;
            }

            if (getDamage() >= 50 && getDamage()<100) {
                this.temperature = this.temperature - (decrement / 2);
            }else{
                this.temperature = this.temperature - decrement;
            }


            updateAnimation();
        }

        public void updateAnimation(){
            if(getDamage()>=100){
                setAnimation(normalAnimation_broken);

            }
            if(isOn()){
                if(getTemperature()>4000 && getDamage()<100){
                    setAnimation(normalAnimation_hot);
                }

                if(getTemperature()<=4000){
                    setAnimation(normalAnimation_on);

                }

            }else{
                if(getDamage()<100 ){
                    setAnimation(normalAnimation);

                }
            }




}       @Override
        public boolean repair () {
            if(getDamage()==0){
                return false;
            }

            if (getDamage() >= 50) {
                this.damage = this.damage - 50;

            }
            if (getDamage() < 50){
                this.damage = 0;
            }

            return true;

    }
        @Override
        public void turnOn(){

            if(getDamage() >= 100) {
                return;
            }
            running=true;
            updateAnimation();
            for (EnergyConsumer energyConsumer : this.devices)
            {
                energyConsumer.setPowered(true);

            }

        }
        @Override
        public void turnOff(){
            running=false;
            this.temperature=getTemperature();
            updateAnimation();


                for (EnergyConsumer energyConsumer : this.devices)
                {
                    energyConsumer.setPowered(false);

                }

        }
         @Override
        public boolean isOn(){
            return running;
        }
        public void addLight(Light light){
            this.addDevice(light);
        }
        public void removeLight(Light light){
            this.removeDevice(light);
        }

        public void addDevice(EnergyConsumer energyConsumer){
        this.energyConsumer =energyConsumer;
        if( energyConsumer != null){
            this.devices.add(energyConsumer);


            energyConsumer.setPowered(running);


        }


        }
        public void removeDevice(EnergyConsumer energyConsumer){
            energyConsumer.setPowered(false);
            this.devices.remove(energyConsumer);

        }
    @Override
        public void addedToScene(@NotNull Scene scene) {
            super.addedToScene(scene);
            new PerpetualReactorHeating(1).scheduleFor(this);
        }

        public boolean extinguish(){

            if(this.getDamage()>=100 && this.getTemperature()>4000){
                this.temperature = 4000;
                this.normalAnimation = new Animation("sprites/reactor_extinguished.png");
                setAnimation(this.normalAnimation);
                return true;
            }

            return false;


        }


    public EnergyConsumer getEnergyConsumer() {
        return energyConsumer;
    }
}
