package projects.TA_web.action;

import projects.TA_web.entity.CouponType;
import projects.TA_web.page_object.admin_portal.EditCouponTypePO;

public interface IEditCouponTypeAction {
    void updateCouponType(EditCouponTypePO editCouponTypePO, CouponType couponType);
}
