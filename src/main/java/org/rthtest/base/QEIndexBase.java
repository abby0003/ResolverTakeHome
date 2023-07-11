package org.rthtest.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class QEIndexBase {

    public static WebDriver driver;
    static String usr_dir;

    public static long PAGE_LOAD_TIMEOUT = 10;
    public static long IMPLICIT_WAIT = 10;

    public QEIndexBase(){


        usr_dir = System.getProperty("user.dir").toString();
      //  driver.get(usr_dir + "\\src\\main\\java\\org\\rthtest\\question\\QE-index.html");
    }

    public static void initialization(String browser) {

        if(browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else {
            throw new IllegalArgumentException("Invalid browser value!!");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(usr_dir + "\\src\\main\\java\\org\\rthtest\\question\\QE-index.html");
    }

    public static void closeDriver() {
        driver.close();
    }

}
