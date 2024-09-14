package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_CheckboxTest {
    @Test
    void verifySelectCheckboxSucessfully() {
        /*
        1.Open browser
        2.Navigate to https://the-internet.herokuapp.com/checkboxes
        3.Check on checkbox1
        4.Verify checkbox1 is checked
        5.Check on checkbox2
        6.Verify checkbox2 is checked
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        //WebElement checkbox2=driver.findElement(By.xpath("//form[@id='checkboxes']//input[2]"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes input:nth-child(1)"));

        check(checkbox1);

        Assert.assertTrue(checkbox1.isSelected());

        check(checkbox2);

        Assert.assertTrue(checkbox2.isSelected());
        driver.quit();
    }

    static void check(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    static void uncheck(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }
}
