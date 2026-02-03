package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");

    //Elements
    protected WebElement getTablogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTablogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    // Methods
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTablogin().click();
        return new LoginPage();
    }
}
