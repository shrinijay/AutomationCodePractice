package javachallenge;

import java.util.*;

public class JavaChallenge2 {

    //Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    public static void main(String[] args) {
        int[] num = {4,1,2,2,1};

        Map<Integer,Integer> arrMap = new HashMap<>();

        for(int i=0;i<num.length;i++)
        {
            if(arrMap.containsKey(num[i]))
            {
                arrMap.put(num[i],arrMap.get(num[i])+1);
            }
            else
                arrMap.put(num[i],1);
        }

        Set<Integer> keysOnly = arrMap.keySet();

        for(Integer key : keysOnly)
        {
            System.out.println("printing "+arrMap.get(key));
            if(arrMap.get(key)==1)
                System.out.println("The unique element is "+arrMap.entrySet());
        }

        System.out.println("Map is "+arrMap);

    }


}
