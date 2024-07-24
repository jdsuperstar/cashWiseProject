package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckPage;
import pages.HomePageElza;
import utilites.Driver;

public class CheckTest {








        WebDriver driver = Driver.getDriver();
        CheckPage checkPage = new CheckPage();
        HomePageElza homePage = new HomePageElza();
        Faker faker = new Faker();

        @Test
        public void checkFunctionality() {
            driver.get("https://cashwise.us/");
            homePage.login("admin@codewise.com", "codewise123");
            checkPage.report.click();
            checkPage.checkButton.click();
            checkPage.addCheck.click();
            checkPage.titleButton.sendKeys(faker.name().fullName());
            checkPage.selectButton.click();
            checkPage.selectSeller.click();
            checkPage.commentBox.sendKeys("The tuition fee $1000 was paid");
            checkPage.dueDateButton.sendKeys("07/03/2023");
            checkPage.addButton.click();
            checkPage.selectWriteTitle.click();
            checkPage.saveButton.click();
            String expectedUrl = "https://cashwise.us/dashboard/costs/checks";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertFalse(expectedUrl.equals(actualUrl));

        }


        @Test
        public void  checkTheDate() {
            driver.get("https://cashwise.us/");
            homePage.login("admin@codewise.com", "codewise123");
            checkPage.report.click();
            checkPage.checkButton.click();
            checkPage.addCheck.click();
            checkPage.titleButton.sendKeys("Tuition Fee");
//        checkPage.selectButton.click();
//        checkPage.selectSeller.click();
            checkPage.dueDateButton.sendKeys("32/13/2023");
            checkPage.addButton.click();
            checkPage.selectWriteTitle.click();
            checkPage.saveButton.click();
            String expectedUrl = "https://cashwise.us/dashboard/costs/checks";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertFalse(expectedUrl.equals(actualUrl));
            Driver.quitDriver();


        }

    }
