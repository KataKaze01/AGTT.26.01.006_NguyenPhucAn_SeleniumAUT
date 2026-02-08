package Railway;

import Common.Utilities;
import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResetPasswordTest extends BaseTest {
    @Test
    public void TC10(){
        System.out.println("Reset password shows error if the new password is same as current");
        System.out.println("Pre-condition: an actived account is existing");

        System.out.println("1. Navigate to QA Railway Login page");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        System.out.println("2. Click on \"Forgot Password page\" link");
        System.out.println("3. Enter the email address of the activated account");
        System.out.println("4. Click on \"Send Instructions\" button");
        UserAccount userAccount = new UserAccount("hellof82723@sharklasers.com", Constant.PASSWORD, "");
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.resetPassword(userAccount);

        Utilities.switchToLatestWindow();

        System.out.println("5. Login to the mailbox (the same mailbox when creating account) ");
        MailPage mailPage = new MailPage();
        mailPage.open();

        System.out.println("6. Open email with subject contaning \"Please reset your password\" and the email of the account at step 3");
        System.out.println("7. Click on reset link");
        resetPasswordPage = mailPage.confirmResetPassword(userAccount);

        System.out.println("Redirect to Railways page and Form \"Password Change Form\" is shown with the reset password token");
        String actualMsg = resetPasswordPage.getPasswordChangeForm();
        String expectedMsg = "Password Change Form";
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("8. Input same password into 2 fields  \"new password\" and \"confirm password\"");
        System.out.println("9. Click Reset Password");
        resetPasswordPage.passwordChangeForm(userAccount);

        System.out.println("Message \"The new password cannot be the same with the current password\" is shown");
        String actualConfirmMsg = resetPasswordPage.getLblResetPasswordErrorMsg().getText();
        String expectedConfirmMsg = "The new password cannot be the same with the current password";
        Assert.assertEquals(actualConfirmMsg, expectedConfirmMsg);

    }
}