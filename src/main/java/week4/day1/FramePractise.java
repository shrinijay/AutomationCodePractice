package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramePractise {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
        driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        driver.switchTo().alert().accept();
        System.out.println(" Text is " +driver.findElement(By.id("demo")).getText());
        if(driver.findElement(By.id("demo")).getText().contains("OK"))
            System.out.println("Ok is pressed");
        driver.switchTo().defaultContent();
    }
}
