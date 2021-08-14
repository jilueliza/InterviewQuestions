package SDET.InterviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		driver.manage().window().maximize();
		
		WebElement countryDrp = driver.findElement(By.id("input-country"));
		
		Select countrySelection = new Select(countryDrp);
		countrySelection.selectByVisibleText("Brazil");
		countrySelection.selectByIndex(12);
		countrySelection.selectByValue("10");
		
		//selecting option from dropdown without using methods
		List<WebElement> allOptions = countrySelection.getOptions();
		for(WebElement option : allOptions) {
			if(option.getText().equals("Denmark")) {
				option.click();
				break;
			}
		}
		driver.close();
		driver.quit();

	}

}
