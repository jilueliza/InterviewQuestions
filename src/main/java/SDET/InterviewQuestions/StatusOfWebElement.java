package SDET.InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Display status : " + searchStore.isDisplayed());
		System.out.println("Enable status : " + searchStore.isEnabled());
		
		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));
		System.out.println("Male radio button status 1 : " + male.isSelected()); //false
		System.out.println("Female radio buttion status 1 : " + female.isSelected()); //false
		
		male.click();
		System.out.println("Male radio button status 2 : " + male.isSelected());	//true
		System.out.println("Female radio buttion status 2 : " + female.isSelected());	//false
		
		female.click();
		System.out.println("Male radio button status 3 : " + male.isSelected());	//false
		System.out.println("Female radio buttion status 3 : " + female.isSelected());	//true
		
		
		driver.close();
		driver.quit();

	}

}
