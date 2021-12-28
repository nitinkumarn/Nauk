package Nauk;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunnerNit {
	
	@Test
	public  void Nitin_naukri() throws InterruptedException{

		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
//		WebDriver driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/nlogin/login");
		
		System.out.println("URL Launched");
		Thread.sleep(3000);
		driver.findElement(By.id("usernameField")).sendKeys("nitinkumarsuccess@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Nitink@1995");
		driver.findElement(By.xpath("//div[@class='action row mb0']/div/button[1]")).click();
		Thread.sleep(2000);
		System.out.println("Login success");
		
		driver.findElement(By.xpath("//div[@class='personal-info col s12 center']/div[1]")).click();
		
		driver.findElement(By.xpath("//em[contains(text(),'Edit')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='name']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Nitinkumar N");
		
		driver.findElement(By.xpath("//button[@id='saveBasicDetailsBtn']")).click();
		System.out.println("completed");
		
		Thread.sleep(2000);
		driver.quit();

	}

}

