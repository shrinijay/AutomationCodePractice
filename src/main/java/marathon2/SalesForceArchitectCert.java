package marathon2;

import io.github.sukgu.Shadow;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SalesForceArchitectCert {
    public static void main(String[] args) throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@1234");
        driver.findElement(By.id("Login")).click();
        String currentWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//span[text()='Mobile Publisher']//following::span[text()='Learn More']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        String newWindow = windowHandlesList.get(1);
        driver.switchTo().window(newWindow);
       /* if(driver.findElement(By.xpath("//h1[text()='Confirm redirect?']")).isDisplayed())
            System.out.println("Driver navigated to opened tab");*/
        driver.findElement(By.xpath("//button[text()='Confirm']")).click();
        System.out.println("Getting the title of new window opened "+driver.getTitle());
        Shadow shadowDom = new Shadow(driver);
        shadowDom.findElementByXPath("//span[text()='Learning']").click();
        Actions action = new Actions(driver);
        action.moveToElement(shadowDom.findElementByXPath("//span[text()='Learning on Trailhead']")).perform();
        shadowDom.findElementByXPath("//a[text()='Salesforce Certification']").click();
        System.out.println("Getting the title after clicking salesfroce certification "+driver.getTitle());
        WebElement administrator = driver.findElement(By.xpath("//a[text()='Administrator']"));
        action.scrollToElement(administrator).perform();
        driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
        System.out.println("Getting the title after clicking the architect role "+driver.getTitle());
        WebElement salesForceArctEle = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']"));
        action.moveToElement(salesForceArctEle).perform();
        System.out.println("Architect summary");
        System.out.println(driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']")).getText());
        action.moveToElement(driver.findElement(By.xpath("(//div[@class='credentials-card ']/div[@class='credentials-card_title'])[5]"))).perform();
        List<WebElement> certList = driver.findElements(By.xpath("//div[@class='credentials-card ']/div[@class='credentials-card_title']"));
        System.out.println("Certificate List");
        for(WebElement eachCert : certList)
            System.out.println(eachCert.getText());

        File src = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./src/test/resources/SalesforceArchitect.png");
        FileUtils.copyFile(src,dest);

        driver.quit();
    }
}
