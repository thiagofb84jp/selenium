package br.pb.thiagofb84jp.toolsQA.register.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By newUserButton = By.id("newUser");
    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By userName = By.id("userName");
    By password = By.id("password");
    By registerButton = By.id("register");
    By frame = By.xpath("//iframe[starts-with(@name,'a-')]");
    By captha = By.id("recaptcha-anchor");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickNewUserButton() {
        driver.findElement(newUserButton).click();
    }

    public void setFirstName(String strFirstName) {
        driver.findElement(firstName).click();
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(strFirstName);
    }

    public void setLastName(String strLastName) {
        driver.findElement(lastName).click();
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(strLastName);
    }

    public void setUserName(String strUserName) {
        driver.findElement(userName).click();
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        driver.findElement(password).click();
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickCaptcha() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(captha));
        element.click();
    }
}
