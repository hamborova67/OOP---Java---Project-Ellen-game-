package sk.tuke.kpi.oop.game;

public enum Direction {
    NORTH(0,1), EAST(1,0), SOUTH(0, -1),  WEST(-1,0), NONE(0,0),
    NORTHEAST(1,1), NORTHWEST(-1,1), SOUTHEAST(1,-1), SOUTHWEST(0,-1);
    private int dx,dy;
    private Direction direction;

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
        if(angle==0){
            return NORTH.direction;
        }
        else if(angle==90){
            return WEST.direction;
        }
        else if (angle==180) {
            return SOUTH.direction;
        }
        else if(angle==270){
            return EAST.direction;
        }
        else if(angle==315){
            return NORTHEAST.direction;
        }
        else if(angle==45){
            return NORTHWEST.direction;
        }
        else if(angle==225){
            return SOUTHEAST.direction;
        }
        else if(angle==135){
            return SOUTHWEST.direction;
        }
        else{
            return NONE.direction;
        }

    }
    public Direction combine(Direction other){
        int x,y;
        x=other.dx + this.getDx();
        y=other.dy + this.getDy();

        for(Direction c : Direction.values()){
            if(c.getDx()==x && c.getDy()==y){
                direction=c;
                return direction;
            }
            else{
                direction=NONE;
            }
        }

        return direction;
    }
}

