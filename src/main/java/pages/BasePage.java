package pages;

import controls.Link;
import utilities.Constant;

public class BasePage {
    private final Link tabLink = new Link("css=a[href*='%s']");
    private final Link hyperlink = new Link("//div[@id='content']/ul//li/a[contains(text(),'%s')]");

    public void selectOnTab(String pathTab) {
        tabLink.setDynamicValue(pathTab);
        tabLink.click();
    }

    public void clickHyperLinkText(String pathHyperLink) {
        hyperlink.setDynamicValue(pathHyperLink);
        hyperlink.click();
    }

    public String getURLPage(String name) {
        hyperlink.setDynamicValue(name);
        return hyperlink.getCurrentULR();
    }
}
