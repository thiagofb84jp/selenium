package br.pb.thiagofb84jp;

import com.google.common.annotations.VisibleForTesting;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.http.WebSocket;
import java.sql.Driver;

public class TesteGoogle {
    private WebDriver driver;

    @Before
    public void setup() {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test
    public void testeGoogle() {
        Assert.assertEquals("Google", driver.getTitle());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
