package PointLine;

public class Point {

    private int x;
    private int y;


    public Point(){

    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(int[] ar){
        this.x = ar[0];
        this.y = ar[1];
    }

    public int[] getXY(){
        return new int[]{x, y};
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){

        String pointInfo = "(x="+x+", y="+y+")"+
                            "\nDistance to origo: " + String.format("%.2f", distance());
        return pointInfo;
    }

    // Avstand fra punkt til et tilfeldig annet punkt satt av x og y
    public double distance(int x,int y){
        int xDiff=this.x-x;
        int yDiff=this.y-y;
        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }

    // Avstand fra punkt til Origo
    public double distance(){
        int xDiff=this.x;
        int yDiff=this.y;
        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }

    // Avstand mellom to punkter
    public double distance(Point point){
        int xDiff=this.x - point.x;
        int yDiff=this.y - point.y;
        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }

    public double distance(Point point, Point point2){
        int xDiff=point.x - point2.x;
        int yDiff=point.y - point2.y;
        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }


}
