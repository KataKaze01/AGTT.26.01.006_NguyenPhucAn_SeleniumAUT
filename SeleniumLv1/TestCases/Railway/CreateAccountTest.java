package Railway;

import Common.Utilities;
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
        String pid = Utilities.generateRandomString(8);
        UserAccount userAccount = new UserAccount(Constant.USERNAME, Constant.PASSWORD, "", pid);
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
        UserAccount userAccount = new UserAccount(Constant.USERNAME, "", "", "");
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
        System.out.println("TC09 - User create and activate account");

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Click on \"Create an account\"");
        RegisterPage registerPage = homePage.gotoRegisterPage();

        System.out.println("3. Enter valid information into all fields");
        System.out.println("4. Click on \"Register\" button");
        String randomEmail = Utilities.generateRandomEmail();
        UserAccount userAccount = new UserAccount(randomEmail, Constant.PASSWORD, "", Constant.PID);
        registerPage.register(userAccount);

        System.out.println("\"Thank you for registering your account\" is shown");
        String actualMsg = registerPage.getLblSuccessMsg().getText();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("5. Get email information (webmail address, mailbox and password) and navigate to that webmail");
        Utilities.switchToLatestWindow();

        MailPage mailPage = new MailPage();
        mailPage.open();

        System.out.println("6. Login to the mailbox");
        System.out.println("7. Open email with subject containing \"Please confirm your account\" and the email of the new account at step 3");
        System.out.println("8. Click on the activate link");
        registerPage = mailPage.confirmMail(randomEmail);

        System.out.println("Redirect to Railways page and message \"Registration Confirmed! You can now log in to the site\" is shown");
        String activationMsg = registerPage.getLblRegistrationConfirmedMsg().getText();
        String expectedActivationMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(activationMsg, expectedActivationMsg);
    }
}