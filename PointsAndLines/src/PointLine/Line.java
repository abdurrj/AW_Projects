package PointLine;

public class Line {

    private Point a;
    private Point b;

    public Line() {

    }

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public void setPointAB(Point a, Point b){
        this.a = a;
        this.b = b;
    }

    public Point[] getAB(){
        return new Point[]{a,b};
    }

    public String toString(){
        int[] aPos = a.getXY();
        int[] bPos = b.getXY();
        String output =
                String.format("a=(x=%d, y=%d), b=(x=%d, y=%d)",
                        aPos[0], aPos[1], bPos[0], bPos[1]);
        return output;
    }

    public double length(){
        return a.distance(b);
    }
}
