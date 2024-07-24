package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.security.PublicKey;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

public class sellerPage {
    WebDriver driver;

    public sellerPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[text()=\"Expenses\"]")
    public WebElement expenses;
    @FindBy(xpath = "//li[text()=\"Expenses\"]/div[@class=\"MuiListItemIcon-root css-13ink46\"]")
    public WebElement expenses2;
    @FindBy(xpath = "//a[text()=\"Sellers\"]")
    public WebElement seller;
    @FindBy(xpath = "//button[text()=\"Add seller\"]")
    public WebElement addSeller;
    @FindBy(xpath = "//input[@placeholder=\"Write title\"]")
    public WebElement writeTitle;
    @FindBy(xpath = "//input[@placeholder=\"Write full name\"]")
    public WebElement fullName;
    @FindBy(xpath = "//input[@placeholder=\"Email\"]")
    public WebElement email;
    @FindBy(xpath = "//input[@placeholder=\"+1 ___ ___ ____ \"]")
    public WebElement phoneNumber;
    @FindBy(xpath = "//input[@placeholder=\"Write address\"]")
    public WebElement enterAddress;
    @FindBy(xpath = "//button[text()=\"Save\"]")
    public WebElement save;
    @FindBy(xpath = "//p[text()=\"Seller name cannot contain digits or special characters\"]")
    public WebElement alertMessage;
    @FindBy(xpath = "//table/tbody/tr[1]/td[3]")
    public WebElement table;
    @FindBy(xpath = "//button[text()=\"Cancel\"]")
    public WebElement cancel;
    @FindBy(xpath = "//input[@id=\"name_input_text\"]")
    public WebElement searchBar;
    @FindBy(xpath = "//table/tbody/tr[1]/td[3]")
    public WebElement nameSearched;


    //verify that name was add to the table,

    public void verifyName(String name) {
        List<WebElement> fullNames = Driver.getDriver().findElements(By.xpath("//table/tbody/tr/td[3]"));
        List<String> addedNames = new ArrayList<>();
        for (WebElement names : fullNames) {
            addedNames.add(names.getText());
        }
        Assert.assertTrue(addedNames.contains(name));
        System.out.println(addedNames);
    }

    public void nameToSearch() {
        searchBar.click();
        String nameToSearch = table.getText();
        searchBar.sendKeys(nameToSearch + Keys.ENTER);
        Assert.assertEquals(nameSearched.getText(), nameToSearch);
    }

    public void enterName(String enterName) {
        Actions actions = new Actions(driver);
        searchBar.click();
        actions.keyDown(searchBar, Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND);
        actions.keyDown(searchBar, Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
        actions.keyDown(searchBar, Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND);
        actions.keyDown(searchBar, Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE);
        actions.build().perform();
        searchBar.sendKeys(enterName + Keys.ENTER);
        Assert.assertNotEquals(enterName, table.getText());
    }

}
