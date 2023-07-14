package week3.day1;

public class SmartPhone extends AndroidPhone{

    public void takeVideo(){
        System.out.println("Take Video in SmartPhone ");
    }

    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone();
        smartPhone.takeVideo();
    }
}
