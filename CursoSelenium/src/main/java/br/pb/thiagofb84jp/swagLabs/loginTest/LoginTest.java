package br.pb.thiagofb84jp.swagLabs.loginTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;


//https://github.com/thiagofb84jp/studies-qa/blob/master/AddressBook/java/br/pb/selenium/addressbook/test/SignInTest.java
//https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//https://the-internet.herokuapp.com/
//https://phptravels.org/login
//https://gist.github.com/miodeqqq/b416b42e1573e6d35f464375297a070c
//https://demoqa.com/login

public class LoginTest {

    private static final String URL_SWAG_LABS = "https://www.saucedemo.com/";

    WebDriver driver;

    @Before
    public void setup() {
        ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.out).build();
        driver = new ChromeDriver(service);
        driver.manage().window().maximize();
        driver.get(URL_SWAG_LABS);
    }

    @Test
    public void shouldLoginWithSuccessful() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals("Products", driver.findElement(By.xpath("//span[text()='Products']")).getText());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
