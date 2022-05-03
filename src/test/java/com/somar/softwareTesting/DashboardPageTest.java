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
public class DashboardPageTest {
    public WebDriver driver;
    private String email = "somar.rezk.1994@gmail.com";
    private String password = "somarsomar";
    private String searchText = "test";

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSearchAction() {
        MainPage mainPage = new MainPage(this.driver);
        SignIn loginPage = mainPage.signInPage();
        DashboardPage dashboardPage = loginPage.clickLogin(email, password);
        SearchPage searchPage = dashboardPage.search(searchText);
        assertTrue(searchPage.returnBody().contains("Search Results"));
    }
}
