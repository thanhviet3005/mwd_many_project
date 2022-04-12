package projects.TA_web.page_object.admin_portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCouponTypePO {

    // for table
    @FindBy(id = "tableTitle")
    public WebElement h5Title;
    @FindBy(xpath = "//button[text()='Add']")
    public WebElement btnAdd;
    @FindBy(xpath = "//thead//span[text()='Name']")
    public WebElement spanName;
    @FindBy(xpath = "//thead//span[text()='Limit']")
    public WebElement spanLimit;
    @FindBy(xpath = "//thead//span[text()='Status']")
    public WebElement spanStatus;

    // 'Delete' dialog
    @FindBy(id = "modal-modal-title")
    public WebElement h2DialogTitle;
    @FindBy(xpath = "//h2[@id='modal-modal-title']//following-sibling::div//button[text()='Ok']")
    public WebElement btnDelete;
    @FindBy(xpath = "//h2[@id='modal-modal-title']//following-sibling::div//button[text()='Cancel']")
    public WebElement btnCancel;
    @FindBy(xpath = "//div[text()='The Coupon Type has been deleted successfully.']")
    public WebElement divSuccessMessage;

    public By h2DialogTitleBy = By.id("modal-modal-title");

    // row 10 on the table
    @FindBy(xpath = "//th[@id='enhanced-table-checkbox-0'][1]")
    public WebElement thNameRow1;
    public By thNameRow1By = By.xpath("//th[@id='enhanced-table-checkbox-0'][1]");

    @FindBy(xpath = "//th[@id='enhanced-table-checkbox-0']//following-sibling::th//button//*[@data-testid='DeleteOutlineIcon']")
    public WebElement svgIconDeleteRow1;

    public ManageCouponTypePO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

}
