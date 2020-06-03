package Way2auto.Pageobject;

import java.io.IOException;

import org.openqa.selenium.By;



public class HomePage extends page{
    
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfilePage profilenav() throws IOException
	{
		click("profilepage_xpath");
		return new ProfilePage();
	}
}
