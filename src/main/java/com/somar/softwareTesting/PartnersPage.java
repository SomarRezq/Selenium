package com.somar.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PartnersPage extends BasePage {
    private By textarea = By.xpath("//*[@id=\"form-message\"]");

    public PartnersPage(WebDriver driver) {
        super(driver);
    }

    public String returnTextAreaText(){
        return this.waitForElement(textarea).getAttribute("placeholder");
    }
}
