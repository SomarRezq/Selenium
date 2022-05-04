package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    private By profileButton = By.xpath("/html/body/div[1]/header/div/div/nav/ul[1]/li[7]/button");
    private By logoutButton = By.xpath("/html/body/div[1]/header/div/div/nav/ul[1]/li[7]/ul/li[7]/a");
    private By openSearchWindow = By.xpath("/html/body/div[1]/header/div/div/nav/ul[1]/li[9]/button");
    private By searchTextInput = By.xpath("//*[@id=\"doc-search-box-input\"]");
    private By searchButton = By.xpath("//*[@id=\"ds-input-handle\"]/button[2]");
    private By contactButton = By.xpath("//*[@id=\"account-menu-dropdown\"]/li[6]/a");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage signOut() {
        this.waitForElement(profileButton).click();
        this.waitForElement(logoutButton).click();
        wait.until(ExpectedConditions.urlContains("automate"));
        return new SignInPage(driver);
    }

    public SearchPage search(String text) {
        this.waitForElement(openSearchWindow).click();
        this.waitForElement(searchTextInput).sendKeys(text);
        this.waitForElement(searchButton).click();
        wait.until(ExpectedConditions.urlContains("search"));
        return new SearchPage(driver);
    }

    public ContactPage contactUs() {
        this.waitForElement(profileButton).click();
        this.waitForElement(contactButton).click();
        wait.until(ExpectedConditions.urlContains("contact"));
        return new ContactPage(driver);
    }
}
