package week3.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonListMobilePrice {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles",Keys.ENTER);

        List<WebElement> priceDetails = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        System.out.println("Total Mobile Listed is "+priceDetails.size());

        List<Integer> priceList = new ArrayList<>();

        for(WebElement eachElement : priceDetails)
        {
            String eachText = eachElement.getText();
            String replacedText = eachText.replaceAll(",","");
            System.out.println(eachText +"with its replaced text is "+replacedText);
            priceList.add(Integer.parseInt(replacedText));
        }

        System.out.println("Printing the List "+priceList);

        Collections.sort(priceList);

        System.out.println("Printing the list after sorting "+priceList);

        System.out.println("The least mobile is "+priceList.get(0));

        driver.quit();


    }
}
