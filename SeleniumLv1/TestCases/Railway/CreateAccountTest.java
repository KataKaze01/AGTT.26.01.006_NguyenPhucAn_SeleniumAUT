package Railway;

import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {
    @Test
    public void TC07(){
        System.out.println("TC07 - User can't create account with an already in-use email");
        System.out.println("Pre-condition: an actived account is existing");

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        RegisterPage registerPage = homePage.gotoRegisterPage();

        System.out.println("3. Enter information of the created account in Pre-condition");
        System.out.println("4. Click on \"Register\" button");
        UserAccount userAccount = new UserAccount(Constant.USERNAME, Constant.PASSWORD, Constant.PID);
        registerPage.register(userAccount);

        System.out.println("Error message \"This email address is already in use.\" displays above the form.");
        String actualMsg = registerPage.getLblRegisterErrorMsg().getText();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg, expectedMsg);

    }

    @Test
    public void TC08(){
        System.out.println("TC08 - User can't create account while password and PID fields are empty");

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        RegisterPage registerPage = homePage.gotoRegisterPage();

        System.out.println("3. Enter valid email address and leave other fields empty");
        UserAccount userAccount = new UserAccount(Constant.USERNAME, "", "");
        registerPage.register(userAccount);

        System.out.println("Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.");
        String actualMsg = registerPage.getLblRegisterErrorMsg().getText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("Next to password fields, error message \"Invalid password length.\" displays");
        String actualPwdError = registerPage.getPasswordErrorMsg();
        String expectedPwdError = "Invalid password length";
        Assert.assertEquals(actualPwdError, expectedPwdError);

        System.out.println("Next to PID field, error message \"Invalid ID length.\" displays");
        String actualPidError = registerPage.getPidErrorMsg();
        String expectedPidError = "Invalid ID length";
        Assert.assertEquals(actualPidError, expectedPidError);
    }

    @Test
    public void TC09(){

    }
}
