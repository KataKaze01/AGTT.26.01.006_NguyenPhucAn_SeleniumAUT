package Constant;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://saferailway.somee.com/Page/HomePage.cshtml";
    public static final String GUERILLAMAIL_URL = "https://www.guerrillamail.com/inbox";
    public static final String USERNAME = "katakazeno1@gmail.com";
    public static final String PASSWORD = "12345678";
    public static final String PID = "54234231";
    public static final Duration TIMEOUT = Duration.ofSeconds(60);
}