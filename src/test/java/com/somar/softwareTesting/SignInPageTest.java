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
public class SignInPageTest {
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
    public void testSignInPage() {
        MainPage mainPage = new MainPage(this.driver);
        SignInPage loginPage = mainPage.signInPage();
        assertTrue(loginPage.returnBody().contains("Sign in"));
    }

    @Test
    public void testSignInAction() {
        MainPage mainPage = new MainPage(this.driver);
        SignInPage loginPage = mainPage.signInPage();
        DashboardPage dashboardPage = loginPage.signIn(email, password);
        assertTrue(dashboardPage.returnBody().contains("Automate"));
    }

    @Test
    public void testSignOutAction() throws InterruptedException {
        MainPage mainPage = new MainPage(this.driver);
        SignInPage loginPage = mainPage.signInPage();
        DashboardPage dashboardPage = loginPage.signIn(email, password);
        loginPage = dashboardPage.signOut();
        assertTrue(loginPage.returnBody().contains("Sign in"));
    }
}
