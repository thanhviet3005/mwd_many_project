package projects.TA_web.action;

import SSO_project.entity.UserAccount;
import projects.TA_web.page_object.user_portal.LoginPO;

public interface ILoginAction {
    void loginSSO(LoginPO loginPO, UserAccount userAccount);
}
