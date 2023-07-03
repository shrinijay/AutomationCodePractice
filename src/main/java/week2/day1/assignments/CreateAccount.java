package week2.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("username")).sendKeys("DemoCsr");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();

        driver.findElement(By.linkText("Accounts")).click();
        driver.findElement(By.xpath("//a[contains(@href,'createAccountForm')]")).click();
        driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited AccountNew1");
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
        driver.findElement(By.xpath("(//span[@class='tableheadtext']/following::input)[2]")).sendKeys("XYZ");
        driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Onsite");
        driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("1200000");

        WebElement industry = driver.findElement(By.xpath("//select[@name='industryEnumId']"));
        Select indDD = new Select(industry);
        indDD.selectByIndex(3);
        System.out.println("Getting the dropdown value "+industry.getAttribute("select"));

        Select ownerShipDD = new Select(driver.findElement(By.name("ownershipEnumId")));
        ownerShipDD.selectByVisibleText("S-Corporation");

        Select sourceDD = new Select(driver.findElement(By.id("dataSourceId")));
        sourceDD.selectByValue("LEAD_EMPLOYEE");

        new Select(driver.findElement(By.id("marketingCampaignId"))).selectByIndex(6);

        new Select(driver.findElement(By.id("generalStateProvinceGeoId"))).selectByValue("TX");

        driver.findElement(By.xpath("//input[@value='Create Account']")).click();

        System.out.println("Getting the title "+driver.getTitle());


        driver.close();



    }
}
