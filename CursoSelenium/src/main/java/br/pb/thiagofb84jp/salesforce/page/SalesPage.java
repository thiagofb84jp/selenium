package br.pb.thiagofb84jp.salesforce.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SalesPage {

    private WebDriver driver;

    private WebDriverWait wait;

    By salesLink = By.xpath("//a[@title='Sales']/parent::*");
    By titleSales = By.xpath("//span[@class='header-product-name']");
    By cookiesButton = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    By salesforceReleaseNotes = By.xpath("//a[@title='Salesforce Release Notes']");
    By salesforceWinter = By.xpath("//h1[@class='slds-text-heading_large']");

    public SalesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickAcceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(cookiesButton));

        driver.findElement(cookiesButton).click();
    }

    public void clickSalesLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(salesLink));

        driver.findElement(salesLink).click();
    }

    public void clickSalesforceReleaseNotes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(salesforceReleaseNotes));

        driver.findElement(salesforceReleaseNotes).click();
    }

    public void validateTitle(String sales) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(titleSales));

        String getResult = driver.findElement(titleSales).getText();
        Assert.assertEquals(getResult, sales);
    }

    public void validateSalesForceReleaseTitle(String strMsgSalesforce) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(salesforceWinter));

        String getResult = driver.findElement(salesforceWinter).getText();
        Assert.assertEquals(getResult, strMsgSalesforce);
    }
}
