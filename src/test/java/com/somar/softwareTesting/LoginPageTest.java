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
public class LoginPageTest {
    public WebDriver driver;
    private String email = "somar.rezk.1994@gmail.com";
    private String password = "somarsomar";

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
    public void testLoginPage() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        assertTrue(loginPage.getBodyText().contains("Jitsi as a Service"));
    }

    @Test
    public void testLoginAction() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        DashboardPage dashboardPage = loginPage.clickLogin(email, password);
        assertTrue(dashboardPage.getBodyText().contains("Full frame integration"));
    }

    @Test
    public void testLogoutAction() throws InterruptedException {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        DashboardPage dashboardPage = loginPage.clickLogin(email, password);
        assertTrue(dashboardPage.getBodyText().contains("Full frame integration"));
        loginPage = dashboardPage.logout();
        assertTrue(loginPage.getBodyText().contains("Login"));
    }
}
