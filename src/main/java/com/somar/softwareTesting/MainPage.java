package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By footerBy = By.xpath("/html/body/div[1]/footer");
    private By loginButton = By.xpath("/html/body/div[1]/header/div[1]/div/nav/ul[1]/li[5]/a");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.browserstack.com/");
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }

    public LoginPage getLoginPage() {
        this.waitAndReturnElement(loginButton).click();
        return new LoginPage(this.driver);
    }
}
