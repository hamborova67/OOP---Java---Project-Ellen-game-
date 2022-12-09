package sk.tuke.kpi.oop.game;

public enum Direction {
                                          NORTH(0,1),
                NORTHWEST(-1,1),                          NORTHEAST(1,1),
             WEST(-1,0),                                                 EAST(1,0),
                SOUTHWEST(-1,-1),                          SOUTHEAST(1,-1),
                                          SOUTH(0, -1),


    NONE(0,0);
    private int dx,dy;


    private float angle;
    private
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
        if((dx==1 || dx==-1) && dy==0){
            angle=angle-180;
        }
        if(dx !=0 && dy != 0){
            angle=-angle;
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
        x= getDx() + other.getDx() ;
        y=getDy() + other.getDy();

        if(x==2 || x==-2 ){
            x=x/2;
        }
        if(y==2 || y==-2){
            y=y/2;
        }

        Direction direction=null;

        for (Direction c : Direction.values()) {
            if (c.getDx() == x && c.getDy() == y)
            {
                direction=c;
            }
        }

        return direction;
    }
}

