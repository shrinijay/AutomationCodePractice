package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LeafGroundAssignment {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/input.xhtml");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//h5[contains(text(),'Type your name')]/following-sibling::div//input")).sendKeys("Shrinidhi");
        driver.findElement(By.xpath("//h5[contains(text(),'Append Country')]/following-sibling::div//input")).sendKeys("India");

        WebElement textBox = driver.findElement(By.xpath("(//div[@class='grid formgrid'])[3]//input"));
        System.out.println("Is textbox disabled "+textBox);


        driver.findElement(By.xpath("(//div[@class='grid formgrid'])[4]//input")).clear();

        WebElement textRetrieval = driver.findElement(By.xpath("(//div[@class='grid formgrid'])[5]//input"));
        System.out.println("Retrieved text is "+textRetrieval.getAttribute("value"));

        WebElement typeEmail = driver.findElement(By.xpath("//h5[contains(text(),'Type email and Tab')]/following-sibling::div//input"));
        typeEmail.sendKeys("shrinidhi@gmail.com");
        typeEmail.sendKeys(Keys.TAB);

        WebElement aboutYourself = driver.findElement(By.xpath("//textarea[@placeholder='About yourself']"));
        System.out.println(aboutYourself.isDisplayed()); // have to check

        aboutYourself.sendKeys("Hello this is shrinidhi");

        driver.findElement(By.xpath("//div[@class='col-12 mb-2 lg:col-8']/input")).sendKeys(Keys.ENTER);

        boolean isErrorMsgDisplayed = driver.findElement(By.xpath("//span[text()='Age is mandatory']")).isDisplayed();
        System.out.println("Error Message is displayed "+isErrorMsgDisplayed);

        //driver.findElement(By.xpath("//span[@class='ui-float-label']/input")).click();

        driver.quit();



    }
}
