package projects.TA_web.page_object.admin_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPortalPo {
    @FindBy(xpath = "//nav//span[text()='Manage Coupon Type']")
    public WebElement spanManageCouponType;
    @FindBy(xpath = "//nav//span[text()='Manage Coupon']")
    public WebElement spanManageCoupon;
    @FindBy(xpath = "//nav//span[text()='Manage Client']")
    public WebElement spanManageClient;
    @FindBy(xpath = "//button//*[name()='svg' and @data-testid='ArrowDropDownIcon']")
    public WebElement btnMenuAccount;

    public AdminPortalPo(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

}
