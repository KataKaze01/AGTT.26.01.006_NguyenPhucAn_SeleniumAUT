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
        Utilities.click(_btnLogin);

        return new HomePage();
    }
}