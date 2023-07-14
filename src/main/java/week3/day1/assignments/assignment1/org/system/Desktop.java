package week3.day1.assignments.assignment1.org.system;

public class Desktop extends Computer {
    public void desktopSize(){
        System.out.println("Desktop Size from Desktop Class");
    }

    public static void main(String[] args) {
        Desktop desktop = new Desktop();
        desktop.computerModel("Computer Model using Desktop object");
        desktop.desktopSize();
    }
}
