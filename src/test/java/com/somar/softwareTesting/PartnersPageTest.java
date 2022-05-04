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
class PartnersPageTest {
    public WebDriver driver;

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TestReturnTextAreaTextAction() {
        MainPage mainPage = new MainPage(this.driver);
        PartnersPage partnersPage = mainPage.partnersPage();
        assertTrue(partnersPage.returnTextAreaText().contains("Tell us how we can help"));
    }

    @AfterAll
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}