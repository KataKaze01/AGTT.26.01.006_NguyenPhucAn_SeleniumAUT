package Common;

import Constant.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;

public class Utilities {

    private static final String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomString(Integer length) {
        if (length == null || length <= 0) {
            throw new IllegalArgumentException("Length must be a positive integer");
        }

        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHANUMERIC.length());
            result.append(ALPHANUMERIC.charAt(index));
        }

        return result.toString();
    }

    public static String generateRandomEmail() {
        int usernameLength = 8 + random.nextInt(5); // 8 to 12
        String username = generateRandomString(usernameLength);

        String[] domains = {"sharklasers.com", "guerrillamail.info", "guerrillamail.biz", "guerrillamail.com", "guerrillamail.de", "guerrillamail.net", "guerrillamail.org", "guerrillamailblock.com"};
        String domain = domains[random.nextInt(domains.length)];

        return username + "@" + domain;
    }

    public static void waitForElementVisibility(WebDriver driver, WebElement element, Duration time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementVisibility(WebDriver driver, WebElement element) {
        waitForElementVisibility(driver, element, Duration.ofSeconds(10));
    }

    public static void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});", element);
    }


    public static By waitForClickable(By locator, Duration timeout){
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return locator;
    }

    public static By waitForClickable(By locator){
        return waitForClickable(locator, Constant.TIMEOUT);
    }

    public static WebElement waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIMEOUT);

        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            Constant.WEBDRIVER.navigate().refresh();

            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
    }

    public static void waitForOptionPresent(By selectLocator, String optionText, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, timeout);
        wait.until(driver -> {
	        Select select = new Select(driver.findElement(selectLocator));
	        return select.getOptions().stream().anyMatch(o -> o.getText().trim().equals(optionText));
	    });
    }

    public static void switchToWindow(int index){
        ArrayList<String> tabs = new ArrayList<>(Constant.WEBDRIVER.getWindowHandles());
        Constant.WEBDRIVER.switchTo().window(tabs.get(index));
    }

    public static void switchToLatestWindow(){
        ArrayList<String> tabs = new ArrayList<>(Constant.WEBDRIVER.getWindowHandles());
        Constant.WEBDRIVER.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static void click(By locator) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }


}