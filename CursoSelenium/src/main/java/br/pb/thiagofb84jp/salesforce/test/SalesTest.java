package br.pb.thiagofb84jp.salesforce.test;

import br.pb.thiagofb84jp.salesforce.core.Core;
import br.pb.thiagofb84jp.salesforce.page.SalesPage;
import org.junit.Test;

public class SalesTest extends Core {

    private static final String SALESFORCE_HELP = "https://help.salesforce.com/s/?language=en_US";

    SalesPage salesPage = new SalesPage(driver);

    public SalesTest() {
        driver.get(SALESFORCE_HELP);
        salesPage.clickAcceptCookies();
    }

    @Test
    public void itShouldAccessSalesArea() {
        salesPage.clickSalesLink();
        salesPage.validateTitle("Sales");
        salesPage.clickSalesforceReleaseNotes();
        salesPage.validateSalesForceReleaseTitle("Salesforce Winter ’24 Release Notes");
    }

    @Test
    public void itShouldAccessServiceArea() {

    }

    @Test
    public void itShouldAccessMarketingArea() {

    }

    @Test
    public void itShouldAccessCommerceArea() {

    }

    @Test
    public void itShouldAccessAnalyticsArea() {

    }

    @Test
    public void itShouldAccessPlatformArea() {

    }

    @Test
    public void itShouldAccessFinancialServiceArea() {

    }
}
