package TESTCASES;

import org.testng.annotations.Test;

import libary.Utility;
import pages.Add_Task_Page;
import pages.Login_page;
import pages.Search_page;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Test2 extends Utility{
	Add_Task_Page ad;
	Login_page l;
	Search_page s;
	int num=2;
	 @BeforeMethod
	  public void lanuchBrowser() {
		  d=launchBroser("FIREFOX", "http://examples.codecharge.com/TaskManager/Default.php");//Launch of Browser with Chrome
	  }
	
	@Test(dataProvider="login",priority=0)
	public void login_test(String userName,String password)
	{
		l=new Login_page(d);
		  l.do_login(userName,password);//Login with Valid data
		  String result=l.get_log();//Get result of login
		  Assert.assertTrue(result.contains("Logout"));//compare result
		  

	}
	@DataProvider
	  public String[][] login() {
		  get_data("login",1,2);//Get data from login excel
		 return data;
	   
	  }
	@Test(dataProvider="project_serch",priority=2)
	public void serch_test_project(String task_name,String project,String priority,String status,String type,String assign_to)
	{
		
		  s=new Search_page(d);
		  s.do_serch(project,priority,status,type,assign_to);//search for project
		  ScreenShot();//take screen shot
		  String serch_result=s.project_result();//get project name
		  Assert.assertTrue(serch_result.contains(task_name));//compare the result
		  
		
	}
	@DataProvider
	  public String[][] project_serch() {
		  get_data("project",3,6);//Get data from project sheet
		 return data;
	   
	  }
	@Test(dataProvider = "serch_parameter",priority=1)
  public void search_test_parameter(String project,String priority,String status,String type,String assign_to,String extpected_result) {
	  	  
	   s=new Search_page(d);
	  s.do_serch(project,priority,status,type,assign_to);//search for each parameter
	  ScreenShot();//take screen shot
	  String actual_result= s.table_result(num);//get result
	  num++;
	  Assert.assertTrue(actual_result.contains(extpected_result));//comapre result
  }
	 @DataProvider
	  public String[][] serch_parameter() {
		 get_data("parameter", 3, 6);//get data from parameter sheet
		
		 return data;
	   
	  }

  @AfterMethod
  public void closeBrowser() {
	  d.close();//close Browser
	  
	  
	  
  }



  }
