package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class ProductsAndServicesPage {
    WebDriver driver;

    public ProductsAndServicesPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()= \"Add products or service\"]")
    public WebElement addProductOrService;

    @FindBy(xpath = "//table[@class=\"MuiTable-root css-1owb465\"]")
    public WebElement listOfProductsOrServices;

    @FindBy(xpath = "//span[text()=\"List is empty\"]")
    public WebElement emptyList;

    @FindBy(xpath = "//input[@id=\"product_title_input_text\"]")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@id=\"product_price_input_text\"]")
    public WebElement priceInput;

    @FindBy(xpath = "//div[@aria-labelledby=\"select mui-component-select-service_type_id\"]")
    public WebElement serviceSelect;

    @FindBy(xpath = "//li[@data-value=\"2\"]")
    public WebElement serviceProduct;

    @FindBy(xpath = "//*[text()=\"Service\"]")
    public WebElement serviceService;

    @FindBy(xpath = "//div[@aria-labelledby=\"select mui-component-select-category_id\"]")
    public WebElement categorySelect;

    @FindBy(xpath = "//li/span//..")
    public WebElement testCategory;

    @FindBy(xpath = "//input[@id=\"product_description_input_text\"]")
    public WebElement descriptionField;

    @FindBy(xpath = "//*[text()=\"Save\"]")
    public WebElement saveProductOrService;

    @FindBy(xpath = "//div[@class=\"SnackbarContainer-top SnackbarContainer-right SnackbarContainer-root css-uwcd5u\"]")
    public WebElement productAlert;

    @FindBy(xpath = "//tbody//tr[1]//td[6]//button[1]")
    public WebElement editButton;

    @FindBy(xpath = "//tbody//tr[1]//td[6]//button[2]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[text()=\"Delete\"]")
    public WebElement confirmDelete;

    @FindBy(xpath = "//p[text()= \"Price cannot be empty\"]")
    public WebElement priceError;

    public void clickAddProductOrService(){
        addProductOrService.click();
    }

    public void addProductOrService(String name, String price, String productOrService, String description){
        nameInput.sendKeys(name);
        priceInput.sendKeys(price);
        serviceSelect.click();
        if (productOrService.equals("product")){
            serviceProduct.click();
        }
        if (productOrService.equals("service")){
            serviceService.click();
        }
        categorySelect.click();
        testCategory.click();
        descriptionField.sendKeys(description);
        saveProductOrService.click();
    }


}
