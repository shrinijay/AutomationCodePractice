package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptDialogAlert {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/alert.xhtml");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//h5[contains(text(),'Prompt Dialog')]/following::button")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert msg "+alert.getText());
        String text = "Testleaf";
        alert.sendKeys(text);
        //alert.accept();
        alert.dismiss();
        System.out.println("Checkig if the result is displayed "+driver.findElement(By.id("confirm_result")).isDisplayed());
        //if(driver.findElement(By.id("confirm_result")).getText().contains(text))
            System.out.println("the entered text appears in the result "+driver.findElement(By.id("confirm_result")).getText());
        driver.close();
    }
}
