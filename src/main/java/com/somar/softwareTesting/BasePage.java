package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 25);
    }
    public String returnBody() {
        WebElement bodyElement = this.waitForElement(By.tagName("body"));
        return bodyElement.getText();
    }

    protected WebElement waitBeforClick(By locator) {
        WebElement button = this.waitForElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(button));
        return button;
    }

    protected WebElement waitForElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }
}
