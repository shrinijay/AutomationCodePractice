package week1.day1.assignments;

public class FibonacciSeries {

    public static void main(String[] args) {
        int range = 11;
        int  previousNum = 0, nextNum = 1, sum =0;
        for(int i=1;i<=range;i++)
        {
            //fibo -> 0 1 1 2 3 5 8
            System.out.print(previousNum + "\t"); //firstIteration -> 0
            sum = previousNum+nextNum;
            previousNum = nextNum;
            nextNum = sum;
        }
    }
}
