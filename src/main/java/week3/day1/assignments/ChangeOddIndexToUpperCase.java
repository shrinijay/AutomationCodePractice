package week3.day1.assignments;

public class ChangeOddIndexToUpperCase {

    public static void main(String[] args) {
        String str = "changeme",temp, str2="";
        char[] charArr = str.toCharArray();
        for(int i=0;i<charArr.length;i++)
        {
            if(i%2!=0){
                temp = String.valueOf(charArr[i]).toUpperCase();
                charArr[i] = temp.charAt(0);
            }
            str2+=charArr[i];
        }
        System.out.println("Manipulated string is "+str2);
    }
}
