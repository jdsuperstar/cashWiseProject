package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilites.Driver;


public class CheckPage {

    WebDriver driver;

    public CheckPage(){
        driver = Driver.getDriver();

        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "//li[text()=\"Expenses\"]")
    public WebElement report;

    @FindBy(xpath = "//a[@href=\"/dashboard/costs/checks\"]")
    public WebElement checkButton;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-containedPrimary') and contains(., 'Add check')]")
    public WebElement addCheck;

    @FindBy(xpath = "//input[@id='invoice_title_input_text']\n")
    public WebElement titleButton;

    @FindBy(xpath = "//div[@class=\" css-11unzgr\"]//div[1]")
    public WebElement selectButton;

    @FindBy(xpath = "//div[@class=\" css-1wy0on6\"]")
    public WebElement selectSeller;


    @FindBy(xpath = "//textarea[@id=\"description_input_text\"]" )
    public WebElement commentBox;

    @FindBy(xpath = "//input[@id=\"To_input_text\"]")
    public WebElement dueDateButton;

    @FindBy(xpath  ="//button[@class=\"MuiButton-root MuiButton-BORDERED MuiButton-BORDEREDPrimary MuiButton-sizeMedium MuiButton-BORDEREDSizeMedium MuiButtonBase-root css-g7im2v\"]")
    public WebElement addButton;

    @FindBy(xpath = "//div[@id=\"react-select-4-listbox\"]//div[3]//div[@aria-disabled=\"false\"]")
    public WebElement selectWriteTitle;

    @FindBy(xpath = "//button[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root css-xdzsgw\"]")
    public WebElement saveButton;

    //    @FindBy(xpath ="//table//tbody//tr//td[7]")
//    public WebElement deleteButton;
    @FindBy(xpath = "//tr[@class=\"MuiTableRow-root css-1wyooym\"][2]")
    public WebElement  checkCreation;





}



