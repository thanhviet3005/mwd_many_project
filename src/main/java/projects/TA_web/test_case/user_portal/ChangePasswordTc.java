package projects.TA_web.test_case.user_portal;

import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;

import common.*;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;
import projects.TA_web.action.IChangePasswordAction;
import projects.TA_web.action.ILoginAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.action.implement_action.ChangePasswordAction;
import projects.TA_web.action.implement_action.LoginAction;
import projects.TA_web.action.implement_action.NavigateAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.page_object.user_portal.ChangePasswordPO;
import projects.TA_web.page_object.user_portal.LoginOn23ServerPO;
import projects.TA_web.page_object.user_portal.UserPortalPO;

public class ChangePasswordTc {

    /**
     * Test case 01: Verify the UI items on the page 'Change password'
     *
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode
     *  + Press the key 'Enter' on the keyboard
     * 2. Login with an inactive account
     *  + Enter user account to the field 'Email'
     *  + Enter password to the field 'Password'
     *  + Select the button 'Login'
     * 3. Go to the page 'Change password'
     *  + Select the account menu
     *  + Select the tab 'Change password'
     * 4. Verify UI items on the form 'Change password'
     *  + The form title and all label fields: Password, New password, Confirm password
     *  + All buttons: Submit, Cancel
     */
    @Test(priority = 1,
            testName = "Test case 01: Verify the UI items on the page 'Change password'",
            description = "Verify all UI item's text show on the page")
    public void TC01_Verify_the_UI_items_on_the_page_Change_password(){
        INavigateAction navigateA = new NavigateAction();
        LoginOn23ServerPO loginPO = new LoginOn23ServerPO(Constant.webDriver);
        ILoginAction loginA = new LoginAction();
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        IGeneralAction generalA = new GeneralAction();
        ChangePasswordPO changePwPO = new ChangePasswordPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        try {
            System.out.println("Test case 01: Verify the UI items on the page 'Change password'");

            LogReport.logMainStep("1. Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            navigateA.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with an inactive account");
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " );
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            loginA.loginSSO(loginPO, dataTestTAWeb.inactivated_SSO_account_for_server_23);

            LogReport.logMainStep("3. Go to the page 'Change password'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("4. Verify UI items on the form 'Change password'");
            LogReport.logSubStep("The form title and all label fields: Password, New password, Confirm password");
            changePwA.verifyTextLabelsDisplay(generalA, changePwPO, dataTestTAWeb);
            LogReport.logSubStep("All buttons: Submit, Cancel");
            changePwA.verifyButtonName(generalA, changePwPO, dataTestTAWeb);
            LogReport.logSubStep("Verify the placeholder text ");
            changePwA.verifyPlaceHolderTextDisplay(generalA, changePwPO, dataTestTAWeb);
            LogReport.logSubStep("Verify all error message and icon 'Warning' are hidden");
            changePwA.verifyAllErrorMessageHidden(generalA, Constant.webDriver, changePwPO);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }


    /**
     * Test case 02 : Verify error messages show on proper when entering invalid values to the field 'Password'
     *
     * 1. Login with an inactivated account
     *  + Navigate to URL http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode
     *  + Enter the email to the field 'Email'
     *  + Enter the password to the field 'Password'
     *  + Select the button 'Login'
     * 2. Select the tab 'Change password ' on the menu 'account name'
     *  + Hover the tab 'account name' on the header bar
     *  + Select the tab 'Change password'
     * 3. Enter values to all fields on the page 'Change Password', then verify error messages and icon 'Warning' display proper
     *  + Enter value to the field 'New Password'
     *  + Enter value to the field 'Confirm Password'
     *  + Click any points on the screen, except the button 'Submit'
     *  + Verify error messages and icon 'Warning'
     * 4. Repeat step 3 with these values:
     *  + new empty password for 'Password' and 'confirm password'
     *      Expected:  Error messages and icons 'Warning' of both 2 fields show on
     *  + only number for 'Password' and 'confirm password'
     *      Expected:
     *          - Only the error message and icon 'Warning' of the field 'New password' shows on
     *          - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + only letter values for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + short strings for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + only special letters for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + having white space letters between other letters for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + valid value for 'Password' and 'confirm password', eg: #F123%Test$/[~<;`/*-+,./;'[]\-=_+{}|:<>?`~
     *      Expected:
     *      - The error messages and icons 'Warning' of both 2 fields hide
     *  + new password, confirm password are same as the current password
     *      Expected:
     *      - The error messages and icons 'Warning' of both 2 fields hide
     *  + the text to 'Password' field is over 128 letters
     *      Expected:
     *      - The error messages and icons 'Warning' of both 2 fields hide
     *  + Values of fields 'Password' and 'Confirm password' difference
     *      Expected:
     *          - the error message and icon 'Warning' of the field 'New password' hide
     *          - the error message and icon 'Warning' of the field 'Confirm password' show on
     *
     */
    @Test(priority = 2, enabled = false,
            testName = "Test case 02 : Verify error messages show on proper when entering invalid values to the field 'Password'",
            description = "Description: Verify the error messages appear when changing password with invalid values",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckChangePw")
    public void TC1000_Verify_error_messages_show_on_proper_when_entering_invalid_values_to_the_field_Password
    (UserAccount userAccount, String newPw, String confirmPw, String errorMsgExpected) {
        System.out.println("Test case 01 : Verify error messages show on proper when entering invalid values to the field 'Password'");
        System.out.println("email: " + userAccount.getEmail() + "\n"
                + "old password: " + userAccount.getPassword() + "\n"
                + "new password: " + newPw + "\n"
                + "confirm password: " + confirmPw + "\n"
                + "error message new password: " + errorMsgExpected);
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginOn23ServerPO loginPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();

        try {
            LogReport.logMainStep("1. Login with a valid account");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Enter the email of the activated/ inactivated account, eg: ");
            LogReport.logSubStep("Enter the password, eg: ");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Select the tab 'Change password ' on the menu 'account name'");
            LogReport.logSubStep("Hover the tab 'account name' on the nav bar");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("3. Enter values to all fields on the page 'Change Password', then verify error messages and icon 'Warning' display proper when entering values to change password");
            LogReport.logSubStep("Enter values to the field 'Password*', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter values to the field 'New Password*', eg: " + newPw);
            LogReport.logSubStep("Enter values to the field 'Confirm Password* ', eg: " + confirmPw);
            changePwA.verifyErrorMessageDisplayProper(userAccount, newPw, confirmPw, errorMsgExpected);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 02 : Verify error messages display when submitting without entering values
     *
     * 1. Login with a valid account
     *  + Open the web browser
     *  + Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode
     *  + Enter the email to the field 'Email'
     *  + Enter the password to the field 'Password'
     *  + Select the button 'Login'
     * 2. Go to the page 'Change password'
     *  + Select the tab 'Change password ' on the menu 'account name'
     *  + Hover the tab 'account name' on the header bar
     *  + Select the tab 'Change password'
     * 3. Enter nothing to all fields on the page 'Change Password'
     *  + Enter nothing to all fields
     *  + Select the button 'Submit'
     * 4. Verify error messages and icons 'Warning' display on 3 fields 'Password', 'New password', 'Confirm password'
     */
    @Test(priority = 2,
            testName = "Test case 02 : Verify error messages display when submitting without entering values",
            description = "Description: Verify the error messages and icon 'Warning' appear when update password without values",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckChangePwPageForAllEmptyField")
    public void TC02_Verify_error_messages_display_when_without_entering_values(UserAccount userAccount) {
        System.out.println("Test case 01 : Verify error messages show on proper when entering invalid values to the field 'Password'");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginOn23ServerPO loginPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        IGeneralAction generalA = new GeneralAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);

        try {
            LogReport.logMainStep("1. Login with a valid account");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Navigate to URL: " + URL.loginPageOnServer23Url);
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " );
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Go to the page 'Change password'");
            LogReport.logSubStep("Select the tab 'Change password ' on the menu 'account name'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("3. Enter nothing to all fields on the page 'Change Password'");
            LogReport.logSubStep("Enter nothing to all fields");
            LogReport.logSubStep("Select the button 'Submit'");
            changePasswordPO.btnSubmit.click();

            LogReport.logMainStep("4. Verify error messages and icons 'Warning' display on 3 fields 'Password', 'New password', 'Confirm password'");
            changePwA.verifyAllErrorMessageDisplay(generalA, changePasswordPO, dataTestTAWeb);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 03 : Verify error messages for the field 'New password' display without submitting
     *
     * 1. Login with a valid account
     *  + Open the web browser
     *  + Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode
     *  + Enter the email to the field 'Email'
     *  + Enter the password to the field 'Password'
     *  + Select the button 'Login'
     * 2. Go to the page 'Change password'
     *  + Select the tab 'Change password ' on the menu 'account name'
     *  + Hover the tab 'account name' on the header bar
     *  + Select the tab 'Change password'
     * 3. Enter invalid values to the field 'New password'
     *  + Enter current password to the field 'Password'
     *  + Enter invalid values to the field 'New password'
     *  + Enter value to the field 'Confirm password' same to the field 'New password'
     *  + Click to any points on the page, eg: title page
     * 4. Verify the error message display proper for the field 'New password'
     * 5. Repeat the step 3, 4 with these values:
     *  + only number for 'Password' and 'confirm password'
     *      Expected:
     *          - Only the error message and icon 'Warning' of the field 'New password' shows on
     *          - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + only letter values for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + short strings for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + only special letters for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     *  + having white space letters between other letters for 'Password' and 'confirm password'
     *      Expected:
     *      - Only the error message and icon 'Warning' of the field 'New password' shows on
     *      - the error message and icon 'Warning' of the field 'Confirm password' hide
     */
    @Test(priority = 3,
            testName = "Test case 03 : Verify error messages for the field 'New password' display without submitting",
            description = "Description: Verify the error messages and icon 'Warning' for field 'New password' display " +
                    "and in contrast with the field 'Confirm Password', and values to both fields 'New password' and 'Confirm password' are same",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckFieldPassword")
    public void TC03_Verify_error_messages_for_the_field_New_password_display_without_submitting
    (UserAccount userAccount, String newPw, String errorMsgExpected) {
        System.out.println("Test case 03 : Verify error messages for the field 'New password' display without submitting");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginOn23ServerPO loginPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);

        try {
            LogReport.logMainStep("1. Login with a valid account");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Navigate to URL: " + URL.loginPageOnServer23Url);
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " );
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Go to the page 'Change password'");
            LogReport.logSubStep("Select the tab 'Change password ' on the menu 'account name'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("3. Enter invalid values to the field 'New password'");
            LogReport.logSubStep("Enter current password to the field 'Password', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter invalid values to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Enter value to the field 'Confirm password' same to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Click to any points on the page, eg: title page");
            changePwA.enterValueToCheckErrorMessage(changePasswordPO, userAccount, newPw, newPw);

            LogReport.logMainStep("4. Verify the error message display proper for the field 'New password'");
            changePwA.verifyErrorMessageForPasswordDisplay(changePasswordPO, userAccount.getPassword(), newPw
                    , errorMsgExpected);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }


    /**
     * Test case 04 : Verify error messages appear after submitting with valid values
     *
     * 1. Login with a valid account
     *  + Open the web browser
     *  + Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode
     *  + Enter the email to the field 'Email'
     *  + Enter the password to the field 'Password'
     *  + Select the button 'Login'
     * 2. Go to the page 'Change password'
     *  + Select the tab 'Change password ' on the menu 'account name'
     *  + Hover the tab 'account name' on the header bar
     *  + Select the tab 'Change password'
     * 3. Enter valid values to all fields, then verify the error message display properly
     *  + Enter valid values to the field 'Password'
     *  + Enter valid values to the field 'New password'
     *  + Enter valid value to the field 'Confirm password' same to the field 'New password'
     *  + Click the button 'Submit'
     * 4. Repeat the step 3 with these values:
     *  + Enter the current password to all fields
     *      - Expected:
     *      The error message appear inform the current and new password are same
     *      All error message for all field still hide
     *  + Enter the current password to the field 'New password','Confirm new password' and enter an other password to the field 'Password'
     *      - Expected:
     *      The error message appear inform the current password are wrong
     *      All error message for all field still hide
     */
    @Test(priority = 4,
            testName = "Test case 04 : Verify error messages appear after submitting with valid values",
            description = "Description: The corresponding error message appear when submitting with 3 fields are same or current password is wrong",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckErrorMsgWhenSubmittingValidValue")
    public void TC04_Verify_error_messages_appear_after_submitting_with_valid_values
    (UserAccount userAccount, String newPw, String errorMsgExpected) {
        System.out.println("Test case 04 : Verify error messages appear after submitting with valid values");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginOn23ServerPO loginPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);

        try {
            LogReport.logMainStep("1. Login with a valid account");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Navigate to URL: " + URL.loginPageOnServer23Url);
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " );
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Go to the page 'Change password'");
            LogReport.logSubStep("Select the tab 'Change password ' on the menu 'account name'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("3. Enter invalid values to the field 'New password', then verify error messages display properly");
            LogReport.logSubStep("Enter password to the field 'Password', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter invalid values to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Enter value to the field 'Confirm password' same to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Select the button 'Submit'");
            LogReport.logSubStep("Verify the error message for particular fields are hidden, and the error message display inform to user");
            changePwA.verifyErrorMessageAfterSubmitValidValues(changePasswordPO, userAccount, newPw, errorMsgExpected);
            // after the dev implement the element 'error' message, I will updating  to the method changePwA.changePassword(changePasswordPO, userAccount, newPw, newPw)

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 05 : Verify error messages do not display when entering valid values to all fields
     *
     * 1. Login with a valid account
     *  + Open the web browser
     *  + Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode
     *  + Enter the email to the field 'Email'
     *  + Enter the password to the field 'Password'
     *  + Select the button 'Login'
     * 2. Go to the page 'Change password'
     *  + Select the tab 'Change password ' on the menu 'account name'
     *  + Hover the tab 'account name' on the header bar
     *  + Select the tab 'Change password'
     * 3. Enter valid values to the field 'New password'
     *  + Enter current password to the field 'Password'
     *  + Enter valid values to the field 'New password'
     *  + Enter valid to the field 'Confirm password' same to the field 'New password'
     *  + Click to any points on the page, eg: title page
     * 4. Verify the error message display proper for the field 'New password'
     * 5. Repeat the step 3, 4 with these values:
     *  + Enter valid values to to all fields,
     *      - Expected: No error messages and icons 'Warning' appear
     */
    @Test(priority = 5,
            testName = "Test case 05 : Verify error messages do not display when entering valid values to all fields",
            description = "Description: No error message and icon 'Warning' display when entering valid values to all fields",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckErrorMsgNoDisplayWhenEnteringValidValues")
    public void TC05_Verify_error_messages_do_not_display_when_entering_valid_values_to_all_fields
    (UserAccount userAccount, String newPw) {
        System.out.println("Test case 05 : Verify error messages appear after submitting with valid values");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginOn23ServerPO loginPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();

        try {
            LogReport.logMainStep("1. Login with a valid account");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Navigate to URL: " + URL.loginPageOnServer23Url);
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " );
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Go to the page 'Change password'");
            LogReport.logSubStep("Select the tab 'Change password ' on the menu 'account name'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("3. Enter invalid values to all fields");
            LogReport.logSubStep("Enter current password to the field 'Password', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter invalid values to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Enter value to the field 'Confirm password' same to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Click to any points on the page, eg: title page");
            changePwA.enterValueToCheckErrorMessage(changePasswordPO, userAccount, newPw, newPw);

            LogReport.logMainStep("4. Verify error messages and icons 'Warning' do not display");
            changePwA.verifyAllErrorMessageHidden(generalA, Constant.webDriver, changePasswordPO);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 06 : Verify error message for the field 'Confirm new password' display when values for both fields 'New password', 'Confirm new password' difference
     *
     * 1. Login with a valid account
     *  + Open the web browser
     *  + Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode
     *  + Enter the email to the field 'Email'
     *  + Enter the password to the field 'Password'
     *  + Select the button 'Login'
     * 2. Go to the page 'Change password'
     *  + Select the tab 'Change password ' on the menu 'account name'
     *  + Hover the tab 'account name' on the header bar
     *  + Select the tab 'Change password'
     * 3. Enter valid values to all field
     *  + Enter current password to the field 'Password'
     *  + Enter valid values to the field 'New password'
     *  + Enter other valid value to the field 'Confirm password'
     *  + Click to any points on the page, eg: title page
     * 4. Verify the error message display for the field 'Confirm new password'
     * 5. Repeat the step 3, 4 with these values:
     *  + Enter valid values to to all fields,
     *      - Expected: No error messages and icons 'Warning' appear
     */
    @Test(priority = 6,
            testName = "Test case 05 : Verify error messages do not display when entering valid values to all fields",
            description = "Description: No error message and icon 'Warning' display when entering valid values to all fields",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckErrorMsgNoDisplayWhenEnteringValidValues")
    public void TC06_Verify_error_messages_do_not_display_when_entering_valid_values_to_all_fields
    (UserAccount userAccount, String newPw, String confirmPw, String errorMsgExpected) {
        System.out.println("Test case 05 : Verify error messages do not display when entering valid values to all fields");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginOn23ServerPO loginPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();

        try {
            LogReport.logMainStep("1. Login with a valid account");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Navigate to URL: " + URL.loginPageOnServer23Url);
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " );
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Go to the page 'Change password'");
            LogReport.logSubStep("Select the tab 'Change password ' on the menu 'account name'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("3. Enter invalid values to all fields");
            LogReport.logSubStep("Enter current password to the field 'Password', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter invalid values to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Enter value to the field 'Confirm password' same to the field 'New password', eg: " + confirmPw);
            LogReport.logSubStep("Click to any points on the page, eg: title page");
            changePwA.enterValueToCheckErrorMessage(changePasswordPO, userAccount, newPw, confirmPw);

            LogReport.logMainStep("4. Verify error messages and icons 'Warning' display for field 'Confirm new password'");
            changePwA.verifyErrorMessageWhenNewPwAndConfirmPwDifferences(generalA, changePasswordPO, errorMsgExpected);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 07 : Verify successful message display when change password successful
     *
     * 1. Login with a valid account
     *  + Open the web browser
     *  + Navigate to URL: http://sso.logigear.com:8080/?host_url=http%3A%2F%2Fsso.logigear.com%3A8080%2Fbackend%2Fssoframework%2Fauthorize%3Fclient_id%3Dtaportal%26scope%3Dtest%26state%3Dtaportal1647238866861%26redirect_uri%3Dhttp%3A%2F%2Ffrontend.taportal.com%3A8080%2Flogin%26response_type%3Dcode
     *  + Enter the email to the field 'Email'
     *  + Enter the password to the field 'Password'
     *  + Select the button 'Login'
     * 2. Go to the page 'Change password'
     *  + Select the tab 'Change password ' on the menu 'account name'
     *  + Hover the tab 'account name' on the header bar
     *  + Select the tab 'Change password'
     * 3. Enter valid values to all fields
     *  + Enter current password to the field 'Password'
     *  + Enter valid values to the field 'New password', 'Confirm new password' that is alike
     * 4. Verify the success message display after updating password successfully
     */
    @Test(priority = 7,
            testName = "Test case 07 : Verify successful message display when change password successful",
            description = "Description: The successful message display after changing password successful with valid values",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckChangePwPageForAllEmptyField")
    public void TC07_Verify_successful_message_display_when_change_password_successful
    (UserAccount userAccount, String newPw, String successMsg) {
        System.out.println("Test case 07 : Verify successful message display when change password successful");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginOn23ServerPO loginPO = new LoginOn23ServerPO(Constant.webDriver);
        UserPortalPO userPortalPO = new UserPortalPO(Constant.webDriver);
        IChangePasswordAction changePwA = new ChangePasswordAction();
        ChangePasswordPO changePasswordPO = new ChangePasswordPO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();

        try {
            LogReport.logMainStep("1. Login with a valid account");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Navigate to URL: " + URL.loginPageOnServer23Url);
            LogReport.logSubStep("Enter user account to the field 'Email', eg: " );
            LogReport.logSubStep("Enter password to the field 'Password'");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(Constant.webDriver);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Go to the page 'Change password'");
            LogReport.logSubStep("Select the tab 'Change password ' on the menu 'account name'");
            LogReport.logSubStep("Select the account menu");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.goToChangePasswordPage(Constant.webDriver, userPortalPO);

            LogReport.logMainStep("3. Enter invalid values to all fields");
            LogReport.logSubStep("Enter current password to the field 'Password', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter valid value to the field 'New password', eg: " + newPw);
            LogReport.logSubStep("Enter the same value to the field 'Confirm password', eg: " + newPw);
            LogReport.logSubStep("Select the button 'Submit'");
            changePwA.changePassword(changePasswordPO, userAccount, newPw, newPw);

            LogReport.logMainStep("4. Verify the success message displaying");
            // after dev implement the element 'Success' message, keep implementing the script to verify this message


        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }




}
