import point.Line;
import point.Point;

public class TestProgramLine {

    public static void main(String[] args) {

        Point pointAA = new Point(1,1);
        Point pointAB = new Point(1,6);
        Point pointBA = new Point(2, 1);
        Point pointBB = new Point(2, 6);

        Line lineA = new Line(pointAA, pointAB);
        Line lineB = new Line(pointBA, pointBB);

        System.out.println(lineA);
        System.out.println(lineA.length());
        System.out.println(lineB.length());

        double lineDiff = checkLength(lineA, lineB);
        if (lineDiff==0.0) {
            System.out.println("The lines have equal length");
        }
        else if (lineDiff>0.0) {
            System.out.println("Line A is longer than Line B");
        }
        else {
            System.out.println("Line B is longer than Line A");
        }
    }

    private static double checkLength(Line a, Line b){
        return a.length()-b.length();
    }

}
