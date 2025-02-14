package meaventask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTask3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.guvi.in");
		driver.findElement(By.xpath("(//a[@id='login-btn'])[1]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,280)");
		driver.findElement(By.id("email")).sendKeys("pslisting06@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Priya@1234");
		driver.findElement(By.id("login-btn")).click();
		String pageTitle = driver.getTitle();
		System.out.println("title: " + pageTitle);
		driver.quit();
		
	}

}
