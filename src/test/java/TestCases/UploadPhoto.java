package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Way2auto.Pageobject.HomePage;
import Way2auto.Pageobject.Topnavigation;

public class UploadPhoto extends BaseTest{
	
	@Test
	public void updatephoto() throws InterruptedException, IOException
	{
		HomePage p = new HomePage();
		p.profilenav().updatephoto();
		
		
	}

}
