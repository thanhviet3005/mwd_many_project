package projects.TA_web.action;

import general_action.implement.GeneralAction;
import projects.TA_web.page_object.admin_portal.AddCouponPO;

public interface IAddCouponAction {
    void verifyAllLabelsOnFormCoupon(AddCouponPO addCouponPO, GeneralAction generalAction);
    void verifyAllFieldsOnFormCoupon(AddCouponPO addCouponPO, GeneralAction generalAction);
    void verifyAllButtonsNames(AddCouponPO addCouponPO, GeneralAction generalAction);

}
