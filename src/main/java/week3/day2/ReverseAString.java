package week3.day2;

public class ReverseAString {

    public static void main(String[] args) {
        String str = "Testleaf Learning";
        //String[] str1 = str.split(" ");
        char[] c = str.toCharArray();
        System.out.println(c.length);
        for(int i=c.length-1;i>=0;i--)
        {
            System.out.print(c[i]);
        }
       /* System.out.println("\n");
        for(int j=0;j<str1.length;j++)
        {
            char[] d= str1[j].toCharArray();
            for(int k=d.length-1;k>=0;k--)
                System.out.print(d[k]);
            System.out.print("\t");
        }*/
    }
}
