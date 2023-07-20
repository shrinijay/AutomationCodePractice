package marathon2;

import io.github.sukgu.Shadow;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class ServiceNow {
    public static void main(String[] args) throws IOException, InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://dev31913.service-now.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("q+NozS5Qe8!E");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        Shadow shadowDom = new Shadow(driver);
        shadowDom.setImplicitWait(10);
        shadowDom.findElementByXPath("//div[text()='All']").click();
        //Thread.sleep(5000);
        shadowDom.findElementByXPath("//input[@id='filter']").click();
        shadowDom.findElementByXPath("//span[text()='Service Catalog']").click();
        // shadowDom.findElementByXPath("//input[@id='filter']").sendKeys("Service catalog",Keys.ENTER);
        //shadowDom.findElementByXPath("//a[@aria-label='Service Catalog']").click();

        Thread.sleep(5000);

        WebElement frameEle = shadowDom.findElementByXPath("//iframe[@title='Main Content']");

        driver.switchTo().frame(frameEle);

        System.out.println("Name of the page - " + driver.findElement(By.xpath("//span[@role='heading']")).getText());

        driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]/ancestor::a[1]")).click();

        Boolean val = driver.findElement(By.xpath("//h1[contains(text(),'Mobiles')]")).isDisplayed();
        if (val)
            System.out.println("Mobiles page is navigated ");
        WebElement iPhone = driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']/parent::a"));
        Actions action = new Actions(driver);
        action.scrollToElement(iPhone).perform();
        iPhone.click();

        WebElement color = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));

        Select colorSelect = new Select(color);
        colorSelect.selectByVisibleText("Rose Gold");
        System.out.println("Chosen color - " + colorSelect.getFirstSelectedOption().getText());

        WebElement storage = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[3]"));
        Select storageSelect = new Select(storage);
        storageSelect.selectByValue("onetwentyeight");
        System.out.println("Chosen storage - " + storageSelect.getFirstSelectedOption().getText());

        WebElement orderNow = driver.findElement(By.xpath("//button[contains(text(),'Order Now')]"));

        action.scrollToElement(orderNow).perform();
        orderNow.click();

        Boolean requestStat = driver.findElement(By.xpath("//span[contains(text(),'submitted')]")).isDisplayed();
        if (requestStat)
            System.out.println("Order placed successfully , the value is " + driver.findElement(By.xpath("//span[contains(text(),'submitted')]")).getText());

        System.out.println("Request number is " + driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText());

        File src = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snaps/ServiceNow.png");
        FileUtils.copyFile(src, dest);

        driver.close();

    }
}
