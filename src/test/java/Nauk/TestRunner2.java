package Nauk;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunner2 {

	
	@Test
	public static void Nandan_naukri() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		
		
		String ParentwindowID = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			String ChildwindowIds = itr.next();
			if(!(ParentwindowID.equals(ChildwindowIds))) {
				driver.switchTo().window(ChildwindowIds);
				driver.close();
			}
		}
		
		driver.switchTo().window(ParentwindowID);
		driver.findElement(By.xpath("//a[@id='login_Layer']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/input[1]")).sendKeys("deepikabu1998@gmail.com");
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[3]/input[1]")).sendKeys("deepika@98");
		driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[2]/div[1]/form[1]/div[6]/button[1]")).click();
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'My Naukri')]"))).perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]")).click();
		
		driver.findElement(By.xpath("//em[contains(text(),'Edit')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='name']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Deepika B.U");
		
		driver.findElement(By.xpath("//button[@id='saveBasicDetailsBtn']")).click();
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
