
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AssessmentTest2Level1 {


    @Test
    public void calculateSurfaceAreaOrVolumeOfCube() {
        // surface area (area of all 6 sides) of cube with width 10
        int result = Methods.calculateSurfaceAreaOrVolumeOfCube(true, 10); //6*10*10
        Assert.assertEquals(600, result);

        // volume of cube with width 10
        result = Methods.calculateSurfaceAreaOrVolumeOfCube(false, 10); //10*10*10
        Assert.assertEquals(1000, result);

        // surface area (area of all 6 sides) of cube with width 7
        result = Methods.calculateSurfaceAreaOrVolumeOfCube(true, 7); //6*7*7
        Assert.assertEquals(294, result);

        // volume of cube with width 7
        result = Methods.calculateSurfaceAreaOrVolumeOfCube(false, 7); //7*7*7
        Assert.assertEquals(343, result);
    }

    @Test
    public void sumEdgesAndMaybeAdd10000() {

        // edges = first and last element (sum edges and maybe add 10000 = sum first and last element and maybe add 10000)

        Assert.assertEquals(19, Methods.sumEdges(new int[] {4, 11, 15}, false)); // 4+15
        Assert.assertEquals(10019, Methods.sumEdges(new int[] {4, 11, 15}, true)); // 4+15+10000

        Assert.assertEquals(8, Methods.sumEdges(new int[] {6,2}, false)); // 6+2
        Assert.assertEquals(10008, Methods.sumEdges(new int[] {6,2}, true)); // 6+2+10000

        Assert.assertEquals(177, Methods.sumEdges(new int[] {100, 200, 500, 77}, false)); // 100+77
        Assert.assertEquals(10177, Methods.sumEdges(new int[] {100, 200, 500, 77}, true)); // 100+77+10000
    }

    @Test
    public void createAndDescribeReligions() {
        Religion hinduism = new Religion("Hinduism", "India", 1300000000);
        Assert.assertEquals("Hinduism started in India and has 1300 million followers", hinduism.describe());

        Religion islam = new Religion("Islam", "the Middle East", 1600000000);
        Assert.assertEquals("Islam started in the Middle East and has 1600 million followers", islam.describe());

        Religion buddhism = new Religion("Buddhism", "Asia", 500000000);
        Assert.assertEquals("Buddhism started in Asia and has 500 million followers", buddhism.describe());
    }

    @Test
    public void sortReligionsByNumberOfFollowers() {
        Religion hinduism = new Religion("Hinduism", "India", 1300000000);
        Religion buddhism = new Religion("Buddhism", "Asia", 500000000);
        Religion islam = new Religion("Islam", "the Middle East", 1600000000);
        List<Religion> religions = Arrays.asList(hinduism, buddhism, islam);

        Methods.sortByNumberOfFollowers(religions);

        Assert.assertEquals("Islam", religions.get(0).getName());
        Assert.assertEquals("Hinduism", religions.get(1).getName());
        Assert.assertEquals("Buddhism", religions.get(2).getName());
    }
}