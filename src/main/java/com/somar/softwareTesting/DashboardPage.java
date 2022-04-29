package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    private By profileButton = By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div/div[2]/div[1]/div/div[2]/div/divv");
    private By logoutButton = By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div[5]");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        this.waitAndReturnElement(profileButton).click();
        this.waitAndReturnElement(logoutButton).click();
        wait.until(ExpectedConditions.urlContains("login"));
        return new LoginPage(driver);
    }
}
