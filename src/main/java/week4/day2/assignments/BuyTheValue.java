package week4.day2.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BuyTheValue {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://buythevalue.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.xpath("(//div[@class='product-image'])[1]")).click();
        driver.findElement(By.id("wk_zipcode")).sendKeys("600100");
        driver.findElement(By.xpath("//input[@value='Check']")).click();
        String deliveryCheckText = driver.findElement(By.xpath("//div[@class='wk_availability_msg']")).getText();
        System.out.println("Delivery Check Result "+deliveryCheckText);
        driver.findElement(By.id("product-add-to-cart")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@href='/cart'])[3]")).click();
        //driver.findElement(By.xpath("//span[text()='View Cart']/parent::a")).click();
        Boolean myCartPage = driver.findElement(By.xpath("//h1[text()='My Cart']")).isDisplayed();
        if(myCartPage)
            System.out.println("Navigated to mycartpage");
        WebElement element = driver.findElement(By.id("agree"));
        System.out.println("Checking if agree button is clicked "+element.isSelected());
        driver.findElement(By.id("checkout")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text ---- "+alert.getText());
        alert.accept();
        element.click();
        System.out.println("Checking if agree button is clicked "+element.isSelected());


    }
}
