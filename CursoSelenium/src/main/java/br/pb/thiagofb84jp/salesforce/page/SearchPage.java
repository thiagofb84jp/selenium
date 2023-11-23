package br.pb.thiagofb84jp.salesforce.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By searchText = By.xpath("//div[@class='magic-box-input']/input");
    By searchButton = By.xpath("//span[@class='coveo-search-button']");
    By linkCustomHelpCentral = By.xpath("//a[@class='CoveoResultLink coveo-accessible-button ResultLinkClicked']");
    By resultSearch = By.xpath("//a[@class='CoveoResultLink coveo-accessible-button ResultLinkClicked']");
    By titleResultSearch = By.xpath("//h1[@class='slds-text-heading_large']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setSearch(String strSearch) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(searchText));

        driver.findElement(searchText).click();
        driver.findElement(searchText).clear();
        driver.findElement(searchText).sendKeys();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickLink(String customHelpCentral) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(linkCustomHelpCentral));

        driver.findElement(linkCustomHelpCentral).click();
    }

    public void verifyResultSearch(String strMsgResult) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(resultSearch));

        String getResult = driver.findElement(resultSearch).getText();
        Assert.assertEquals(getResult, strMsgResult);
    }

    public void verifyTitleResultSearch(String strTitleResultSearch) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(titleResultSearch));

        String getResult = driver.findElement(titleResultSearch).getText();
        Assert.assertEquals(getResult, strTitleResultSearch);
    }
}
