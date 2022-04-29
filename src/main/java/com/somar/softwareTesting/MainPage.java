package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By footerBy = By.xpath("/html/body/div[1]/div/div[3]/div/div[8]/div");
    private By loginButton = By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/header/div/div[3]/a[2]/button");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://jaas.8x8.vc/");
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }

    public LoginPage getLoginPage() {
        this.waitAndReturnElement(loginButton).click();
        return new LoginPage(this.driver);
    }
}
