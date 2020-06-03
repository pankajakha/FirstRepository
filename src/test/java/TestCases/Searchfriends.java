package TestCases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Way2auto.Pageobject.Loginpage;
import Way2auto.Pageobject.ProfilePage;
import Way2auto.Pageobject.Topnavigation;


public class Searchfriends extends BaseTest {
	
	
	@Test(priority=2 , dataProvider="getvalue")
	public void friends(String value) throws IOException
	{
		ProfilePage pp = new ProfilePage();
		 int totalresult = pp.searchresults(value);
		Boolean bool;
		if(totalresult>0)
		{
			bool = true;
		}
		else bool = false;
		System.out.println(totalresult);
		System.out.println(bool);
		softassert.assertTrue(bool);
		//Topnavigation topnav= new Topnavigation();
	  // 	topnav.logout();
		softassert.assertAll();
		

	}
	
	@Test (priority=1 ,dataProvider="getdata2")
	public void dologin(String username , String password) throws IOException
	{
		
		
		Loginpage l= new Loginpage();
		l.login(username, password);
		ProfilePage pp = new ProfilePage();
		 pp.friendssearch();
		
		
	}
	
	@DataProvider()
	public static Object[][] getvalue(){
		String sheetName = "testvalue";
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
         Object[][] data = new Object[rowNum-1][colNum];
		
		System.out.println("Total rows are : "+rowNum+"  total cols are : "+colNum);
		
            for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
		     data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
				
			}
			
		}
	
		
		return data;
		
		
	}
	
	@DataProvider()
	public static Object[][] getdata2(){
		String sheetName = "testdata2";
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
         Object[][] data = new Object[rowNum-1][colNum];
		
		System.out.println("Total rows are : "+rowNum+"  total cols are : "+colNum);
		
            for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
		     data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
				
			}
			
		}
	
		
		return data;
		
		
	}

}
