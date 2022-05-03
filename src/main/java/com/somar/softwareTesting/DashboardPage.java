package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    private By profileButton = By.xpath("/html/body/div[1]/header/div/div/nav/ul[1]/li[7]/button");
    private By logoutButton = By.xpath("/html/body/div[1]/header/div/div/nav/ul[1]/li[7]/ul/li[7]/a");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public SignIn logout() {
        this.waitForElement(profileButton).click();
        this.waitForElement(logoutButton).click();
        wait.until(ExpectedConditions.urlContains("live"));
        return new SignIn(driver);
    }
}
