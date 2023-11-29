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
    By serviceLink = By.xpath("//a[@title='Service']/parent::*");
    By marketing = By.xpath("//a[@title='Marketing']/parent::*");
    By titlePage = By.xpath("//span[@class='header-product-name']");
    By cookiesButton = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    By salesforceReleaseNotes = By.xpath("//a[@title='Salesforce Release Notes']");
    By essentials = By.xpath("//a[@title='Essentials']");
    By marketingCloudContactData = By.xpath("//a[@title='Marketing Cloud Contact Data']");
    By titleDocSalesforce = By.xpath("//h1[@class='slds-text-heading_large']");

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

    public void clickServiceLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(serviceLink));

        driver.findElement(serviceLink).click();
    }

    public void clickSalesforceReleaseNotes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(salesforceReleaseNotes));

        driver.findElement(salesforceReleaseNotes).click();
    }

    public void clickEssentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(essentials));

        driver.findElement(essentials).click();
    }

    public void clickMarketingLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(marketing));

        driver.findElement(marketing).click();
    }

    public void clickMarketingCloudContactData() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(marketingCloudContactData));

        driver.findElement(marketingCloudContactData).click();
    }

    public void validateTitle(String sales) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(titlePage));

        String getResult = driver.findElement(titlePage).getText();
        Assert.assertEquals(getResult, sales);
    }

    public void validateSalesForceTitle(String strMsgSalesforce) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(titleDocSalesforce));

        String getResult = driver.findElement(titleDocSalesforce).getText();
        Assert.assertEquals(getResult, strMsgSalesforce);
    }
}