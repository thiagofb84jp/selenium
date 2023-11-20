package br.pb.thiagofb84jp.swagLabs.loginPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By menuButton = By.id("react-burger-menu-btn");
    By logoutLink = By.linkText("Logout");
    By goodMessage = By.xpath("//span[text()='Products']");
    By msgUserWithoutUsername = By.xpath("//h3[text()='Epic sadface: Username is required']");
    By msgUserWithoutPassword = By.xpath("//h3[text()='Epic sadface: Password is required']");
    By msgUserLockedOut = By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']");
    By msgLoginWithDiffPassword = By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setUsername(String strEmail) {
        driver.findElement(username).click();
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(strEmail);
    }

    public void setPassword(String strPassword) {
        driver.findElement(password).click();
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickBtnLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickBtnMenu() {
        driver.findElement(menuButton).click();
    }

    public void clickLogoutLink() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logoutLink));
        driver.findElement(logoutLink).click();
    }

    public void validateMsgLoggedUser(String strGoodMessage) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodMessage));
        String getResult = driver.findElement(goodMessage).getText();
        Assert.assertEquals(getResult, strGoodMessage);
    }

    public void validateMsgUserWithoutUsername(String strMsgUserWithoutUsername) {
        String getResult = driver.findElement(msgUserWithoutUsername).getText();
        Assert.assertEquals(getResult, strMsgUserWithoutUsername);
    }

    public void validateMsgUserWithoutPassword(String strMsgUserWithoutPassword) {
        String getResult = driver.findElement(msgUserWithoutPassword).getText();
        Assert.assertEquals(getResult, strMsgUserWithoutPassword);
    }

    public void validateMsgUserLockedOut(String strMsgUserLockedOut) {
        String getResult = driver.findElement(msgUserLockedOut).getText();
        Assert.assertEquals(getResult, strMsgUserLockedOut);
    }

    public void validateMsgLoginWithDiffPassword(String strMsgLoginWithDiffPassword) {
        String getResult = driver.findElement(msgLoginWithDiffPassword).getText();
        Assert.assertEquals(getResult, strMsgLoginWithDiffPassword);
    }

    public void isButtonAvailableOnThePage() {
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed());
    }
}