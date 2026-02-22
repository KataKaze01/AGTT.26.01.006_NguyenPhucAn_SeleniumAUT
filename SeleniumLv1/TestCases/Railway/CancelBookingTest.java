package Railway;

import Constant.Constant;
import DataObjects_Railway.BookTicket;
import DataObjects_Railway.UserAccount;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Enum.Station;
import Enum.SeatType;

public class CancelBookingTest extends BaseTest {
    @Test
    public void TC16(){
        System.out.println("User can cancel a ticket");
        System.out.println("Pre-condition: an actived account is existing");
        int dayToAdd = 6;
        String ticketAmount = "1";

        System.out.println("1. Navigate to QA Railway Website");
        HomePage homePage = new HomePage();
        homePage.open();
        UserAccount userAccount = new UserAccount(Constant.USERNAME, Constant.PASSWORD, "", "");

        System.out.println("2. Login with a valid account");
        LoginPage loginPage = homePage.gotoLoginPage();
        homePage = loginPage.login(userAccount);

        System.out.println("3. Book a ticket");
        BookTicketPage bookTicketPage = homePage.gotoTabBookTicketPage();
        String dateSelected = bookTicketPage.getSelectedDepartDate();
        String expectedDate = LocalDate.parse(dateSelected, DateTimeFormatter.ofPattern("M/d/yyyy")).plusDays(dayToAdd).format(DateTimeFormatter.ofPattern("M/d/yyyy"));
        BookTicket bookTicket = new BookTicket(expectedDate, Station.NHATRANG.getValue(), Station.HUE.getValue(), SeatType.SOFTBEDWITHAIRCONDITIONER.getValue(), ticketAmount);
        bookTicketPage.bookTicketForm(bookTicket);

        System.out.println("4. Click on \"My ticket\" tab");
        CancelBookingPage cancelBookingPage = homePage.gotoMyTicketPage();

        System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        cancelBookingPage.clickCancel(Station.NHATRANG.getValue(), Station.HUE.getValue(), SeatType.SOFTBEDWITHAIRCONDITIONER.getValue(), "2/21/2026");

        System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();

        System.out.println("The canceled ticket is disappeared.");

    }
}