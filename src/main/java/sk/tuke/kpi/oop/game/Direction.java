package sk.tuke.kpi.oop.game;

public enum Direction {
    NORTH(0,1), EAST(1,0), SOUTH(0, -1),  WEST(-1,0), NONE(0,0),
    NORTHEAST(1,1), NORTHWEST(-1,1), SOUTHEAST(1,-1), SOUTHWEST(0,-1);
    private int dx,dy;

    private float angle;
    Direction(int dx, int dy) {
        this.dx=dx;
        this.dy=dy;

    }
    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }
    public float getAngle(){
        float angle = (float) Math.toDegrees(Math.atan2(dx, dy));

        if(angle < 0){
            angle += 360;
        }
        if(dx==1 || dx==-1){
            angle=angle-180;
        }

        return angle;
    }
    public static Direction fromAngle(float angle){
        if(angle==0.0){
            return NORTH;
        }
        if(angle==90.0){
            return WEST;
        }
        if (angle==180.0) {
            return SOUTH;
        }
        if(angle==270.0){
            return EAST;
        }
        if(angle==315.0){
            return NORTHEAST;
        }
        if(angle==45.0){
            return NORTHWEST;
        }
        if(angle==225.0){
            return SOUTHEAST;
        }
        if(angle==135.0){
            return SOUTHWEST;
        }
        return NONE;


    }
    public Direction combine(Direction other){

        int x,y;
        x=other.dx + this.getDx();
        y=other.dy + this.getDy();

        if(this.getDy()==other.getDy()){
            x=this.getDx();
        }
        if(this.getDy()==other.getDy()){
            y=this.getDy();
        }

        if(x==2){
            x=1;
        }
        if(x==-2){
            x=-1;
        }
        if(y==2){
            y=1;
        }
        if(y==-2){
            y=-1;
        }

        Direction direction=NONE;
        for(Direction c : Direction.values()){
            if(c.getDx()==x && c.getDy()==y){
                direction=c;
            }
        }
        return direction;
    }
}

