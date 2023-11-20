package br.pb.thiagofb84jp.toolsQA.registerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    By newUserButton = By.id("");
    By firstName = By.id("");
    By lastName = By.id("");
    By userName = By.id("");
    By password = By.id("");
    By registerButton = By.id("");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
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
}
