package projects.TA_web.page_object.admin_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCouponPO extends AddCouponPO{
    @FindBy(xpath = "tableTitle")
    public WebElement h5Title;

    public EditCouponPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, AddCouponPO.class);
        PageFactory.initElements(webDriver, this);
    }
}
