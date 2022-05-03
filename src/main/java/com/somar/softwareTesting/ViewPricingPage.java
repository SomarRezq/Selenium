package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ViewPricingPage extends BasePage {
    private By selectLocator = By.xpath("//*[@id=\"live-team-select-summary-table\"]");
    private By chooseButton = By.xpath("//*[@id=\"live-plans\"]/div[1]/div[6]/div/div[2]/div[5]/form/input[1]");
    private Select selectUsers = new Select(this.driver.findElement(selectLocator));

    public ViewPricingPage(WebDriver driver) {
        super(driver);
    }

    public OrdersPage Order(String value) {
        selectUsers.selectByVisibleText(value);
        this.waitForElement(chooseButton).click();
        wait.until(ExpectedConditions.urlContains("orders"));
        return new OrdersPage(this.driver);
    }
}
