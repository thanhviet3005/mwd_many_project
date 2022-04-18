package projects.TA_web.test_case.admin_portal;

import SSO_project.action.ILoginAction;

import SSO_project.action.implement_action.LoginAction;

import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;
import projects.TA_web.action.IAddCouponTypeAction;
import projects.TA_web.action.IEditCouponTypeAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.action.implement_action.AddCouponTypeAction;
import projects.TA_web.action.implement_action.EditCouponTypeAction;
import projects.TA_web.action.implement_action.NavigateAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.AddCouponTypePO;
import projects.TA_web.page_object.admin_portal.EditCouponTypePO;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;

public class EditCouponTypeTC extends BaseTest {

    /** Test case 1: Verify all UI items display fully on the form 'Edit '
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
     * 3. Go to the page 'Edit coupon type'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon type'
     *  + Select the symbol 'Edit' at random from the data table
     * 4. Verify all UI items on form 'Edit' display fully, including:
     *  + All labels: 'Name', 'Limit', 'Status'
     *  + All input and select fields: 'Name', 'Limit', 'Status'
     *  + All button: 'Save', 'Cancel'
     */
    @Test(priority = 1,
            testName = "Test case 1: Verify all UI items display fully on the form 'Edit '",
            description = "Description: Verify all UI item show on the form 'Add'")
    public void TC01_Verify_all_UI_items_display_fully_on_the_form_Add(){
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.activated_SSO_account;
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IGeneralAction generalAction = new GeneralAction();
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        try {
            System.out.println("Test case 1: Verify all UI items display fully on the form 'Add '");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg:");
            LogReport.logSubStep("Enter the password, eg:");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Edit coupon type' at random");
            LogReport.logSubStep("Select the link 'Go To Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage coupon type'");
            LogReport.logSubStep("Select any symbol 'Edit' at random from the data table");
            navigateAction.goToEditCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Verify all UI items on form 'Edit' display fully");
            LogReport.logSubStep("<b>Verify all labels names and title: 'Name', 'Limit', 'Status', 'Add coupon type'</b>");
            addCouponTypeAction.verifyAllLabelsAndTitle(generalAction, addCouponTypePO);
            LogReport.logSubStep("<b>Verify all input fields and selection fields: 'Name', 'Limit', 'Status'</b>");
            addCouponTypeAction.verifyAllInputFields(generalAction, addCouponTypePO);
            LogReport.logSubStep("<b>Verify all names of buttons: 'Save', 'Cancel'</b>");
            addCouponTypeAction.verifyAllButton(generalAction, addCouponTypePO);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 2: Verify error message display proper for the field 'Name' on the form 'Edit coupon type'
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
     * 3. Go to the page 'Edit coupon type'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon type'
     *  + Select the symbol 'Edit' at random from the data table
     * 4. Enter invalid values to the field 'Name' then click any points on the screen
     *  + Clear the current value on the field 'Name'
     *  + Enter value to the field 'Name'
     *  + Click the title form
     * 5. Verify all error messages and icon 'Warning' for the field 'Name' appear fully
     * 6. Repeat the step 4,5 with these values:
     *  + Enter nothing
     *      -> Verify the error message and icon 'Warning' display for this field
     + Enter extensive texts
     *      -> Verify texts display on these fields are 200 first letters
     *  + Enter texts consist white space letters at the beginning and ending places, eg: "  TEst    "
     *      -> Verify texts displaying on these fields are trimmed
     *  + Enter Unicode text to these fields
     *      -> Verify texts displaying on these fields are unchanged
     *  + Enter texts consist special character to these field, eg: "Test #.,{}'" and press Enter
     *      -> Expected result: The error message: 'Please remove special characters.' displays
     * 7. Back to the page 'Manage coupon type'
     *  + Select the button 'Cancel'
     */
    @Test(priority = 2,
            testName = "Test case 1: Verify error message display proper for the field 'Name' on the form 'Edit coupon type'",
            description = "Description: Verify the error message and icon 'Warning' for the field 'Name' appear proper",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckFieldNameOfCouponType")
    public void TC02_Verify_all_UI_items_display_fully_on_the_form_Add
    (UserAccount user, String valueForName, String expectedText , String errorMsg){
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        EditCouponTypePO editCouponTypePO = new EditCouponTypePO(Constant.webDriver);
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IGeneralAction generalAction = new GeneralAction();

        try {
            System.out.println("Test case 2: Verify error message display proper for the field 'Name'");
            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg:");
            LogReport.logSubStep("Enter the password, eg:");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Edit coupon type' at random");
            LogReport.logSubStep("Select the link 'Go To Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage coupon type'");
            LogReport.logSubStep("Select any symbol 'Edit' at random from the data table");
            navigateAction.goToEditCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Enter invalid values to the field 'Name' then click any points on the screen");
            LogReport.logSubStep("Clear the current value on the field 'Name'");
            LogReport.logSubStep("Enter value to the field 'Name', eg: " + valueForName);
            LogReport.logSubStep("Click the label 'Limit'");
            generalAction.enterValueOneField(editCouponTypePO.inputName, valueForName, editCouponTypePO.labelLimit);

            LogReport.logMainStep("5. Verify all error messages and icon 'Warning' for the field 'Name' appear properly");
            addCouponTypeAction.verifyErrorMsgFieldName(addCouponTypePO, expectedText, errorMsg);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 3: Verify error message display proper for the field 'Limit' on the form 'Edit coupon type'
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
     * 3. Go to the page 'Edit coupon type'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon type'
     *  + Select the symbol 'Edit' at random from the data table
     * 4. Enter invalid values to the field 'Limit' then click any points on the screen
     *  + Clear the current value on the field 'Limit'
     *  + Enter value to the field 'Limit'
     *  + Click the title form
     * 5. Verify all error messages and icon 'Warning' for the field 'Limit' appear fully
     * 6. Repeat the step 4,5 with these values:
     *  + Enter nothing
     *      -> Verify the error message and icon 'Warning' display for this field
     +  + Enter extensive texts mix of letters and numbers
     *      -> Verify only numbers display
     *  + Enter the text contains special letters (no consist numbers)
     *      -> verify no letters display
     *  + Enter texts consist numbers and white space letters at the beginning and ending places
     *      -> Verify white space letters are trimmed
     *  + Enter Unicode text to these fields
     *      -> Verify no text displaying
     * 7. Back to the page 'Manage coupon type'
     *  + Select the button 'Cancel'
     */
    @Test(priority = 3,
            testName = "Test case 3: Verify error message display proper for the field 'Limit' on the form 'Edit coupon type'",
            description = "Description: Verify the error message and icon 'Warning' for the field 'Limit' appear properly",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckFieldLimitOfCouponType")
    public void TC03_Verify_error_message_display_proper_for_the_field_Limit_on_the_form_Edit_coupon_type
    (UserAccount user, String valueForLimit, String expectedText, String errorMsg){
        INavigateAction navigateAction = new NavigateAction();
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        EditCouponTypePO editCouponTypePO = new EditCouponTypePO(Constant.webDriver);
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IGeneralAction generalAction = new GeneralAction();
        try {
            System.out.println("Test case 3: Verify error message display proper for the field 'Limit' on the form 'Edit coupon type'");

            System.out.println("Test case 3: Verify error message display proper for the field 'Limit'");
            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Edit coupon type' at random");
            LogReport.logSubStep("Select the link 'Go To Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage coupon type'");
            LogReport.logSubStep("Select any symbol 'Edit' at random from the data table");
            navigateAction.goToEditCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Enter values to the field 'Limit' then click any points on the screen");
            LogReport.logSubStep("Clear the current value on the field 'Limit'");
            LogReport.logSubStep("Enter value to the field 'Limit', eg: " + valueForLimit);
            LogReport.logSubStep("Click the label 'Name'");
            generalAction.enterValueOneField(editCouponTypePO.inputLimit, valueForLimit, editCouponTypePO.labelName);

            LogReport.logMainStep("5. Verify all error messages and icon 'Warning' for the field 'Limit' appear properly");
            addCouponTypeAction.verifyErrorMsgFieldLimit(addCouponTypePO, expectedText, errorMsg);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 4: Verify error message display on the form 'Edit coupon type' when submitting the name being already in use
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
     * 3. Go to the page 'Edit coupon type'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon type'
     *  + Select the symbol 'Edit' at random from the data table
     * 4. Enter valid values to the field 'Name', this value is already in use
     *  + Clear the current value on each fields
     *  + Enter a value to the field 'Name' that is already in use for another coupon type
     *  + Enter value to the field 'Limit'
     *  + Select value on the field 'Status'
     *  + Select the button 'Save'
     * 5. Verify the error message display
     * 6. Back to the page 'Manage coupon type'
     *  + Select the button 'Cancel'
     */
    @Test(priority = 4,
            testName = "Test case 4: Verify error message display on the form 'Edit coupon type' when submitting the name being already in use",
            description = "Description: Verify the error message display when submitting the name being already in use")
    public void TC04_Verify_error_message_display_proper_for_the_field_Limit(){
        INavigateAction navigateAction = new NavigateAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.activated_SSO_account;
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IEditCouponTypeAction editCouponTypeAction = new EditCouponTypeAction();
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        CouponType couponType = dataTestTAWeb.coupon_type_already_in_use;
        IGeneralAction generalAction = new GeneralAction();
        ManageCouponTypePO manageCouponTypePO = new ManageCouponTypePO(Constant.webDriver);
        EditCouponTypePO editCouponTypePO = new EditCouponTypePO(Constant.webDriver);

        try {
            System.out.println("Test case 4: Verify error message display on the form 'Edit coupon type' when submitting the name being already in use");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Edit coupon type' at random");
            LogReport.logSubStep("Select the link 'Go To Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage coupon type'");
            LogReport.logSubStep("Select any symbol 'Edit' at random from the data table");
            navigateAction.goToEditCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Enter valid values all field");
            LogReport.logSubStep("Clear the current value on each fields");
            LogReport.logSubStep("Enter value already in use to the field 'Name', eg: " + couponType.getName());
            LogReport.logSubStep("Enter value to the field 'Limit', eg: " + couponType.getLimit());
            LogReport.logSubStep("Select value on the field 'Status', eg: " + couponType.getStatus());
            LogReport.logSubStep("Select the button 'Save'");
            editCouponTypeAction.updateCouponType(editCouponTypePO, couponType);

            LogReport.logMainStep("5. Verify the error message display");
            addCouponTypeAction.verifyErrorMsgFieldName(addCouponTypePO
                    , dataTestTAWeb.empty_text, dataTestTAWeb.error_msg_name_existed);

            LogReport.logMainStep("6. Back to the page 'Manage coupon type'");
            LogReport.logSubStep("Select the button 'Cancel'");
            addCouponTypePO.btnCancel.click();
            LogReport.logSubStep("Verify the page 'Manage coupon type' display");
            generalAction.verifyElementDisplayed(manageCouponTypePO.h5Title, "The page 'Manage coupon type'");

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 5: Verify the successful message display after submitting successful on the form 'Edit coupon type'
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
     * 3. Go to the page 'Edit coupon type'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon type'
     *  + Select the symbol 'Edit' at random from the data table
     * 4. Enter valid values all field
     *  + Enter value to the field 'Name'
     *  + Enter value to the field 'Limit'
     *  + Select value on the field 'Status'
     *  + Select the button 'Save'
     * 5. Verify the success message display
     * 6. Back to the page 'Manage coupon type'
     *  + Select the button 'Cancel'
     */
    @Test(priority = 5,
            testName = "Test case 5: Verify the successful message display after submitting successful on the form 'Edit coupon type'",
            description = "Description: Verify the successful message display after the user updates successful")
    public void TC05_Verify_the_successful_message_display_after_submitting_successful(){
        INavigateAction navigateAction = new NavigateAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.activated_SSO_account;
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        CouponType couponType = dataTestTAWeb.coupon_type_has_image_jpeg;
        IEditCouponTypeAction editCouponTypeAction = new EditCouponTypeAction();
        EditCouponTypePO editCouponTypePO = new EditCouponTypePO(Constant.webDriver);
        IGeneralAction generalAction = new GeneralAction();

        try {
            System.out.println("Test case 5: Verify the successful message display after submitting successful on the form 'Edit coupon type'");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(Constant.webDriver);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Edit coupon type' at random");
            LogReport.logSubStep("Select the link 'Go To Admin Page'");
            LogReport.logSubStep("Select the tab 'Manage coupon type'");
            LogReport.logSubStep("Select any symbol 'Edit' at random from the data table");
            navigateAction.goToEditCouponTypePage(Constant.webDriver);

            LogReport.logMainStep("4. Enter valid values for all fields");
            LogReport.logSubStep("Clear all fields");
            LogReport.logSubStep("Enter value to the field 'Name'");
            LogReport.logSubStep("Enter value to the field 'Limit'");
            LogReport.logSubStep("Select value on the field 'Status'");
            LogReport.logSubStep("Select the button 'Save'");
            editCouponTypeAction.updateCouponType(editCouponTypePO, couponType);

            LogReport.logMainStep("5. Verify the success message display");
            generalAction.verifyTextDisplay(dataTestTAWeb.success_msg_update_coupon_type,
                    editCouponTypePO.divAlertMessage, false);
            editCouponTypeAction.updateCouponType(editCouponTypePO, dataTestTAWeb.coupon_type_has_image_png);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

}
