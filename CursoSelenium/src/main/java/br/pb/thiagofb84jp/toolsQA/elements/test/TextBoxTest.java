package br.pb.thiagofb84jp.toolsQA.elements.test;

import br.pb.thiagofb84jp.toolsQA.core.Core;
import br.pb.thiagofb84jp.toolsQA.elements.page.TextBoxPage;
import org.junit.Test;

public class TextBoxTest extends Core {

    private static final String URL_DEMO_QA = "https://demoqa.com/text-box";

    TextBoxPage textBoxPage = new TextBoxPage(driver);

    public TextBoxTest() {
        driver.get(URL_DEMO_QA);
    }

    @Test
    public void shouldSubmitWithSuccessfully() {
        String name = "Jonathan dos Santos Barbosa Silva Paiva";
        String email = "jonathan.barbosa@email.com";
        String address = "Rua dos Sonhos Perdidos da Silva, no. 55";
        String permanentAddress = "Rua Jesus Menino Praga Andrade Barreto, no. 82";

        textBoxPage.setFullName(name);
        textBoxPage.setEmail(email);
        textBoxPage.setCurrentAddress(address);
        textBoxPage.setPermanentAddress(permanentAddress);
        textBoxPage.clickSubmitButton();

        textBoxPage.verifyName("Name:" + name);
        textBoxPage.verifyEmail("Email:" + email);
        textBoxPage.verifyCurrentAddress("Current Address :" + address);
        textBoxPage.verifyPermanentAddress("Permananet Address :" + permanentAddress);
    }
}
