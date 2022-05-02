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
        assertTrue(mainPage.getBodyText().contains("Testing Made Easy"));
        assertTrue(mainPage.getFooterText().contains("PRODUCTS"));
    }

    @AfterAll
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}