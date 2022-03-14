package projects.TA_web.page_object.user_portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {
    @FindBy(id = "email")
    public WebElement inputEmail;
    @FindBy(id = "password")
    public WebElement inputPassword;
    @FindBy(css = "button[type='submit']")
    public WebElement btnLogin;

    public LoginPO(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }



}
