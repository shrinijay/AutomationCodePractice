package week3.day1.assignments.Classroom;

public class Samsung extends AndroidTV{


    @Override
    public void playVideo() {
        System.out.println("Implemented play video in SamSung Concrete class");
    }

    public static void main(String[] args) {
        Samsung samsung = new Samsung();
        samsung.openApp();
        samsung.playVideo();
    }
}
