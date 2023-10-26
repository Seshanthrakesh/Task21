package com.task21.Answers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q3_NestedFrames {
	static WebDriver driver=null;
	public static void main(String[] args) {
		driver=new ChromeDriver();//Opens the Chrome Browser
		driver.manage().window().maximize();//maximize the browser window
		driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");//navigate to a url
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//locate the frame WebElement and switch to top frame
		WebElement top=driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(top);
		
		//Verifies that there are three frames in the page
		List<WebElement> frame=driver.findElements(By.tagName("frame"));
		if(frame.size()==3) {
			System.out.println("There are three Frames on the page.");
		}
		else
			System.out.println("There are no three frame on the page.");

		//Switch to Left frame  and get the text as LEFT
		WebElement left=driver.findElement(By.cssSelector("frame[name='frame-left']"));
		driver.switchTo().frame(left);
		WebElement leftframeElement =driver.findElement(By.tagName("body"));
		String ltext=leftframeElement.getText();


		//verifies the left Frame has text "LEFT"
		if(ltext.equals("LEFT")) {
			System.out.println("Left Frame has a text - "+ltext);
		}else
			System.out.println("No Text in the Frame");

		//Switch back to Top Frame
		driver.switchTo().parentFrame();

		//Switch to middle frame  and get the text as MIDDLE
		WebElement middle =driver.findElement(By.cssSelector("frame[name='frame-middle']"));
		driver.switchTo().frame(middle);
		WebElement middleframeElement =driver.findElement(By.tagName("body"));
		String mtext=middleframeElement.getText();

		//Verifies the middle frame has text "MIDDLE"
		if(mtext.equals("MIDDLE")) {
			System.out.println("Middle frame has text - "+mtext);
		}else
			System.out.println("No Text in the Frame");

		//Switch back to top frame
		driver.switchTo().parentFrame();

		//Switch to right frame  and get the text as RIGHT
		WebElement right =driver.findElement(By.cssSelector("frame[name='frame-right']"));
		driver.switchTo().frame(right);
		WebElement rightframeElement =driver.findElement(By.tagName("body"));
		String rtext=rightframeElement.getText();

		//Verifies the  right frame has text "MIDDLE"
		if(rtext.equals("RIGHT")) {
			System.out.println("Right frame has text - "+rtext);
		}else
			System.out.println("No Text in the Frame");

		//Switch back to top frame
		driver.switchTo().parentFrame();
		//switch to defaultcontent
		driver.switchTo().defaultContent();

		//Switch to bottom frame and get the text as BOTTOM
		WebElement bottom =driver.findElement(By.cssSelector("frame[name='frame-bottom']"));
		driver.switchTo().frame(bottom);
		WebElement bottomframeElement =driver.findElement(By.tagName("body"));
		String btext=bottomframeElement.getText();

		//Verifies the Bottom frame has text "BOTTOM"
		if(btext.equals("BOTTOM")) {
			System.out.println("Bottom frame has text - "+btext);
		}else
			System.out.println("No Text in the Frame");

		//Switch back to top frame
		driver.switchTo().defaultContent();
	
		//gets the title of the page
		String ftitle=driver.getTitle();
		if(ftitle.equals("Frames"))
		{
			System.out.println("Title of the page is "+ftitle);
		}else
			System.out.println("The page Title is not Frames");


		//close the browser
		driver.quit();





	}

}
