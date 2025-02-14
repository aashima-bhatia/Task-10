package meaventask;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait; 
public class Task3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.guvi.in");
        driver.findElement(By.xpath("(//a[normalize-space()='Sign up'])[1]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,280)");
		WebElement dummyName = driver.findElement(By.id("name"));
		dummyName.sendKeys("Priya Sharma");
		WebElement dummyEmail= driver.findElement(By.id("email"));
		dummyEmail.sendKeys("pslisting06@gmail.com");
		WebElement dummyPassword = driver.findElement(By.id("password"));
		dummyPassword.sendKeys("Priya@1234");
		WebElement dummyMobileNumber = driver.findElement(By.id("mobileNumber"));
		dummyMobileNumber.sendKeys("8789871789");
		driver.findElement(By.id("signup-btn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement profileDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileDrpDwn")));
		profileDropdown.click();
		Select dropProfile = new Select(profileDropdown);
        dropProfile.selectByIndex(3);
        WebElement degreeDropdown = driver.findElement(By.id("degreeDrpDwn"));
        degreeDropdown.click();
        Select dropDegree = new Select(degreeDropdown);
        dropDegree.selectByIndex(11);
        WebElement yearDropdown = driver.findElement(By.id("year"));
        yearDropdown.sendKeys("2017");
        driver.findElement(By.xpath("(//a[normalize-space()='Submit'])[1]")).click();
        
	}

}
