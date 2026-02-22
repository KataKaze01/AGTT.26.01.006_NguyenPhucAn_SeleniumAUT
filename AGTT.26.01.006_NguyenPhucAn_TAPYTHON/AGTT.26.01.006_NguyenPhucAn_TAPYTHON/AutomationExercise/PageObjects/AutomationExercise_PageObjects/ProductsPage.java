package AutomationExercise_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

public class ProductsPage extends GeneralPage {
    //Locators
    private String btnViewProduct = "//div[@class='features_items']//div[.//h2='%s' and .//p='%s']/following-sibling::div[@class='choose']//a";
    private final By txtName = By.xpath("//input[@id='name']");
    private final By txtEmailAddress = By.xpath("//input[@id='email']");
    private final By txtAddReview = By.xpath("//textarea[@id='review']");
    private final By btnSubmit = By.xpath("//button[@id='button-review']");
    private By lblReviewSuccessMsg = By.xpath("//span[contains(text(), 'Thank you for your review.')]");
    private By btnViewCart = By.xpath("//div[@id='cartModal']//a[contains(@href, 'view_cart')]");
    private final By btnAddToCart = By.xpath("//div[contains(@class, 'productinfo')]//a[contains(@class, 'add-to-cart')]");
    private static final String btnAddToCartIndexXpath = "(//div[contains(@class, 'productinfo')]//a[contains(@class, 'add-to-cart')])[%d]";
    private final By lblAddress = By.xpath("//ul[@id='address_delivery']/li[contains(@class, 'address_address1') and .!= '']");
    private final By lblCityStateZipcode = By.xpath("//ul[@id='address_delivery']/li[@class='address_city address_state_name address_postcode']");
    private final By lblCountry = By.xpath("//ul[@id='address_delivery']/li[@class='address_country_name']");

    //Elements
    public WebElement getBtnViewProduct(String price, String nameProduct){
        By locator = By.xpath(String.format(btnViewProduct, price, nameProduct));
        Utilities.waitForClickable(locator);
        return Constant.WEBDRIVER.findElement(locator);
    }
    public WebElement getTxtName(){return Utilities.waitForVisible(txtName);}
    public WebElement getTxtEmailAddress(){return Utilities.waitForVisible(txtEmailAddress);}
    public WebElement getTxtAddReview(){return Utilities.waitForVisible(txtAddReview);}
    public WebElement getLblReviewSuccessMsg(){return Utilities.waitForVisible(lblReviewSuccessMsg);
    }
    public String getAddress() {
        return Utilities.findElement(lblAddress).getText();
    }

    public String getCity() {
        String[] splitString = Utilities.findElement(lblCityStateZipcode).getText().split(" ");
        return splitString[0];
    }

    public String getState() {
        String[] splitString = Utilities.findElement(lblCityStateZipcode).getText().split(" ");
        return splitString[1];
    }

    public String getZipcode() {
        String[] splitString = Utilities.findElement(lblCityStateZipcode).getText().split(" ");
        return splitString[2];
    }

    public String getCountry() {
        return Utilities.findElement(lblCountry).getText();
    }

    //Methods

    public ProductsPage addRandomProductToCart() {
        int totalButtons = Constant.WEBDRIVER.findElements(btnAddToCart).size();
        Utilities.click(By.xpath(String.format(btnAddToCartIndexXpath, Utilities.randomInt(totalButtons))));
        return this;
    }

    public String getSuccessMsg(){return this.getLblReviewSuccessMsg().getText();}

    public void clickViewProduct(String price, String nameProduct){
        WebElement btn = getBtnViewProduct(price, nameProduct);
        btn.click();
    }

    public HomePage writeReviewProduct(String price, String nameProduct, String name, String email, String addReview){
        clickViewProduct(price, nameProduct);
        getTxtName().sendKeys(name);
        getTxtEmailAddress().sendKeys(email);
        getTxtAddReview().sendKeys(addReview);
        Utilities.click(btnSubmit);

        return new HomePage();
    }

    public HomePage addCart(){
        addRandomProductToCart();
        Utilities.click(btnViewCart);

        return new HomePage();
    }
}
