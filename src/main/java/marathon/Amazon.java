package marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Amazon {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags");
        driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
        String bagResults = driver.findElement(By.xpath("//div[contains(@class,'a-spacing-top-small')]/span")).getText();
        System.out.println("Results of bags "+(bagResults.split(" "))[3]);
       // driver.findElement(By.xpath("(//span[text()='Skybags']/preceding::i[@class='a-icon a-icon-checkbox'])[5]")).click();

        driver.findElement(By.xpath("(//div[@id='brandsRefinements']//i[@class='a-icon a-icon-checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//div[@id='brandsRefinements']//i[@class='a-icon a-icon-checkbox'])[2]")).click();

        driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
        driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();

        String firstResult = driver.findElement(By.xpath("//h2[contains(@class,'s-line-clamp-2')]/a/span")).getText();
        System.out.println("first result is "+firstResult);

        String secondResult = driver.findElement(By.xpath("(//h2[contains(@class,'s-line-clamp-2')]/a/span)[2]")).getText();
        System.out.println("second text is "+secondResult);

        System.out.println("Title of the Webpage is "+driver.getTitle());

        driver.close();
    }
}
