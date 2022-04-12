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
import projects.TA_web.page_object.admin_portal.EditCouponPO;

public class EditCouponTc extends BaseTest {

    /** Test case 1: Verify the UI items on the page 'Edit coupon'
     * 1. Go to the page Login
     *  + Open the web browser
     *  + Enter URL to the address bar on the browser:
     *  + Press the key 'Enter' on the keyboard
     *  + Select the button 'Login'
     * 2. Login with valid account
     *  + Go to the page 'Login'
     *  + Enter the email
     *  + Enter the password
     *  + Select the button 'Login'
     * 3. Go to the page 'Edit coupon'
     *  + Select the link 'Go To Admin Page'
     *  + Select the tab 'Manage coupon'
     *  + Select icon 'Edit' at random from the data table
     * 4. Verify UI items display, include:
     *  + Verify the title text and all label names: Name, Type, Value, Unit name, Point, Duration, Unit name, Status, Presentee
     *  + Verify all button names: Save, Cancel
     * 5. Verify all values that they are displaying on all fields of the coupon at step 3
     */
@Test(priority = 1,testName = "Verify the UI items on the page 'Edit coupon")
    public void Verify_GUI(){
    INavigateAction navigateAction = new NavigateAction();
    TestArchitectPO testArchitectPO = new TestArchitectPO(Constant.webDriver);
    ILoginAction loginAction = new LoginAction();
    LoginPO loginPO = new LoginPO(Constant.webDriver);
    DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
    UserAccount user = dataTestTAWeb.activated_SSO_account;
    IAddCouponTypeAction addCouponTypeAction = new AddCouponTypeAction();
    IGeneralAction generalAction = new GeneralAction();
    EditCouponPO editCouponPO = new EditCouponPO(Constant.webDriver);

    try {

    }
    catch (Exception e){
        LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                Constant.webDriver.getCurrentUrl(), e);
        e.printStackTrace();
    }

    }
}
