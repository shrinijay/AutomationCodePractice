package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LeafGroundAssignment3 {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://leafground.com/window.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.xpath("//span[text()='Open']")).click(); //just checking if it clicks when we give only span
        //the above is working so no need of below
        //driver.findElement(By.xpath("//span[text()='Open']/parent::button")).click();

        String parentWindow = driver.getWindowHandle();
        List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        System.out.println("no of Windows opened "+windowsList.size());
        driver.switchTo().window(windowsList.get(1));

        String url = driver.getCurrentUrl();
        if(url.contains("dashboard"))
            System.out.println("driver navigated to new tab");

        driver.close();
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
        List<String> windowsList2 = new ArrayList<>(driver.getWindowHandles());
        System.out.println("no of Windows opened after clicking close windows "+(windowsList2.size()-1));
        for(int i=1;i<windowsList2.size();i++)
        {
            driver.switchTo().window(windowsList2.get(i));
            System.out.println(driver.getTitle()+" url is "+driver.getCurrentUrl());
            driver.close();
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Title of primary page "+driver.getTitle());


        driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
        List<String> windowsList3 = new ArrayList<>(driver.getWindowHandles());
        System.out.println("no of Windows opened after clicking open multiple "+(windowsList3.size()-1));
        for(int i=1;i<windowsList3.size();i++)
        {
            driver.switchTo().window(windowsList3.get(i));
            System.out.println(driver.getTitle()+" url is "+driver.getCurrentUrl());
            driver.close();
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Title of primary page "+driver.getTitle());

        driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
        List<String> windowsList4 = new ArrayList<>(driver.getWindowHandles());
        System.out.println("no of Windows opened after clicking open with delay "+(windowsList4.size()-1));

        for(int i=1;i<windowsList4.size();i++)
        {
            driver.switchTo().window(windowsList4.get(i));
            System.out.println(driver.getTitle()+" url is "+driver.getCurrentUrl());
            driver.close();
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Title of primary page "+driver.getTitle());

        driver.quit();
    }
}
