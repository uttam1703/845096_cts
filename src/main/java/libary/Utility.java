package libary;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import excel.Read_excel;


public class Utility extends Read_excel {
	protected WebDriver dr;
//	public utility(WebDriver d)
//	{
//		this.d=d;
//	}
	
		// TODO Auto-generated constructor stub
	
	public void ScreenShot()
	{
		
		File f1=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	    File f2=new File("src\\test\\resources\\SCREENSHOT\\"+System.currentTimeMillis()+".png");
	try {
		FileUtils.copyFile(f1, f2);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
	public WebDriver launchBroser(String br,String url)
	{
		
		if(br.contains("CHROME") ) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\DRIVER\\chromedriver_v79.exe");
			 dr=new ChromeDriver();
		}
			 else  if(br.contains("FIREFOX") ) {
			System.setProperty("webdriver.gecko.driver","src\\test\\resources\\DRIVER\\geckodriver.exe");
			 dr= new FirefoxDriver();
			 }
			 
				 
		
		dr.get(url);
		 dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return dr;
			
	}
	public WebElement waitForElement(WebDriver dr,By loc,int timeout) {
		try{
			WebDriverWait wait =new WebDriverWait(dr,timeout);
		     WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
		     System.out.println("fo");
		     return element;
		     }
		catch(Exception e)
		{ System.out.println("not");}
		return null;
	}
	
	public WebElement elementclick(WebDriver dr,By loc,int timeout) {
		try {
		WebDriverWait wait=new WebDriverWait(dr,timeout);
		 WebElement element =wait.until(ExpectedConditions.elementToBeClickable(loc));
		 System.out.println("fo");

		 return element;
		}
		catch(Exception e) {System.out.println("not");}
		return null;
	}

}
