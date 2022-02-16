package SSO_project.test_case;

import SSO_project.action.IChangePwAction;
import SSO_project.action.ILoginAction;
import SSO_project.action.ILogoutAction;
import SSO_project.action.INavigateAction;
import SSO_project.action.implement_action.ChangePasswordAction;
import SSO_project.action.implement_action.LoginAction;
import SSO_project.action.implement_action.LogoutAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.ChangePwPO;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import base_test.BaseTest;
import common.*;
import general_action.IGeneralAction;
import general_action.implement.GeneralImpA;
import org.testng.annotations.Test;

public class ChangePwTc extends BaseTest {

    /**
     * Test case 01 : Verify error messages show on proper when entering invalid values to the field 'Password'
     * <p>
     * 1. Login with a valid account
     *  + Navigate to https://stage1.testarchitect.com/
     *  + Select the button 'Login'
     *  + Enter the email of the inactivated account
     *  + Enter the password of the inactivated account
     *  + Select the button 'Login'
     * 2. Select the tab 'Change password ' on the menu 'account name'
     *  + Hover the tab 'account name' on the nav bar
     *  + Select the tab 'Change password'
     * 3. Enter values to all fields on the page 'Change Password'
     *  + Enter value to the field 'Password'
     *  + Enter value to the field 'New Password'
     *  + Enter value to the field 'Confirm Password'
     *  + Click any points on the screen, except the button 'Submit'
     * 4. Verify error messages and icon 'Warning' display proper when entering values to change password
     * 5. Repeat step 3,4 with these values:
     *  + new empty password
     *  + only number for new password
     *  + only letter value for new password
     *  + short string for new password
     *  + only special string value for new password
     *  + having space character in value to the 'New password' field
     *  + valid value for new password, eg: #F123%Test$/[~<;`/*-+,./;'[]\-=_+{}|:<>?`~
     *  + new password, confirm password are same as the current password
     *  + the text to 'Password' field is over 128 letters
     *
     */
    @Test(priority = 1,
            testName = "Test case 01 : Verify error messages show on proper when entering invalid values to the field 'Password'",
            description = "Description: Verify the error messages appear when changing password with invalid values",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckChangePw")
    public void TC01_Verify_error_messages_show_on_proper_when_entering_invalid_values_to_the_field_Password
    (UserAccount userAccount, String newPw, String confirmPw, String errorMsgExpected) {
        System.out.println("Test case 01 : Verify error messages show on proper when entering invalid values to the field 'Password'");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        ChangePwPO changePwPO = new ChangePwPO(Constant.webDriver);
        IChangePwAction changePwA = new ChangePasswordAction();
        IGeneralAction generalA = new GeneralImpA();
        DataTestSSO dataTestSSO = new DataTestSSO();

        try {
            LogReport.logMainStep("1. Login with an inactivated account");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Enter the email of the activated/ inactivated account, eg: ");
            LogReport.logSubStep("Enter the password, eg: ");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Select the tab 'Change password ' on the menu 'account name'");
            LogReport.logSubStep("Hover the tab 'account name' on the nav bar");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.gotoChangePwPageAfterLogin(Constant.webDriver, testArchitectPO);

            LogReport.logMainStep("3. Enter values to all fields on the page 'Change Password'");
            LogReport.logSubStep("Enter values to the field 'Password*', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter values to the field 'New Password*', eg: " + newPw);
            LogReport.logSubStep("Enter values to the field 'Confirm Password* ', eg: " + confirmPw);
            if(errorMsgExpected.equals(dataTestSSO.error_msg_current_pw_wrong)){
                userAccount.setPassword(dataTestSSO.pw_activated_strong);
            }
            changePwA.checkErrorMsgOfChangePwPage(changePwPO, userAccount, newPw, confirmPw);

            LogReport.logMainStep("4. Verify error messages and icon 'Warning' display proper when entering values to change password");
            /*
            case 1: 'Password' and 'Confirm password' are empty.
            case 2: Error message expected is empty, that means input values are valid
            case 3: 'New password', 'Confirm password' and current password are at the same
            case 4: 'New password' and 'Confirm password' difference
            case 5: Other cases
             */
            if (newPw.equals("") && confirmPw.equals("")){
                generalA.verifyTextDisplay(errorMsgExpected, changePwPO.labelErrorNewPw, false);
                generalA.verifyElementDisplayed(changePwPO.svgIconWarningNewPw,
                        "The icon 'Warning' of the field 'New password'");
                generalA.verifyTextDisplay(errorMsgExpected, changePwPO.labelConfirmPw, false);
                generalA.verifyElementDisplayed(changePwPO.svgIconWarningConfirmPw,
                        "The icon 'Warning' of the field 'Confirm password'");
            }else if(errorMsgExpected.equals("")){
                generalA.verifyElementHidden(changePwPO.labelErrorNewPwBy, Constant.webDriver
                        , "The error message for the field 'New password'");
                generalA.verifyElementHidden(changePwPO.svgIconWarningNewPwBy, Constant.webDriver,
                        "The icon 'Warning' for the field 'New password'");
            }else if(newPw.equals(confirmPw) && newPw.equals(userAccount.getPassword())
                    || errorMsgExpected.equals(dataTestSSO.error_msg_current_pw_wrong)){
                generalA.verifyTextDisplay(errorMsgExpected, changePwPO.divErrorMsgCurrentPw, false);
            }else if(!newPw.equals(confirmPw)){
                generalA.verifyTextDisplay(errorMsgExpected, changePwPO.labelErrorConfirmPw, false);
                generalA.verifyElementDisplayed(changePwPO.svgIconWarningConfirmPw
                        , "The icon 'Warning' of the field 'Confirm password'");
            }else {
                generalA.verifyTextDisplay(errorMsgExpected, changePwPO.labelErrorNewPw, false);
                generalA.verifyElementDisplayed(changePwPO.svgIconWarningNewPw, "The icon 'Warning' of the field 'New password'");
            }
        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /**
     * Test case 02 : Verify updating password successfully by valid values
     *
     * 1. Login with an inactivated account
     *  + Navigate to https://stage1.testarchitect.com/
     *  + Select the button 'Login'
     *  + Enter the email of the inactivated account
     *  + Enter the password of the inactivated account
     *  + Select the button 'Login'
     * 2. Select the tab 'Change password ' on the menu 'account name'
     *  + Hover the tab 'account name' on the nav bar
     *  + Select the tab 'Change password'
     * 3. Enter valid values to all fields, then submitting
     *  + Enter current password to the field 'Password'
     *  + Enter current password to the field 'New Password'
     *  + Enter current password to the field 'Confirm Password'
     *  + Select the button 'Submit'
     * 4. Verify the successful message display clearly
     *  + The successful message display clearly
     *  + The browser back to the page 'Home', the tab 'account name' still displays
     * 5. Log out of the current account
     *  + Select the tab 'Account name'
     *  + Select the option 'Log out'
     * 6. Login with current account again
     *  + Select the button 'Login' on the page 'Home'
     *  + Enter the email of the inactivated account
     *  + Enter the new password of the inactivated account
     *  + Select the button 'Login'
     * 7. Verify login successful with new password
     *  + Verify the tab 'Account name' display
     */
    @Test(priority = 2,
            testName = "Test case 02 : Verify updating password successfully by valid values",
            description = "Description: Verify the update password successfully and login with new passsword again successfully",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToUpdatePwSuccessful")
    public void TC02_Verify_updating_password_successfully_by_valid_values
    (UserAccount userAccount, String newPw, String confirmPw, String previousPw) {
        System.out.println("Test case 02 : Verify updating password successfully by valid values");
        INavigateAction navigateA = new NavigateAction();
        ILoginAction loginA = new LoginAction();
        ILogoutAction logoutA = new LogoutAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        ChangePwPO changePwPO = new ChangePwPO(Constant.webDriver);
        IChangePwAction changePwA = new ChangePasswordAction();
        IGeneralAction generalA = new GeneralImpA();
        try {
            LogReport.logMainStep("1. Login with a valid account");
            LogReport.logSubStep("Launch the web browser");
            LogReport.logSubStep("Navigate to https://stage1.testarchitect.com/");
            LogReport.logSubStep("Select the button 'Login' on the navigation bar");
            LogReport.logSubStep("Enter the email of the activated/ inactivated account, eg: ");
            LogReport.logSubStep("Enter the password, eg: ");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("2. Select the tab 'Change password ' on the menu 'account name'");
            LogReport.logSubStep("Hover the tab 'account name' on the nav bar");
            LogReport.logSubStep("Select the tab 'Change password'");
            navigateA.gotoChangePwPageAfterLogin(Constant.webDriver, testArchitectPO);

            LogReport.logMainStep("3. Enter values to all fields on the page 'Change Password'");
            LogReport.logSubStep("Enter values to the field 'Password*', eg: " + userAccount.getPassword());
            LogReport.logSubStep("Enter values to the field 'New Password*', eg: " + newPw);
            LogReport.logSubStep("Enter values to the field 'Confirm Password* ', eg: " + confirmPw);
            changePwA.changePw(changePwPO, userAccount, newPw, confirmPw);

            LogReport.logMainStep("4. Verify the successful message display clearly");
            LogReport.logSubStep("The successful message display clearly");
            LogReport.logSubStep("The browser back to the page 'Home', the tab 'account name' still displays");
            generalA.verifyElementDisplayed(changePwPO.h1SuccessText, "The successful message");
            generalA.verifyElementDisplayed(testArchitectPO.accountName, "The tab 'account name' still");

            LogReport.logMainStep("5. Log out of the current account");
            LogReport.logSubStep("Select the tab 'Account name'");
            LogReport.logSubStep("Select the option 'Log out'");
            logoutA.logoutCurrentAccount(testArchitectPO);

            LogReport.logMainStep("6. Login with current account again");
            LogReport.logSubStep("Select the button 'Login' on the page 'Home'");
            LogReport.logSubStep("Enter the email of the inactivated account, eg: " + userAccount.getEmail());
            LogReport.logSubStep("Enter the new password of the inactivated account: " + userAccount.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            userAccount.setPassword(newPw);
            loginA.loginSSO(loginPO, userAccount);

            LogReport.logMainStep("7. Verify login successful with new password");
            generalA.verifyElementDisplayed(testArchitectPO.accountName, "The account name");

            // change password to previous password, no log to report
            testArchitectPO.accountName.click();
            testArchitectPO.optChangePw.click();
            changePwA.changePw(changePwPO, userAccount, previousPw, previousPw);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }
}
