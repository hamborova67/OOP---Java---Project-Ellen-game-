package sk.tuke.kpi.oop.game.weapons;

public abstract class Firearm {
    private int initAmmo;
    private int maxAmmo;

    public Firearm(int initAmmo, int maxAmmo){
        this.initAmmo = initAmmo;
        this.maxAmmo = maxAmmo;
    }
    public Firearm(int initAmmo){
        this.initAmmo = initAmmo;
        this.maxAmmo = initAmmo;
    }


    public void setAmmo(int initAmmo) {
        this.initAmmo = initAmmo;
    }

    public int getAmmo(){
        return initAmmo;
    }
    public void reload(int newAmmo){
        int ammoPom = getAmmo()+newAmmo;
        if(ammoPom<maxAmmo){
            setAmmo(ammoPom);

        }else{
            setAmmo(maxAmmo);
        }

    }

    public int getMaxAmmo() {
        return maxAmmo;
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
