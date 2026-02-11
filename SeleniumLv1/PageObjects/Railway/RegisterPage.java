package Railway;

import Common.Utilities;
import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //Locators
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPid = By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//input[@value='Register']");
    private final By _lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By _lblRegisterSuccessMsg = By.xpath("//div[@id='content']/h1");
    private final By _lblPasswordErrorMsg = By.xpath("//input[@id='password']/following-sibling::label[contains(@class,'validation-error')]");
    private final By _lblPìdErrorMsg = By.xpath("//input[@id='pid']/following-sibling::label[contains(@class,'validation-error')]");
    private final By lblRegistrationConfirmedMsg = By.xpath("//div[@id='content']/p");

    //Elements
    public WebElement getTxtEmail(){
        return Utilities.waitForVisible(_txtEmail);
    }

    public WebElement getTxtPassword(){
        return Utilities.waitForVisible(_txtPassword);
    }

    public WebElement getTxtConfirmPassword(){
        return Utilities.waitForVisible(_txtConfirmPassword);
    }

    public WebElement getTxtPid(){
        return Utilities.waitForVisible(_txtPid);
    }

    public WebElement getBtnRegister(){
        Utilities.waitForClickable(_btnRegister);
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    public WebElement getLblRegisterErrorMsg(){
        return Utilities.waitForVisible(_lblRegisterErrorMsg);
    }

    public WebElement getLblPasswordErrorMsg(){
        return Utilities.waitForVisible(_lblPasswordErrorMsg);
    }

    public WebElement getLblSuccessMsg(){
        return Utilities.waitForVisible(_lblRegisterSuccessMsg);
    }

    public WebElement getLblPidErrorMsg(){
        return Utilities.waitForVisible(_lblPìdErrorMsg);
    }
    public WebElement getLblRegistrationConfirmedMsg(){
        return Utilities.waitForVisible(lblRegistrationConfirmedMsg);
    }

    public String getPasswordErrorMsg(){return this.getLblPasswordErrorMsg().getText();}
    public String getPidErrorMsg(){return this.getLblPidErrorMsg().getText();}

    //Methods
    public HomePage register(UserAccount userAccount){
        getTxtEmail().sendKeys(userAccount.getUsernameAccount());
        getTxtPassword().sendKeys(userAccount.getPasswordAccount());
        getTxtConfirmPassword().sendKeys(userAccount.getPasswordAccount());
        getTxtPid().sendKeys((userAccount.getPidAccount()));
        getBtnRegister().click();

        return new HomePage();
    }
}