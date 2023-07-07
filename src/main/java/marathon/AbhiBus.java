package marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class AbhiBus {

    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.abhibus.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.linkText("Bus")).click();
        driver.findElement(By.xpath("//label[text()='Leaving from']/preceding::input")).sendKeys("Chennai");
        driver.findElement(By.xpath("//li[text()='Chennai']")).click();

        driver.findElement(By.xpath("//label[text()='Going to']/preceding::input[@id='destination']")).sendKeys("Bangalore");
        driver.findElement(By.xpath("//li[text()='Bangalore']")).click();

        driver.findElement(By.xpath("//label[text()='Date of Journey']/preceding::input[@id='datepicker1']")).click();
        driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-today')]/following::a[1]")).click();

        driver.findElement(By.xpath("//a[text()='Search']")).click();
        System.out.println("Title after clicking search "+driver.getTitle());

        WebElement firstResultingBusEle = driver.findElement(By.xpath("(//h2[@class='TravelAgntNm ng-binding'])[1]"));
        System.out.println("Printing the first bus resulting name "+firstResultingBusEle.getText());




       driver.findElement(By.xpath("(//span[text()='Select Seat']/preceding::a[@class='btn-seatselect book1'])[2]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//div[@class='xClose'])[2]")));


        driver.findElement(By.xpath("(//p[@class='lower-new'])[1]/following::li[contains(@class,'sleeper available')]/a")).click();

       System.out.println("Printing the color of the seat after clicking "+driver.findElement(By.xpath("(//p[@class='lower-new'])[1]/following::li[contains(@class,'sleeper selected')]/a")).getCssValue("background-color"));

       String seatSelectedDetail = driver.findElement(By.xpath("//div[@class='jurnydetails']//span[@id='seatnos']")).getText();
       System.out.println("Seat Selected Value is "+seatSelectedDetail);

       String totalFare = driver.findElement(By.xpath(" //div[@class='jurnydetails']//span[@id='ticketfare']")).getText();
       System.out.println("Total fare is "+totalFare);

       WebElement boardingDropDown = driver.findElement(By.id("boardingpoint_id"));
        boardingDropDown.click();

        for(WebElement option : new Select(boardingDropDown).getOptions())
        {
            if(option.getText().contains("velachery"))
                option.click();
        }

        WebElement selectedElementBoardingPoint = new Select(boardingDropDown).getFirstSelectedOption();
        System.out.println("Selected option in dropping point dd "+selectedElementBoardingPoint.getText());

        WebElement droppingDD = driver.findElement(By.id("droppingpoint_id"));
        droppingDD.click();

        Select droppingPointDD = new Select(droppingDD);
        for(WebElement option : droppingPointDD.getOptions())
        {
            if(option.getText().contains("Electronic City"))
                option.click();
        }

        WebElement selectedElementDroppingPoint = new Select(droppingDD).getFirstSelectedOption();
        System.out.println("Selected option in dropping point dd "+selectedElementDroppingPoint.getText());



        System.out.println("Title of the page is "+driver.getTitle());

        driver.close();




    }
}
