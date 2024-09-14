package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_HyperlinkTest {
    /*
            Hyper link : Hyperlink - link text
        1.Open browser
        2.Navigate to https://the-internet.herokuapp.com/status_codes
        3.Click on "200"
        4.Then "200 status code" page appear
        5.Click on "go here"
        6.Click on "301"
        7.Then "301 status code" page appear
        8.Click on "go here"
        9.Click on "404"
        10.Then "404 status code" page appear
        11.Click on "go here"
        12.Click on "500"
        13.Then "500 status code" page appear
        14.Click on "go here"
     */
    @Test
    void verifyNavigateHypeLinkSuccessfully() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");
        String href = driver.findElement(By.linkText("200")).getAttribute("href");
        driver.findElement(By.linkText("200")).click(); //goi ca atribute va text
        Assert.assertTrue(driver.getCurrentUrl().contains(href));

        driver.navigate().back();//quay ve trang chu

        href = driver.findElement(By.linkText("301")).getAttribute("href");
        driver.findElement(By.linkText("301")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));

        driver.navigate().back();

        href = driver.findElement(By.linkText("404")).getAttribute("href");
        driver.findElement(By.linkText("404")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));

        driver.navigate().back();

        href = driver.findElement(By.linkText("500")).getAttribute("href");
        driver.findElement(By.linkText("500")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));

        driver.navigate().refresh();

        driver.quit();
        /*
        driver.findElement(By.xpath("//a[.='200']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/status_codes/200"));

        String href=driver.findElement(By.linkText("200")).getAttribute("href");
        driver.findElement(By.linkText("200")).click();//gồm cả atribute và text
        Assert.assertTrue(driver.getCurrentUrl().contains(href));

        driver.findElement(By.linkText("here")).click();

        href=driver.findElement(By.linkText("301")).getAttribute("href");
        driver.findElement(By.linkText("301")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));

        driver.findElement(By.linkText("here")).click();

         href=driver.findElement(By.linkText("404")).getAttribute("href");
        driver.findElement(By.linkText("404")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));

        driver.findElement(By.linkText("here")).click();

         href=driver.findElement(By.linkText("500")).getAttribute("href");
        driver.findElement(By.linkText("500")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));

        driver.findElement(By.linkText("here")).click();

        driver.quit();

         */
    }
}
