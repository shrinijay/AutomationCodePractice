package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropDownPractice {

    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps");
        driver.findElement(By.id("username")).sendKeys("demoSalesManager");
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

        List<WebElement> secDropDownOptions = secDropDown.getOptions();
        for(int i=0;i<secDropDownOptions.size();i++)
        {
            System.out.println("Printing the options from source dropdowns---> "+secDropDownOptions.get(i).getText());
        }

        secDropDown.selectByIndex(4);

        Select marketDD = new Select(driver.findElement(By.id("createLeadForm_marketingCampaignId")));
        marketDD.selectByVisibleText("Automobile");

        Select ownerShipDD = new Select(driver.findElement(By.id("createLeadForm_ownershipEnumId")));
        ownerShipDD.selectByValue("OWN_SCORP");

        driver.findElement(By.name("submitButton")).click();

        System.out.println("Title is "+driver.getTitle());

        driver.close();

    }
}
