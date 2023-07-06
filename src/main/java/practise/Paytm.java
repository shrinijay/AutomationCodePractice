package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Paytm {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://paytm.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.linkText("Paytm for Consumer")).click();
        Actions action = new Actions(driver);

        WebElement ele = driver.findElement(By.xpath("//a[text()='Payments']"));
        action.moveToElement(ele).click(ele).build().perform();
        WebElement ele1 = driver.findElement(By.xpath("//a[contains(text(),'Recharges')]"));
        action.moveToElement(ele1).click(ele1).build().perform();
        System.out.println("Title "+driver.getTitle());
    }
}
