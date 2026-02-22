package Railway;

import Common.Utilities;
import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MailPage extends GeneralPage {

    //Locators
    private final By btnClickToEdit = By.xpath("//span[@id='inbox-id']");
    private final By txtText = By.xpath("//span[@id='inbox-id']//input[@type='text']");
    private final By btnSet = By.xpath("//button[@class='save button small']");
    private final By confirmEmail = By.xpath("//td[contains(., 'thanhletraining03@gmail.com')]");
    private final By confirmLinkAccount = By.xpath("//div[@class='email_body']//a[contains(@href, 'Account/Confirm')]");
    private final By confirmLinkResetPassword = By.xpath("//div[@class='email_body']//a[contains(@href, 'Account/PasswordReset')]");

    //Elements
    public WebElement getBtnClickToEdit(){
        Utilities.waitForClickable(btnClickToEdit);
        return Constant.WEBDRIVER.findElement(btnClickToEdit);
    }

    public WebElement getTxtText(){
        return Utilities.waitForVisible(txtText);
    }

    public WebElement getBtnSet(){
        Utilities.waitForClickable(btnSet);
        return Constant.WEBDRIVER.findElement(btnSet);
    }

    //Methods
    public MailPage open(){
        Constant.WEBDRIVER.navigate().to(Constant.GUERILLAMAIL_URL);
        return this;
    }

    public RegisterPage confirmMail(String emailAddress){
        String username = emailAddress.split("@")[0];
        getBtnClickToEdit().click();
        getTxtText().clear();
        getTxtText().sendKeys(username);
        getBtnSet().click();
        Utilities.waitForVisible(confirmEmail).click();
        Utilities.waitForVisible(confirmLinkAccount).click();
        Utilities.switchToLatestWindow();

        return new RegisterPage();
    }

    public ResetPasswordPage confirmResetPassword(UserAccount userAccount){
        getBtnClickToEdit().click();
        getTxtText().clear();
        getTxtText().sendKeys(userAccount.getUsernameAccount());
        getBtnSet().click();
        Utilities.waitForVisible(confirmEmail).click();
        Utilities.waitForVisible(confirmLinkResetPassword).click();
        Utilities.switchToLatestWindow();

        return new ResetPasswordPage();
    }
}