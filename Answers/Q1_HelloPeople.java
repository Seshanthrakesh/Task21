package com.task21.Answers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1_HelloPeople {
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();//Opens the chrome Browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();//Maximize the Browser window
		driver.navigate().to("https://the-internet.herokuapp.com/iframe");//Navigate to the Url
		
		//Locate the iframe and switch to iframe 
		WebElement wb=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(wb);
		
		//Locates the WebElement
		WebElement textframe=driver.findElement(By.xpath("//p[text()=\"Your content goes here.\"]"));
		
		//clears the text in the text Field
		textframe.clear();
		
		//Enter the Hello people inside the frame
		textframe.sendKeys("Hello people");
				
		//close the browser
		driver.close();
		
	}

}
