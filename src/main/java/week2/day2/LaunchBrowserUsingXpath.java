package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowserUsingXpath {

    public static void main(String[] args) {

        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps");

        driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("demoSalesManager");
        driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        driver.findElement(By.xpath("//a[contains(text(),'/SFA')]")).click();
        driver.findElement(By.xpath("//a[text()='Leads']")).click();

        driver.findElement(By.xpath("//a[text()=''Create Lead]")).click();

        //(//span[text()='First name']/following::input)[1]

        //(//span[text()='Number Of Employees']/following::input)[1]

        driver.close();

    }
}
