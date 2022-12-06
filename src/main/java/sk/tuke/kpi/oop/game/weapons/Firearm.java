package sk.tuke.kpi.oop.game.weapons;

public abstract class Firearm {
    private int initAmmo;
    private int maxAmmo;
    private Fireable fireable;

    public Firearm(int initAmmo, int maxAmmo){
        this.initAmmo = initAmmo;
        this.maxAmmo = maxAmmo;
    }
    public Firearm(int initAmmo){
        this.initAmmo = initAmmo;
    }

    public Firearm() {

    }

    public int getAmmo(){
        return 0;
    }
    public void reload(int amount){

    }
    public Fireable fire(){
        return fireable;
    }
    protected Fireable createBullet(){
        return fireable;
    }
}
