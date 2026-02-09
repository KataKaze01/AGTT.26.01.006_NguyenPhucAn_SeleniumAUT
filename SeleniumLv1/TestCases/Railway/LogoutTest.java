package Railway;

import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test
    public void TC06(){
        System.out.println("TC06 - User is redirected to Home page after logging out");
        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        System.out.println("2. Login with valid Email and Password");
        LoginPage loginPage = homePage.gotoLoginPage();
        UserAccount userAccount = new UserAccount(Constant.USERNAME, Constant.PASSWORD, "", "");
        loginPage.login(userAccount);

        System.out.println("Home page displays.");
        FAQPage faqPage = homePage.gotoFAQPage();

        System.out.println("\"Log out\" tab is disappeared.");
        homePage = faqPage.logout();
    }
}