package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;
import utilities.Driver;


public class LoginTest {

//    HomePage homePage = new HomePage();
    LogInPage logInPage = new LogInPage();
    String correctEmail = "saitegin05@gmail.com";
    String correctPassword = "codewise";
    Faker faker = new Faker();


    @BeforeMethod
    public void goToWebSiteAndChangeLangToEnglish(){
        Driver.getDriver().get("https://cashwise.us/main?showLogin=false");
        Driver.getDriver().manage().window().maximize();

//        Changin language to English
        logInPage.languageButton.click();
        logInPage.laguageBtENG.click();

    }



    @Test (groups = "goToWebSiteAndChangeLangToEnglish")
    public void logInSucces(){
//        goToWebSiteAndChangeLangToEnglish();
        logInPage.logIn(correctEmail, correctPassword);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h2[text()=\"CodewiseTest\"]")).getText().equals("CodewiseTest"));

        //log outing
        logInPage.accountProfil.click();
        logInPage.logoutButton.click();
        logInPage.logoutAcceptButton.click();
    }


    //Negative
    @Test (groups = "goToWebSiteAndChangeLangToEnglish")
    public void logInUnsucces(){
//        goToWebSiteAndChangeLangToEnglish();
        logInPage.logIn(faker.internet().emailAddress(), faker.internet().password());
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h3[text()=\"Sign in\"]")).getText().equals("Sign in"));

    }


    @Test (groups = "goToWebSiteAndChangeLangToEnglish")
    public void forgotPassword(){
//        goToWebSiteAndChangeLangToEnglish();
        logInPage.signIn.click();
        logInPage.forgotbutton.click();
        logInPage.forgotEmailInput.sendKeys(faker.internet().emailAddress() + Keys.ENTER);
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//p[text()=\"Ссылка для сброса пароля отправлена!\"]")).getText(),"Ссылка для сброса пароля отправлена!");

    }

    @Test(groups = {"goToWebSiteAndChangeLangToEnglish"})
    public void logoutFun() {
//        goToWebSiteAndChangeLangToEnglish();
        logInPage.logout(correctEmail, correctPassword);
        Assert.assertTrue(logInPage.signIn.isDisplayed());

    }



}
