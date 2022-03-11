package projects.TA_web.page_object.user_portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveAMessagePO {
    /* ****  Locator & Element **** */
    @FindBy(css = "h5[id='tableTitle']")
    public WebElement h5Title;
    @FindBy(xpath = "//label[text()='First Name']")
    public WebElement labelFirstName;
    @FindBy(id = "firstName")
    public WebElement inputFirstName;
    @FindBy(xpath = "//label[text()='Last Name']")
    public WebElement labelLastName;
    @FindBy(id = "lastName")
    public WebElement inputLastName;
    @FindBy(xpath = "//label[text()='Email']")
    public WebElement labelEmail;
    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(xpath = "//label[text()='Phone']")
    public WebElement labelPhone;
    @FindBy(id = "phone")
    public WebElement inputPhone;
    @FindBy(xpath = "//label[text()='Question/ Comment']")
    public WebElement labelQuestionAndComment;
    @FindBy(xpath = "//label[@for='name']//following-sibling::div//textarea[@aria-label='minimum height']")
    public WebElement textareaQuestionAndComment;
    @FindBy(xpath = "//label[@for='contained-button-file']")
    public WebElement labelAttachFile;
    @FindBy(css = "button[type='Submit']")
    public WebElement btnSendMsg;
    @FindBy(css = "div[id='tableTitle']")
    public WebElement divTableTitle;
    @FindBy(xpath = "//div[@id='tableTitle']//following-sibling::div//table//span[text()='Date']")
    public WebElement spanTableHeaderDate;
    @FindBy(xpath = "//div[@id='tableTitle']//following-sibling::div//table//span[text()='Message']")
    public WebElement spanTableHeaderMessage;
    @FindBy(xpath = "//div[@id='tableTitle']//following-sibling::div//table//span[text()='Status']")
    public WebElement spanTableHeaderStatus;

    // Error message and icon 'Warning'
    @FindBy(xpath = "//input[@id='firstName']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningFirstName;
    @FindBy(xpath = "//input[@id='firstName']//parent::div//following-sibling::label")
    public WebElement labelErrorMsgFirstName;
    public By svgIconWarningFirstNameBy = By.xpath("//input[@id='firstName']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']") ;
    public By labelErrorMsgFirstNameBy = By.xpath("//input[@id='firstName']//parent::div//following-sibling::label");

    @FindBy(xpath = "//input[@id='lastName']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningLastName;
    @FindBy(xpath = "//input[@id='lastName']//parent::div//following-sibling::label")
    public WebElement labelErrorMsgLastName;
    public By svgIconWarningLastNameBy = By.xpath("//input[@id='lastName']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']");
    public By labelErrorMsgLastNameBy = By.xpath("//input[@id='lastName']//parent::div//following-sibling::label");

    @FindBy(xpath = "//input[@id='email']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']")
    public WebElement svgIconWarningEmail;
    @FindBy(xpath = "//input[@id='email']//parent::div//following-sibling::label")
    public WebElement labelErrorMsgEmail;
    @FindBy(xpath = "//input[@id='phone']//parent::div//following-sibling::label")
    public WebElement labelErrorMsgPhone;
    public By labelErrorMsgPhoneBy = By.xpath("//input[@id='phone']//parent::div//following-sibling::label");

    @FindBy(xpath = "//button[@title='Close']//parent::div//preceding-sibling::div[normalize-space(text())]")
    public WebElement divConfirmMsg;

    public By svgIconWarningEmailBy = By.xpath("//input[@id='email']//following-sibling::*[name() = 'svg' and @data-icon='exclamation-triangle']");
    public By labelErrorMsgEmailBy = By.xpath("//input[@id='email']//parent::div//following-sibling::label");

    // pagination
    @FindBy(xpath = "//nav[@aria-label='pagination navigation']")
    public WebElement navPaginationArea;

    /* ****  Constructor  **** */
    public LeaveAMessagePO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

}
