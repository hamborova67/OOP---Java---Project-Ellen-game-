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
        if(angle==0.0){
            return NORTH.direction;
        }
        if(angle==90.0){
            return WEST.direction;
        }
        if (angle==180.0) {
            return SOUTH.direction;
        }
        if(angle==270.0){
            return EAST.direction;
        }
        if(angle==315.0){
            return NORTHEAST.direction;
        }
        if(angle==45.0){
            return NORTHWEST.direction;
        }
        if(angle==225.0){
            return SOUTHEAST.direction;
        }
        if(angle==135.0){
            return SOUTHWEST.direction;
        }
        return NONE.direction;


    }
    public Direction combine(Direction other){

        int x,y;



        if(this.getDy()==other.getDy()){
            x=this.getDx();
        }else{
            x=other.dx + this.getDx();
        }
        if(this.getDy()==other.getDy()){
            y=this.getDy();
        }else{
            y=other.dy + this.getDy();
        }

        direction=NONE;
        for(Direction c : Direction.values()){
            if(c.getDx()==x && c.getDy()==y){
                direction=c;
            }
        }
        return direction;
    }
}

