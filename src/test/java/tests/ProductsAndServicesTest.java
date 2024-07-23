package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsAndServicesPage;
import pages.UserPage;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtils;

public class ProductsAndServicesTest {
    HomePage homePage;
    UserPage userPage;
    ProductsAndServicesPage productsAndServicesPage;
    Faker faker;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
        userPage = new UserPage();
        productsAndServicesPage = new ProductsAndServicesPage();
        faker = new Faker();
        Driver.getDriver().get(Config.getProperty("website"));
        homePage.login("vladtest@gmail.com", "123456");
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }


    @Test
    public void viewProductAndService(){
        userPage.salesDropdown.click();
        userPage.productsAndServices.click();
        Assert.assertTrue(productsAndServicesPage.emptyList.isDisplayed() || productsAndServicesPage.listOfProductsOrServices.isDisplayed());
    }

    @Test
    public void addProductOrService(){
        userPage.salesDropdown.click();
        userPage.productsAndServices.click();
        productsAndServicesPage.clickAddProductOrService();
        productsAndServicesPage.addProductOrService(faker.food().vegetable(), String.valueOf(faker.number().numberBetween(1,5000)),"product","test");
        Assert.assertTrue(productsAndServicesPage.productAlert.isDisplayed());
    }

    @Test
    public void editProductOrService(){
        userPage.salesDropdown.click();
        userPage.productsAndServices.click();
        productsAndServicesPage.editButton.click();
        SeleniumUtils.waitForSeconds(1);
        SeleniumUtils.clear(productsAndServicesPage.priceInput);
        productsAndServicesPage.priceInput.sendKeys(String.valueOf(faker.number().numberBetween(1,5000)));
        productsAndServicesPage.saveProductOrService.click();
        Assert.assertTrue(productsAndServicesPage.productAlert.isDisplayed());
    }

    @Test
    public void deleteProductOrService(){
        userPage.salesDropdown.click();
        userPage.productsAndServices.click();
        productsAndServicesPage.deleteButton.click();
        productsAndServicesPage.confirmDelete.click();
        Assert.assertTrue(productsAndServicesPage.productAlert.isDisplayed());;
    }

    //Negative (Adding a product or service without including the price)
    @Test
    public void addWithMissingFields() throws InterruptedException {
        String price = "";
        userPage.salesDropdown.click();
        userPage.productsAndServices.click();
        productsAndServicesPage.clickAddProductOrService();
        productsAndServicesPage.addProductOrService(faker.food().vegetable(),price,"product","test");
        Assert.assertTrue(productsAndServicesPage.priceError.isDisplayed());
    }

    //Negative (Editing a product or service with invalid data)
    @Test
    public void editWithInvalidData(){
        String price = "";
        userPage.salesDropdown.click();
        userPage.productsAndServices.click();
        productsAndServicesPage.editButton.click();
        SeleniumUtils.waitForSeconds(1);
        SeleniumUtils.clear(productsAndServicesPage.priceInput);
        productsAndServicesPage.priceInput.sendKeys(price);
        productsAndServicesPage.saveProductOrService.click();
        Assert.assertTrue(productsAndServicesPage.priceError.isDisplayed());
    }








}
