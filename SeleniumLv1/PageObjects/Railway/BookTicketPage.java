package Railway;

import Common.Utilities;
import Constant.Constant;
import DataObjects_Railway.BookTicket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    private String btnCheckPriceTimeTable = "//table[@class='MyTable WideTable']//td[.='%s']/following-sibling::td[.='%s']/following-sibling::td//a[.='check price']";
    private String btnBookTicketTimeTable = "//table[@class='MyTable WideTable']//td[.='%s']/following-sibling::td[.='%s']/following-sibling::td//a[.='book ticket']";
    private final By lblTicketPriceTitle = By.xpath("//div[@id='content']//h1");
    private final By lblTableTicketSmall = By.xpath("//th[@colspan='7' and contains(text(),'Ticket price from')]");
    private final By lblPriceHS = By.xpath("//tr[th[contains(text(),'Price')]]/td[1]");
    private final By lblPriceSS = By.xpath("//tr[th[contains(text(),'Price')]]/td[2]");
    private final By lblPriceSSC = By.xpath("//tr[th[contains(text(),'Price')]]/td[3]");
    private final By lblPriceHB = By.xpath("//tr[th[contains(text(),'Price')]]/td[4]");
    private final By lblPriceSB = By.xpath("//tr[th[contains(text(),'Price')]]/td[5]");
    private final By lblPriceSBC = By.xpath("//tr[th[contains(text(),'Price')]]/td[6]");

    //Elements
    private WebElement getCbbDepartDate(){
        Utilities.waitForClickable(cbbDepartDate);
        return Constant.WEBDRIVER.findElement(cbbDepartDate);
    }

    private WebElement getCbbDepartFrom(){
        Utilities.waitForClickable(cbbDepartFrom);
        return Constant.WEBDRIVER.findElement(cbbDepartFrom);
    }

    private WebElement getCbbArriveAt(){
        Utilities.waitForClickable(cbbArriveAt);
        return Constant.WEBDRIVER.findElement(cbbArriveAt);
    }

    private WebElement getCbbSeatType(){
        Utilities.waitForClickable(cbbSeatType);
        return Constant.WEBDRIVER.findElement(cbbSeatType);
    }

    private WebElement getCbbTicketAmount(){
        Utilities.waitForClickable(cbbTicketAmount);
        return Constant.WEBDRIVER.findElement(cbbTicketAmount);
    }

    private WebElement getBtnBookTicket(){
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

    public WebElement getCellAmountTicket(){
        return Utilities.waitForVisible(cellAmount);
    }

    public WebElement getLblDepartStation(){
        return Utilities.waitForVisible(lblDepartStation);
    }

    public WebElement getBtnCheckPriceTimeTable(String depart, String arrive){
        By locator = By.xpath(String.format(btnCheckPriceTimeTable, depart, arrive));
        Utilities.waitForClickable(locator);
        return Constant.WEBDRIVER.findElement(locator);
    }

    public WebElement getBtnBookTicketTimeTable(String depart, String arrive){
        By locator = By.xpath(String.format(btnBookTicketTimeTable, depart, arrive));
        Utilities.waitForClickable(locator);
        return Constant.WEBDRIVER.findElement(locator);
    }

    public WebElement getLblTicketPriceTitle(){
        return Utilities.waitForVisible(lblTicketPriceTitle);
    }

    public WebElement getLblTableTicketSmall() {
        return Utilities.waitForVisible(lblTableTicketSmall);
    }

    public WebElement getLblPriceHS(){
        return Utilities.waitForVisible(lblPriceHS);
    }

    public WebElement getLblPriceSS(){
        return Utilities.waitForVisible(lblPriceSS);
    }

    public WebElement getLblPriceSSC(){
        return Utilities.waitForVisible(lblPriceSSC);
    }

    public WebElement getLblPriceHB(){
        return Utilities.waitForVisible(lblPriceHB);
    }

    public WebElement getLblPriceSB(){
        return Utilities.waitForVisible(lblPriceSB);
    }

    public WebElement getLblPriceSBC(){
        return Utilities.waitForVisible(lblPriceSBC);
    }

    //Methods
    public String getSelectedDepartDate() {
        WebElement departDate = getCbbDepartDate();
        Select select = new Select(departDate);
        return select.getFirstSelectedOption().getText();
    }

    public String getTicketBookedSuccessMsg(){return this.getLblTicketBookedSuccessMsg().getText();}

    public String getDepartDateText(){return this.getCellDepartDate().getText();}

    public String getDepartStationText(){return this.getCellDepartStation().getText();}

    public String getArriveStationText(){return this.getCellArriveStation().getText();}

    public String getSeatTypeText(){return this.getCellSeatType().getText();}

    public String getAmountTicketText(){return this.getCellAmountTicket().getText();}

    public String getTicketPriceTitle(){return this.getLblTicketPriceTitle().getText();}

    public String getTableTicketSmall(){return this.getLblTableTicketSmall().getText();}

    public String getPriceHS(){return this.getLblPriceHS().getText();}

    public String getPriceSS(){return this.getLblPriceSS().getText();}

    public String getPriceSSC(){return this.getLblPriceSSC().getText();}

    public String getPriceHB(){return this.getLblPriceHB().getText();}

    public String getPriceSB(){return this.getLblPriceSB().getText();}

    public String getPriceSBC(){return this.getLblPriceSBC().getText();}

    public void selectDepartDate(String date){
        WebElement element = getCbbDepartDate();
        Select select = new Select(element);
        select.selectByVisibleText(date);
    }

    public void selectDepartFrom(String stationName){
        new Select(getCbbDepartFrom()).selectByVisibleText(stationName);
    }

    public String getSelectedDepartFrom() {
        Select select = new Select(getCbbDepartFrom());
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedArriveAt() {
        Select select = new Select(getCbbArriveAt());
        return select.getFirstSelectedOption().getText();
    }

    public void selectArriveAt(String stationName){
        WebElement arriveElement = getCbbArriveAt();
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(arriveElement));
        arriveElement = getCbbArriveAt();
        Select selectArrive = new Select(arriveElement);
        selectArrive.selectByVisibleText(stationName);
    }

    public void selectSeatType(String seatType){
        new Select(getCbbSeatType()).selectByVisibleText(seatType);
    }

    public void selectTicketAmount(String amount){
        new Select(getCbbTicketAmount()).selectByVisibleText(amount);
    }

    public HomePage bookTicketForm(BookTicket bookTicket){
        Utilities.scrollToElement(getCbbArriveAt());
        selectDepartDate(bookTicket.getDepartDate());
        selectDepartFrom(bookTicket.getDepartFrom());
        selectArriveAt(bookTicket.getArriveAt());
        selectSeatType(bookTicket.getSeatType());
        selectTicketAmount(bookTicket.getTicketAmount());
        getBtnBookTicket().click();
        Utilities.waitForClickable(lblDepartStation);
        Utilities.scrollToElement(getLblDepartStation());
        return new HomePage();
    }

    public void clickCheckPrice(String depart, String arrive){
        WebElement btn = getBtnCheckPriceTimeTable(depart, arrive);
        Utilities.scrollToElement(btn);
        btn.click();
    }

    public HomePage trainTimetable(String depart, String arrive){
        clickCheckPrice(depart, arrive);
        return new HomePage();
    }

    private By getBtnBookTicketTimeTableLocator(String depart, String arrive) {
        return By.xpath(String.format(btnBookTicketTimeTable, depart, arrive));
    }

    public HomePage clickBookTicket(String depart, String arrive){
        By btnLocator = getBtnBookTicketTimeTableLocator(depart, arrive);
        WebElement btn = getBtnBookTicketTimeTable(depart, arrive);
        Utilities.scrollToElement(btn);
        Utilities.waitForClickable(btnLocator);
        btn.click();
        return new HomePage();
    }

    public HomePage bookTicketForm(String departDate, String amountTicket){
        Utilities.scrollToElement(getCbbTicketAmount());
        selectDepartDate(departDate);
        selectTicketAmount(amountTicket);
        getBtnBookTicket().click();
        Utilities.scrollToElement(getLblDepartStation());
        return new HomePage();
    }
}