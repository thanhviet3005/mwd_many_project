package projects.TA_web.page_object.user_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPortalPO {
    /* ****  Locator & Element **** */
    @FindBy(xpath = "//nav//img[@alt='TestArchitect Logo']")
    public WebElement imgLogoTA;
    @FindBy(xpath = "//nav//li//span[text()='My Account']")
    public WebElement spanMyAccount;
    @FindBy(xpath = "//nav//li//span[text()='My Account']//parent::div//preceding-sibling::*[name()='svg' and @data-testid='BadgeIcon']")
    public WebElement svgIconMyAccount;
    @FindBy(xpath = "//nav//li//span[text()='Refer and Earn']")
    public WebElement spanReferAndEarn;
    @FindBy(xpath = "//nav//li//span[text()='Refer and Earn']//parent::div//preceding-sibling::*[name()='svg' and @data-testid='PeopleAltOutlinedIcon']")
    public WebElement svgIconReferAndEarn;
    @FindBy(xpath = "//nav//li//span[text()='Redeem']")
    public WebElement spanRedeem;
    @FindBy(xpath = "//nav//li//span[text()='Redeem']//parent::div//preceding-sibling::*[name()='svg' and @data-testid='CardGiftcardIcon']")
    public WebElement svgIconRedeem;
    @FindBy(xpath = "//nav//li//span[text()='Leave a message']")
    public WebElement spanLeaveAMessage;
    @FindBy(xpath = "//nav//li//span[text()='Leave a message']//parent::div//preceding-sibling::*[name()='svg' and @data-testid='ChatOutlinedIcon']")
    public WebElement svgIconLeaveAMessage;
    @FindBy(xpath = "")
    public WebElement linkGoToAdminPage;

    public UserPortalPO (WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }








}
