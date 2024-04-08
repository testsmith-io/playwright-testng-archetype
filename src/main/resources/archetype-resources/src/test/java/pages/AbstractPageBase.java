#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import com.microsoft.playwright.Page;

abstract class AbstractPageBase {
    protected Page page;

    public AbstractPageBase(Page page) {
        this.page = page;
    }
}
