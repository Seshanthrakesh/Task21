package com.task21.Answers;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2_NewWindow {
	static WebDriver driver=null;
	public static void main(String[] args) {
		driver=new ChromeDriver();//Opens the Chrome Browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();//Maximize the browser Window
		driver.navigate().to("https://the-internet.herokuapp.com/windows");//navigate to the Url

		//Gets the Title of the Active window
		String parentwindow= driver.getTitle();
		
		//clicks the Click here Button
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		//Store the all windows Title
		Set<String> allwindow=driver.getWindowHandles();
		
		//Switch To the New window
		for(String  newwin : allwindow)
		{
			driver.switchTo().window(newwin);
		}

		//verifies that Switch to New Window And New Window is opened
		String NewWindow_title=driver.getTitle();
		if( NewWindow_title.equalsIgnoreCase("New window")){
			System.out.println(NewWindow_title+" is Opened ");
		}
		else
			System.out.println(NewWindow_title+" is Not Opened");
		
		//Close the Current Window
		driver.close();

		//verifies the Original Window is Active
		if(parentwindow.equalsIgnoreCase("The Internet"))
		{

			System.out.println(parentwindow+" : original Window Is Active");
		}
		else {
			System.out.println(parentwindow+" : Original Window is Not Active");
		}

		
		//Close the Browser Instance
		driver.quit();


	}

}
