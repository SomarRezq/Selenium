package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SignInPage extends BasePage {

    private By emailTextField = By.xpath("/html/body/main/div[4]/section/form/div[1]/div/div[1]/div[4]/div/input");
    private By passwordTextField = By.xpath("/html/body/main/div[4]/section/form/div[1]/div/div[1]/div[5]/div/input");
    private By submitButton = By.xpath("/html/body/main/div[4]/section/form/div[1]/div/div[1]/div[10]/div/input");

    public SignInPage(WebDriver driver) {
        super(driver);
    }


    public DashboardPage clickLogin(String email, String password) {
        this.waitForElement(emailTextField).sendKeys(email);
        this.waitForElement(passwordTextField).sendKeys(password);

        // wait until the button is clickable
        waitBeforClick(submitButton).click();

        // wait until the page is loaded
        wait.until(ExpectedConditions.urlContains("dashboard"));
        return new DashboardPage(driver);
    }
}
