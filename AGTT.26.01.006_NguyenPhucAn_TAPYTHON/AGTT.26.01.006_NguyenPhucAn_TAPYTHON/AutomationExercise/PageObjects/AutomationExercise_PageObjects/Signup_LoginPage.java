package AutomationExercise_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AutomationExercise_DataObjects.UserAccount;
import Common.Utilities;
import Constant.Constant;

public class Signup_LoginPage extends GeneralPage {
    //Locators
    private By loginForm = By.xpath("//div[@class='login-form']");
    private By txtEmailAddress = By.xpath("//input[@data-qa='login-email']");
    private By txtPassword = By.xpath("//input[@placeholder='Password']");
    private By btnLogin = By.xpath("//button[normalize-space()='Login']");
    private By signupForm = By.xpath("//div[@class='signup-form']");
    private By txtName = By.xpath("//input[@placeholder='Name']");
    private By txtEmailSignup = By.xpath("//input[@data-qa='signup-email']");
    private By btnSignup = By.xpath("//button[normalize-space()='Signup']");
    private By rdoMr = By.xpath("//input[@id='id_gender1']");
    private By rdoMrs = By.xpath("//input[@id='id_gender2']");
    private By txtNameEmailAccountInfo = By.xpath("//input[@id='name']");
    private By txtPasswordAccountInfo = By.xpath("//input[@id='password']");
    private By cbbDay = By.xpath("//select[@id='days']");
    private By cbbMonth = By.xpath("//select[@id='months']");
    private By cbbYear = By.xpath("//select[@id='years']");
    private By cbSignupForOurNewsletter = By.xpath("//input[@id='newsletter']");
    private By cbReceiveSpecialOffersFromOurPartners = By.xpath("//input[@id='optin']");
    private By txtFistname = By.xpath("//input[@id='first_name']");
    private By txtLastname = By.xpath("//input[@id='last_name']");
    private By txtCompany = By.xpath("//input[@id='company']");
    private By txtAddress = By.xpath("//input[@id='address1']");
    private By cbbCountry = By.xpath("//select[@id='country']");
    private By txtState = By.xpath("//input[@id='state']");
    private By txtCity = By.xpath("//input[@id='city']");
    private By txtZipcode = By.xpath("//input[@id='zipcode']");
    private By txtMobileNumber = By.xpath("//input[@id='mobile_number']");
    private By btnCreateAccount = By.xpath("//button[normalize-space()='Create Account']");
    private By btnContinue = By.xpath("//div[@class='pull-right']/a");

    //Elements
    public WebElement getLoginForm(){return Utilities.waitForVisible(loginForm);}
    public WebElement getTxtEmailAddress(){return Utilities.waitForVisible(txtEmailAddress);}
    public WebElement getTxtPassword(){return Utilities.waitForVisible(txtPassword);}
    public WebElement getBtnLogin(){return Utilities.waitForVisible(btnLogin);}
    public WebElement getSignupForm(){return Utilities.waitForVisible(signupForm);}
    public WebElement getTxtName(){return Utilities.waitForVisible(txtName);}
    public WebElement getTxtEmailSignup(){return Utilities.waitForVisible(txtEmailSignup);}
    public WebElement getBtnSignup(){return Utilities.waitForVisible(btnSignup);}
    public WebElement getRdoMr(){
        Utilities.waitForClickable(rdoMr);
        return Constant.WEBDRIVER.findElement(rdoMr);
    }
    public WebElement getRdoMrs(){
        Utilities.waitForClickable(rdoMrs);
        return Constant.WEBDRIVER.findElement(rdoMrs);
    }
    public WebElement getTxtNameEmailAccountInfo(){return Utilities.waitForVisible(txtNameEmailAccountInfo);}
    public WebElement getTxtPasswordAccountInfo(){return Utilities.waitForVisible(txtPasswordAccountInfo);}
    public WebElement getCbbDay(){
        Utilities.waitForClickable(cbbDay);
        return Constant.WEBDRIVER.findElement(cbbDay);
    }
    public WebElement getCbbMonth(){
        Utilities.waitForClickable(cbbMonth);
        return Constant.WEBDRIVER.findElement(cbbMonth);
    }
    public WebElement getCbbYear(){
        Utilities.waitForClickable(cbbYear);
        return Constant.WEBDRIVER.findElement(cbbYear);
    }
    public WebElement getCbSignupForOurNewsletter(){
        Utilities.waitForClickable(cbSignupForOurNewsletter);
        return Constant.WEBDRIVER.findElement(cbSignupForOurNewsletter);
    }
    public WebElement getCbReceiveSpecialOffersFromOurPartners(){
        Utilities.waitForClickable(cbReceiveSpecialOffersFromOurPartners);
        return Constant.WEBDRIVER.findElement(cbReceiveSpecialOffersFromOurPartners);
    }
    public WebElement getTxtFirstname(){return Utilities.waitForVisible(txtFistname);}
    public WebElement getTxtLastname(){return Utilities.waitForVisible(txtLastname);}
    public WebElement getTxtCompany(){return Utilities.waitForVisible(txtCompany);}
    public WebElement getTxtAddress(){return Utilities.waitForVisible(txtAddress);}
    public WebElement getCbbCountry(){
        Utilities.waitForClickable(cbbCountry);
        return Constant.WEBDRIVER.findElement(cbbCountry);
    }
    public WebElement getTxtState(){return Utilities.waitForVisible(txtState);}
    public WebElement getTxtCity(){return Utilities.waitForVisible(txtCity);}
    public WebElement getTxtZipcode(){return Utilities.waitForVisible(txtZipcode);}
    public WebElement getTxtMobileNumber(){return Utilities.waitForVisible(txtMobileNumber);}
    public WebElement getBtnContinue(){
        Utilities.waitForClickable(btnContinue);
        return Constant.WEBDRIVER.findElement(btnContinue);
    }

    public WebElement getBtnCreateAccount(){
        Utilities.waitForClickable(btnCreateAccount);
        return Constant.WEBDRIVER.findElement(btnCreateAccount);
    }

    //Methods
    public void selectDay(String day){
        new Select(getCbbDay()).selectByVisibleText(day);
    }

    public void selectMonth(String month){
        new Select(getCbbMonth()).selectByVisibleText(month);
    }

    public void selectYear(String year){
        new Select(getCbbYear()).selectByVisibleText(year);
    }

    public void selectCountry(String country){
        new Select(getCbbCountry()).selectByVisibleText(country);
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr") || title.equalsIgnoreCase("Mr.")) {
            getRdoMr().click();
        } else if (title.equalsIgnoreCase("Mrs") || title.equalsIgnoreCase("Mrs.")) {
            getRdoMrs().click();
        } else {
            throw new IllegalArgumentException("Invalid title: " + title + ". Please use 'Mr' or 'Mrs'");
        }
    }

    public HomePage signup(UserAccount userAccount){
        getTxtName().sendKeys(userAccount.getName());
        getTxtEmailSignup().sendKeys(userAccount.getEmail());
        Utilities.click(btnSignup);

        selectTitle(userAccount.getTitle());
        getTxtPasswordAccountInfo().sendKeys(userAccount.getPassword());
        getTxtFirstname().sendKeys(userAccount.getFirstname());
        getTxtLastname().sendKeys(userAccount.getLastname());
        getTxtCompany().sendKeys(userAccount.getCompany());
        getTxtAddress().sendKeys(userAccount.getAddress());
        getTxtState().sendKeys(userAccount.getState());
        getTxtCity().sendKeys(userAccount.getCity());
        getTxtZipcode().sendKeys(userAccount.getZipcode());
        getTxtMobileNumber().sendKeys(userAccount.getMobileNumber());
        Utilities.scrollToElement(getBtnCreateAccount());
        Utilities.click(btnCreateAccount);
        Utilities.click(btnContinue);

        return new HomePage();
    }

}