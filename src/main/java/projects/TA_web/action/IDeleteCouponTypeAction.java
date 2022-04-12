package projects.TA_web.action;

import general_action.IGeneralAction;
import projects.TA_web.page_object.admin_portal.ManageCouponTypePO;

public interface IDeleteCouponTypeAction {
    void verifyUIItemsDeleteDialog(ManageCouponTypePO manageCouponTypePO);
    void verifyDeleteCouponType(ManageCouponTypePO manageCouponTypePO);
}
