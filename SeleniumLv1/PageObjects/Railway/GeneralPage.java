package Railway;

import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblErrorMessage = By.xpath("//p[contains(@class,'message') and contains(@class,'error')]");
    private final By tabFAQ = By.xpath("//div[@id='menu']//a[@href='/Page/FAQ.cshtml']");

    //Elements
    protected WebElement getTabLogin(){
        return Utilities.waitForVisible(tabLogin);
    }
    protected WebElement getTabRegister(){
        return Utilities.waitForVisible(tabRegister);
    }
    protected WebElement getTabLogout(){
        return Utilities.waitForVisible(tabLogout);
    }
    protected WebElement getLblWelcomeMessage(){
        return Utilities.waitForVisible(lblWelcomeMessage);
    }
    protected WebElement getLblErrorMessage(){
        return Utilities.waitForVisible(lblErrorMessage);
    }
    protected WebElement getTabFAQ(){
        return Utilities.waitForVisible(tabFAQ);
    }

    // Methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }

    public String getErrorMessage(){
        return this.getLblErrorMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public HomePage logout(){
        getTabLogout().click();
        return new HomePage();
    }

    public FAQPage gotoFAQPage() {
        getTabFAQ().click();
        return new FAQPage();
    }
}