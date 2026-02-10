package Railway;

import Constant.Constant;
import DataObjects_Railway.UserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        bookTicketPage.bookTicketForm(2, "Nha Trang", "Huế", "Soft bed with air conditioner", "1");

        System.out.println("Message \"Ticket booked successfully!\" displays.");
        String actualMsg = bookTicketPage.getLblTicketBookedSuccessMsg().getText();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("Ticket information display correctly (Depart Date, Depart Station, Arrive Station, Seat Type, Amount)");
        int daysToAdd = 3;
        String departStation = "Nha Trang";
        String arriveStation = "Huế";
        String seatType = "Soft bed with air conditioner";
        String ticketAmount = "1";

        String expectedDate = LocalDate.now().plusDays(daysToAdd)
                .format(DateTimeFormatter.ofPattern("M/d/yyyy"));

        Assert.assertEquals(bookTicketPage.getLblTicketBookedSuccessMsg().getText(), expectedMsg);
        Assert.assertEquals(bookTicketPage.getCellDepartStation().getText(), departStation);
        Assert.assertEquals(bookTicketPage.getCellArriveStation().getText(), arriveStation);
        Assert.assertEquals(bookTicketPage.getCellSeatType().getText(), seatType);
        Assert.assertEquals(bookTicketPage.getCellAmount().getText(), ticketAmount);
        Assert.assertEquals(bookTicketPage.getCellDepartDate().getText(), expectedDate);
    }

    @Test
    public void TC13(){
        System.out.println("User can book many tickets at a time");
        System.out.println("Pre-condition: an actived account is existing");

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();
        UserAccount userAccount = new UserAccount("kpaqlthe@sharklasers.com", Constant.PASSWORD, "", "");

        System.out.println("2. Login with a valid account ");
        LoginPage loginPage = homePage.gotoLoginPage();
        homePage = loginPage.login(userAccount);

        System.out.println("3. Click on \"Book ticket\" tab");
        BookTicketPage bookTicketPage = homePage.gotoTabBookTicketPage();

        System.out.println("4. Select the next 25 days from \"Depart date\"");
        System.out.println("5. Select \"Nha Trang\" for \"Depart from\" and \"Sài Gòn\" for \"Arrive at\".");
        System.out.println("6. Select \"Soft seat with air conditioner\" for \"Seat type\"");
        System.out.println("7. Select \"5\" for \"Ticket amount\"");
        System.out.println("8. Click on \"Book ticket\" button");
        bookTicketPage.bookTicketForm(25, "Nha Trang", "Sài Gòn", "Soft seat with air conditioner", "5");

        System.out.println("Message \"Ticket booked successfully!\" displays.");
        String actualMsg = bookTicketPage.getLblTicketBookedSuccessMsg().getText();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("Ticket information display correctly (Depart Date, Depart Station, Arrive Station, Seat Type, Amount)");
        int daysFromNow = 24;
        String depart = "Nha Trang";
        String arrive = "Sài Gòn";
        String seat = "Soft seat with air conditioner";
        String amount = "5";

        String expectedDepartDate = LocalDate.now().plusDays(daysFromNow)
                .format(DateTimeFormatter.ofPattern("M/d/yyyy"));

        Assert.assertEquals(bookTicketPage.getCellDepartStation().getText(), depart);
        Assert.assertEquals(bookTicketPage.getCellArriveStation().getText(), arrive);
        Assert.assertEquals(bookTicketPage.getCellSeatType().getText(), seat);
        Assert.assertEquals(bookTicketPage.getCellDepartDate().getText(), expectedDepartDate);
        Assert.assertEquals(bookTicketPage.getCellAmount().getText(), amount);
    }

    @Test
    public void TC14(){
        System.out.println("User can check price of ticket from Timetable");
        System.out.println("Pre-condition: an actived account is existing");

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();
        UserAccount userAccount = new UserAccount(Constant.USERNAME, Constant.PASSWORD, "", "");

        System.out.println("2. Login with a valid account");
        LoginPage loginPage = homePage.gotoLoginPage();
        homePage = loginPage.login(userAccount);

        System.out.println("3. Click on \"Timetable\" tab");
        BookTicketPage bookTicketPage = homePage.gotoTabTimeTable();

        System.out.println("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
        bookTicketPage.trainTimetable("Đà Nẵng", "Sài Gòn");

        System.out.println("\"Ticket Price\" page is loaded.");
        String actualMsg = bookTicketPage.getLblTicketPriceTitle().getText();
        String expectedMsg = "Ticket Price";
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("Ticket table shows \"Ticket price from Đà Nẵng to Sài Gòn\".");
        String actualSubHeader = bookTicketPage.getLblTableTicketSmall().getText();
        String expectedSubHeader = "Ticket price from Đà Nẵng to Sài Gòn";
        Assert.assertEquals(actualSubHeader, expectedSubHeader);

        System.out.println("Price for each seat displays correctly\n" + "HS = 310000, SS = 335000, SSC = 360000, HB = 410000, SB = 460000, SBC = 510000");
        String hs = "310000";
        String ss = "335000";
        String ssc = "360000";
        String hb = "410000";
        String sb = "460000";
        String sbc = "510000";

        Assert.assertEquals(bookTicketPage.getLblPriceHS().getText(), hs);
        Assert.assertEquals(bookTicketPage.getLblPriceSS().getText(), ss);
        Assert.assertEquals(bookTicketPage.getLblPriceSSC().getText(), ssc);
        Assert.assertEquals(bookTicketPage.getLblPriceHB().getText(), hb);
        Assert.assertEquals(bookTicketPage.getLblPriceSB().getText(), sb);
        Assert.assertEquals(bookTicketPage.getLblPriceSBC().getText(), sbc);
    }

    @Test
    public void TC15(){
        System.out.println("User can book ticket from Timetable");
        System.out.println("Pre-condition: an actived account is existing");
        int daysFromNow = 3;
        String depart = "Quảng Ngãi";
        String arrive = "Huế";
        String seat = "Hard seat";
        String amount = "5";

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();
        UserAccount userAccount = new UserAccount("wnroumff@sharklasers.com", Constant.PASSWORD, "", "");

        System.out.println("2. Login with a valid account");
        LoginPage loginPage = homePage.gotoLoginPage();
        homePage = loginPage.login(userAccount);

        System.out.println("3. Click on \"Timetable\" tab");
        BookTicketPage bookTicketPage = homePage.gotoTabTimeTable();

        System.out.println("4. Click on book ticket of route \"Quảng Ngãi\" to \"Huế\"");
        bookTicketPage.clickBookTicket(depart, arrive);

        System.out.println("5. Select Depart date = tomorrow");
        System.out.println("6. Select Ticket amount = 5");
        System.out.println("7. Click on \"Book ticket\" button");
        bookTicketPage.bookTicketTimeTable(daysFromNow, amount);

        System.out.println("Book ticket form is shown with the corrected \"depart from\" and \"Arrive at\"");
        String departFrom = "Quảng Ngãi";
        String arriveAt = "Huế";

        Assert.assertEquals(bookTicketPage.getSelectedDepartFrom(), departFrom);
        Assert.assertEquals(bookTicketPage.getSelectedArriveAt(), arriveAt);

        System.out.println("Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
        String actualMsg1 = bookTicketPage.getLblTicketBookedSuccessMsg().getText();
        String expectedMsg1 = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg1, expectedMsg1);

        String expectedDepartDate = LocalDate.now().plusDays(daysFromNow)
                .format(DateTimeFormatter.ofPattern("M/d/yyyy"));

        Assert.assertEquals(bookTicketPage.getCellDepartStation().getText(), depart);
        Assert.assertEquals(bookTicketPage.getCellArriveStation().getText(), arrive);
        Assert.assertEquals(bookTicketPage.getCellSeatType().getText(), seat);
        Assert.assertEquals(bookTicketPage.getCellDepartDate().getText(), expectedDepartDate);
        Assert.assertEquals(bookTicketPage.getCellAmount().getText(), amount);
    }
}