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
class ViewPricingPageTest {
    public WebDriver driver;
    private String selectValue = "5 users";

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testOrdersPage() {
        MainPage mainPage = new MainPage(this.driver);
        ViewPricingPage viewPricingPage = mainPage.viewPricingPage();
        OrdersPage ordersPage = viewPricingPage.Order(selectValue);
        assertTrue(ordersPage.returnBody().contains("Bill Details"));
    }

    @AfterAll
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}