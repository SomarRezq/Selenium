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
class contactPageTest {
    public WebDriver driver;
    ConfigFileReader configFileReader;
    private String email, password, path;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        configFileReader = new ConfigFileReader();
        this.email = configFileReader.getUserName();
        this.password = configFileReader.getPassWord();
        this.path = configFileReader.getImgPath();
    }

    @Test
    public void testgetWorkingLocalyValueAction() {
        MainPage mainPage = new MainPage(this.driver);
        SignInPage loginPage = mainPage.signInPage();
        DashboardPage dashboardPage = loginPage.signIn(email, password);
        ContactPage contactPage = dashboardPage.contactUs();
        assertTrue(contactPage.getWorkingLocalyValue().contains("Yes"));
    }

    @Test
    public void testuploadFileAction() {
        MainPage mainPage = new MainPage(this.driver);
        SignInPage loginPage = mainPage.signInPage();
        DashboardPage dashboardPage = loginPage.signIn(email, password);
        ContactPage contactPage = dashboardPage.contactUs();
        assertTrue(contactPage.uploadFile(path).contains("1.png"));
    }

    @Test
    public void testdragAndDropFileAction() {
        MainPage mainPage = new MainPage(this.driver);
        SignInPage loginPage = mainPage.signInPage();
        DashboardPage dashboardPage = loginPage.signIn(email, password);
        ContactPage contactPage = dashboardPage.contactUs();
        assertTrue(contactPage.dragAndDropFile(path).contains("1.png"));
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}