package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SalesForceAssignment {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@1234");
        driver.findElement(By.id("Login")).click();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        System.out.println("Website Title ---> " +driver.getTitle());
        driver.close();

    }
}
