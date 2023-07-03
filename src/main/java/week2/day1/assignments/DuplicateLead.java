package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.findElement(By.id("username")).sendKeys("DemoCsr");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        driver.findElement(By.partialLinkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Create Lead")).click();

        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("abcd");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("efgh");
        driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("ijkl");
        driver.findElement(By.xpath("//input[contains(@id,'departmentName')]")).sendKeys("Account");
        driver.findElement(By.name("description")).sendKeys("Description field abcd");
        driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@xyz.com");
        driver.findElement(By.xpath("//input[@value='Create Lead']")).click();

        System.out.println("Title of resulting page is "+driver.getTitle());

        driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
        driver.findElement(By.id("createLeadForm_companyName")).clear();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("hello98");

        driver.findElement(By.id("createLeadForm_lastName")).clear();
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("hello98");
        driver.findElement(By.xpath("//input[@value='Create Lead']")).click();

        System.out.println("Title of resulting page is "+driver.getTitle());

        driver.close();

    }
}
