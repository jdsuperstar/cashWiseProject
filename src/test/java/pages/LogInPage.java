package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.util.Strings;
import utilities.Driver;


public class LogInPage {
    WebDriver driver;

    public LogInPage(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

//    Log in
    @FindBy(xpath = "//button[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-1wgjx4y\"]")
    public WebElement signIn ;

    @FindBy (xpath = "//input[@id=\"email_input_text\"]")
    public WebElement emailInput ;

    @FindBy (xpath = "//input[@id=\"password_input_text\"]")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButtonBase-root css-hl90zr\"]")
    public WebElement signInButtonAfterValid;

    public void logIn(String email, String password){
        signIn.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButtonAfterValid.click();
    }

//    Forgot password
    @FindBy(xpath = "//span[@class=\"css-ui00j9\"]")
    public WebElement forgotbutton;

    @FindBy(xpath = "//input[@id=\"email_input_text\"]")
    public WebElement forgotEmailInput;



    // Log out page classes
    @FindBy(css = "#header > div.css-omke5m > p > svg")
    public WebElement accountProfil;

    @FindBy(xpath = "//li[text()=\"Log out\"]")
    public WebElement logoutButton;

    public void logout(String email, String password) {
        logIn(email,password);
        accountProfil.click();
        logoutButton.click();
        logoutAcceptButton.click();
    }

    @FindBy(xpath = "//button[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-wdgwt9\"]")
    public WebElement logoutAcceptButton;


//    Changing language to english
    @FindBy (xpath = "//div[@class=\"css-q281fx\"]//p[@class=\"css-1it55co\"]")
    public WebElement languageButton;
    @FindBy (xpath = "//span[text()=\"English\"]")
    public WebElement laguageBtENG;


}
