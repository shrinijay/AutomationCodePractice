package week1.day1.assignments;

public class PrimeNumber {

    public static void main(String[] args) {

        int num = 18;
        boolean isPrime = false;
        for(int i=2;i<=num;i++)
        {
            if(num%i != 0)
                isPrime = true;
            break;
        }
        if(isPrime==true)
            System.out.println("Given number "+num+" is prime");
        else
            System.out.println("Given number "+num+" is not a prime");
    }
}
