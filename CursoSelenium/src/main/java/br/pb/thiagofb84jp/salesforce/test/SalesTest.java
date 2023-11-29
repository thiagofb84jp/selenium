package br.pb.thiagofb84jp.salesforce.test;

import br.pb.thiagofb84jp.salesforce.core.Core;
import br.pb.thiagofb84jp.salesforce.page.SalesPage;
import org.junit.Ignore;
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
        salesPage.validateSalesForceTitle("Salesforce Winter ’24 Release Notes");
    }

    @Test
    public void itShouldAccessServiceArea() {
        salesPage.clickServiceLink();
        salesPage.validateTitle("Service");
        salesPage.clickEssentials();
        salesPage.validateSalesForceTitle("What is Salesforce Essentials?");
    }

    @Test
    public void itShouldAccessMarketingArea() {
        salesPage.clickMarketingLink();
        salesPage.validateTitle("Marketing");
        salesPage.clickMarketingCloudContactData();
        salesPage.validateSalesForceTitle("Marketing Cloud Contact Data");
    }

    @Ignore
    @Test
    public void itShouldAccessCommerceArea() {

    }

    @Ignore
    @Test
    public void itShouldAccessAnalyticsArea() {

    }

    @Ignore
    @Test
    public void itShouldAccessPlatformArea() {

    }

    @Ignore
    @Test
    public void itShouldAccessFinancialServiceArea() {

    }
}
