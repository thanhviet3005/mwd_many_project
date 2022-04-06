package projects.TA_web.test_case.user_portal;

import SSO_project.action.ILoginAction;
import SSO_project.action.INavigateAction;
import SSO_project.action.IUpdateProfileAction;
import SSO_project.action.implement_action.LoginAction;
import SSO_project.action.implement_action.NavigateAction;
import SSO_project.action.implement_action.UpdateProfileAction;
import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
import SSO_project.page_object.LoginPO;
import SSO_project.page_object.TestArchitectPO;
import SSO_project.page_object.UpdateProfilePO;
import common.Constant;
import common.ExtentReportManager;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import org.testng.annotations.Test;

public class EditProfileTc {


    /**
     * Test case 1: Verify GUI after load page successfully
     *
     *
     *
     *
     * */
    @Test(priority = 1,
            testName = "Verify GUI after load page successfully",
            description = "Verify GUI after load page successfully",
            dataProviderClass = DataTestSSO.class,
            dataProvider = "getDataToCheckUIUpdateProfilePage")
    public void TC_1_Verify_GUI(UserAccount userAccount){
        System.out.println("Test case 1: Verify GUI after load page successfully");
        INavigateAction navigateAction = new NavigateAction();

        LoginPO loginPO = new LoginPO(Constant.webDriver);
        IUpdateProfileAction updateProfileAction = new UpdateProfileAction();
        IGeneralAction generalAction = new GeneralAction();
        ILoginAction loginAction = new LoginAction();
        try {

        }
        catch (Exception exception){
            LogReport.logErrorAndCaptureBase64(ExtentReportManager.extentTest, SSOUtilImpA.stepName,
                    Constant.webDriver.getCurrentUrl(), exception);
            exception.printStackTrace();
        }


    }
    @Test(priority = 2)
    public  void TC_2_Verify_Error_Message_On_Fields_FirstName_LastName(String textName,String textDisplay, String errorMsg){

    }

    @Test(priority = 3)
    public void TC_3_Verify_UploadAvatar(){

    }
}
