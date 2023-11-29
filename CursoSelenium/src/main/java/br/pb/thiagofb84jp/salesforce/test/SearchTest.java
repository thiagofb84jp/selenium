package br.pb.thiagofb84jp.salesforce.test;

import br.pb.thiagofb84jp.salesforce.core.Core;
import br.pb.thiagofb84jp.salesforce.page.SearchPage;
import org.junit.Test;

public class SearchTest extends Core {

    private static final String SALESFORCE_HELP = "https://help.salesforce.com/s/?language=en_US";

    SearchPage searchPage = new SearchPage(driver);

    public SearchTest() {
        driver.get(SALESFORCE_HELP);
    }

    @Test
    public void shouldSearchWithSuccessfully() {
        searchPage.clickAcceptCookies();
        searchPage.setSearch("Custom Help Content");
        searchPage.clickSearchButton();
        searchPage.verifyResultSearch("Custom Help Content");
        searchPage.clickLink("Custom Help Content");
        searchPage.verifyTitleResultSearch("Custom Help Content");
    }
}
