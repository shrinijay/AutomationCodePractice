package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class WebTable   {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://erail.in/");
        driver.manage().window().maximize();
        driver.findElement(By.id("txtStationFrom")).clear();
        driver.findElement(By.id("txtStationFrom")).sendKeys("MS", Keys.ENTER);
        driver.findElement(By.id("txtStationTo")).click();
        driver.findElement(By.id("txtStationTo")).sendKeys("CAPE",Keys.ENTER);
        WebElement sortCheckBox = driver.findElement(By.id("chkSelectDateOnly"));
        System.out.println("Checking if sort date checkbox is selected "+sortCheckBox.isSelected());
        sortCheckBox.click();
        System.out.println("Checking if sort date checkbox is unselected "+sortCheckBox.isSelected());
        WebElement table = driver.findElement(By.xpath("//table[contains(@class,'stickyTrainListHeader')]"));
        System.out.println("Total number of td "+table.findElements(By.tagName("td")).size());
        //finding out the total no.of rows in table
        System.out.println("Total number of Rows "+table.findElements(By.tagName("tr")).size());
        List<String> data = new ArrayList<>();
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        //get the column data from each of the row
        for(int i=1;i< rows.size();i++)
        {
            List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
            for(int j=0;j<col.size();j++)
            {
                data.add(col.get(j).getText());
            }
            data.add("\n");
        }
        System.out.println("each row list "+data);

        //finding out the total no.of columns in header
        System.out.println("Total no. of Columns "+table.findElements(By.tagName("th")).size());

        //get data from the 1st row
        List<WebElement> firstRowColData = rows.get(1).findElements(By.tagName("td"));
        for (WebElement colData: firstRowColData) {
            System.out.print(colData.getText()+" \t ");
        }
        System.out.println("");
        //print all data in the second column(train names)
        List<WebElement> secondColData = driver.findElements(By.xpath("//table[contains(@class,'stickyTrainListHeader')]//td[1]"));
        List<String> secondColDataList = new ArrayList<>();
        System.out.println("Printing second col data ");
        for(int i=0;i<secondColData.size();i++)
        {
           secondColDataList.add(secondColData.get(i).getText());
        }
        System.out.println(secondColDataList);

    }
}
