package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MergeContact {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("username")).sendKeys("DemoCsr");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();

        driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
        Set<String> windows = driver.getWindowHandles();
        List<String> windowsList = new ArrayList<>(windows);
        driver.switchTo().window(windowsList.get(1));
        //driver.manage().window().maximize();
        driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]/div/a)[1]")).click();

        driver.switchTo().window(windowsList.get(0));
        System.out.println("selected value "+driver.findElement(By.name("ComboBox_partyIdFrom")).getAttribute("valuenow"));

        driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
        Set<String> windowsAnother = driver.getWindowHandles();
        List<String> windowsAnotherList = new ArrayList<>(windowsAnother);
        driver.switchTo().window(windowsAnotherList.get(1));
        //driver.manage().window().maximize();
        driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]/div/a)[2]")).click();
        driver.switchTo().window(windowsAnotherList.get(0));
        System.out.println("selected value "+driver.findElement(By.name("ComboBox_partyIdTo")).getAttribute("valuenow"));
        driver.findElement(By.xpath("//a[text()='Merge']")).click();

        driver.switchTo().alert().accept();
        System.out.println("Title of the page "+driver.getTitle());

        driver.quit();



    }
}
