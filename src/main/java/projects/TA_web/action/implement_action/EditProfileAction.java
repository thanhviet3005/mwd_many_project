package projects.TA_web.action.implement_action;

import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.openqa.selenium.WebDriver;
import projects.TA_web.action.IEditProfileAction;
import projects.TA_web.page_object.user_portal.EditProfilePO;

public class EditProfileAction implements IEditProfileAction {



    @Override
    public void UploadAvatar(EditProfilePO editProfilePO, boolean isImage) {
        IGeneralAction generalAction = new GeneralAction();
        if (!isImage){
            editProfilePO.uploadAvatar.sendKeys("D:\\mwd_many_project\\src\\main\\java\\SSO_project\\data_test\\Dashboard exercises 1.pdf");
            generalAction.verifyElementDisplayed(editProfilePO.labelErrorMsgUploadImg,"Invalid image type");
        } else {

            editProfilePO.uploadAvatar.sendKeys("D:\\mwd_many_project\\src\\main\\java\\SSO_project\\data_test\\superman.jpg");
            editProfilePO.btnSave.click();
            generalAction.verifyElementDisplayed(editProfilePO.divSuccessgUploadAvatar," Valid  image type");

        }
    }

    @Override
    public void UpdateFields(EditProfilePO editProfilePO, String textInput) {
        editProfilePO.inputFirstName.clear();
        editProfilePO.inputFirstName.sendKeys(textInput);
        editProfilePO.inputLastName.clear();
        editProfilePO.inputLastName.sendKeys(textInput);
        editProfilePO.labelCompany.click();


    }

    @Override
    public void checkAllFieldsDisplayed(IGeneralAction generalAction, EditProfilePO editProfilePO) {
            generalAction.verifyElementDisplayed(editProfilePO.labelFirstName,"Label first name ");
            generalAction.verifyElementDisplayed(editProfilePO.labelLastName,"Label last name");
            generalAction.verifyElementDisplayed(editProfilePO.inputFirstName,"input field first name");
            generalAction.verifyElementDisplayed(editProfilePO.inputLastName,"input field last name");
            generalAction.verifyElementDisplayed(editProfilePO.labelCompany,"label company");
            generalAction.verifyElementDisplayed(editProfilePO.inputComany,"input field company");
            generalAction.verifyElementDisplayed(editProfilePO.labelState,"label state");
            generalAction.verifyElementDisplayed(editProfilePO.inputState,"input state");
            generalAction.verifyElementDisplayed(editProfilePO.labelTitle,"label title");
            generalAction.verifyElementDisplayed(editProfilePO.inputTitle,"input title");
            generalAction.verifyElementDisplayed(editProfilePO.labelPhone,"label phone");
            generalAction.verifyElementDisplayed(editProfilePO.inputPhone,"input field phone");
            generalAction.verifyElementDisplayed(editProfilePO.btnSave,"button Save");
            generalAction.verifyElementDisplayed(editProfilePO.btnCancelEditProfile,"button Cancel");

    }

    @Override
    public void checkAllErrorMsg(IGeneralAction generalAction, WebDriver webDriver, EditProfilePO editProfilePO) {

    }
}
