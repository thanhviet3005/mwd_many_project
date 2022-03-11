package projects.TA_web.action.implement_action;

import SSO_project.entity.UserAccount;
import projects.TA_web.action.IChangePasswordAction;
import projects.TA_web.page_object.user_portal.ChangePasswordPO;

public class ChangePasswordAction implements IChangePasswordAction {
    @Override
    public void enterValueToCheckErrorMessage(ChangePasswordPO changePwPO, UserAccount userAccount, String newPw, String confirmPw) {
        changePwPO.inputPw.sendKeys(userAccount.getPassword());
        changePwPO.inputNewPw.sendKeys(newPw);
        changePwPO.inputConfirmPw.sendKeys(confirmPw);
        changePwPO.btnShowPw.click();
        changePwPO.btnShowNewPw.click();
        changePwPO.btnShowConfirmPw.click();
        changePwPO.h1Title.click();
    }

    @Override
    public void changePassword(ChangePasswordPO changePwPO, UserAccount userAccount, String newPw, String confirmPw) {
        changePwPO.inputPw.sendKeys(userAccount.getPassword());
        changePwPO.inputNewPw.sendKeys(newPw);
        changePwPO.inputConfirmPw.sendKeys(confirmPw);
        changePwPO.btnShowPw.click();
        changePwPO.btnShowNewPw.click();
        changePwPO.btnShowConfirmPw.click();
        changePwPO.btnSubmit.click();
    }
}
