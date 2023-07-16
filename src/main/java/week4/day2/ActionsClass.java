package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/drag.xhtml;");
        driver.manage().window().maximize();
        System.out.println("Title "+driver.getTitle());
        WebElement source = driver.findElement(By.xpath("//p[text()='Drag to target']"));
        WebElement dest = driver.findElement(By.xpath("//p[text()='Drop here']"));
        System.out.println("Getting color before dragging "+source.getCssValue("background-color"));
        Actions action = new Actions(driver);
        action.dragAndDrop(source,dest).perform();
        String text = driver.findElement(By.xpath("//p[@class='ui-widget-header']")).getText();
        System.out.println("Dropped text "+text);
        if(text.contains("Dropped"))
            System.out.println("Element is dropped properly to the destination");
        System.out.println("GEtting the color "+driver.findElement(By.id("form:drop_content")).getCssValue("background-color"));
        driver.close();
    }

}
