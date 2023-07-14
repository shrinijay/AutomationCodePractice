package week3.day1.assignments;

public class ReverseEvenWords {

    public static void main(String[] args) {
        String test = "I am a software tester" , str2="", temp="";
        String[] str = test.split(" ");
        for (int i = 0; i < str.length; i++) {

            if (i % 2 != 0) {
                char[] charArr = str[i].toCharArray();
                for (int j = charArr.length - 1; j >= 0; j--) {
                    temp += charArr[j];
                }
                str[i] = temp;
            }
            str2=str2+" "+str[i];
        }
        System.out.println("Final String is "+str2);
    }
}
