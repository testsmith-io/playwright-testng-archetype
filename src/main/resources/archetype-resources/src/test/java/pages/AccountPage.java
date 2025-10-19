#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class AccountPage extends AbstractPageBase {

    private final Locator myAccountHeading;

    public AccountPage(Page page) {
        super(page);
        this.myAccountHeading = page.locator("[data-test='page-title']");
    }

    @Step("Check if My Account page is displayed")
    public Locator isMyAccountPageDisplayed() {
        return myAccountHeading;
    }

}