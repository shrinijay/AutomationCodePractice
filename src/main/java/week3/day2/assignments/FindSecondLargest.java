package week3.day2.assignments;

import java.util.*;

public class FindSecondLargest {

    public static void main(String[] args) {
        int[] data = {3,2,11,4,6,7,2,3,3,6,7};

        Set<Integer> integerSet = new TreeSet<>();
        for(int i=0;i<data.length;i++)
            integerSet.add(data[i]);
        System.out.println("Set is "+integerSet);

        List<Integer> list = new ArrayList<>();
        Iterator itr = integerSet.iterator();
        while(itr.hasNext())
        {
            list.add((Integer) itr.next());
        }
        System.out.println("List is "+list);
        System.out.println("Second largest "+list.get(list.size()-2));

    }
}
