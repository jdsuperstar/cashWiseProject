package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserPage {

    WebDriver driver;

    public UserPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//*[text()=\"Sales\"]")
    public WebElement salesDropdown;

    @FindBy(xpath = "//a[@href=\"/dashboard/sales/products-and-services\"]")
    public WebElement productsAndServices;



    public void clickSales(){
        salesDropdown.click();
    }

}
