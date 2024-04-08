#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserUtil {

    public static Browser createBrowser(String browserType, Playwright playwright) {
        Browser browser = null;
        switch (BrowserName.valueOf(browserType.toUpperCase())) {
            case CHROMIUM:
                browser = playwright.chromium().launch();
                break;
            case CHROMIUM_HEADED:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case FIREFOX:
                browser = playwright.firefox().launch();
                break;
            case FIREFOX_HEADED:
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case WEBKIT:
                browser = playwright.webkit().launch();
                break;
            case WEBKIT_HEADED:
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case CHROME:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome"));
                break;
            case CHROME_HEADED:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case MSEDGE:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge"));
                break;
            case MSEDGE_HEADED:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
                break;
        }
        return browser;
    }
}
