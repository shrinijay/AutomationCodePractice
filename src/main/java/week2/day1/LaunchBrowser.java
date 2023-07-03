package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchBrowser {

    public static void main(String[] args) {
       /* ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login");*/

        EdgeDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://www.facebook.com/login");
        edgeDriver.manage().window().maximize();
    }
}
