package Railway;

import Common.Utilities;
import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class CancelBookingPage extends GeneralPage {

    //Locators
    private final String btnCancel = "//table[@class='MyTable']//td[.='%s']/following-sibling::td[.='%s']/following-sibling::td[.='%s']/following-sibling::td[.='%s']/following-sibling::td//input[@value='Cancel']";
    private final String myTicketTableItemXpath = "//td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]/input";

    //Elements
    public WebElement getBtnCancel(String depart, String arrive, String seat, String dateDepart){
        By locator = By.xpath(String.format(btnCancel, depart, arrive, seat, dateDepart));
        Utilities.waitForClickable(locator);
        return Constant.WEBDRIVER.findElement(locator);
    }

    public WebElement getMyTicketTableItemXpath(String departStation, String arriveStation, String seatType, String departDate, String bookDate){
        By locator = By.xpath(String.format(myTicketTableItemXpath, departStation, arriveStation, seatType, departDate, bookDate));
        return Utilities.waitForVisible(locator);
    }

    //Methods
    public By getBtnCancelTbl(String depart, String arrive, String seat, String dateDepart) {
        return By.xpath(String.format(btnCancel, depart, arrive, seat, dateDepart));
    }

    public HomePage clickCancel(String depart, String arrive, String seat, String dateDepart){
        By btnLocator = getBtnCancelTbl(depart, arrive, seat, dateDepart);
        WebElement btn = getBtnCancel(depart, arrive, seat, dateDepart);
        Utilities.scrollToElement(btn);
        Utilities.waitForClickable(btnLocator);
        btn.click();

        return new HomePage();
    }

    public String getTicketTableItemXpath(String departStation, String arriveStation, String seatType, String departDate, String bookDate){
        return getMyTicketTableItemXpath(departStation, arriveStation, seatType, departDate, bookDate).getAttribute("value");
    }

}