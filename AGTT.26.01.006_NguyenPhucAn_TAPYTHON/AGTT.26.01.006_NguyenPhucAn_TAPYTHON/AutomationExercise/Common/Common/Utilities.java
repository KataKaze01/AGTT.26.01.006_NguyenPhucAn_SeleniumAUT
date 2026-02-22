package Common;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class Utilities {

    private static final String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom random = new SecureRandom();
    private static final String[] FIRSTNAME = {
            "An", "Binh", "Chi", "Dung", "Ha",
            "Huy", "Lan", "Linh", "Minh", "Nam"
    };
    private static final String[] LASTNAMES = {
            "Nguyen", "Tran", "Le", "Pham", "Hoang"
    };


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
        int usernameLength = 5 + random.nextInt(5); // 8 to 12
        String username = generateRandomString(usernameLength);

        String[] domains = {"test.com"};
        String domain = domains[random.nextInt(domains.length)];

        return username + "_" + "@" + domain;
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

    public static void switchToLatestWindow(){
        ArrayList<String> tabs = new ArrayList<>(Constant.WEBDRIVER.getWindowHandles());
        Constant.WEBDRIVER.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static void click(By locator) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static WebElement getElement(By locator) {
        return waitForVisible(locator);
    }

    public static WebElement waitForElementVisible(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementVisible(By locator) {
        return waitForElementVisible(locator, Constant.TIMEOUT);
    }
    public static WebElement safeWaitForElementVisible(By locator, Duration timeout) {
        try {
            return waitForElementVisible(locator, timeout);
        } catch (TimeoutException e) {
            return  null;
        }
    }
    public static WebElement safeWaitForElementVisible(By locator) {
        return safeWaitForElementVisible(locator, Constant.TIMEOUT);
    }
    public static WebElement waitForElementPresent(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
    public static WebElement waitForElementPresent(By locator) {
        return waitForElementPresent(locator, Constant.TIMEOUT);
    }
    public static WebElement safeWaitForElementPresent(By locator, Duration timeout) {
        try {
            return waitForElementPresent(locator, timeout);
        } catch (TimeoutException e) {
            return  null;
        }
    }
    public static WebElement safeWaitForElementPresent(By locator) {
        return safeWaitForElementPresent(locator, Constant.TIMEOUT);
    }
    public static void waitForPageLoad(Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, timeout);
        wait.until(webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState"), "complete"));
    }
    public static void waitForPageLoad() {
        waitForPageLoad(Constant.TIMEOUT);
    }

    public static WebElement findElement(By locator, Duration pageLoadTimeout, Duration elementTimeout) {
        waitForPageLoad(pageLoadTimeout);
        // Wait to prevent flaky scenarios
        waitForElementPresent(locator, elementTimeout);
        return Constant.WEBDRIVER.findElement(locator);
    }

    public static WebElement findElement(By locator, Duration elementTimeout) {
        return findElement(locator, Constant.TIMEOUT, elementTimeout);
    }

    public static WebElement findElement(By locator) {
        return findElement(locator, Constant.TIMEOUT);
    }

    public static boolean isElementPresent(By locator) {
        try {
            Constant.WEBDRIVER.findElement(locator);
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    public static void disableGoogleAd() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        String advertisementFullscreenContainer = "//ins[@class='adsbygoogle adsbygoogle-noablate' and contains(@style, '100vw')]";
        String iframeAdvertisementContainer = "//iframe[contains(@id, 'aswift')]";
        By iframeAdvertisement = By.xpath("//iframe[@id='ad_iframe']");
        By btnCloseAdvertisement = By.xpath("//div[contains(@id, 'dismiss-button') or contains(@id, 'close-button')]");

        WebElement advertisement = safeWaitForElementVisible(By.xpath(advertisementFullscreenContainer), Duration.ofSeconds(1));
        if(advertisement != null) {
            Constant.WEBDRIVER.switchTo().frame(Utilities.findElement(By.xpath(advertisementFullscreenContainer + iframeAdvertisementContainer)));
            if(isElementPresent(btnCloseAdvertisement)) {
                js.executeScript("arguments[0].click();", Utilities.findElement(btnCloseAdvertisement));
            } else {
                Constant.WEBDRIVER.switchTo().frame(Utilities.findElement(iframeAdvertisement));
                js.executeScript("arguments[0].click();", Utilities.findElement(btnCloseAdvertisement));
            }
            Constant.WEBDRIVER.switchTo().defaultContent();
        }
    }

    public static int randomInt(int start, int end) {
        return start + random.nextInt(end - start);
    }

    public static int randomInt(int end) {
        return randomInt(1, end);
    }
}