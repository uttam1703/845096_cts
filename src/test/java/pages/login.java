package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import libary.utility;

public class login {
	WebDriver d;
	public login(WebDriver d)
	{
		this.d=d;
	}
	utility u=new utility();
	By admin=By.xpath("//a[@href='Administration.php']");
	By user=By.xpath("//input[@name='login']");
	By pass=By.xpath("//input[@name='password']");
	By login=By.xpath("//input[@name='DoLogin']");
	By task_btn=By.xpath("//a[@href='Default.php']");
	public void ck_ad() {
		WebElement we=u.elementclick(d,admin, 20);
		we.click();
	}
	public void se_lo(String a) {
		WebElement we=u.waitForElement(d,user, 20);
		we.sendKeys(a);
	}
	public void se_ps(String a) {
		WebElement we=u.waitForElement(d,pass, 20);
		we.sendKeys(a);
	}
	public void ck_bt() {
		WebElement we=u.elementclick(d,login, 20);
		we.click();
	}
	public void ck_task() {
		WebElement we=u.elementclick(d,task_btn, 20);
		we.click();
	}
	public void do_login()
	{
		this.ck_ad();
		u.get_data();
		this.se_lo("admin");
		this.se_ps("admin");
		this.ck_bt();
	}
	

}
