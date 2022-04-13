package projects.TA_web.action.implement_action;

import general_action.implement.GeneralAction;
import projects.TA_web.action.IAddCouponAction;
import projects.TA_web.data_test.DataTestTAWeb;
import projects.TA_web.page_object.admin_portal.AddCouponPO;

public class AddCouponAction implements IAddCouponAction {

    @Override
    public void verifyAllLabelsOnFormCoupon(AddCouponPO addCouponPO, GeneralAction generalAction) {
        DataTestTAWeb dataTestTAWeb = new DataTestTAWeb();
        generalAction.verifyTextDisplay(dataTestTAWeb.labelName, addCouponPO.labelName, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelType, addCouponPO.labelType, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelValue, addCouponPO.labelValue, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelUnitFirst, addCouponPO.labelUnitFirst, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelPoint, addCouponPO.labelPoint, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelDuration, addCouponPO.labelDuration, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelUnitFirst, addCouponPO.labelUnitDuration, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelStatus, addCouponPO.labelStatus, false);
        generalAction.verifyTextDisplay(dataTestTAWeb.labelPresentee, addCouponPO.labelPresentee, false);
    }

    @Override
    public void verifyAllFieldsOnFormCoupon(AddCouponPO addCouponPO, GeneralAction generalAction) {
        generalAction.verifyElementDisplayed(addCouponPO.inputName, "The input field 'Name'");


    }

    @Override
    public void verifyAllButtonsNames(AddCouponPO addCouponPO, GeneralAction generalAction) {

    }


}
