package projects.TA_web.action.implement_action;

import common.Constant;
import common.URL;
import org.openqa.selenium.WebDriver;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.page_object.admin_portal.AdminPortalPo;
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
        webDriver.get(URL.portalStage1Ta);
    }

    @Override
    public void goToAddCoupon(WebDriver webDriver) {
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        AdminPortalPo adminPortalPO = new AdminPortalPo(Constant.webDriver);
        ManageCouponTypePO manageCouponTypePO = new ManageCouponTypePO(Constant.webDriver);
        userPortalPO.spanGoToAdminPage.click();
        adminPortalPO.spanManageCouponType.click();
        manageCouponTypePO.btnAdd.click();
    }
}
