package projects.TA_web.action.implement_action;

import common.Constant;
import common.LogReport;
import general_action.IGeneralAction;
import general_action.implement.GeneralAction;
import projects.TA_web.action.IDeleteCouponTypeAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;

public class DeleteCouponTypeAction implements IDeleteCouponTypeAction {

    @Override
    public void verifyUIItemsDeleteDialog(ManageCouponTypePO manageCouponTypePO) {
        IGeneralAction generalA = new GeneralAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        CouponType couponType = dataTestTAWeb.valid_coupon_type_active;

        LogReport.logSubStep("Verify the dialog title");
        String titleExpected = dataTestTAWeb.h2TitleDeleteDialogCouponType + couponType + "?";
        generalA.verifyTextDisplay(titleExpected, manageCouponTypePO.h2DialogTitle, false);

        LogReport.logSubStep("Verify all button name: 'Delete', 'Cancel'");
        generalA.verifyTextDisplay(dataTestTAWeb.btnCancel, manageCouponTypePO.btnCancel, false);
        generalA.verifyTextDisplay(dataTestTAWeb.btnDelete, manageCouponTypePO.btnDelete, false);
    }

    @Override
    public void verifyDeleteCouponType(ManageCouponTypePO manageCouponTypePO) {
        IGeneralAction generalAction = new GeneralAction();
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        generalAction.verifyTextDisplay(dataTestTAWeb.success_msg_delete_coupon_type,
                manageCouponTypePO.divSuccessMessage, false);
        generalAction.verifyElementHidden(manageCouponTypePO.h2DialogTitleBy, Constant.webDriver, "The dialog 'Delete coupon type'");
        generalAction.verifyElementHidden(manageCouponTypePO.thNameRow1By, Constant.webDriver, "The coupon type at row 0");
    }
}
