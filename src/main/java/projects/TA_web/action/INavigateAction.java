package projects.TA_web.action;

import org.openqa.selenium.WebDriver;
import projects.TA_web.page_object.user_portal.UserPortalPO;

public interface INavigateAction {
    void goToLeaveAMessagePage(WebDriver webDriver, UserPortalPO userPortalPO) ;
    void goToChangePasswordPage(WebDriver webDriver, UserPortalPO userPortalPO);
    void goToLoginPage(WebDriver webDriver);
    void goToAddCoupon(WebDriver webDriver);

}
