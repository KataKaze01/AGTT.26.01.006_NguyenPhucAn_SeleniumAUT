package AutomationExercise_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;

public class GeneralPage {
    //Locators
    private final By tabHome = By.xpath("//div[@class='shop-menu pull-right']//a[@href='/']");
    private final By tabProducts = By.xpath("//div[@class='shop-menu pull-right']//a[@href='/products']");
    private final By tabCart = By.xpath("//div[@class='shop-menu pull-right']//a[@href='/view_cart']");
    private final By tabSignup_Login = By.xpath("//div[@class='shop-menu pull-right']//a[@href='/login']");
    private final By tabTCs = By.xpath("//div[@class='shop-menu pull-right']//a[@href='/test_cases']");
    private final By tabAPITesting = By.xpath("//div[@class='shop-menu pull-right']//a[@href='/api_list']");
    private final By tabVideoTutorials = By.xpath("//div[@class='shop-menu pull-right']//a[@href='https://www.youtube.com/c/AutomationExercise']");
    private final By tabContactUs = By.xpath("//div[@class='shop-menu pull-right']//a[@href='/contact_us']");

    //Elements
    protected WebElement getTabHome(){return Utilities.waitForVisible(tabHome);}
    protected WebElement getTabProducts(){return Utilities.waitForVisible(tabProducts);}
    protected WebElement getTabCart(){return Utilities.waitForVisible(tabCart);}
    protected WebElement getTabSignup_Login(){return Utilities.waitForVisible(tabSignup_Login);}
    protected WebElement getTabTCs(){return Utilities.waitForVisible(tabTCs);}
    protected WebElement getTabAPITesting(){return Utilities.waitForVisible(tabAPITesting);}
    protected WebElement getTabVideoTutorials(){return Utilities.waitForVisible(tabVideoTutorials);}
    protected WebElement getTabContactUs(){return Utilities.waitForVisible(tabContactUs);}

    //Methods
    public Signup_LoginPage gotoSignup_Login(){
        this.getTabSignup_Login().click();
        return new Signup_LoginPage();
    }

    public ProductsPage gotoProductsPage(){
        this.getTabProducts().click();
        return new ProductsPage();
    }

    public CartPage gotoCartPage(){
        this.getTabCart().click();
        return new CartPage();
    }

}
