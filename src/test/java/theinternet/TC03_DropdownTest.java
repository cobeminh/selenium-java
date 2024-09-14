package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_DropdownTest {
    /*
             DropDown : Select option
        1.Open browser
        2.Navigate to https://the-internet.herokuapp.com/dropdown
        3.Select "option 1"
        4.Validate "option 1" is selected

     */
    //chon 1option
    @Test
    void verifySelectOption1Successfully() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));

        //select.selectByVisibleText("Option 1");
        select.selectByIndex(2);
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 2']")).isSelected());
        driver.quit();
    }

    //chon tu 2 option tro len
    @Test
    void verifySelectMultipleOptionSuccessfully() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByVisibleText("Banana");

        select.selectByIndex(1);
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());

        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());


    }
}
