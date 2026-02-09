package Railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookTicketPage extends GeneralPage {

    //Locators
    private final By cbbDepartDate = By.xpath("//select[@name='Date']");
    private final By cbbDepartFrom = By.xpath("//select[@name='DepartStation']");
    private final By cbbArriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By cbbSeatType = By.xpath("//select[@name='SeatType']");
    private final By cbbTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By btnBookTicket = By.xpath("//input[@type='submit']");
    private final By lblTicketBookedSuccessMsg = By.xpath("//div[@id='content']/h1");
    private final By cellDepartStation = By.xpath("//tr[@class='OddRow']/td[1]");
    private final By cellArriveStation = By.xpath("//tr[@class='OddRow']/td[2]");
    private final By cellSeatType = By.xpath("//tr[@class='OddRow']/td[3]");
    private final By cellDepartDate = By.xpath("//tr[@class='OddRow']/td[4]");
    private final By cellAmount = By.xpath("//tr[@class='OddRow']/td[7]");
    private final By lblDepartStation = By.xpath("//table//th[text()='Depart Station']");


    //Elements
    public WebElement getCbbDepartDate(){
        Utilities.waitForClickable(cbbDepartDate);
        return Constant.WEBDRIVER.findElement(cbbDepartDate);
    }

    public WebElement getCbbDepartFrom(){

        return Constant.WEBDRIVER.findElement(cbbDepartFrom);
    }

    public WebElement getCbbArriveAt(){
        Utilities.waitForClickable(cbbArriveAt);
        return Constant.WEBDRIVER.findElement(cbbArriveAt);
    }

    public WebElement getCbbSeatType(){
        Utilities.waitForClickable(cbbSeatType);
        return Constant.WEBDRIVER.findElement(cbbSeatType);
    }

    public WebElement getCbbTicketAmount(){
        Utilities.waitForClickable(cbbTicketAmount);
        return Constant.WEBDRIVER.findElement(cbbTicketAmount);
    }

    public WebElement getBtnBookTicket(){
        Utilities.waitForClickable(btnBookTicket);
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    public WebElement getLblTicketBookedSuccessMsg(){
        return Utilities.waitForVisible(lblTicketBookedSuccessMsg);
    }

    public WebElement getCellDepartStation(){
        return Utilities.waitForVisible(cellDepartStation);
    }

    public WebElement getCellArriveStation(){
        return Utilities.waitForVisible(cellArriveStation);
    }

    public WebElement getCellSeatType(){
        return Utilities.waitForVisible(cellSeatType);
    }

    public WebElement getCellDepartDate(){
        return Utilities.waitForVisible(cellDepartDate);
    }

    public WebElement getCellAmount(){
        return Utilities.waitForVisible(cellAmount);
    }

    public WebElement getLblDepartStation(){
        return Utilities.waitForVisible(lblDepartStation);
    }

    //Methods
    public void selectNextTwoDays(){
        WebElement element = getCbbDepartDate();
        String targetDateText = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("M/dd/yyyy"));

        System.out.println(targetDateText);
        Select select = new Select(element);
        select.selectByVisibleText(targetDateText);
    }

    public void selectDepartFrom(){
        WebElement departElement = getCbbDepartFrom();

        Select selectDepart = new Select(departElement);
        selectDepart.selectByVisibleText("Nha Trang");
    }

    public void selectArriveAt(){
        WebElement arriveElement = getCbbArriveAt();
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(arriveElement));
        arriveElement = getCbbArriveAt();
        Select selectArrive = new Select(arriveElement);
        selectArrive.selectByVisibleText("Huế");
    }

    public void selectSeatType(){
        WebElement seatElement = getCbbSeatType();

        Select selectSeat = new Select(seatElement);
        selectSeat.selectByVisibleText("Soft bed with air conditioner");
    }

    public void selectTicketAmount(){
        WebElement ticketElement = getCbbTicketAmount();

        Select selectTicket = new Select(ticketElement);
        selectTicket.selectByVisibleText("1");
    }

    public HomePage bookTicketForm(){
        Utilities.scrollToElement(getCbbArriveAt());
        selectNextTwoDays();
        selectDepartFrom();
//        Utilities.waitForOptionPresent(cbbArriveAt, getCellArriveStation().getText(), Constant.TIMEOUT);
        selectArriveAt();
        selectSeatType();
        selectTicketAmount();
        getBtnBookTicket().click();
        Utilities.waitForClickable(lblDepartStation);
        Utilities.scrollToElement(getLblDepartStation());
        return new HomePage();
    }
}