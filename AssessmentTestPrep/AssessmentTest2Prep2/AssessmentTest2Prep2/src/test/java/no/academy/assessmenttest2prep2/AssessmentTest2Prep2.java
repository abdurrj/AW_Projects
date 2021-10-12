package no.academy.assessmenttest2prep2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssessmentTest2Prep2 {

    @Test
    public void reverseString() {
        Assert.assertEquals(Methods.reverseString("AWAcademy"), "ymedacAWA");
        Assert.assertEquals(Methods.reverseString("Alt for Norge"), "egroN rof tlA");
        Assert.assertEquals(Methods.reverseString("Det er nesten fredag!"), "!gaderf netsen re teD");
    }

    @Test
    public void reverseList() {
        List<String> coolOrderedList = new ArrayList<>();
        coolOrderedList.add("a");
        coolOrderedList.add("b");
        coolOrderedList.add("c");
        coolOrderedList.add("d");

        List<String> coolReverseOrderedList = new ArrayList<>();
        coolReverseOrderedList.add("d");
        coolReverseOrderedList.add("c");
        coolReverseOrderedList.add("b");
        coolReverseOrderedList.add("a");

        Assert.assertEquals(Methods.reverseList(coolOrderedList), coolReverseOrderedList);
    }

    @Test
    public void volumeOfAPyramid() {
        Assert.assertEquals(Methods.volumeOfAPyramid(10, 10, 10), 333.33, 0.33);
        Assert.assertEquals(Methods.volumeOfAPyramid(1, 2, 3), 2, 0.1);
        Assert.assertEquals(Methods.volumeOfAPyramid(5, 10, 20), 333.33, 0.33);
    }

    @Test
    public void volumeOfASphere() {
        Assert.assertEquals(Methods.volumeOfASphere(10), 4188.79, 0.1);
        Assert.assertEquals(Methods.volumeOfASphere(42), 310339.08, 0.1);
        Assert.assertEquals(Methods.volumeOfASphere(2), 33.51, 0.1);
    }

    @Test
    public void YELLTHENAMESWITHSTREAM() {
        List<String> stringListOne = Arrays.asList("Berit", "Gunnar", "Jens", "Ann-Kristin");
        List<String> stringListResultOne = Arrays.asList("BERIT", "GUNNAR", "JENS", "ANN-KRISTIN");
        List<String> stringListTwo = Arrays.asList("Per", "Pia", "Gunter");
        List<String> stringListResultTwo = Arrays.asList("PER", "PIA", "GUNTER");

        Assert.assertEquals(Methods.yellNames(stringListOne), stringListResultOne);
        Assert.assertEquals(Methods.yellNames(stringListTwo), stringListResultTwo);
    }

    @Test
    public void steamsStreamsStreamsStreams() {
        Assert.assertEquals(Methods.getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam"), 14);
        Assert.assertEquals(Methods.getTotalNumberOfLettersOfNamesLongerThanFive("jake", "jones", "elisabeth"), 9);
        Assert.assertEquals(Methods.getTotalNumberOfLettersOfNamesLongerThanFive("aaron"), 0);
        Assert.assertEquals(Methods.getTotalNumberOfLettersOfNamesLongerThanFive("zac", "liam", "gregory"), 7);
        Assert.assertEquals(Methods.getTotalNumberOfLettersOfNamesLongerThanFive("gary", "john", "dave", "james"), 0);
    }

    @Test
    public void checkIfPrimeNumber() {
        Assert.assertTrue(Methods.isPrimeNumber(2));
        Assert.assertTrue(Methods.isPrimeNumber(59));
        Assert.assertTrue(Methods.isPrimeNumber(83));
        Assert.assertTrue(Methods.isPrimeNumber(97));

        Assert.assertFalse(Methods.isPrimeNumber(51));
        Assert.assertFalse(Methods.isPrimeNumber(42));
    }

    @Test
    public void calculateBricksCorrectly() {
        Assert.assertTrue(Methods.calculateIfWeCanSucceedAtBrickLaying(3, 1, 8));
        Assert.assertTrue(Methods.calculateIfWeCanSucceedAtBrickLaying(3, 2, 10));
        Assert.assertTrue(Methods.calculateIfWeCanSucceedAtBrickLaying(43, 1, 46));
        Assert.assertTrue(Methods.calculateIfWeCanSucceedAtBrickLaying(7, 1, 8));

        Assert.assertFalse(Methods.calculateIfWeCanSucceedAtBrickLaying(7, 1, 13));
        Assert.assertFalse(Methods.calculateIfWeCanSucceedAtBrickLaying(3, 2, 9));
        Assert.assertFalse(Methods.calculateIfWeCanSucceedAtBrickLaying(3, 1, 9));
        Assert.assertFalse(Methods.calculateIfWeCanSucceedAtBrickLaying(40, 1, 46));
    }

    @Test
    public void getSecondLargestElementInAnArray() {
        int[] arr1 = {10, 5, 8, 1, 4, 2};
        int[] arr2 = {99, 41, 61, 68, 1, 89};
        int[] arr3 = {998, 999, 999, 999, 999, 999};

        Assert.assertEquals(Methods.getSecondLargestNumberInArray(arr1), 8);
        Assert.assertEquals(Methods.getSecondLargestNumberInArray(arr2), 89);
        Assert.assertEquals(Methods.getSecondLargestNumberInArray(arr3), 998);
    }

    @Test
    public void getNumberOccurringMultipleTimes() {
        int[] array1 = {10, 20, 20, 30, 40};
        int[] array2 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 9};
        int[] array3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 9};

        Assert.assertEquals(Methods.getNumberOccurringMultipleTimes(array1), 20);
        Assert.assertEquals(Methods.getNumberOccurringMultipleTimes(array2), 9);
    }

    @Test
    public void doubleValueUsingStream() {
        List<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> array1_Sol = new ArrayList<>(Arrays.asList(2, 4, 6));
        List<Integer> array2 = new ArrayList<>(Arrays.asList(6, 8, 6, 8, -1));
        List<Integer> array2_Sol = new ArrayList<>(Arrays.asList(12, 16, 12, 16, -2));
        List<Integer> array3 = new ArrayList<>(Arrays.asList());
        List<Integer> array3_Sol = new ArrayList<>(Arrays.asList());
        Assert.assertEquals(Methods.doubleAllValuesWithStream(array1), array1_Sol);
        Assert.assertEquals(Methods.doubleAllValuesWithStream(array2), array2_Sol);
        Assert.assertEquals(Methods.doubleAllValuesWithStream(array3), array3_Sol);
    }

    @Test
    public void findStartsWithCAndSortAndUppercase() {
        List<String> aList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        List<String> aList_Sol = Arrays.asList("C1", "C2");
        Assert.assertEquals(Methods.filterAndUppercaseAndSort(aList), aList_Sol);
    }
}
