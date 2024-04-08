#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.testscripts;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import ${package}.utils.BrowserUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;

    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    public static Page getPage() {
        return page.get();
    }

    @BeforeClass
    void launchBrowser() {
        final String browserName = System.getProperty("browser", "chromium_headed");
        playwright = Playwright.create();
        browser = BrowserUtil.createBrowser(browserName, playwright);
    }

    @AfterClass
    void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page.set(context.newPage());
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

}