package AutomationExercise_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationExercise_DataObjects.UserAccount;
import AutomationExercise_PageObjects.CartPage;
import AutomationExercise_PageObjects.HomePage;
import AutomationExercise_PageObjects.ProductsPage;
import AutomationExercise_PageObjects.Signup_LoginPage;
import Common.Utilities;
import Constant.Constant;
import Enum.AllProducts;

public class ProductsTest extends BaseTest{
    @Test
    public void TC_01(){
        System.out.println("Verify user can submit a product review successfully");
        System.out.println("Preconditions: User is not required to be logged in.");
        String randomEmail = Utilities.generateRandomEmail();

        System.out.println("1. Navigate to the URL ");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click Products");
        Utilities.disableGoogleAd();
        ProductsPage productsPage = homePage.gotoProductsPage();

        System.out.println("3. Select any product by clicking View Product on a random item");
        System.out.println("4. Verify that the “Write Your Review” section is displayed");
        System.out.println("5. Enter valid Name, Email, and Review text");
        System.out.println("6. Click Submit");
        Utilities.disableGoogleAd();
        productsPage.writeReviewProduct("Rs. 500", AllProducts.BLUETOP.getValue(), "an", randomEmail, "I think it very nice but this product need improve fabric quality");

        System.out.println("7. Verify the success message “Thank you for your review.” is displayed.");
        String actualMsg = productsPage.getSuccessMsg();
        String expectedMsg = "Thank you for your review.";
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    public void TC_02(){
        System.out.println("Verify delivery & billing addresses match registration details ");
        System.out.println("Preconditions: User does not have an existing account ");
        String randomEmail = Utilities.generateRandomEmail();
        UserAccount userAccount = new UserAccount("Mr", Constant.NAME, randomEmail, Constant.PASSWORD, Constant.FIRSTNAME, Constant.LASTNAME, "Agest", Constant.ADDRESS, "United State", Constant.STATE, Constant.CITY, Constant.ZIPCODE, Constant.MOBILE_PHONE);
        String deliveryAddressLastname = "Mr. Kata Kaze";
        String deliveryAddressCompany = "Agest";
        String deliveryAddress = Constant.ADDRESS;
        String deliveryAddressCityStatePostcode = "CCC SSS 12345";
        String deliveryAddressCountry = Constant.COUNTRY;
        String deliveryAddressPhone = Constant.MOBILE_PHONE;

        System.out.println("1. Navigate to the URL ");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click Signup / Login ");
        Utilities.disableGoogleAd();
        Signup_LoginPage signupLoginPage = homePage.gotoSignup_Login();

        System.out.println("3. Create a new account with random email (name_<timestamp>@test.com)");
        System.out.println("4. Click Continue ");
        signupLoginPage.signup(userAccount);

        System.out.println("5. Add a random product to the cart");
        System.out.println("6. In the confirmation popup, click View Cart");
        Utilities.disableGoogleAd();
        ProductsPage productsPage = homePage.gotoProductsPage();
        Utilities.disableGoogleAd();
        productsPage.addCart();

        System.out.println("7.  Click Proceed to Checkout ");
        CartPage cartPage = homePage.gotoCartPage();
        cartPage.proceedCheckOut();

        System.out.println("Verify that the Delivery Address matches the address entered during registration ");
        Assert.assertEquals(productsPage.getAddress(), userAccount.getAddress(), "Address is not displayed as expected");
        Assert.assertEquals(productsPage.getCity(), userAccount.getCity(), "City is not displayed as expected");
        Assert.assertEquals(productsPage.getState(), userAccount.getState(), "State is not displayed as expected");
        Assert.assertEquals(productsPage.getZipcode(), userAccount.getZipcode(), "Zipcode is not displayed as expected");
        Assert.assertEquals(productsPage.getCountry(), userAccount.getCountry(), "Country is not displayed as expected");
    }
}