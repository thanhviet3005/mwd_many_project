package projects.TA_web.action;

import projects.TA_web.page_object.admin_portal.EditCouponPO;

public interface IEditCouponAction {
    void Updatefields(EditCouponPO editCouponPO);
    void DynamicData (EditCouponPO editCouponPO,String text);

}
