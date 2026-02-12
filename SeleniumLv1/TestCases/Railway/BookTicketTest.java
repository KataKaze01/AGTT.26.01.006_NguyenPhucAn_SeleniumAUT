package Railway;

import Constant.Constant;
import DataObjects_Railway.BookTicket;
import DataObjects_Railway.UserAccount;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Enum.Station;
import Enum.SeatType;

public class BookTicketTest extends BaseTest {

    @Test
    public void TC12(){
        System.out.println("User can book 1 ticket at a time");
        System.out.println("Pre-condition: an actived account is existing");
        int daysToAdd = 2;
        String ticketAmount = "1";

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();

        UserAccount userAccount = new UserAccount("udibszpi@sharklasers.com", Constant.PASSWORD, "", "");

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
        String dateSelected = bookTicketPage.getSelectedDepartDate();
        String expectedDate = LocalDate.parse(dateSelected, DateTimeFormatter.ofPattern(Constant.FORMATDATETIME)).plusDays(daysToAdd).format(DateTimeFormatter.ofPattern(Constant.FORMATDATETIME));
        BookTicket bookTicket = new BookTicket(expectedDate, Station.NHATRANG.getValue(), Station.HUE.getValue(), SeatType.SOFTBEDWITHAIRCONDITIONER.getValue(), ticketAmount);

        bookTicketPage.bookTicketForm(bookTicket);

        System.out.println("Message \"Ticket booked successfully!\" displays.");
        String actualMsg = bookTicketPage.getTicketBookedSuccessMsg();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("Ticket information display correctly (Depart Date, Depart Station, Arrive Station, Seat Type, Amount)");
        Assert.assertEquals(bookTicketPage.getDepartDateText(), expectedDate);
        Assert.assertEquals(bookTicketPage.getDepartStationText(), Station.NHATRANG.getValue());
        Assert.assertEquals(bookTicketPage.getArriveStationText(), Station.HUE.getValue());
        Assert.assertEquals(bookTicketPage.getSeatTypeText(), SeatType.SOFTBEDWITHAIRCONDITIONER.getValue());
        Assert.assertEquals(bookTicketPage.getAmountTicketText(), ticketAmount);
    }

    @Test
    public void TC13(){
        System.out.println("User can book many tickets at a time");
        System.out.println("Pre-condition: an actived account is existing");
        int dayToAdd = 24;
        String amountTicket = "5";

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();
        UserAccount userAccount = new UserAccount("VpvRVze0@sharklasers.com", Constant.PASSWORD, "", "");

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
        String dateSelected = bookTicketPage.getSelectedDepartDate();
        String expectedDate = LocalDate.parse(dateSelected, DateTimeFormatter.ofPattern(Constant.FORMATDATETIME)).plusDays(dayToAdd).format(DateTimeFormatter.ofPattern(Constant.FORMATDATETIME));
        BookTicket bookTicket = new BookTicket(expectedDate, Station.NHATRANG.getValue(), Station.SAIGON.getValue(), SeatType.SOFTSEATWITHAIRCONDITIONER.getValue(), "5");
        bookTicketPage.bookTicketForm(bookTicket);

        System.out.println("Message \"Ticket booked successfully!\" displays.");
        String actualMsg = bookTicketPage.getLblTicketBookedSuccessMsg().getText();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("Ticket information display correctly (Depart Date, Depart Station, Arrive Station, Seat Type, Amount)");
        Assert.assertEquals(bookTicketPage.getDepartDateText(), expectedDate);
        Assert.assertEquals(bookTicketPage.getDepartStationText(), Station.NHATRANG.getValue());
        Assert.assertEquals(bookTicketPage.getArriveStationText(), Station.SAIGON.getValue());
        Assert.assertEquals(bookTicketPage.getSeatTypeText(), SeatType.SOFTSEATWITHAIRCONDITIONER.getValue());
        Assert.assertEquals(bookTicketPage.getAmountTicketText(), amountTicket);
    }

    @Test
    public void TC14(){
        System.out.println("User can check price of ticket from Timetable");
        System.out.println("Pre-condition: an actived account is existing");
        String hs = "310000";
        String ss = "335000";
        String ssc = "360000";
        String hb = "410000";
        String sb = "460000";
        String sbc = "510000";

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
        String actualMsg = bookTicketPage.getTicketPriceTitle();
        String expectedMsg = "Ticket Price";
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("Ticket table shows \"Ticket price from Đà Nẵng to Sài Gòn\".");
        String actualSubHeader = bookTicketPage.getTableTicketSmall();
        String expectedSubHeader = "Ticket price from Đà Nẵng to Sài Gòn";
        Assert.assertEquals(actualSubHeader, expectedSubHeader);

        System.out.println("Price for each seat displays correctly\n" + "HS = 310000, SS = 335000, SSC = 360000, HB = 410000, SB = 460000, SBC = 510000");
        Assert.assertEquals(bookTicketPage.getPriceHS(), hs);
        Assert.assertEquals(bookTicketPage.getPriceSS(), ss);
        Assert.assertEquals(bookTicketPage.getPriceSSC(), ssc);
        Assert.assertEquals(bookTicketPage.getPriceHB(), hb);
        Assert.assertEquals(bookTicketPage.getPriceSB(), sb);
        Assert.assertEquals(bookTicketPage.getPriceSBC(), sbc);
    }

    @Test
    public void TC15(){
        System.out.println("User can book ticket from Timetable");
        System.out.println("Pre-condition: an actived account is existing");
        int dayToAdd = 1;
        String amountTicket = "5";

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();
        UserAccount userAccount = new UserAccount("8qrqQD@guerrillamail.net", Constant.PASSWORD, "", "");

        System.out.println("2. Login with a valid account");
        LoginPage loginPage = homePage.gotoLoginPage();
        homePage = loginPage.login(userAccount);

        System.out.println("3. Click on \"Timetable\" tab");
        BookTicketPage bookTicketPage = homePage.gotoTabTimeTable();

        System.out.println("4. Click on book ticket of route \"Quảng Ngãi\" to \"Huế\"");
        bookTicketPage.clickBookTicket(Station.QUANGNGAI.getValue(), Station.HUE.getValue());

        System.out.println("Book ticket form is shown with the corrected \"depart from\" and \"Arrive at\"");
        Assert.assertEquals(bookTicketPage.getSelectedDepartFrom(), Station.QUANGNGAI.getValue());
        Assert.assertEquals(bookTicketPage.getSelectedArriveAt(), Station.HUE.getValue());

        System.out.println("5. Select Depart date = tomorrow");
        System.out.println("6. Select Ticket amount = 5");
        System.out.println("7. Click on \"Book ticket\" button");
        String dateSelected = bookTicketPage.getSelectedDepartDate();
        String expectedDate = LocalDate.parse(dateSelected, DateTimeFormatter.ofPattern(Constant.FORMATDATETIME)).plusDays(dayToAdd).format(DateTimeFormatter.ofPattern(Constant.FORMATDATETIME));
        bookTicketPage.bookTicketForm(expectedDate, amountTicket);

        System.out.println("Message \"Ticket booked successfully!\" displays.");
        String actualMsg1 = bookTicketPage.getTicketBookedSuccessMsg();
        String expectedMsg1 = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg1, expectedMsg1);

        System.out.println("Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
        Assert.assertEquals(bookTicketPage.getDepartDateText(), expectedDate);
        Assert.assertEquals(bookTicketPage.getDepartStationText(), Station.QUANGNGAI.getValue());
        Assert.assertEquals(bookTicketPage.getArriveStationText(), Station.HUE.getValue());
        Assert.assertEquals(bookTicketPage.getSeatTypeText(), SeatType.HARDSEAT.getValue());
        Assert.assertEquals(bookTicketPage.getAmountTicketText(), amountTicket);
    }
}