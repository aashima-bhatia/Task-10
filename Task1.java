package meaventask;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://jqueryui.com/datepicker/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		WebElement iframe = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframe);
        WebElement dateInput = driver.findElement(By.id("datepicker"));
        dateInput.click();
        driver.findElement(By.xpath("//a[@title='Next']")).click();
        driver.findElement(By.xpath("//a[text()='22']")).click();
        
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("alert('Selected Date: ' + document.getElementById('datepicker').value);");
        Alert alert = driver.switchTo().alert();
        String alerttext = alert.getText();
        System.out.println(alerttext);
        alert.accept();
	}

}
