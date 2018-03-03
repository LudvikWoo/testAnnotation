package com.guoyasoft.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserEngine {
    public static WebDriver startupChrome() {
        System.setProperty("webdriver.chrome.driver",
                "C:/software/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
    
    public static void shutdownChrome(WebDriver driver) {  
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        System.out.println( "Closing browser...");  
        driver.quit();  
    } 
}
