package projects.TA_web.action;

import general_action.IGeneralAction;
import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.AddCouponTypePO;

public interface IAddCouponTypeAction {
    void verifyUIAddPage(IGeneralAction generalAction, AddCouponTypePO addCouponTypePO);
    void verifyErrorMsgFieldName(AddCouponTypePO addCouponTypePO, String expectedText, String errorMsg);
    void verifyErrorMsgFieldLimit(AddCouponTypePO addCouponTypePO, String expectedText, String errorMsg);
    void addNewCouponType(AddCouponTypePO addCouponTypePO, CouponType couponType);
    void verifyAddNewCouponTypeSuccess();


}
