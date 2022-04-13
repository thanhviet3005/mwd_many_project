package projects.TA_web.action.implement_action;

import common.ISSOUtilA;
import common.SSOUtilImpA;
import projects.TA_web.action.IEditCouponTypeAction;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.EditCouponTypePO;

public class EditCouponTypeAction implements IEditCouponTypeAction {
    @Override
    public void updateCouponType(EditCouponTypePO editCouponTypePO, CouponType couponType) {
        ISSOUtilA utilA = new SSOUtilImpA();
        editCouponTypePO.inputName.clear();
        editCouponTypePO.inputLimit.clear();
        editCouponTypePO.inputName.sendKeys(couponType.getName());
        editCouponTypePO.inputLimit.sendKeys(couponType.getLimit());
        utilA.selectOptionByText(editCouponTypePO.divSelectStatus, couponType.getStatus());
        editCouponTypePO.inputUploadImage.sendKeys(couponType.getImageLink());
        editCouponTypePO.btnSave.click();
    }
}
