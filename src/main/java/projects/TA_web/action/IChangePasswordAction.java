package projects.TA_web.action;

import SSO_project.entity.UserAccount;
import projects.TA_web.page_object.user_portal.ChangePasswordPO;

public interface IChangePasswordAction {
    void enterValueToCheckErrorMessage(ChangePasswordPO changePwPO, UserAccount userAccount, String newPw, String confirmPw);
    void changePassword(ChangePasswordPO changePwPO, UserAccount userAccount, String newPw, String confirmPw);
}
