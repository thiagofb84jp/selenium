package br.pb.thiagofb84jp.toolsQA.elements.test;

import br.pb.thiagofb84jp.toolsQA.core.Core;
import br.pb.thiagofb84jp.toolsQA.elements.page.TextBoxPage;
import org.junit.Test;

public class TextBoxTest extends Core {

    private static final String URL_DEMO_QA = "https://demoqa.com/";

    TextBoxPage textBoxPage = new TextBoxPage(driver);

    public TextBoxTest() {
        driver.get(URL_DEMO_QA);
    }

    @Test
    public void shouldSubmitWithSuccessfully() {
        textBoxPage.clickTextBoxLink("Text Box");
        textBoxPage.setFullName("strFullName");
        textBoxPage.setEmail("strFullEmail");
        textBoxPage.setCurrentAddress("strCurrentAddress");
        textBoxPage.setPermanentAddress("strPermanentAddress");
        textBoxPage.clickSubmitButton();
    }
}
