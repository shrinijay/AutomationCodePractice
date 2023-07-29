package week4.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SnapDealAssignment4 {

    public static void main(String[] args) throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        EdgeDriver driver = new EdgeDriver(options);
        driver.get("https://www.snapdeal.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Actions actions = new Actions(driver);
        WebElement men = driver.findElement(By.xpath("//span[contains(text(),\"Men's Fashion\")]"));
        actions.moveToElement(men).perform();
        driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')]")).click();
        System.out.println("Total Shoes available "+driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText());
        driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

        driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
        driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();

        Thread.sleep(5000);
        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='lfloat marR10']/span[@class='lfloat product-price']"));

        List<Integer> priceOnly = new ArrayList<>();


        for(int i=0;i<priceList.size();i++)
        {
            String text = priceList.get(i).getText();
            String replacedText = text.replaceAll("[^0-9]","");
            System.out.println("replaced text "+replacedText);
            priceOnly.add(Integer.parseInt(replacedText));
        }
        System.out.println("price only list "+priceOnly);
        List<Integer> sortValidate = new ArrayList<>(priceOnly);
        Collections.sort(sortValidate);
        System.out.println("sort validate list "+sortValidate);
        int count = 0;
        for(int i=0;i<sortValidate.size();i++)
        {
            if(sortValidate.get(i)==priceOnly.get(i))
                count++;
        }
        if(count == sortValidate.size())
            System.out.println("The list displayed in sorted order");

        WebElement leftSlider = driver.findElement(By.xpath("//a[@class='price-slider-scroll left-handle ui-slider-handle ui-state-default ui-corner-all hashAdded']"));
        actions.moveToElement(leftSlider).moveByOffset(60,70).build().perform();
        Thread.sleep(2000);
        driver.close();

        WebElement fromVal = driver.findElement(By.xpath("//div[@class='price-text-box']/input[@name='fromVal']"));
        fromVal.clear();
        fromVal.sendKeys("500");



    }
}
