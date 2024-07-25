package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class AddClientPage {
    WebDriver driver;

    public AddClientPage(){

        this.driver = Driver.getDriver();
        PageFactory.initElements(driver,this);

    }

    // all stored webElements
    @FindBy(xpath = "//li[text()='Sales']")
    public WebElement sales;
    @FindBy(xpath = "//button[text()='Add client']")
    public WebElement addClient;
    @FindBy(xpath = "//input[@id=\"react-select-3-input\"]")
    public WebElement selectTag;
    @FindBy(xpath = "//button[text()='Create new tag']")
    public  WebElement createTag;
    @FindBy(xpath = "//input[@id=\"name_tag_input_text\"]")
    public WebElement tagName;
    @FindBy(xpath = "//button[@form=\"tag-form\"]")
    public WebElement saveButton;
    @FindBy(xpath = "//input[@id=\"company_name_input_text\"]")
    public  WebElement companyName;
    @FindBy(xpath = "//div[@id=\"react-select-3-option-0\"]")
    public WebElement defaultTag;
    @FindBy(xpath = "//input[@id=\"client_name_input_text\"]")
    public WebElement clientFullName;
    @FindBy(xpath = "//input[@id=\"email_input_text\"]")
    public WebElement clientEmail;
    @FindBy(xpath = "//input[@id=\"phone_number_input_text\"]")
    public WebElement clientPhone;
    @FindBy(xpath = "//input[@id=\"address_input_text\"]")
    public WebElement clientAddress;
    @FindBy(xpath = "//button[@form=\"clientForm\"]")
    public WebElement saveClientButton;
    @FindBy(xpath = "//tr[@class=\"MuiTableRow-root css-1wyooym\"]")
    public WebElement clientInfo;
    @FindBy(xpath = "//p[text()='Please enter a valid email address']")
    public WebElement errorNameMessage;
    @FindBy(xpath = "//div[@style=\"padding-left: 15px;\"]//input[@type=\"checkbox\"]")
    public WebElement checkAll;
    @FindBy(xpath = "//input[@type=\"checkbox\"]")
    public WebElement checkboxes;
    @FindBy(xpath = "//button[@class=\"MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButtonBase-root css-162b761\"]")
    public WebElement archiveAll;
    @FindBy(xpath = "//span[contains(text(), 'List is empty')]")
    public WebElement emptyMessage;

}
