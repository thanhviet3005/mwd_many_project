package projects.TA_web.test_case.admin_portal;

import SSO_project.action.ILoginAction;
import SSO_project.action.INavigateAction;
import SSO_project.action.implement_action.LoginAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import base_test.BaseTest;
import common.*;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;
import projects.TA_web.action.IDeleteCouponTypeAction;
import projects.TA_web.action.implement_action.DeleteCouponTypeAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;

public class DeleteCouponTypeTc extends BaseTest {

    /** Test case 01: Verify UI items on the 'Delete' dialog
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Enter the email, eg:
     *  + Enter the password, eg:
     *  + Select the button 'Login'
     * 3. Go to the page 'Manage coupon type'
     *  +
     *  +
     * 4. Open the 'Delete' dialog
     *  + Select the 'Trash' symbol at random
     * 5. Verify UI items on the dialog, including:
     *  + The dialog title
     *  + All button: 'Delete', 'Cancel'
     */
    @Test(priority = 1,
            testName = "Test case 1: Verify UI items on the 'Delete' dialog",
            description = "Description: Verify all UI item show on the dialog 'Delete'")
    public void TC01_UI_items_on_the_Delete_dialog(){
        ManageCouponTypePO couponTypePO = new ManageCouponTypePO(Constant.webDriver);
        IDeleteCouponTypeAction deleteCouponTypeA = new DeleteCouponTypeAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.activated_SSO_account;
        INavigateAction navigateA = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);

        try {
            System.out.println("Test case 1: Verify UI items on the 'Delete' dialog");
            LogReport.logMainStep("1. Go to the page Login:");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser:");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg:");
            LogReport.logSubStep("Enter the password, eg:");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Manage coupon type'");
            LogReport.logSubStep("");
            LogReport.logSubStep("");
            LogReport.logSubStep("");

            LogReport.logMainStep("4. Open the 'Delete' dialog");
            LogReport.logSubStep("Select the 'Trash' symbol at random, eg at row 10");
            couponTypePO.svgIconDeleteRow1.click();

            LogReport.logMainStep("5. Verify UI items on the dialog");
            deleteCouponTypeA.verifyUIItemsDeleteDialog(couponTypePO);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 02: Verify the dialog disappear after selecting the button 'Cancel'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email, eg:
     *  + Enter the password, eg:
     *  + Select the button 'Login'
     * 3. Go to the page 'Manage coupon type'
     *  +
     *  +
     * 4. Open the 'Delete' dialog
     *  + Select the 'Trash' symbol at random
     * 5. Verify the dialog disappear after selecting the button 'Cancel'
     *  + Select the button 'Cancel'
     *  + Verify the dialog disappear
     */
    @Test(priority = 2,
            testName = "Test case 02: Verify the dialog disappear after selecting the button 'Cancel'",
            description = "Description: Verify all UI item show on the dialog 'Delete'")
    public void TC02_Verify_the_dialog_disappear_after_selecting_the_button_Cancel(){
        ManageCouponTypePO couponTypePO = new ManageCouponTypePO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        INavigateAction navigateA = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.activated_SSO_account;

        try {
            System.out.println("Test case 1: Verify UI items on the 'Delete' dialog");

            LogReport.logMainStep("1. Go to the page Login:");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser:");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg:");
            LogReport.logSubStep("Enter the password, eg:");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Manage coupon type'");
            LogReport.logSubStep("");
            LogReport.logSubStep("");
            LogReport.logSubStep("");

            LogReport.logMainStep("4. Open the 'Delete' dialog");
            LogReport.logSubStep("Select the 'Trash' symbol at random, eg at row 10");
            couponTypePO.svgIconDeleteRow1.click();

            LogReport.logMainStep("5. Verify the dialog disappear after selecting the button 'Cancel'");
            LogReport.logSubStep("Select the button 'Cancel'");
            couponTypePO.btnCancel.click();
            LogReport.logSubStep("Verify the dialog disappear");
            generalA.verifyElementHidden(couponTypePO.h2DialogTitleBy, Constant.webDriver, "The dialog 'Delete coupon type'");

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 03: Verify the success message appears after selecting the button 'Delete'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email, eg:
     *  + Enter the password, eg:
     *  + Select the button 'Login'
     * 3. Go to the page 'Manage coupon type'
     *  +
     *  +
     * 4. Open the 'Delete' dialog
     *  + Select the 'Trash' symbol at random
     * 5. Verify the dialog disappear after selecting the button 'Cancel'
     *  + Select the button 'Delete'
     *  + Verify the success message appear
     *  + Verify the 'Delete' Dialog also disappear
     */
    @Test(priority = 3,
            testName = "Test case 03: Verify the success message appears after selecting the button 'Delete'",
            description = "Description: Verify the success message appears after selecting the button 'Delete'")
    public void TC03_Verify_the_success_message_appears_after_selecting_the_button_Delete(){
        ILoginAction loginAction = new LoginAction();
        INavigateAction navigateA = new NavigateAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.activated_SSO_account;
        ManageCouponTypePO couponTypePO = new ManageCouponTypePO(Constant.webDriver);
        IGeneralAction generalA = new GeneralAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        try {
            System.out.println("Test case 1: Verify UI items on the 'Delete' dialog");

            LogReport.logMainStep("1. Go to the page Login:");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser:");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateA.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg:");
            LogReport.logSubStep("Enter the password, eg:");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Manage coupon type'");
            LogReport.logSubStep("");
            LogReport.logSubStep("");
            LogReport.logSubStep("");
            // implement here

            LogReport.logMainStep("4. Delete the coupon type");
            LogReport.logSubStep("Select the 'Trash' symbol at random");
            LogReport.logSubStep("Select the button 'Delete'");
            couponTypePO.svgIconDeleteRow1.click();
            couponTypePO.btnDelete.click();

            LogReport.logMainStep("5. Verify the user deleted coupon type successfully");
            LogReport.logSubStep("Verify the success message appear");
            generalA.verifyTextDisplay(dataTestTAWeb.success_msg_delete_coupon_type,
                    couponTypePO.divSuccessMessage, false);
            LogReport.logSubStep("Verify the 'Delete' Dialog also disappear");
            generalA.verifyElementHidden(couponTypePO.h2DialogTitleBy, Constant.webDriver, "The dialog 'Delete coupon type'");
            LogReport.logSubStep("Verify the coupon type no longer display on the data table");
            generalA.verifyElementHidden(couponTypePO.thNameRow1By, Constant.webDriver, "The coupon type at row 10");

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

}
