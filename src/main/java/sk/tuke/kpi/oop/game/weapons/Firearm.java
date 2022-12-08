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


    public void setAmmo(int initAmmo) {
        this.initAmmo = initAmmo;
    }

    public int getAmmo(){
        return initAmmo;
    }
    public void reload(int newAmmo){
        int ammoPom = initAmmo+newAmmo;

        if(ammoPom<maxAmmo){
            initAmmo=ammoPom;
        }else{
            initAmmo=maxAmmo;
        }

    }
    public Fireable fire(){
        if(initAmmo<=0){
            return null;
        }
        initAmmo--;
        return createBullet();
    }
    protected Fireable createBullet(){
        return new Bullet();
    }
}
