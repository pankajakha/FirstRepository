package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Way2auto.Pageobject.Loginpage;
import Way2auto.Pageobject.ProfilePage;
import Way2auto.Pageobject.Topnavigation;


public class LoginTest extends BaseTest {
	
	@Test(dataProvider="getdata")
	public void dologin(String username , String password , String flag) throws IOException
	{
		if(flag.equalsIgnoreCase("Y"))
		{
		Loginpage l= new Loginpage();
		l.login(username, password);
		//Topnavigation topnav= new Topnavigation();
		//topnav.logout();
  		//topnav.gotoactivity();
  	//	topnav.gotohome();
	//	Searchfriends f= new Searchfriends();
	//	f.friends(value);
	 // Topnavigation topnav= new Topnavigation();
   	//   topnav.logout();
	//	ProfilePage pp = new ProfilePage();
	//	 pp.friendssearch();
	 Topnavigation topnav= new Topnavigation();
		 topnav.logout();
		}
		else 
		{
			throw new SkipException("Skipping this exception");
		}
	}

	@DataProvider()
	public static Object[][] getdata(){
		String sheetName = "testdata";
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
