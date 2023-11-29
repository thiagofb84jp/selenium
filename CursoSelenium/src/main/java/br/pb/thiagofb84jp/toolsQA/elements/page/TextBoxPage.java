package br.pb.thiagofb84jp.toolsQA.elements.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By userName = By.id("userName");
    By userEmail = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");
    By submitButton = By.id("submit");
    By msgName = By.id("name");
    By msgEmail = By.id("email");
    By msgCurrentAddress = By.xpath("//p[@id='currentAddress']");
    By msgPermanentAddress = By.xpath("//p[@id='permanentAddress']");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setFullName(String strFullName) {
        driver.findElement(userName).click();
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(strFullName);
    }

    public void setEmail(String strEmail) {
        driver.findElement(userEmail).click();
        driver.findElement(userEmail).clear();
        driver.findElement(userEmail).sendKeys(strEmail);
    }

    public void setCurrentAddress(String strAddress) {
        driver.findElement(currentAddress).click();
        driver.findElement(currentAddress).clear();
        driver.findElement(currentAddress).sendKeys(strAddress);
    }

    public void setPermanentAddress(String strPermanentAddress) {
        driver.findElement(permanentAddress).click();
        driver.findElement(permanentAddress).clear();
        driver.findElement(permanentAddress).sendKeys(strPermanentAddress);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void verifyName(String name) {
        String getResult = driver.findElement(msgName).getText();
        Assert.assertEquals(getResult, name);
    }

    public void verifyEmail(String email) {
        String getResult = driver.findElement(msgEmail).getText();
        Assert.assertEquals(getResult, email);
    }

    public void verifyCurrentAddress(String address) {
        String getResult = driver.findElement(msgCurrentAddress).getText();
        Assert.assertEquals(getResult, address);
    }

    public void verifyPermanentAddress(String permanentAddress) {
        String getResult = driver.findElement(msgPermanentAddress).getText();
        Assert.assertEquals(getResult, permanentAddress);
    }
}
