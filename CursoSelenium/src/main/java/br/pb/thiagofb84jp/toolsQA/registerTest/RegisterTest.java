package br.pb.thiagofb84jp.toolsQA.registerTest;

import br.pb.thiagofb84jp.swagLabs.core.Core;
import br.pb.thiagofb84jp.toolsQA.registerPage.RegisterPage;

public class RegisterTest extends Core {

    private static final String URL_LOGIN_DEMOQA = "https://demoqa.com/login";

    RegisterPage registerPage = new RegisterPage(driver);

    public RegisterTest() {
        driver.get(URL_LOGIN_DEMOQA);
    }

    public void shouldRegisterWithSucessfully() {
        registerPage.clickNewUserButton();
        registerPage.setFirstName("Marcos");
        registerPage.setLastName("Duarte da Silva Lima");
        registerPage.setUserName("strUserName");
        registerPage.setPassword("strPassword");
        registerPage.clickRegisterButton();
    }
}
