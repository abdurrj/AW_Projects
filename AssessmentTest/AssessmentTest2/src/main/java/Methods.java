import java.util.Collections;
import java.util.List;

public class Methods {

    public static int calculateSurfaceAreaOrVolumeOfCube(boolean surfaceCalculation, int width) {
        if (surfaceCalculation){
            return 6*width*width;
        }

        return (int) Math.pow(width,3);
    }


    public static int sumEdges(int[] arr, boolean add10000) {
        int result = 0;
        if (add10000){
            result +=10000;
        }
        result += arr[0] + arr[arr.length-1];
        return result;
    }

    public static void sortByNumberOfFollowers(List<Religion> religions) {
        Collections.sort(religions, (o2, o1) -> o1.getNumberOfFollowers() - o2.getNumberOfFollowers());
    }
}
