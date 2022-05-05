package com.somar.softwareTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DashboardPageTest {
    public WebDriver driver;
    ConfigFileReader configFileReader;

    private String email, password;
    private String searchText = "test";

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        configFileReader = new ConfigFileReader();
        this.email = configFileReader.getUserName();
        this.password = configFileReader.getPassWord();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSearchAction() {
        MainPage mainPage = new MainPage(this.driver);
        SignInPage loginPage = mainPage.signInPage();
        DashboardPage dashboardPage = loginPage.signIn(email, password);
        SearchPage searchPage = dashboardPage.search(searchText);
        assertTrue(searchPage.returnBody().contains("Search Results"));
    }

    @Test
    public void testcontactUsPage() {
        MainPage mainPage = new MainPage(this.driver);
        SignInPage loginPage = mainPage.signInPage();
        DashboardPage dashboardPage = loginPage.signIn(email, password);
        ContactPage contactPage = dashboardPage.contactUs();
        assertTrue(contactPage.returnBody().contains("Get in touch with us"));
    }
}
