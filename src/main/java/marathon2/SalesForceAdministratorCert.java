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

public class SalesForceAdministratorCert {

    public static void main(String[] args) throws IOException, InterruptedException {
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
        administrator.click();
        String verifyAdministratorTitle = driver.getTitle();
        if(verifyAdministratorTitle.contains("Administrator"))
            System.out.println("Title contains "+verifyAdministratorTitle);
        Thread.sleep(7000);
        WebElement certScroll = driver.findElement(By.xpath("(//div[contains(text(),'Certification')])[4]"));
        action.scrollToElement(certScroll).perform();
        //action.scrollToElement(driver.findElement(By.xpath("//div[text()='Related Credentials']"))).perform();
        //List<WebElement> certificationList = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
        List<WebElement> certificationList = driver.findElements(By.xpath("//div[contains(text(),'Certification')]/following::a"));
       // System.out.println(certificationList.size()+" "+certificationList.get(0).getText());
        for(int i=0;i<7;i++)
        {
            String certName = certificationList.get(i).getText();
            if(!certName.contains("Sched"))
                System.out.println("The certification lists under Administrator "+certName);
       }

        File source = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snaps/SalesForceCertification.png");
        FileUtils.copyFile(source,dest);



        driver.quit();


    }
}
