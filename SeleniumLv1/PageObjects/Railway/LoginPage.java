package Railway;

import Common.Utilities;
import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{

    //Locators
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By btnForgotPassword = By.xpath("//a[contains(text(), 'Forgot Password')]");
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By btnSendInstructions = By.xpath("//p[@class='form-actions']/input");

    //Elements
    public WebElement getTxtUsername(){
        return Utilities.waitForVisible(_txtUsername);
    }

    public WebElement getTxtPassword(){
        return Utilities.waitForVisible(_txtPassword);
    }

    public WebElement getBtnLogin(){
        Utilities.waitForClickable(_btnLogin);
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getBtnForgotPassword(){
        Utilities.waitForClickable(btnForgotPassword);
        return Constant.WEBDRIVER.findElement(btnForgotPassword);
    }

    public WebElement getTxtMail(){
        return Utilities.waitForVisible(txtEmail);
    }

    public WebElement getBtnSendInstructions(){
        Utilities.waitForClickable(btnSendInstructions);
        return Constant.WEBDRIVER.findElement(btnSendInstructions);
    }

    public WebElement getLblLoginErrorMsg(){
        return Utilities.waitForVisible(_lblLoginErrorMsg);
    }

    //Methods
    public HomePage login(String username, String password){
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();


        return new HomePage();
    }

    public HomePage login(UserAccount userAccount){
        getTxtUsername().sendKeys(userAccount.getUsernameAccount());
        getTxtPassword().sendKeys(userAccount.getPasswordAccount());
        getBtnLogin().click();


        return new HomePage();
    }
}