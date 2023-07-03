package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.findElement(By.id("username")).sendKeys("DemoCsr");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        driver.findElement(By.partialLinkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Create Lead")).click();

        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Shrinidhi");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("V");

        WebElement dropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
        Select secDropDown = new Select(dropDown);
        secDropDown.selectByVisibleText("Employee");

        new Select(driver.findElement(By.id("createLeadForm_marketingCampaignId"))).selectByValue("9001");

        new Select(driver.findElement(By.id("createLeadForm_ownershipEnumId"))).selectByIndex(5);

        new Select(driver.findElement(By.id("createLeadForm_generalCountryGeoId"))).selectByVisibleText("India");

        driver.findElement(By.name("submitButton")).click();

        System.out.println("Resulting page title "+driver.getTitle());

        driver.close();
    }
}
