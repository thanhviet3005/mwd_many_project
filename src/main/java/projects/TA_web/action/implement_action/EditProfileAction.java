package projects.TA_web.action.implement_action;

import general_action.IGeneralAction;
import org.openqa.selenium.WebDriver;
import projects.TA_web.action.IEditProfileAction;
import projects.TA_web.page_object.user_portal.EditProfilePO;

public class EditProfileAction implements IEditProfileAction {



    @Override
    public void UploadAvatar(EditProfilePO editProfilePO, boolean isImage) {

    }

    @Override
    public void UpdateFields(EditProfilePO editProfilePO, String textInput) {

    }

    @Override
    public void checkAllFieldsDisplayed(IGeneralAction generalAction, EditProfilePO editProfilePO) {

    }

    @Override
    public void checkAllErrorMsg(IGeneralAction generalAction, WebDriver webDriver, EditProfilePO editProfilePO) {

    }
}
