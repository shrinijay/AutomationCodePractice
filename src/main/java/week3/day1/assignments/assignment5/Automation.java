package week3.day1.assignments.assignment5;

public class Automation extends MultipleLanguage implements TestTool,Language {
    @Override
    public void java() {
        System.out.println("Java Language");
    }

    @Override
    public void ruby() {
        System.out.println("Ruby Language");
    }

    @Override
    public void selenium() {
        System.out.println("Selenium Testing Tool");
    }

    public static void main(String[] args) {
        Automation automation = new Automation();
        automation.java();
        automation.ruby();
        automation.selenium();
        automation.python();
    }
}
