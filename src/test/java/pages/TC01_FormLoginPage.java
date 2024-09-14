package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static supports.Browser.*;

public class TC01_FormLoginPage {
    public WebDriver driver;
    private By usernameTextBox = By.id("username");
    private By passwordTextBox = By.id("password");
    private By loginButton = By.xpath("//button[contains(.,' Login')]");
    private By resultMessage = By.className("success");

    public void open() {
        visit("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password) {
        fill(usernameTextBox, username);
        fill(passwordTextBox, password);
        click(loginButton);
    }

    public String getSuccessMessage() {
        return getText(resultMessage);
    }
}
