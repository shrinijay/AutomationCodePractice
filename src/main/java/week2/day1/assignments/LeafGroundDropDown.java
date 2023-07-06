package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeafGroundDropDown {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/select.xhtml");
        driver.manage().window().maximize();

        WebElement tool = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));

        new Select(tool).selectByVisibleText("Cypress");

        driver.findElement(By.xpath("//div[@role='combobox']")).click();
        driver.findElement(By.xpath("//li[@data-label='Germany']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Select City']/following::div")).click();
        driver.findElement(By.xpath("//li[text()='Frankfurt']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete-multiple-container')]/following::button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete-items')]//li[3]")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete-multiple-container')]/following::button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[text()='JMeter']")).click();

        //cancelling the JMeter from course
        driver.findElement(By.xpath("//li[@data-token-value='JMeter']/span")).click();

        driver.findElement(By.xpath("//label[text()='Select Language']/parent::div")).click();
        driver.findElement(By.xpath("//li[text()='Tamil']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Select Values']/parent::div")).click();

        driver.findElement(By.xpath("(//ul[@role='listbox'])[4]/li[2]")).click();
        Thread.sleep(2000);
        driver.close();

    }
}
