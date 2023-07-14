package week3.day1.assignments.assignment3;

public class AxisBank extends BankInfo{
    public void deposit(){
        System.out.println("in deposit method in AxisBank");
    }

    public static void main(String[] args) {
        AxisBank axisBank = new AxisBank();
        axisBank.deposit();
    }
}
