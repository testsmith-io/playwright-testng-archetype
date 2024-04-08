#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import ${package}.properties.Environment;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePage extends AbstractPageBase {

    private final Locator signInButton;

    public HomePage(Page page) {
        super(page);
        this.signInButton = page.locator("[data-test='nav-sign-in']");
    }

    @Step("Open the Practice Software Testing homepage")
    public HomePage navigate() {
        page.navigate(Environment.getProperties().url());
        return this;
    }

    @Step("Is Sign In button displayed")
    public boolean isSignInButtonDisplayed() {
        return signInButton.isDisabled();
    }

}
