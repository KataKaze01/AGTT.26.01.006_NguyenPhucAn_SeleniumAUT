package Railway;

import Common.Utilities;
import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResetPasswordPage extends GeneralPage {

    //Locators
    private final By btnForgotPassword = By.xpath("//a[contains(text(), 'Forgot Password')]");
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By btnSendInstructions = By.xpath("//p[@class='form-actions']/input");
    private final By lblPasswordChangeForm = By.xpath("//legend[text()='Password Change Form']");
    private final By txtNewPassword = By.xpath("//input[@name='newPassword']");
    private final By txtConfirmPassword = By.xpath("//input[@name='confirmPassword']");
    private final By btnResetPassword = By.xpath("//input[@type='submit']");
    private final By lblResetPasswordErrorMsg = By.xpath("//div[@id='content']/p");
    private final By lblConfirmPasswordErrorMsg = By.xpath("//label[@class='validation-error']");

    //Elements

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

    public WebElement getLblPasswordChangeForm(){
        return Utilities.waitForVisible(lblPasswordChangeForm);
    }

    public WebElement getTxtNewPassword(){
        return Utilities.waitForVisible(txtNewPassword);
    }

    public WebElement getTxtConfirmPassword(){
        return Utilities.waitForVisible(txtConfirmPassword);
    }

    public WebElement getBtnResetPassword(){
        Utilities.waitForClickable(btnResetPassword);
        return Constant.WEBDRIVER.findElement(btnResetPassword);
    }

    public WebElement getLblResetPasswordErrorMsg(){
        return Utilities.waitForVisible(lblResetPasswordErrorMsg);
    }

    public WebElement getLblConfirmPasswordErrorMsg(){
        return Utilities.waitForVisible(lblConfirmPasswordErrorMsg);
    }

    //Methods
    public HomePage resetPassword(UserAccount userAccount){
        getBtnForgotPassword().click();
        getTxtMail().sendKeys(userAccount.getUsernameAccount());
        Utilities.scrollToElement(getBtnSendInstructions());
        getBtnSendInstructions().click();

        return new HomePage();
    }

    public String getResetPasswordErrorMsg(){
        return this.getLblResetPasswordErrorMsg().getText();
    }

    public String getPasswordChangeForm(){
        return this.getLblPasswordChangeForm().getText();
    }

    public HomePage passwordChangeForm(UserAccount userAccount){
        Utilities.scrollToElement(getTxtNewPassword());
        getTxtNewPassword().sendKeys(userAccount.getPasswordAccount());
        getTxtConfirmPassword().sendKeys(userAccount.getPasswordAccount());
        getBtnResetPassword().click();

        return new HomePage();
    }

    public HomePage passwordChangeForm1(UserAccount userAccount){
        Utilities.scrollToElement(getTxtNewPassword());
        getTxtNewPassword().sendKeys(userAccount.getPasswordAccount());
        getTxtConfirmPassword().sendKeys(userAccount.getResetPasswordAccount());
        getBtnResetPassword().click();
        Utilities.scrollToElement(getBtnResetPassword());

        return new HomePage();
    }

}