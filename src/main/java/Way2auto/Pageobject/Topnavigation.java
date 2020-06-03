package Way2auto.Pageobject;

public class Topnavigation {
	
	public void logout()
	{
		page.click("topnavg_icon_xpath");
		page.click("Logout_xpath");
		
	}
	
	public void gotoactivity()
	{
		page.click("Activity_log_xpath");
	}
	
	public void gotohome()
	{
		page.click("home_xpath");
	}

}
