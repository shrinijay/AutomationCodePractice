package week3.day1.assignments;

public class RemoveDuplicatesWords {
    public static void main(String[] args) {
        String text = "We learn java basics as part of java sessions in java week1" , temp, str2="";


       String[] str = text.split(" ");
        for(int i=0;i<str.length;i++)
        {
            int count = 0;
            temp = str[i];
            for(int j=0;j< str.length;j++)
            {
                if(temp.equals(str[j]))
                    count++;
            }
            if(count > 1)
                str[i] = "";
            str2+= str[i]+" ";
        }
        System.out.println("Text after duplicates removal "+str2);
    }
}
