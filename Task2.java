package meaventask;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.switchTo().frame(0);
		WebElement element1= driver.findElement(By.id("draggable"));
		WebElement element2= driver.findElement(By.id("droppable"));
		Actions objAct = new Actions(driver);  //passing driver for keyboard actions
		objAct.dragAndDrop(element1, element2).build().perform(); // dragging element1 to element2
		// Wait for color change
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element2, "background-color"));

        // Check CSS color property to verify drop
        String colorBefore = element1.getCssValue("background-color");
        String colorAfter = element2.getCssValue("background-color");
        System.out.println("Color before drop: " + colorBefore);
        System.out.println("Color after drop: " + colorAfter);

        if (!colorBefore.equals(colorAfter)) {
            System.out.println("Color change verified: Drag and drop successful!");
        } else {
            System.out.println("No color change: Drag and drop failed.");
        }
		
		
		String msg = element2.getText();
		Assert.assertEquals("Dropped!", msg); // asserting on the msg
		
		if(msg.equalsIgnoreCase("Dropped!")) {
			System.out.println("Dropped Successfull");
		}else {
			System.out.println("DragDrop not successfull");
		}
////		//verify using color change
//		String colorBefore = element2.getCssValue("background-color");
//		objAct.dragAndDrop(element1, element2).perform();
//		String colorAfter = element2.getCssValue("background-color");
//		if (!colorBefore.equals(colorAfter)) {
//            System.out.println("Color change verified: Drag and drop successful!");
//        } else {
//            System.out.println("No color change: Drag and drop failed.");
//        }
		// Check CSS color property to verify drop
//        String backgroundColor = element2.getCssValue("background-color");
//        System.out.println("Target background color after drop: " + backgroundColor);
	}

}
