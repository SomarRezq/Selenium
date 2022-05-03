package com.somar.softwareTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainPageTest {
    public WebDriver driver;

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSiteLoads() {
        MainPage mainPage = new MainPage(this.driver);
        assertTrue(mainPage.returnBody().contains("Testing Made Easy"));
        assertTrue(mainPage.returnFooter().contains("PRODUCTS"));
    }

    @Test
    public void testPricingPage() {
        MainPage mainPage = new MainPage(this.driver);
        ViewPricingPage viewPricingPage = mainPage.viewPricingPage();
        assertTrue(viewPricingPage.returnBody().contains("PRODUCTS"));
    }

    @Test
    public void testPartnersPage() {
        MainPage mainPage = new MainPage(this.driver);
        PartnersPage partnersPage = mainPage.partnersPage();
        assertTrue(partnersPage.returnBody().contains("Become a BrowserStack Partner"));
    }

    @Test
    public void testTitle() {
        MainPage mainPage = new MainPage(this.driver);
        assertTrue(mainPage.GetTitle().contains("Most Reliable App & Cross Browser Testing Platform | BrowserStack"));
    }
    
    @AfterAll
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}