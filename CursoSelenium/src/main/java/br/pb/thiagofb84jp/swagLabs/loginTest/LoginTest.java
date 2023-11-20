package br.pb.thiagofb84jp.swagLabs.loginTest;

import br.pb.thiagofb84jp.swagLabs.core.Core;
import br.pb.thiagofb84jp.swagLabs.loginPage.LoginPage;
import org.checkerframework.checker.fenum.qual.SwingTextOrientation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.concurrent.TimeUnit;

public class LoginTest extends Core {

    private static final String URL_SWAG_LABS = "https://www.saucedemo.com/";

    LoginPage loginPage = new LoginPage(driver);

    public LoginTest() {
        driver.get(URL_SWAG_LABS);
    }

    @Test
    public void shouldLoginWithSuccessful() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickBtnLogin();
        loginPage.validateMsgLoggedUser("Products");
    }

    @Test
    public void shouldNotloginWithoutToFillUsername() {
        loginPage.setPassword("secret_sauce");
        loginPage.clickBtnLogin();
        loginPage.validateMsgUserWithoutUsername("Epic sadface: Username is required");
    }

    @Test
    public void shouldNotloginWithoutToFillPassword() {
        loginPage.setUsername("secret_sauce");
        loginPage.clickBtnLogin();
        loginPage.validateMsgUserWithoutPassword("Epic sadface: Password is required");
    }

    @Test
    public void shouldLoginPerformanceGlitchUser() {
        loginPage.setUsername("performance_glitch_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickBtnLogin();
        loginPage.validateMsgLoggedUser("Products");
    }

    @Test
    public void shouldNotLoginWithUserLockedOut() {
        loginPage.setUsername("locked_out_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickBtnLogin();
        loginPage.validateMsgUserLockedOut("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void shouldNotLoginWithDiffPassword() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("abcd_123");
        loginPage.clickBtnLogin();
        loginPage.validateMsgLoginWithDiffPassword("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void shouldLogout() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickBtnLogin();
        loginPage.clickBtnMenu();
        loginPage.clickLogoutLink();
        loginPage.isButtonAvailableOnThePage();
    }
}
