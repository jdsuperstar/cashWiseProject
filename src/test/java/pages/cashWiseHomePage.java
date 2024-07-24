package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class cashWiseHomePage {
    WebDriver driver;

    public cashWiseHomePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(id = "email_input_text")
    public WebElement emailInput;

    @FindBy(id = "password_input_text")
    public WebElement passwordInput;

    @FindBy(xpath = "//form//button[text()='Sign in']")
    public WebElement signInBtnInForm;

    public  void login(String username, String password) {
        signInButton.click();
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInBtnInForm.click();
    }


}
