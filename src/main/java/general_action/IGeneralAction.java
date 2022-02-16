package general_action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface IGeneralAction {
    /**
     * 1. Level: Low
     * 2. Purpose: Verify the text look like the design, then log result
     * 3. Scope: Use it when only log verifying result to sub step. It is useful
     * @param expectedText: The text is expected
     * @param webElement: The element locator is check
     * @param isInputField: is True if the element is a tag 'input'
     */
    void verifyTextDisplay(String expectedText, WebElement webElement, boolean isInputField);

    /**
     * 1. Level: Low
     * 2. Purpose: Verify the element is actually enable and not disable, then log result
     * 3. Scope: Use it when only log verifying result to sub step. It is useful
     * @param webElement: The element locator is check
     * @param elementName: The name of element is logged to extent report
     */
    void verifyElementEnable(WebElement webElement, String elementName);

    /**
     * 1. Level: Low
     * 2. Purpose: Verify the element is actually displayed, avoid the attribute 'style: display : none', then log result
     * 3. Scope: Use it when only log verifying result to sub step. It is useful
     * @param webElement: The element locator is check
     * @param elementName: The name of element is logged to extent report
     */
    void verifyElementDisplayed(WebElement webElement, String elementName);

    /**
     * 1. Level: Low
     * 2. Purpose: Verify the element currently hide or no existing
     * 3. Scope: Use it when only log verifying result to sub step. It is useful
     * @param by: The element locator is checked
     * @param elementName: The name of element is logged to extent report
     * @param webDriver: The current webdriver
     */
    void verifyElementHidden(By by, WebDriver webDriver, String elementName);

    /**
     * 1. Level: Low
     * 2. Purpose: Open a new tab, then close the current tab, finally switch to new tab
     * 3. Scope: Use it when the user want to perform in new tab, and close current tab
     */
    void openNewTabAndCloseCurrentTab(WebDriver webDriver);

    /**
     * 1. Level: Low
     * 2. Purpose: set up the time out of the Webdriver
     * 3. Scope: Use it when the user want to set up the time out of the WebDriver
     * @param webDriver: The current webdriver
     */
    void setupWebdriverTimeOut(WebDriver webDriver);

    void waitElementInteraction(WebDriver webDriver, WebElement webElement, int timeOut);



}
