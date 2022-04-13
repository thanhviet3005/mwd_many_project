package projects.TA_web.action.implement_action;

import common.Constant;
import common.URL;
import org.openqa.selenium.WebDriver;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.page_object.admin_portal.AdminPortalPO;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;
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
        webDriver.get(URL.portalTaOnLocal23);
    }

    @Override
    public void goToAddCouponTypePage(WebDriver webDriver) {
        UserPortalPO userPortalPO = new UserPortalPO(webDriver);
        AdminPortalPO adminPortalPO = new AdminPortalPO(webDriver);
        ManageCouponTypePO manageCouponTypePO = new ManageCouponTypePO(webDriver);
        userPortalPO.spanGoToAdminPage.click();
        adminPortalPO.spanManageCouponType.click();
        manageCouponTypePO.btnAdd.click();
    }

    @Override
    public void goToEditCouponTypePage(WebDriver webDriver) {
        UserPortalPO userPortalPO = new UserPortalPO(webDriver);
        AdminPortalPO adminPortalPO = new AdminPortalPO(webDriver);
        ManageCouponTypePO manageCouponTypePO = new ManageCouponTypePO(webDriver);
        userPortalPO.spanGoToAdminPage.click();
        adminPortalPO.spanManageCouponType.click();
        manageCouponTypePO.svgIconEditRow1.click();
    }

    @Override
    public void goToEditProfileUserPage(WebDriver webDriver, UserPortalPO userPortalPO) throws InterruptedException {
        userPortalPO.svgAccountMenu.click();
        userPortalPO.aMyProfile.click();
        userPortalPO.btnEditProfile.click();

    }


}
