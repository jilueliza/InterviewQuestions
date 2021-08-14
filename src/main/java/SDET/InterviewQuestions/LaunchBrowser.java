package SDET.InterviewQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser 
{
    public static void main( String[] args )
    {
//    	System.setProperty("webdriver.chrome.driver", "E:\\Test Automation\\WebDrivers\\chromedriver.exe");
//    	WebDriver driver = new ChromeDriver();
    	
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	
    	driver.get("https://www.nopcommerce.com/en/demo");
    	
    	System.out.println("Title of web page is " + driver.getTitle());
    	
    	System.out.println("Current URL of web page is " + driver.getCurrentUrl());
    	
    	System.out.println("Page source of web page is " + driver.getPageSource());
    	
    	driver.close();
    	driver.quit();
    }
}
