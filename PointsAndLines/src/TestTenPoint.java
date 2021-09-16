import point.Point;
import point.TenPoints;

public class TestTenPoint {

    public static void main(String[] args) {
        TenPoints tenPoints = new TenPoints();
        Point[] pointArray = tenPoints.tenPoints();

        for (int i = 0; i< pointArray.length; i++){
            System.out.print("Point "+(i+1)+": ");
            System.out.println(pointArray[i].toString());
            System.out.println();
        }
    }
}
