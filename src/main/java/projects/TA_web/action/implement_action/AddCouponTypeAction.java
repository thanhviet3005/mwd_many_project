package projects.TA_web.action.implement_action;

import common.Constant;
import common.ISSOUtilA;
import common.LogReport;
import common.SSOUtilImpA;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import projects.TA_web.action.IAddCouponTypeAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.AddCouponTypePO;
import projects.TA_web.test_case.admin_portal.AddCouponTypeTC;

public class AddCouponTypeAction implements IAddCouponTypeAction {
    @Override
    public void verifyUIAddPage(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();

        LogReport.logSubStep("Verify all texts of labels: 'Name', 'Limit', 'Status' ");
        generalAction.verifyTextDisplay(dataTestTAWeb.labelName, addCouponTypePO.labelName, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelLimit, addCouponTypePO.labelLimit, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelStatus, addCouponTypePO.labelStatus, false);

        LogReport.logSubStep("Verify all input and selection fields: 'Name', 'Limit', 'Status' display");
        generalAction.verifyElementDisplayed(addCouponTypePO.inputName, "The input field 'Name'");
        generalAction.verifyElementDisplayed(addCouponTypePO.inputLimit, "The input field 'Limit'");
        generalAction.verifyElementDisplayed(addCouponTypePO.divSelectStatus, "The selection field 'Status'");

        LogReport.logSubStep("Verify all names of buttons: 'Save', 'Cancel'");
        generalAction.verifyTextDisplay(dataTestTAWeb.btnSave, addCouponTypePO.btnSave, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.btnCancel, addCouponTypePO.btnCancel, false);
    }

    @Override
    public void verifyErrorMsgFieldName(AddCouponTypePO addCouponTypePO, String expectedText, String errorMsg) {
        IGeneralAction generalAction = new GeneralAction();
        if (!errorMsg.equals("")){
            generalAction.verifyTextDisplay(errorMsg, addCouponTypePO.labelErrorMsgForName, false);
            generalAction.verifyElementDisplayed(addCouponTypePO.svgIconWarningForName, "The icon 'Warning' for the field 'Name'");
        }else {
            generalAction.verifyAttributeText(expectedText, addCouponTypePO.inputName, "value");
            generalAction.verifyElementHidden(addCouponTypePO.svgIconWarningForNameBy, Constant.webDriver, "The icon 'Warning' for the field 'Name'");
            generalAction.verifyElementHidden(addCouponTypePO.labelErrorMsgForNameBy, Constant.webDriver, "The error message for the field 'Name'");
        }
    }

    @Override
    public void verifyErrorMsgFieldLimit(AddCouponTypePO addCouponTypePO, String expectedText, String errorMsg) {
        IGeneralAction generalAction = new GeneralAction();
        if (!errorMsg.equals("")){
            generalAction.verifyTextDisplay(errorMsg, addCouponTypePO.labelErrorMsgForLimit, false);
            generalAction.verifyElementDisplayed(addCouponTypePO.svgIconWarningForLimit, "The icon 'Warning' for the field 'Name'");
        }else {
            generalAction.verifyAttributeText(expectedText, addCouponTypePO.inputLimit, "value");
            generalAction.verifyElementHidden(addCouponTypePO.getSvgIconWarningForLimitBy, Constant.webDriver, "The icon 'Warning' for the field 'Limit'");
            generalAction.verifyElementHidden(addCouponTypePO.labelErrorMsgForLimitBy, Constant.webDriver, "The error message for the field 'Limit'");
        }
    }

    @Override
    public void addNewCouponType(AddCouponTypePO addCouponTypePO, CouponType couponType) {
        ISSOUtilA utilA = new SSOUtilImpA();
        addCouponTypePO.inputName.sendKeys(couponType.getName());
        addCouponTypePO.inputLimit.sendKeys(couponType.getLimit());
        utilA.selectOptionByText(addCouponTypePO.divSelectStatus, couponType.getStatus());
        addCouponTypePO.btnSave.click();
    }

    @Override
    public void verifyAddNewCouponTypeSuccess() {

    }

}
