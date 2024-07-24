package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.util.Strings;
import utilites.Driver;
import utilites.Driver;

public class HomePageElza {

    WebDriver driver;
    public HomePageElza(){
        this.driver = Driver.getDriver();

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-1wgjx4y\"]")
    public WebElement signIn ;

    @FindBy (xpath = "//input[@id=\"email_input_text\"]")
    public WebElement emailInput ;

    @FindBy (xpath = "//input[@id=\"password_input_text\"]")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButtonBase-root css-hl90zr\"]")
    public WebElement signInButtonAfterValid;

    //    Changing language to english
    @FindBy (xpath = "//div[@class=\"css-q281fx\"]//p[@class=\"css-1it55co\"]")
    public WebElement languageButton;
    @FindBy (xpath = "//span[text()=\"English\"]")
    public WebElement laguageBtENG;


    public void login(String email, String password){
        languageButton.click();
        laguageBtENG.click();

        signIn.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButtonAfterValid.click();
    }

}
