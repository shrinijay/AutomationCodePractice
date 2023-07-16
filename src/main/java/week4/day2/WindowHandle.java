package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.irctc.co.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String parentWindow = driver.getWindowHandle();
        System.out.println("Getting the current page title "+driver.getTitle());
        driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
        Set<String> listOfHandles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(listOfHandles);
        driver.switchTo().window(handlesList.get(1));
        System.out.println("Page Title of Opened Tab is "+driver.getTitle());
        driver.switchTo().window(handlesList.get(0));
        driver.close();
    }
}
