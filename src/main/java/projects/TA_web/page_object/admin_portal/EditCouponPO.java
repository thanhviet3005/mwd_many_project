package projects.TA_web.page_object.admin_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCouponPO extends AddCouponPO{
    @FindBy(id = "tableTitle")
    public WebElement couponTitle;
    @FindBy (xpath = "//label[.='Name*']")
    public  WebElement labelName;
    @FindBy(xpath = "//label[.='Type*']")
    public  WebElement labelType;
    @FindBy(xpath = "//label[.='Value*']")
    public WebElement labelValue;
    @FindBy(css = "[for='valueUnit']")
    public WebElement labelUnitName;
    @FindBy (xpath = "//label[.='Point*']")
    public  WebElement labelPoint;
    @FindBy (xpath = "//label[.='Duration*']")
    public WebElement labelDuration;
    @FindBy(css = "[for='unitDuration']")
    public  WebElement labelUnitDuration;
    @FindBy (xpath = "//label[.='Status*']")
    public WebElement labelStatus;
    @FindBy(xpath = "//label[.='Presentee']")
    public  WebElement labelPresentee;
    @FindBy(xpath = "//label[@for='type']//following-sibling::div//div[text()=, '%s']")
    public WebElement typeCouponOpts;

    @FindBy(xpath = "//input[@id='name']")
    public  WebElement couponName;
    @FindBy (xpath = "//input[@id='value']")
    public WebElement couponValue;
    @FindBy (xpath = "//div[@id='valueUnit']")
    public WebElement unitName;
    @FindBy (xpath = "//input[@id='point']")
    public  WebElement couponPoint;
    @FindBy (xpath = "//input[@id='duration']")
    public WebElement  couponDuration;
    @FindBy(xpath="//div[.='Days']")
    public  WebElement unitDays;
    @FindBy(xpath = "//div[@id='status-select']")
    public WebElement couponStatus;
    @FindBy (css = "[aria-label='B']")
    public WebElement btnPresenteeYes;
    @FindBy(css = "[aria-label='A']")
    public WebElement btnPresenteeNo;


    /* xpath for select options in all element displays on Edit Coupon page*/
    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//child::li[1]")
    public WebElement selectOpts1;
    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//child::li[2]")
    public WebElement selectOpts2;
    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//child::li[3]")
    public WebElement selectOpts3;

    @FindBy (xpath = "//button[text()='Save']")
    public WebElement btnSave;
    @FindBy (xpath = "//button[text()='Cancel']")
    public WebElement btnCancel;

    public EditCouponPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, AddCouponPO.class);
        PageFactory.initElements(webDriver, this);
    }
}
