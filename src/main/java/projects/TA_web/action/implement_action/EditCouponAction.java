package projects.TA_web.action.implement_action;

import org.openqa.selenium.By;
import projects.TA_web.action.IEditCouponAction;
import projects.TA_web.page_object.admin_portal.EditCouponPO;

public class EditCouponAction implements IEditCouponAction {
    @Override
    public void Updatefields(EditCouponPO editCouponPO) {

    }

    @Override
    public void DynamicData(EditCouponPO editCouponPO, String text) {

        editCouponPO.typeCouponOpts.findElements(By.xpath(text));
    }
}
