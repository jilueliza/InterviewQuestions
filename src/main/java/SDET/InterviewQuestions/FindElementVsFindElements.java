package SDET.InterviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementVsFindElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		//Scenario 1
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchBox.sendKeys("xyz");
		
		//Scenario 2
		//Locator is pointing to multiple webelements
		//but still findElement() will return single webelement
		//22 webelements are matching, among that first element will return
		WebElement footerElements = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(footerElements.getText());
		
		List<WebElement> footerElementList = driver.findElements(By.xpath("\"//div[@class='footer-upper']//a\""));
		System.out.println("Number of elements captured " + footerElementList.size());
		
		for(WebElement element : footerElementList) {
			System.out.println(element.getText());
		}
		
		driver.close();
		driver.quit();

	}

}
