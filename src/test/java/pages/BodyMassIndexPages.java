package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BodyMassIndexPages {
    public WebDriver driver;
    private By metricTab = By.cssSelector("li#menuon a");
    private By clearButton = By.cssSelector("input[value=Clear]");
    private By ageTextBox = By.cssSelector("input#cage");
    private By maleRadioButton = By.cssSelector("td label.cbcontainer:first-child");
    private By femaleRadioButton = By.cssSelector("td label.cbcontainer:last-child");
    private By heightTextBox = By.cssSelector("input#cheightmeter");
    private By weightTextBox = By.cssSelector("input#ckg");
    private By calculateButton = By.xpath("//input[@type='submit' and @value='Calculate']");
    private By resultLabel = By.cssSelector(".rightresult .bigtext b");


    public BodyMassIndexPages(WebDriver driver) {
        this.driver = driver;
    }

    public void openBrowser() {
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectMetricTab() {
        driver.findElement(metricTab).click();
    }

    public void clearForm() {
        driver.findElement(clearButton).click();
    }

    public void fillForm(String age, String gender, double height, double weight) {
        driver.findElement(ageTextBox).sendKeys(age);
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(maleRadioButton).click();
        } else {
            driver.findElement(femaleRadioButton).click();
        }

        driver.findElement(heightTextBox).sendKeys(String.valueOf(height));
        driver.findElement(weightTextBox).sendKeys(String.valueOf(weight));

        driver.findElement(calculateButton).submit();
    }

    public String getResult() {
        return driver.findElement(resultLabel).getText();

    }

}