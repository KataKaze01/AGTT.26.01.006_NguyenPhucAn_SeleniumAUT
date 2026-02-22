package AutomationExercise_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;

public class CartPage extends GeneralPage {
    //Locators
    private By btnProceedChecOut = By.xpath("//a[contains(@class, 'check_out')]");
    private By lbldeliveryAddressLastname = By.xpath("//ul[@id='address_delivery']/li[@class='address_firstname address_lastname']");
    private By lbldeliveryAddressCompany = By.xpath("//ul[@id='address_delivery']/li[@class='address_address1 address_address2']");
    private By lbldeliveryAddress_Address1 = By.xpath("//ul[@id='address_delivery']/li[@class='address_address1 address_address2  ']");
    private By lbldeliveryAddressCityStatePostcode = By.xpath("//ul[@id='address_delivery']/li[@class='address_city address_state_name address_postcode']");
    private By lbldeliveryAddressCountry = By.xpath("//ul[@id='address_delivery']/li[@class='address_firstname address_lastname']");
    private By lbldeliveryAddressPhone = By.xpath("//ul[@id='address_delivery']/li[@class='address_firstname address_lastname']");

    //Elements
    public WebElement getLblDeliveryAddressLastname(){
        return Utilities.waitForVisible(lbldeliveryAddressLastname);
    }

    public WebElement getLblDeliveryAddressCompany(){
        return Utilities.waitForVisible(lbldeliveryAddressCompany);
    }

    public WebElement getLblDeliveryAddress_Address1(){
        return Utilities.waitForVisible(lbldeliveryAddress_Address1);
    }

    public WebElement getLblDeliveryAddressCityStatePostcode(){
        return Utilities.waitForVisible(lbldeliveryAddressCityStatePostcode);
    }

    public WebElement getLblDeliveryAddressCountry(){
        return Utilities.waitForVisible(lbldeliveryAddressCountry);
    }

    public WebElement getLblDeliveryAddressPhone(){
        return Utilities.waitForVisible(lbldeliveryAddressPhone);
    }

    //Methods
    public String getAddressLastname(){return this.getLblDeliveryAddressLastname().getText();}
    public String getAddressCompany(){return this.getLblDeliveryAddressCompany().getText();}
    public String getAddress_Address1(){return this.getLblDeliveryAddress_Address1().getText();}
    public String getAddressCityStatePostcode(){return this.getLblDeliveryAddressCityStatePostcode().getText();}
    public String getAddressCountry(){return this.getLblDeliveryAddressCountry().getText();}
    public String getAddressPhone(){return this.getLblDeliveryAddressPhone().getText();}

    public HomePage proceedCheckOut(){
        Utilities.click(btnProceedChecOut);

        return new HomePage();
    }
}
