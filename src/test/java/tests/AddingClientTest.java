package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddClientPage;
import pages.HomePage;
import utilites.Driver;

import java.util.List;


public class AddingClientTest {
    HomePage homePage = new HomePage();
    AddClientPage addClientPage = new AddClientPage();
    Faker faker = new Faker();

    @BeforeMethod //login
    public void loginFunction(){
        homePage = new HomePage();
        addClientPage = new AddClientPage();
        faker = new Faker();
        Driver.getDriver().get("https://cashwise.us/");
        homePage.login("vladtest@gmail.com","123456");
    }

    @AfterMethod
    public void shutDown(){
        Driver.quitDriver();
    }

     @Test //positive test (client was added successfully and Client's info is displayed
     public void AddClient() throws InterruptedException {
     String companyName = faker.name().title();
     addClientPage.sales.click();
     addClientPage.addClient.click();
     addClientPage.selectTag.click();
     addClientPage.createTag.click();
     addClientPage.tagName.sendKeys(companyName);
     addClientPage.saveButton.click();
     addClientPage.selectTag.click();
     addClientPage.defaultTag.click();
     addClientPage.companyName.sendKeys(companyName);
     addClientPage.clientFullName.sendKeys(faker.name().fullName());
     addClientPage.clientEmail.sendKeys(faker.name().username()+"@gmail.com");
     addClientPage.clientPhone.sendKeys(faker.phoneNumber().cellPhone());
     addClientPage.clientAddress.sendKeys(faker.address().fullAddress());
     addClientPage.saveClientButton.click();
     Assert.assertTrue(addClientPage.clientInfo.isDisplayed());
     
 }

 @Test //negative
    public void ClientWasNotAdded(){
     String companyName = faker.name().title();
     addClientPage.sales.click();
     addClientPage.addClient.click();
     addClientPage.selectTag.click();
     addClientPage.defaultTag.click();
     addClientPage.companyName.sendKeys(companyName);
     addClientPage.clientFullName.sendKeys(faker.name().fullName());
     addClientPage.clientEmail.sendKeys(faker.name().fullName());
     addClientPage.clientPhone.sendKeys("12345678912");
     addClientPage.clientAddress.sendKeys(faker.address().fullAddress());
     addClientPage.saveClientButton.click();
     Assert.assertTrue(addClientPage.errorNameMessage.isDisplayed()); // error message (client's name can not contain special chars or digits)

 }
 @Test //tests if user can select all clients
    public void SelectAll(){
        addClientPage.sales.click();
        addClientPage.checkAll.click();
        Assert.assertTrue(addClientPage.checkboxes.isSelected());
 }

 @Test // tests if the list is empty after archiving all clients
    public void ArchiveAll(){
        addClientPage.sales.click();
        addClientPage.checkAll.click();
        addClientPage.archiveAll.click();
        Assert.assertTrue(addClientPage.emptyMessage.isDisplayed());

 }

 }





