package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().window().maximize();

        driver.findElement(By.id("username")).sendKeys("demosalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();

        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Find Leads")).click();

        Thread.sleep(3000);
        String firstLeadID = driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-cell-first')])[1]//a[@class='linktext']")).getText();
        System.out.println("Leadd ID of the first appearing lead --> "+firstLeadID );
        driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-cell-first')])[1]//a[@class='linktext']")).click();


        driver.findElement(By.xpath("//a[text()='Delete']")).click();

        driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

        driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[@name='id']")).sendKeys(firstLeadID);
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(3000);
        String result  = driver.findElement(By.xpath("//div[@class='x-toolbar x-small-editor']/div")).getText();

        System.out.println("The result displayed is  "+result);
        System.out.println("The result - No records to display is verified "+result.equals("No records to display"));


    }
}
