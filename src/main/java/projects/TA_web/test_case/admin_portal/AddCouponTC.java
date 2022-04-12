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
import org.testng.annotations.Test;
import projects.TA_web.action.IAddCouponTypeAction;
import projects.TA_web.action.INavigateAction;
import projects.TA_web.action.implement_action.AddCouponTypeAction;
import projects.TA_web.action.implement_action.NavigateAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.AddCouponTypePO;

public class AddCouponTC extends BaseTest {

    /** Test case 1: Verify the UI items on the page 'Add coupon'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 4. Verify UI items display, include:
     *  + Verify the title text and all label names: Name, Type, Value, Unit name, Point, Duration, Unit name, Status, Presentee
     *  + Verify all input fields, selection fields: Name, Type, Value, Unit name, Point, Duration, Unit name, Status, Presentee
     *  + Verify all button names: Save, Cancel
     */
    @Test(priority = 1,
            testName = "Test case 1: Verify the UI items on the page 'Add coupon'",
            description = "Description: ")
    public void TC04_Verify_error_message_display_when_submitting_the_name_being_already_in_use(){

        try {
            System.out.println("Test case ");

//            LogReport.logMainStep("1. Go to the page Login");
//            LogReport.logSubStep("Open the web browser");
//            LogReport.logSubStep("Enter the above URL to the address bar on the browser");
//            LogReport.logSubStep("Press the key 'Enter' on the keyboard");
//            LogReport.logSubStep("Select the button 'Login'");
//            navigateAction.goToLoginPage(Constant.webDriver);
//
//            LogReport.logMainStep("2. Login with valid account");
//            LogReport.logSubStep("Go to the page 'Login'");
//            LogReport.logSubStep("Enter the email, eg: " + user.getEmail());
//            LogReport.logSubStep("Enter the password, eg: " + user.getPassword());
//            LogReport.logSubStep("Select the button 'Login'");
//            loginAction.loginSSO(loginPO, user);

        } catch (Exception exception) {
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }
    }

    /** Test case 2: Verify the error messages for empty fields appear fully after creating a new coupon without any values
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 4. Enter nothing value to all fields
     *  + Clear all values on all fields
     *  + Select the button 'Save'
     * 5. Verify the error messages and icon 'Warning' for an empty field appears fully on all required fields
     */

    /** Test case 3: Verify the error message displays appropriate on the field 'Name*'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 4. Enter value to field 'Name'
     *  + Enter an invalid value / a valid value to the field 'Name'
     *  + Click any points on the screen, eg: The title page
     * 5. Verify the error messages display or not
     * 6. Repeat the steps 4, 5 with these values:
     *  + Enter nothing
     *      -> Verify the error message and icon 'Warning' display for this field
     *  + Enter texts consist special character to these field, eg: "Test #.,{}'" and press Enter
     *      -> Expected result: The error message: 'Please remove special characters.' displays
     *  + Enter extensive texts
     *      - Verify texts display on these fields are 200 first letters
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter texts consist white space letters at the beginning and ending places, eg: "  TEst    "
     *      - Verify texts displaying on these fields are trimmed
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter Unicode text to these fields
     *      - Verify texts displaying on these fields are unchanged
     *      - Verify the error message and icon 'Warning' for this field  still hide
     */

    /** Test case 4: Verify the error message displays appropriate on the field 'Value*'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 4. Enter value to field 'Value'
     *  + Enter an invalid value / a valid value to the field 'Name'
     *  + Click any points on the screen, eg: The title page
     * 5. Verify the error messages display or not
     * 6. Repeat the steps 4, 5 with these values:
     *  + Enter nothing
     *      - Verify the error message for the empty field and icon 'Warning' display
     *  + Enter texts consist special character to these field, eg: "Test #.,{}'" and press Enter
     *      - Verify the error message and icon 'Warning' still hide
     *      - Verify the text on the input field is only digits or empty
     *  + Enter extensive texts, and it is mixed numbers, letters
     *      - Verify texts display is only digits
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter texts consist white space letters at the beginning and ending places, eg: "  02468    "
     *      - Verify texts on it are trimmed
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter Unicode text
     *      - Verify text on it are empty text or only digits
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter a text that is mixed numbers, letters, special characters, symbol '+,-,.'
     *      - Verify the error message and icon 'Warning' display
     *      - Verify the text on the field only numbers and symbols '+,-,.'
     *  + Enter a text consists more 200 letters is only numbers
     *      - Verify texts display is only 200 first numbers
     *      - Verify the error message and icon 'Warning' for this field still hide
     */

    /** Test case 5: Verify the error message displays appropriate on the field 'Point*'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 4. Enter value to field 'Value'
     *  + Enter an invalid value / a valid value to the field 'Name'
     *  + Click any points on the screen, eg: The title page
     * 5. Verify the error messages display or not
     * 6. Repeat the steps 4, 5 with these values:
     *  + Enter nothing
     *      - Verify the error message for the empty field and icon 'Warning' display
     *  + Enter texts consist special character to these field, eg: "Test #.,{}'" and press Enter
     *      - Verify the error message and icon 'Warning' still hide
     *      - Verify the text on the input field is only digits or empty
     *  + Enter extensive texts, and it is mixed numbers, letters
     *      - Verify texts display is only digits
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter texts consist white space letters at the beginning and ending places, eg: "  02468    "
     *      - Verify texts on it are trimmed
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter Unicode text
     *      - Verify text on it are empty text or only digits
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter a text that is mixed numbers, letters, special characters, symbol '+,-,.'
     *      - Verify the error message and icon 'Warning' display
     *      - Verify the text on the field only numbers and symbols '+,-,.'
     *  + Enter a text consists more 200 letters is only numbers
     *      - Verify texts display is only 200 first numbers
     *      - Verify the error message and icon 'Warning' for this field still hide
     */

    /** Test case 6: Verify the error message displays appropriate on the field 'Duration*'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 4. Enter value to field 'Value'
     *  + Enter an invalid value / a valid value to the field 'Name'
     *  + Click any points on the screen, eg: The title page
     * 5. Verify the error messages display or not
     * 6. Repeat the steps 4, 5 with these values:
     *  + Enter nothing
     *      - Verify the error message for the empty field and icon 'Warning' display
     *  + Enter texts consist special character to these field, eg: "Test #.,{}'" and press Enter
     *      - Verify the error message and icon 'Warning' still hide
     *      - Verify the text on the input field is only digits or empty
     *  + Enter extensive texts, and it is mixed numbers, letters
     *      - Verify texts display is only digits
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter texts consist white space letters at the beginning and ending places, eg: "  02468    "
     *      - Verify texts on it are trimmed
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter Unicode text
     *      - Verify text on it are empty text or only digits
     *      - Verify the error message and icon 'Warning' for this field still hide
     *  + Enter a text that is mixed numbers, letters, special characters, symbol '+,-,.'
     *      - Verify the error message and icon 'Warning' display
     *      - Verify the text on the field only numbers and symbols '+,-,.'
     *  + Enter a text consists more 200 letters is only numbers
     *      - Verify texts display is only 200 first numbers
     *      - Verify the error message and icon 'Warning' for this field still hide
     */

    /** Test case 7: Verify only active coupon types are displayed at the field 'Unit '
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the above URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Collect all coupon types on the page 'Manage coupon type'
     *  + Select the tab 'Manage coupon type'
     *  + Observe all active coupon types
     * 4. Go to the page 'Add coupon'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 5. Open the coupon type list
     *  + Select the field 'Type'
     * 6. Verify all the active coupon types from step 3 display fully on the field 'Type'
     * 7. Back to page 'Manage coupon type', select and update a coupon type to in-active at random
     *  + Select the tab 'Manage coupon type'
     *  + Select a coupon type at random
     *  + Update this coupon type's status to 'in-active'
     *  + Select the button 'Save'
     * 8. Repeat step 5
     * 9. Verify the in-active coupon at step 7 disappears from list
     */

    /** Test case 8: Verify the error message appears if the user create new coupon is the same to another coupon
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Add coupon'
     *  + Select the tab 'Manage coupon'
     *  + Select the button 'Add'
     * 4. Create a new coupon is the same to any coupons on the data table 'Manage coupon'
     *  + Enter all valid values to all fields, and they are similar another coupon that it is already use
     *  + Select the button 'Save'
     * 5. Verify the error message that it appears to reminder the coupon is existed
     */

    /** Test case 9: Verify the coupon status is updated 'in-active' automatically after the user updates the current coupon type' status that it is 'in-active'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Observe an active coupon, and it has coupon type's status being 'active'
     *  + Go to the page 'Manage coupon'
     *  + Select at random an active coupon, and it has coupon type's status being 'active'
     * 4. Update a current type's status that it is 'in-active'
     *  + Select the coupon type for the coupon from step 3
     *  + Update the coupon type's status being 'in-active'
     * 5. Verify the coupon status at step 3 being 'in-active', and it disappears on the page 'Refer and earn point'
     *  + Back to the page 'Manage coupon'
     *  + Verify the coupon status at step 3 being 'in-active'
     *  + Go to the page 'Refer and earn point'
     *  + Verify this coupon disappear
     */

    /** Notes: This case is tested manual testing
     * Test case 11: Verify the coupon status is updated 'in-active' automatically after the coupon out of duration time
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter the URL to the address bar on the browser: stage1.testarchitect.com
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Add new coupon
     *  + Enter valid values to all fields
     *  + Select any duration time, eg: 1-2 hours/days/months
     * 4. Verify the coupon's status to be updated 'in-active' automatically after the coupon out of the duration time
     */





}
