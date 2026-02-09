package Railway;

import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {

    @Test
    public void TC12(){
        System.out.println("User can book 1 ticket at a time");
        System.out.println("Pre-condition: an actived account is existing");

        HomePage homePage = new HomePage();
        homePage.open();
        UserAccount userAccount = new UserAccount(Constant.USERNAME, Constant.PASSWORD, "", "");

        LoginPage loginPage = homePage.gotoLoginPage();
        homePage = loginPage.login(userAccount);

        BookTicketPage bookTicketPage = homePage.gotoTabBookTicketPage();

        bookTicketPage.bookTicketForm();

        String actualMsg = bookTicketPage.getLblTicketBookedSuccessMsg().getText();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg);


        String actualDepartStation = bookTicketPage.getCellDepartStation().getText();
        String actualArriveStation = bookTicketPage.getCellArriveStation().getText();
        String actualSeatType = bookTicketPage.getCellSeatType().getText();
        String actualDepartDate = bookTicketPage.getCellDepartDate().getText();
        String actualAmount = bookTicketPage.getCellAmount().getText();

        String expectedDepartStation = "Nha Trang";
        String expectedArriveStation = "Huế";
        String expectedSeatType = "Soft bed with air conditioner";
        String expectedDepartDate = "2/12/2026";
        String expectedAmount = "1";

        Assert.assertEquals(actualDepartStation, expectedDepartStation);
        Assert.assertEquals(actualArriveStation, expectedArriveStation);
        Assert.assertEquals(actualSeatType, expectedSeatType);
        Assert.assertEquals(actualDepartDate, expectedDepartDate);
        Assert.assertEquals(actualAmount, expectedAmount);

    }
}