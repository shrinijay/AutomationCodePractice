package week1.day2.assignments;

import java.util.Arrays;

public class FindingSecondLargest {
    public static void main(String[] args) {
        int[] data = {3,2,11,4,6,7};

        Arrays.sort(data);
        System.out.println("Second Largest is "+data[data.length-2]);
    }
}
