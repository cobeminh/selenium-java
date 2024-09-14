package bmicalculator;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BodyMassIndexPage;
import pages.BodyMassIndexPages;
import supports.Browser;
import supports.Utils;

import java.time.Duration;

import static supports.Utils.calculateBMI;

public class BodyMassIndexTest {
    /*      Page Object Model - Body Mass Index Page
       1. Open browser
       2. Navigate to https://www.calculator.net/bmi-calculator.html
       3. Select metric unit tab
       4. Fill calculator with age, gender, weight, height
       5. Validate result is correct
     */
    WebDriver driver;
    WebDriverWait wait;

    @DataProvider
    Object[][] credentialsData() {
        return new Object[][]{
                {"26", "female", 160, 48},
                {"21", "male", 175, 67},
        };
    }

    @Parameters({"browser"})
    @BeforeMethod
    void openBrowser(String browser) {
        Browser.launchBrowser(browser);
    }

    //@Test
    void fillInfo(String age, String gender, double height, double weight) {
        driver.findElement(By.xpath("//*[@id='menuon']/a")).click();
        driver.findElement(By.cssSelector("input[value=Clear]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=button]")));

        driver.findElement(By.id("cage")).sendKeys(age);
        if (gender.equalsIgnoreCase("male")) {
            //driver.findElement(By.xpath("//*[@id='calinputtable']/tbody/tr[2]/td[2]/label[1]/span")).click();
            driver.findElement(By.cssSelector("td label.cbcontainer:first-child")).click();
        } else
            driver.findElement(By.cssSelector("td label.cbcontainer:last-child")).click();
        driver.findElement(By.cssSelector("input#cheightmeter")).sendKeys(String.valueOf(height));
        driver.findElement(By.id("ckg")).sendKeys(String.valueOf(weight));

        //driver.findElement(By.name("x")).click();
        driver.findElement(By.xpath("//input[@type='submit' and @value='Calculate']")).submit();

        double bmi = weight / (height * height * 0.0001);
        String result = String.format("%.1f", bmi);
        Assert.assertTrue(driver.findElement(By.cssSelector(".rightresult .bigtext b")).getText().contains(result));
    }

    @Test(dataProvider = "credentialsData")
    void verifyBMIValue(String age, String gender, double height, double weight) {
        BodyMassIndexPage bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage
                .open()
                .selectMetricTab()
                .clearForm();
        bodyMassIndexPage.fillForm(age, gender, height, weight);

        String expectedResult = calculateBMI(height, weight);
        String actualResult = bodyMassIndexPage.getResult();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @AfterMethod(alwaysRun = true)
    void closeBrowser(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            Browser.captureScreenShot(testResult.getName());
        }
        Browser.quit();
    }
}
