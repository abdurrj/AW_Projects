import PointLine.Point;
import PointLine.TenPoints;

public class TestTenPoint {

    public static void main(String[] args) {
        Point[] pointArray = TenPoints.tenPoints();

        for (int i = 0; i< pointArray.length; i++){
            System.out.print("PointLine.Point "+(i+1)+": ");
            System.out.println(pointArray[i].toString());
            System.out.println();
        }
    }
}
