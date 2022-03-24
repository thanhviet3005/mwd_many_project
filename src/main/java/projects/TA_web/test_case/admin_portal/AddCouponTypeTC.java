package projects.TA_web.test_case.admin_portal;

import SSO_project.action.ILoginAction;
import SSO_project.action.INavigateAction;
import SSO_project.action.implement_action.LoginAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import base_test.BaseTest;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;

import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;
import projects.TA_web.action.IAddCouponTypeAction;
import projects.TA_web.action.implement_action.AddCouponTypeAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.AddCouponTypePO;
import projects.TA_web.page_object.admin_portal.EditCouponTypePO;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;

public class AddCouponTypeTC extends BaseTest {

    /** Test case 1: Verify all UI items display fully on the form 'Add '
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon type'
     *  +
     *  +
     * 4. Verify all UI items on form 'Add' display fully, including:
     *  + All labels: 'Name', 'Limit', 'Status'
     *  + All input and select fields: 'Name', 'Limit', 'Status'
     *  + All button: 'Save', 'Cancel'
     */
    @Test(priority = 1,
            testName = "Test case 1: Verify all UI items display fully on the form 'Add '",
            description = "Description: Verify all UI item show on the form 'Add'")
    public void TC01_Verify_all_UI_items_display_fully_on_the_form_Add(){
        INavigateAction navigateAction = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
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
            navigateAction.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg:");
            LogReport.logSubStep("Enter the password, eg:");
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("");
            LogReport.logSubStep("");
            LogReport.logSubStep("");

            LogReport.logMainStep("4. Verify all UI items on form 'Add' display fully");
            addCouponTypeAction.verifyUIAddPage(generalAction, addCouponTypePO);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }


    /** Test case 2: Verify error message display proper for the field 'Name'
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
     * 3. Go to the page 'Add coupon type'
     *  +
     *  +
     * 4. Enter invalid values to the field 'Name' then click any points on the screen
     *  + Enter value to the field 'Name'
     *  + Click the label 'Limit'
     * 5. Verify all error messages and icon 'Warning' for the field 'Name' appear fully
     * 6. Repeat the step 4,5 with these values:
     *  + Enter nothing
     *      -> Verify the error message and icon 'Warning' display for this field
     *  + Enter texts consist special character to these field, eg: "Test #.,{}'" and press Enter
     *      -> Expected result: The error message: 'Please remove special characters.' displays
     *  + Enter extensive texts
     *      - Verify texts display on these fields are 200 first letters
     *      - Verify the error message and icon 'Warning' for this field does not display
     *  + Enter texts consist white space letters at the beginning and ending places, eg: "  TEst    "
     *      - Verify texts displaying on these fields are trimmed
     *      - Verify the error message and icon 'Warning' for this field does not display
     *  + Enter Unicode text to these fields
     *      - Verify texts displaying on these fields are unchanged
     *      - Verify the error message and icon 'Warning' for this field does not display
     */
    @Test(priority = 2,
            testName = "Test case 2: Verify error message display proper for the field 'Name'",
            description = "Description: Verify the error message and icon 'Warning' for the field 'Name' appear proper",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckFieldNameOfCouponType")
    public void TC02_Verify_error_message_display_proper_for_the_field_Name
    (UserAccount user, String valueForName, String expectedText , String errorMsg){
        INavigateAction navigateAction = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();

        try {
            System.out.println("Test case 2: Verify error message display proper for the field 'Name'");
            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("");
            LogReport.logSubStep("");
            LogReport.logSubStep("");

            LogReport.logMainStep("4. Enter invalid values to the field 'Name' then click any points on the screen");
            LogReport.logSubStep("Enter value to the field 'Name'");
            addCouponTypePO.inputName.sendKeys(valueForName);
            LogReport.logSubStep("Click the label 'Limit'");
            addCouponTypePO.labelLimit.click();

            LogReport.logMainStep("5. Verify all error messages and icon 'Warning' for the field 'Name' appear properly");
            addCouponTypeAction.verifyErrorMsgFieldName(addCouponTypePO, expectedText, errorMsg);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 3: Verify error message display properly for the field 'Limit'
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
     * 3. Go to the page 'Add coupon type'
     *  +
     *  +
     * 4. Enter values to the field 'Limit' then click any points on the screen
     *  + Enter value to the field 'Limit'
     *  + Click the title form
     * 5. Verify all error messages and icon 'Warning' for the field 'Limit' appear fully
     * 6. Repeat the step 4,5 with these values:
     *  + Enter nothing
     *      -> Verify the error message and icon 'Warning' display for this field
     *  + Enter the text contains special letters (no consist numbers)
     *      - verify no letters display
     *      - verify the error message and icon 'Warning' disappear
     *  + Enter Unicode text to these fields
     *      - Verify only numbers display
     *      - verify the error message and icon 'Warning' disappear
     *  + Enter texts consist numbers and white space letters at the beginning and ending places
     *      - Verify white space letters are trimmed
     *      - verify the error message and icon 'Warning' disappear
     +  + Enter extensive texts that is mix of letters and numbers
     *      - Verify only numbers display
     *      - verify the error message and icon 'Warning' disappear
     */
    @Test(priority = 3,
            testName = "Test case 3: Verify error message display proper for the field 'Limit'",
            description = "Description: Verify the error message and icon 'Warning' for the field 'Limit' appear proper",
            dataProviderClass = DataTestTAWeb.class,
            dataProvider = "getDataToCheckFieldLimitOfCouponType")
    public void TC03_Verify_error_message_display_proper_for_the_field_Limit
    (UserAccount user, String valueForLimit, String expectedText, String errorMsg){
        INavigateAction navigateAction = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();

        try {
            System.out.println("Test case 3: Verify error message display proper for the field 'Limit'");
            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("");
            LogReport.logSubStep("");
            LogReport.logSubStep("");

            LogReport.logMainStep("4. Enter values to the field 'Limit' then click any points on the screen");
            LogReport.logSubStep("Enter value to the field 'Limit'");
            addCouponTypePO.inputLimit.sendKeys(valueForLimit);
            LogReport.logSubStep("Click the label 'Name'");
            addCouponTypePO.labelName.click();

            LogReport.logMainStep("5. Verify all error messages and icon 'Warning' for the field 'Limit' appear properly");
            addCouponTypeAction.verifyErrorMsgFieldLimit(addCouponTypePO, expectedText, errorMsg);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 4: Verify error message display when submitting the name being already in use
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
     * 3. Go to the page 'Add coupon type'
     *  +
     *  +
     * 4. Enter valid values all field
     *  + Enter value already in use to the field 'Name'
     *  + Enter value to the field 'Limit'
     *  + Select value on the field 'Status'
     *  + Select the button 'Save'
     * 5. Verify the error message display
     */
    @Test(priority = 4,
            testName = "Test case 4: Verify error message display when submitting the name being already in use",
            description = "Description: Verify the error message display when submitting the name being already in use")
    public void TC04_Verify_error_message_display_when_submitting_the_name_being_already_in_use(){
        INavigateAction navigateAction = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.activated_SSO_account;
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        CouponType couponType = dataTestTAWeb.valid_coupon_type_active;
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);

        try {
            System.out.println("Test case 4: Verify error message display when submitting the name being already in use");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("");
            LogReport.logSubStep("");
            LogReport.logSubStep("");

            LogReport.logMainStep("4. Enter valid values all field");
            LogReport.logSubStep("Enter value already in use to the field 'Name'");
            LogReport.logSubStep("Enter value to the field 'Limit'");
            LogReport.logSubStep("Select value on the field 'Status'");
            LogReport.logSubStep("Select the button 'Save'");
            addCouponTypeAction.addNewCouponType(addCouponTypePO, couponType);

            LogReport.logMainStep("5. Verify the error message display");
            addCouponTypeAction.verifyErrorMsgFieldName(addCouponTypePO
                    , dataTestTAWeb.empty_text, dataTestTAWeb.error_msg_name_existed);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 5: Verify the successful message display after submitting successful
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
     * 3. Go to the page 'Add coupon type'
     *  +
     *  +
     * 4. Enter valid values all field
     *  + Enter value to the field 'Name'
     *  + Enter value to the field 'Limit'
     *  + Select value on the field 'Status'
     *  + Select the button 'Save'
     * 5. Verify the success message display
     */
    @Test(priority = 5,
            testName = "Test case 5: Verify the successful message display after submitting successful",
            description = "Description: Verify the successful message display after submitting successful")
    public void TC05_Verify_the_successful_message_display_after_submitting_successful(){
        ManageCouponTypePO manageCouponTypePO = new ManageCouponTypePO(Constant.webDriver);
        AddCouponTypePO addCouponTypePO = new AddCouponTypePO(Constant.webDriver);
        INavigateAction navigateAction = new NavigateAction();
        TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        UserAccount user = dataTestTAWeb.activated_SSO_account;
        ILoginAction loginAction = new LoginAction();
        LoginPO loginPO = new LoginPO(Constant.webDriver);
        CouponType couponType = dataTestTAWeb.new_coupon_type_active;
        IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
        IGeneralAction generalAction = new GeneralAction();

        try {
            System.out.println("Test case 5: Verify the successful message display after submitting successful");

            LogReport.logMainStep("1. Go to the page Login");
            LogReport.logSubStep("Open the web browser");
            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
            LogReport.logSubStep("Select the button 'Login'");
            navigateAction.goToLoginPage(testArchitectPO);

            LogReport.logMainStep("2. Login with valid account");
            LogReport.logSubStep("Go to the page 'Login'");
            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
            LogReport.logSubStep("Select the button 'Login'");
            loginAction.loginSSO(loginPO, user);

            LogReport.logMainStep("3. Go to the page 'Add coupon type'");
            LogReport.logSubStep("");
            LogReport.logSubStep("");
            LogReport.logSubStep("");

            LogReport.logMainStep("4. Enter valid values all field");
            LogReport.logSubStep("Enter value to the field 'Name'");
            LogReport.logSubStep("Enter value to the field 'Limit'");
            LogReport.logSubStep("Select value on the field 'Status'");
            LogReport.logSubStep("Select the button 'Save'");
            addCouponTypeAction.addNewCouponType(addCouponTypePO, couponType);

            LogReport.logMainStep("5. Verify the success message display");
            generalAction.verifyTextDisplay(dataTestTAWeb.success_msg_add_coupon_type,
                    addCouponTypePO.divSuccessMessage, false);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }



}
