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

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();
        UserAccount userAccount = new UserAccount(Constant.USERNAME, Constant.PASSWORD, "", "");

        System.out.println("2. Login with a valid account ");
        LoginPage loginPage = homePage.gotoLoginPage();
        homePage = loginPage.login(userAccount);

        System.out.println("3. Click on \"Book ticket\" tab");
        BookTicketPage bookTicketPage = homePage.gotoTabBookTicketPage();

        System.out.println("4. Select the next 2 days from \"Depart date\"");
        System.out.println("5. Select Depart from \"Nha Trang\" and Arrive at \"Huế\"");
        System.out.println("6. Select \"Soft bed with air conditioner\" for \"Seat type\"");
        System.out.println("7. Select \"1\" for \"Ticket amount\"");
        System.out.println("8. Click on \"Book ticket\" button");
        bookTicketPage.bookTicketForm();

        System.out.println("Message \"Ticket booked successfully!\" displays.");
        String actualMsg = bookTicketPage.getLblTicketBookedSuccessMsg().getText();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("Ticket information display correctly (Depart Date, Depart Station, Arrive Station, Seat Type, Amount)");
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