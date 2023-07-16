package week4.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/*
 a)Launch the browser
      b)Load the url https://www.irctc.co.in/nget/train-search
      c)Enter MS in ‘From’ textbox
      d)Enter Cape in ‘To’ textbox
      e)Click search button
      f)Click refresh button
      g)Click WL and Click BookNow button
      e)Click No button in the alert

 */
public class IRCTC {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@role='searchbox'])[1]")).sendKeys("MS");
       // driver.findElement(By.xpath("//li[1]/span")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'MS')])[3]")).click();
       Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@role='searchbox'])[2]")).sendKeys("Cape");
        //driver.findElement(By.xpath("//li[1]/span")).click();
        driver.findElement(By.xpath("//span[contains(text(),'CAPE')]")).click();
        driver.findElement(By.xpath("//button[text()='Search']")).click();

        driver.findElement(By.xpath("(//strong[contains(text(),'ANANTAPURI')]/following::div[contains(text(),'Refresh')]/span)[1]")).click();
        driver.findElement(By.xpath("(//strong[contains(text(),'WL')])[1]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Book Now')]")).click();
        driver.findElement(By.xpath("//span[text()='No']")).click();
        driver.close();

    }
}
