package week1.day2.assignments;

public class ArrayDuplicates {
    public static void main(String[] args) {
        int[] nums = {2,5,7,7,5,9,2,3};

        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j< nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    System.out.println("duplicate is found for number "+nums[i]);
                }
            }
        }

    }
}
