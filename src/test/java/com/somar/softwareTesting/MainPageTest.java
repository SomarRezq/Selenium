package com.somar.softwareTesting;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.jsoup.Connection.Base;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainPageTest {
    public WebDriver driver;
    public List<StaticPageClass> staticPages = new ArrayList<>();

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.staticPages.add(new StaticPageClass("https://www.browserstack.com/", "App & Browser Testing Made Easy"));
        this.staticPages.add(new StaticPageClass("https://www.browserstack.com/contact", "Get in touch with us"));
        this.staticPages.add(new StaticPageClass("https://www.browserstack.com/company", "Trusted by 50,000+ customers"));
        //add more test casses
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
    public void testGetTitleAction() {
        MainPage mainPage = new MainPage(this.driver);
        assertTrue(mainPage.GetTitle().contains("Most Reliable App & Cross Browser Testing Platform | BrowserStack"));
    }

    @Test
    public void testhoverToPricingButtonAction() {
        MainPage mainPage = new MainPage(this.driver);
        assertTrue(mainPage.hoverToPricingButton());
    }

    @Test
    public void testHistory() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.signInPage();
        this.driver.navigate().back();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement bodyElement = this.driver.findElement(By.tagName("body"));
        assertTrue(bodyElement.getText().contains("Testing Made Easy"));
    }

    @Test
    public void testStaticPages() {
        this.staticPages.forEach((staticPage) -> {
            this.driver.get(staticPage.getUrl());
            BasePage page = new BasePage(this.driver);
            WebElement bodyElement = page.waitForElement(By.tagName("body"));
            assertTrue(bodyElement.getText().contains(staticPage.getTestText()));
        } );
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}