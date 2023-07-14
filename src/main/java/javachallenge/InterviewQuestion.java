package javachallenge;

public class InterviewQuestion {

    public static void main(String[] args) {
        String str = "Shrinidhi"; String str1 = null;

        int length = str.length();

        char[] c = str.toCharArray();

        for (int i = 0; i < length - 1; i++) {
            int flag = 0;
           char ch = str.charAt(i);
            for (int j = i+1; j < c.length; j++) {
                if(c[j]==ch)
                {
                    flag = 1;
                    break;
                }

            }
            if(flag ==0)
                System.out.print(ch+"\t");
        }

    }
}
