package sk.tuke.kpi.oop.game;

public enum Direction {
    NORTH(0,1), EAST(1,0), SOUTH(0, -1),  WEST(-1,0);
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
        return NORTH.direction;
    }
}

