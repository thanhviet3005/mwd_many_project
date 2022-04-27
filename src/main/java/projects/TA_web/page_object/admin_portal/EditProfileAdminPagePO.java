package projects.TA_web.page_object.admin_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import projects.TA_web.page_object.user_portal.EditProfilePO;

public class EditProfileAdminPagePO extends EditProfilePO {
    @FindBy(xpath = "//input[@id='outlined-textarea']")
    public WebElement inputSearch;
    @FindBy(xpath = "//div[@class='css-1yjo05o']//button//child::span//*[name()='svg' and @data-testid='SearchIcon']")
    public WebElement btnSearch;
    @FindBy(xpath = "//tbody")
    public WebElement emailValue;
    @FindBy (xpath = "//button[text() = 'Edit']")
    public WebElement btnEdit;
    public EditProfileAdminPagePO(WebDriver webDriver) {
        super(webDriver);
    }
}
