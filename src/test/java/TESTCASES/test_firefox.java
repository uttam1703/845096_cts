package TESTCASES;

import org.testng.annotations.Test;

import libary.utility;
import pages.add_task_page;
import pages.login;
import pages.serch;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class test_firefox extends utility{
	add_task_page ad;
	login l;
	serch s;
	int c=5,g=2;
  @Test(dataProvider = "dp")
  public void f(String pro,String pri,String stu,String typ,String assi,String ext_result) {
	  l=new login(d);
	  l.do_login();
	  l.ck_task();
	  
	  s=new serch(d);
	  s.do_serch(pro,pri,stu,typ,assi);
	  ScreenShot(c);
	  String act_result= s.table_result(g);
	  Assert.assertTrue(act_result.contains(ext_result));
  }
  @BeforeMethod
  public void beforeMethod() {
	  d=lunchBroser("FIREFOX", "http://examples.codecharge.com/TaskManager/Default.php");
  }

  @AfterMethod
  public void afterMethod() {
	  d.close();
	  c++;
	  g++;
  }


  @DataProvider
  public String[][] dp() {
	 get_data();
	 return data;
   
  }
}
