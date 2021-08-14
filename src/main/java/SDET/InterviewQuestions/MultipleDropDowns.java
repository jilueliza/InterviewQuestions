package SDET.InterviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleDropDowns {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']")).click();
		
		WebElement jobTitleDrp = driver.findElement(By.id("candidateSearch_jobTitle"));
		selectOptionFromDropDown(jobTitleDrp,"HR Manager");
		
		WebElement vacancyDrp = driver.findElement(By.id("candidateSearch_jobVacancy"));
		selectOptionFromDropDown(vacancyDrp, "All");
		
		WebElement statusDrp = driver.findElement(By.id("candidateSearch_status"));
		selectOptionFromDropDown(statusDrp, "Hired");
		
		driver.close();
		driver.quit();

	}
	
	public static void selectOptionFromDropDown(WebElement element, String value) {
		
		Select drp = new Select(element);
		
		List<WebElement> allOptions = drp.getOptions();
		
		for(WebElement option : allOptions) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
