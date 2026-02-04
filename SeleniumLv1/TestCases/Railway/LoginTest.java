    package Railway;

    import Common.Utilities;
    import Constant.Constant;
    import DataObjects_Railway.UserAccount;
    import org.testng.Assert;
    import org.testng.annotations.Test;

    public class LoginTest extends BaseTest {

        @Test
        public void TC01(){
            System.out.println("TC01 - User can log into Railway with valid username and password");
            System.out.println("1. Navigate to QA Railway Website");
            HomePage homePage = new HomePage();
            UserAccount userAccount = new UserAccount(Constant.USERNAME, Constant.PASSWORD, "");
            homePage.open();

            System.out.println("2. Click on Login tab");
            LoginPage loginPage = homePage.gotoLoginPage();

            System.out.println("3. Enter valid Email and Password");
            System.out.println("4. Click on Login button");
            homePage = loginPage.login(userAccount);
            String actualMsg =  homePage.getWelcomeMessage();
            String expectedMsg = "Welcome " + Constant.USERNAME;

            Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        }

        @Test
        public void TC02(){
            System.out.println("TC02 - User cannot login with blank 'Username' textbox");
            System.out.println("1. Navigate to QA Railway Website");
            HomePage homePage = new HomePage();
            homePage.open();

            System.out.println("2. Click on Login tab");
            LoginPage loginPage = homePage.gotoLoginPage();

            System.out.println("3. User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox");
            System.out.println("4. Click on Login button");
            loginPage.login("", Constant.PASSWORD);
            String actualMsg = loginPage.getErrorMessage();
            String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

            Assert.assertEquals(actualMsg, expectedMsg);
        }

        @Test
        public void TC03(){
            System.out.println("TC03 - User cannot log into Railway with invalid password");
            System.out.println("1. Navigate to QA Railway Website");
            HomePage homePage = new HomePage();
            homePage.open();

            System.out.println("2. Click on 'Login' tab");
            LoginPage loginPage = homePage.gotoLoginPage();

            System.out.println("3. Enter valid Email and invalid Password");
            System.out.println("4. Click on Login button");
            String invalidPassword  = Utilities.generateRandomString(8);
            loginPage.login(Constant.USERNAME, invalidPassword);

            String actualMsg = loginPage.getLblLoginErrorMsg().getText();
            String expectedMsg = "There was a problem with your login and/or errors exist in your form. ";

            Assert.assertEquals(actualMsg, expectedMsg);
        }
    }