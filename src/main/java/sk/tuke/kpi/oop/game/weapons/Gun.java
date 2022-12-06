package sk.tuke.kpi.oop.game.weapons;

public class Gun extends Firearm{
    private int initAmmo;
    private int maxAmmo;
    public Gun(int initAmmo, int maxAmmo){
        super();
        this.initAmmo = initAmmo;
        this.maxAmmo = maxAmmo;
    }
}
