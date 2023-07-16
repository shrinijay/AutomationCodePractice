package marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PVRCinemas {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.pvrcinemas.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//div[text()='Movie Library ']")).click();
        driver.findElement(By.xpath("//select[@name='city']"));

        System.out.println("Checking the status -> " +driver.findElement(By.xpath("//label[contains(text(),'City')]")).isDisplayed());


    }
}
