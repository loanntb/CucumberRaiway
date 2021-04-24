package controls;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Log;

import java.util.List;

public class BaseControl {
    private String locator;
    private By byLocator;
    private String dynamicLocator;
    private BaseControl parent;

    public BaseControl(String locator) {
        this.locator = locator;
        this.dynamicLocator = locator;
        this.byLocator = getByLocator();
    }

    public BaseControl(By byLocator) {
        this.byLocator = byLocator;
    }

    public BaseControl(String locator, Object... args) {
        this.dynamicLocator = locator;
        this.locator = String.format(dynamicLocator, args);
        this.byLocator = getByLocator();
    }

    public BaseControl(BaseControl parent, String locator) {
        this.locator = locator;
        this.dynamicLocator = locator;
        this.byLocator = getByLocator();
        this.parent = parent;
    }

    public BaseControl(BaseControl parent, By byLocator) {
        this.byLocator = byLocator;
        this.parent = parent;
    }

    public BaseControl(BaseControl parent, String locator, Object... args) {
        this.dynamicLocator = locator;
        this.locator = String.format(dynamicLocator, args);
        this.byLocator = getByLocator();
        this.parent = parent;
    }

    protected WebDriver getDriver() {
        return DriverManager.getWebDriver();
    }

    private By getByLocator() {
        String body = this.locator.replaceAll("[\\w\\s]*=(.*)", "$1").trim();
        String type = this.locator.replaceAll("([\\w\\s]*)=.*", "$1").trim();
        switch (type.toLowerCase()) {
            case "css":
                return By.cssSelector(body);
            case "id":
                return By.id(body);
            case "class":
                return By.className(body);
            case "link":
                return By.linkText(body);
            case "xpath":
                return By.xpath(body);
            case "text":
                return By.xpath(String.format("//*[contains(text(), '%s')]", body));
            case "name":
                return By.name(body);
            default:
                return By.xpath(locator);
        }
    }

    public void click() {
        getElement().click();
    }

    public By getLocator() {
        return this.byLocator;
    }

    public void setDynamicValue(Object... args) {
        this.locator = String.format(this.dynamicLocator, args);
        this.byLocator = getByLocator();
    }

    public List<WebElement> totalElements() {
        return getDriver().findElements(getLocator());
    }

    public WebElement getElement() {
        WebElement element = null;
        try {
            if (parent != null) {
                WebElement eleParent = parent.getElement();
                element = eleParent.findElement(getLocator());
            } else {
                element = getDriver().findElement(getLocator());
            }
            return element;
        } catch (StaleElementReferenceException e) {
            Log.error(
                    String.format("StaleElementReferenceException '%s': %s", getLocator().toString(), e.getMessage().split("\n")[0]));
            return getElement();
        }
    }

    public boolean isSelected() {
        try {
            Log.debug(String.format("Is control selected or not: %s", getLocator().toString()));
            return getElement().isSelected();
        } catch (Exception e) {
            Log.error(String.format("IsSelected: Has error with control '%s': %s", getLocator().toString(),
                    e.getMessage().split("\n")[0]));
            return false;
        }
    }

    public boolean isDisplayed() {
        try {
            Log.debug(String.format("is control displayed or not: %s", this.getLocator().toString()));
            return this.getElement().isDisplayed();
        } catch (Exception var2) {
            Log.error(String.format("IsDisplayed: Has error with control '%s': %s", this.getLocator().toString(), var2.getMessage()));
            return false;
        }
    }

    public String getCurrentULR() {
        return DriverManager.getWebDriver().getCurrentUrl();
    }

    public String getText() {
        try {
            Log.debug(String.format("Get text of element %s", getLocator().toString()));
            return getElement().getText().trim();
        } catch (Exception e) {
            Log.error(String.format("Has error with control '%s': %s", getLocator().toString(), e.getMessage().split("\n")[0]));
            throw e;
        }
    }
}
