package Railway;

import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblErrorMessage = By.xpath("//p[contains(@class,'message') and contains(@class,'error')]");
    private final By tabFAQ = By.xpath("//div[@id='menu']//a[@href='/Page/FAQ.cshtml']");
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");


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
    protected WebElement getTabBookTicket(){
        return Utilities.waitForVisible(tabBookTicket);
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
    protected WebElement getTabTimetable(){return Utilities.waitForVisible(tabTimetable);}
    protected WebElement getTabMyTicket(){return Utilities.waitForVisible(tabMyTicket);}

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

    public CancelBookingPage gotoMyTicketPage(){
        this.getTabMyTicket().click();
        return new CancelBookingPage();
    }

    public HomePage logout(){
        getTabLogout().click();
        return new HomePage();
    }

    public BookTicketPage gotoTabBookTicketPage(){
        getTabBookTicket().click();
        return new BookTicketPage();
    }

    public BookTicketPage gotoTabTimeTable(){
        getTabTimetable().click();
        return new BookTicketPage();
    }

    public FAQPage gotoFAQPage() {
        getTabFAQ().click();
        return new FAQPage();
    }
}