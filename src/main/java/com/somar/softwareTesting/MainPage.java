package com.somar.softwareTesting;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    ConfigFileReader configFileReader;

    private By cookieAcceptButton = By.id("accept-cookie-notification");
    private By footerBy = By.xpath("/html/body/div[1]/footer");
    private By loginButton = By.xpath("/html/body/div[1]/header/div[1]/div/nav/ul[1]/li[5]/a");
    private By viewPricingButton = By.xpath("//*[@id=\"post-26\"]/div[6]/div/div/div/article/div/div[2]/div/span[2]/a");
    private By partnersButton = By.xpath("//*[@id=\"menu-item-25041\"]/a");

    public MainPage(WebDriver driver) {
        super(driver);
        configFileReader= new ConfigFileReader();
        this.driver.get(configFileReader.getWebsiteUrl());
        if (!this.driver.findElements(cookieAcceptButton).isEmpty())
        this.waitBeforClick(cookieAcceptButton).click(); 
    }

    public String returnFooter() {
        return this.waitForElement(footerBy).getText();
    }

    public SignInPage signInPage() {
        this.waitForElement(loginButton).click();
        return new SignInPage(this.driver);
    }

    public Boolean hoverToPricingButton() {
        Actions actions = new Actions(this.driver);
        String colorValue = this.waitForElement(viewPricingButton).getCssValue("color");
        actions.moveToElement(this.waitForElement(viewPricingButton)).perform();
        return this.waitForElement(viewPricingButton).getCssValue("color") != colorValue;
    }

    public ViewPricingPage viewPricingPage() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.waitForElement(viewPricingButton).click();
        wait.until(ExpectedConditions.urlContains("pricing"));
        return new ViewPricingPage(this.driver);

    }

    public PartnersPage partnersPage() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        this.waitForElement(partnersButton).click();
        wait.until(ExpectedConditions.urlContains("partners"));
        return new PartnersPage(this.driver);

    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public String getCookies() {
        return this.driver.manage().getCookies().toString();
    }
}
