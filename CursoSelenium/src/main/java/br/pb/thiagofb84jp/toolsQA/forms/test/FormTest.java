package br.pb.thiagofb84jp.toolsQA.forms.test;

import br.pb.thiagofb84jp.salesforce.core.Core;
import br.pb.thiagofb84jp.toolsQA.forms.page.FormPage;
import org.junit.Test;

public class FormTest extends Core {

    private static final String URL_DEMO_QA_FORMS = "https://demoqa.com/automation-practice-form";

    FormPage formPage = new FormPage(driver);

    public FormTest() {
        driver.get(URL_DEMO_QA_FORMS);
    }

    @Test
    public void shouldRegisterStudentWithSuccessfully() {

    }
}
