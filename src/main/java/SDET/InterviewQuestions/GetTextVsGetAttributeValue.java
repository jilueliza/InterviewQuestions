package SDET.InterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextVsGetAttributeValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		driver.manage().window().maximize();
		
		WebElement emailInputBox = driver.findElement(By.xpath("//input[@id='Email']"));
		emailInputBox.clear();
		emailInputBox.sendKeys("admin123@gmail.com");
		
		System.out.println("Result from getAttribute() : " + emailInputBox.getAttribute("value"));
		System.out.println("Result from getText() : "+ emailInputBox.getText());
		
		WebElement login = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
		System.out.println("Result from getAttribute() : " + login.getAttribute("class"));
		System.out.println("Result from getText() : "+ login.getText());
		
		
		driver.close();
		driver.quit();

	}

}
