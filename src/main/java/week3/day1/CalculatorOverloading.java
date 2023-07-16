package week3.day1;

public class CalculatorOverloading {

    public void add(int a, int b)
    {
        System.out.println("Addition with two parameters "+a+b);
    }

    public void add(int a, int b, int c)
    {
        System.out.println("Addition with three parameters "+a+b+c);
    }

    public void multiply(double a,double b)
    {
        System.out.println("Multiply with double parameters "+a*b);
    }

    public void multiply(float a, float b)
    {
        System.out.println("Multiply with float type "+a*b);
    }

    public static void main(String[] args) {

        CalculatorOverloading calc = new CalculatorOverloading();
        calc.add(5,9);
        calc.add(60,90,99);
        calc.multiply(90.99f,8.3f);
        calc.multiply(44.33,55.92);
    }
}
