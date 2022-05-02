package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;

import java.util.function.Predicate;

public class LoginPage extends BasePage {

    private By emailTextField = By.xpath("/html/body/main/div[4]/section/form/div[1]/div/div[1]/div[4]/div/input");
    private By passwordTextField = By.xpath("/html/body/main/div[4]/section/form/div[1]/div/div[1]/div[5]/div/input");
    private By submitButton = By.xpath("/html/body/main/div[4]/section/form/div[1]/div/div[1]/div[10]/div/input");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public DashboardPage clickLogin(String email, String password) {
        this.waitAndReturnElement(emailTextField).sendKeys(email);
        this.waitAndReturnElement(passwordTextField).sendKeys(password);

        // wait until the button is clickable
        waitUntilClickable(submitButton).click();

        // wait until the page is loaded
        wait.until(ExpectedConditions.urlContains("dashboard"));
        return new DashboardPage(driver);
    }
}
