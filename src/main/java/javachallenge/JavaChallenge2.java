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

        Set<Map.Entry<Integer,Integer>> keysOnly = arrMap.entrySet();

        for( Map.Entry<Integer,Integer> each : keysOnly)



        {
            if(each.getValue()==1)
                System.out.println(each);
        }


    }


}
