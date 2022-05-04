package com.somar.softwareTesting;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {
    private JavascriptExecutor js = (JavascriptExecutor) driver;

    private By workingLocalyRadioButton = By.xpath("//*[@id=\"working_locally_yes\"]");
    private By chooseFileButton = By.xpath("//*[@id=\"support-attachment\"]");

    private String JS_DROP_FILE = "var target = arguments[0]," +
            "    offsetX = arguments[1]," +
            "    offsetY = arguments[2]," +
            "    document = target.ownerDocument || document," +
            "    window = document.defaultView || window;" +
            "" +
            "var input = document.createElement('INPUT');" +
            "input.type = 'file';" +
            "input.style.display = 'none';" +
            "input.onchange = function () {" +
            "  var rect = target.getBoundingClientRect()," +
            "      x = rect.left + (offsetX || (rect.width >> 1))," +
            "      y = rect.top + (offsetY || (rect.height >> 1))," +
            "      dataTransfer = { files: this.files };" +
            "" +
            "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
            "    var evt = document.createEvent('MouseEvent');" +
            "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
            "    evt.dataTransfer = dataTransfer;" +
            "    target.dispatchEvent(evt);" +
            "  });" +
            "" +
            "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
            "};" +
            "document.body.appendChild(input);" +
            "return input;";

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public String getWorkingLocalyValue() {
        return this.waitForElement(workingLocalyRadioButton).isSelected() ? "Yes" : "No";
    }

    public String uploadFile(String path) {
        File file = new File(path);
        if (!file.exists())
            throw new WebDriverException("File not found: " + path.toString());

        this.waitForElement(chooseFileButton).sendKeys(path);
        return this.waitForElement(chooseFileButton).getAttribute("value");
    }

    public String dragAndDropFile(String path) {
        File file = new File(path);
        if (!file.exists())
            throw new WebDriverException("File not found: " + path.toString());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement input = (WebElement)js.executeScript(JS_DROP_FILE, this.waitForElement(chooseFileButton), 0, 0);
        input.sendKeys(file.getAbsoluteFile().toString());

        System.out.print("text is: ");
        System.out.println(input.getAttribute("value"));
        return input.getAttribute("value");
    }
}
