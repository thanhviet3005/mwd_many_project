package projects.TA_web.action.implement_action;

import common.URL;
import org.openqa.selenium.WebDriver;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.page_object.user_portal.UserPortalPO;

public class NavigateAction implements INavigateAction {
    @Override
    public void goToLeaveAMessagePage(WebDriver webDriver, UserPortalPO userPortalPO) {
        userPortalPO.spanLeaveAMessage.click();
    }

    @Override
    public void goToChangePasswordPage(WebDriver webDriver, UserPortalPO userPortalPO) {
        userPortalPO.svgAccountMenu.click();
        userPortalPO.aChangePw.click();
    }

    @Override
    public void goToLoginPage(WebDriver webDriver) {
        webDriver.get(URL.loginPageOnServer23Url);
    }
}
