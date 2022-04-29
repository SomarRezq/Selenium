package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Predicate;

public class LoginPage extends BasePage {

    private By emailTextField = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[5]/div/input");
    private By passwordTextField = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[3]/div[1]/div/input");
    private By submitButton = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[4]");
    private By continueButton = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div[6]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public DashboardPage clickLogin(String username, String password) {
        this.waitAndReturnElement(emailTextField).sendKeys(username);
        // wait until the button is clickable
        waitUntilClickable(continueButton).click();

        this.waitAndReturnElement(passwordTextField).sendKeys(password);

        // wait until the button is clickable
        waitUntilClickable(submitButton).click();

        // wait until the page is loaded
        wait.until(ExpectedConditions.urlContains("sample"));
        return new DashboardPage(driver);
    }
}
