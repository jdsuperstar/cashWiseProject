package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.sellerPage;
import utilities.Driver;
import org.testng.Assert;
import pages.cashWiseHomePage;

public class sellertestNG2 {

        WebDriver driver = Driver.getDriver();
        cashWiseHomePage cashWiseHomePage = new cashWiseHomePage();
        sellerPage seller = new sellerPage();
        Faker faker = new Faker();



        @Test
        // positive task
        public void sellerFunctionality() throws InterruptedException {
            String name = faker.name().fullName();
            int numberAddress = faker.number().numberBetween(1,999);
            String address = numberAddress+ " " + faker.name().firstName();
            String email = "@gmail.com";
            String ganareteEmail = faker.name().username()+email;
            String title = faker.name().title();
            String number = numberAddress+""+numberAddress+""+numberAddress+""+"2";


            Driver.getDriver().get("https://cashwise.us/");
            cashWiseHomePage.login("vladtest@gmail.com","123456");
            seller.expenses.click();
            seller.seller.click();
            seller.addSeller.click();
            seller.writeTitle.sendKeys(title);
            seller.fullName.sendKeys(name);
            seller.email.sendKeys(ganareteEmail);
            seller.phoneNumber.sendKeys((CharSequence) number);
            seller.enterAddress.sendKeys(address);
            seller.save.click();
            Thread.sleep(6000);
            seller.verifyName(name);   // to check the seller is added
        }


        @Test
        //Negative Task
        public void sellerNeg(){
            seller.addSeller.click();
            seller.writeTitle.sendKeys("Service");
            // if we enter a number to the name or special character.
            seller.fullName.sendKeys("Johny Dankha123");
            seller.email.sendKeys("johnydankha@gmail.com");
            seller.phoneNumber.sendKeys("7779998888");
            seller.enterAddress.sendKeys("1515 N Devon");
            seller.save.click();
            Assert.assertTrue(seller.alertMessage.isDisplayed());
            seller.cancel.click();
        }

        @Test
        // Positive: search for added seller
        public void searchSeller(){
            seller.nameToSearch();
        }
        @Test
        //Negative: search any name and make sure is not in table
        public void nameSearch()  {
            seller.enterName("Johny Dankha");
        }
        
    }


