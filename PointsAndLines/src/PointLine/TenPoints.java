package PointLine;

public class TenPoints {


    public static Point[] tenPoints(){

        Point[] pointsArray = new Point[10];
        for (int i = 0; i<10; i++){
            pointsArray[i] = new Point(i+1,i+1);
        }
        return pointsArray;
    }

}