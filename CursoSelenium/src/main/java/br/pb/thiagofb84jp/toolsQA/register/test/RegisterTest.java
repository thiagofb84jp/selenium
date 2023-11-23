package br.pb.thiagofb84jp.toolsQA.register.test;

import br.pb.thiagofb84jp.swagLabs.core.Core;
import br.pb.thiagofb84jp.toolsQA.register.page.RegisterPage;
import org.junit.Test;

public class RegisterTest extends Core {

    private static final String URL_LOGIN_DEMOQA = "https://demoqa.com/login";

    RegisterPage registerPage = new RegisterPage(driver);

    public RegisterTest() {
        driver.get(URL_LOGIN_DEMOQA);
    }

    @Test
    public void shouldRegisterWithSucessfully() {
        registerPage.clickNewUserButton();
        registerPage.setFirstName("Marcos");
        registerPage.setLastName("Duarte da Silva Lima");
        registerPage.setUserName("marcos.lima");
        registerPage.setPassword("abcd_123");
        registerPage.clickRegisterButton();
        registerPage.clickCaptcha();
    }
}
