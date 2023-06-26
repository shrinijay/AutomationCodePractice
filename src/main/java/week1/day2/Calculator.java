package week1.day2;

public class Calculator {

    public int addTwoNumbers(int a,int b)
    {
        return a+b;
    }

    public float subtractTwoNumbers(int x,float y)
    {
        return x-y;
    }

    public int divideTwoNumbers(int c,int d)
    {
        return  c/d;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Adding two numbers "+calc.addTwoNumbers(45,99));
        System.out.println("Subtrcting two numbers "+calc.subtractTwoNumbers(50,76.98f));
        System.out.println("Dividing two number "+calc.divideTwoNumbers(32,4));
    }
}
